package Server.WebOver.Core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 09 : 29
 * @Description: todo
 */
public class WebApp {
    private static WebContext webContext;
    static {
        try {
            //SAX解析
            //1、获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //2、从解析工厂获取解析器
            SAXParser parser = factory.newSAXParser();
            //3、编写处理器
            //4、加载文档 Document 注册处理器
            WebHandler webHandler = new WebHandler();
            //5、解析
            parser.parse(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("Server/WebOver/Core/web.xml"), webHandler);
            //获取数据
            webContext = new WebContext(webHandler.getEtities(),webHandler.getMappings());
        }catch (Exception e){
            System.out.println("解析配置文件错误");
        }
    }
    public static Servlet2 getServletFromUrl(String url){
        //假设你在网页上输入了以下参数  /login  /reg
        String clzName = webContext.getClz("/"+url);
        System.out.println(clzName);
        //进行反射
        Class clz;
        try {
            clz = Class.forName(clzName);
            if (clz == null){
                return null;
            }
            Servlet2 servlet = (Servlet2) clz.getConstructor().newInstance();
            return servlet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

