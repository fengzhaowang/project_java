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
        PersonHandler handler = new PersonHandler();
        //5、解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("Server/Basic/Person.xml"),handler);

        //获取数据
        List<Person> persons = handler.getPersons();
        for(Person p:persons){
            System.out.println(p.getName()+"-->"+p.getAge());
        }

    }
}

class PersonHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    private String tag;//存储操作标签

    /**
     * 开始解析文档
     */
    @Override
    public void startDocument(){
        persons = new ArrayList<>();//创建数组
    }

    /**
     * 解析开始
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName != null){
            tag = qName;
            if(tag.equals("person")){
                person = new Person();//初始化
            }
        }
    }

    /**
     * 获取内容
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (tag != null){
            if (tag.equals("name")) {
                person.setName(contents);
            } else if (tag.equals("age")) {
                if (contents.length() > 0) {
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    /**
     * 解析结束
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName != null) {
            if (qName.equals("person")) {
                persons.add(person);
            }
        }
        tag = null;
    }

    /**
     * 结束解析文档
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
    }

    public List<Person> getPersons() {
        return persons;
    }
}