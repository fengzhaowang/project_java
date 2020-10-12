package Server.Web3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理器
 */
public class WebHandler extends DefaultHandler {
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