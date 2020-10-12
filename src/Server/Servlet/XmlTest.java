package Server.Servlet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 30 08 : 44
 * @Description: todo
 */
public class XmlTest {
    public static void main(String[] args) throws Exception {
        //SAX解析
        //1、获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2、从解析工厂获取解析器
        SAXParser parser = factory.newSAXParser();
        //3、编写处理器
        //4、加载文档 Document 注册处理器
        WebHandler webHandler = new WebHandler();
        //5、解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Server/Servlet/web.xml"), webHandler);

        //获取数据
        WebContext webContext = new WebContext(webHandler.getEtities(),webHandler.getMappings());

        //假设你在网页上输入了以下参数  /login  /reg
        String clzName = webContext.getClz("/login");

        //进行反射
        Class clz = Class.forName(clzName);
        Servlet servlet = (Servlet) clz.getConstructor().newInstance();
        System.out.println("对应的包路径："+servlet);
        //调用（服务）
        servlet.service();
    }
}

class WebHandler extends DefaultHandler {
    private List<Entity> etities;
    private List<Mapping> mappings;
    private Entity etity;
    private Mapping mapping;
    private String tag;//存储操作标签
    private boolean isMapping = false;

    /**
     * 开始解析文档
     */
    @Override
    public void startDocument() {
        //创建数组
        etities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }

    /**
     * 解析开始
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName != null) {
            tag = qName;
            if (tag.equals("servlet")) {
                etity = new Entity();//初始化
                isMapping = false;
            } else if (tag.equals("servlet-mapping")) {
                mapping = new Mapping();//初始化
                isMapping = true;
            }
        }
    }

    /**
     * 获取内容
     *
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (tag != null) {
            if (isMapping) {
                //servlet-mapping
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                } else if (tag.equals("url-pattern")) {
                    mapping.addPatten(contents);
                }
            } else {
                //servlet
                if (tag.equals("servlet-name")) {
                    etity.setName(contents);
                } else if (tag.equals("servlet-class")) {
                    etity.setClz(contents);
                }
            }
        }
    }

    /**
     * 解析结束
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName != null) {
            if (qName.equals("servlet")) {
                etities.add(etity);
            } else if(qName.equals("servlet-mapping")){
                mappings.add(mapping);
            }
        }
        tag = null;
    }

    public List<Entity> getEtities() {
        return etities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }
}
