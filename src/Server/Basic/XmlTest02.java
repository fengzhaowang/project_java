package Server.Basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 20 : 52
 * @Description: todo
 */
public class XmlTest02 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        //1、获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2、从解析工厂获取解析器
        SAXParser parser = factory.newSAXParser();
        //3、编写处理器
        //4、加载文档 Document 注册处理器
        ParsonHandler handler = new ParsonHandler();
        //5、解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Server/Basic/Person.xml"),handler);

    }
}

class ParsonHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析文档");
        persons = new ArrayList<Person>();//创建数组
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"--->解析开始");
        if(qName.equals("person")){
            person = new Person();//初始化
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length).trim();
        if(contents.length() > 0){
            System.out.println("内容为："+contents);
        }else{
            System.out.println("内容为空");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"--->解析结束");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("结束解析文档");
    }
}