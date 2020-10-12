package Server.Web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 11 17 : 46
 * @Description: 封装请求协议：封装请求参数为Map
 */
public class Request02 {
    //协议信息
    private String requestInfo;
    //请求方式
    private String method;
    //链接url
    private String url;
    //请求参数
    private String queryStr;
    //存储参数
    private Map<String, List<String>> parameterMap;
    //换行符
    private final String CRLF = "\r\n";
    public Request02(Socket client) throws IOException {
        this(client.getInputStream());
    }
    public Request02(InputStream is){
        parameterMap = new HashMap<>();
        byte[] datas = new byte[1024*1024];
        int len = 0;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
    }
    private void parseRequestInfo(){
        System.out.println("-----开始分解------");
        //----1、获取请求方式：开头到第一个/----
        this.method = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase().trim();
        System.out.println("请求方式" + this.method);

        //2、获取url：从第一个/ 到HTTP/ ----
        //----可能包含请求参数? 前面的为url ----
        //1、获取/的下标
        int startIdx = this.requestInfo.indexOf("/")+1;
        //2、获取HTTP/的下标
        int endIdx = this.requestInfo.indexOf("HTTP/");
        //3、分割字符串
        this.url = this.requestInfo.substring(startIdx,endIdx);
        //4、获取?的位置
        int queryIdx = this.url.indexOf("?");
        if(queryIdx >= 0){
            //表示存在请求参数
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0];
            this.queryStr = (urlArray[1] == null ? "" : decode(urlArray[1],"UTF-8")).trim();
            System.out.println("请求参数为："+this.queryStr);
        }
        System.out.println("地址为："+this.url);

        //3、获取请求参数：如果为Get，则已经获取参数；如果为Post，则有可能在请求体中
        if(this.method.equals("post")){
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if(queryStr == null){
                queryStr = qStr;
            }else{
                queryStr += "&" + qStr;
            }
        }
        queryStr = (queryStr == null ? "" : queryStr);
        System.out.println("请求参数："+queryStr);
        //转成Map fav=1&fav=2&name=shsxt&age=18&others=
        convertMap();
    }
    private void convertMap(){
        //1、分割字符串 &
        String[] keyValues = this.queryStr.split("&");
        for (String queryStr:keyValues){
            //2、再次分割字符串 =
            String[] kv = queryStr.split("=");
            kv = Arrays.copyOf(kv,2);
            //获取key和value
            String key = kv[0];
            String value = (kv[1]==null?null:decode(kv[1],"UTF-8"));
            //存储到map中
            if(!parameterMap.containsKey(key)){
                parameterMap.put(key,new ArrayList<String>());
            }
            parameterMap.get(key).add(value);
        }
    }

    /**
     * 处理中文字符集
     * @param value
     * @param enc
     * @return
     */
    private String decode(String value,String enc){
        try {
            return java.net.URLDecoder.decode(value,enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过name获取表单中的多个值
     * @param key
     * @return
     */
    public String[] getParameterValues(String key){
        List<String> values = this.parameterMap.get(key);
        if(values == null || values.size() < 1){
            return null;
        }
        return values.toArray(new String[0]);
    }
    /**
     * 通过name获取表单中的单个值
     * @param key
     * @return
     */
    public String getParameterValue(String key){
        String[] value = getParameterValues(key);
        return value==null?null:value[0];
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getQueryStr() {
        return queryStr;
    }
}
