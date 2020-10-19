package Factory.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 20 : 32
 * @Description: todo
 */
public class StarHandler implements InvocationHandler {
    Star realStar;

    public StarHandler(Star realStar) {
        super();
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("真正的方法执行前！");
        System.out.println("面试，谈合同，预付款，订机票");
        if(method.getName().equals("sing")){
            object = method.invoke(realStar,args);
        }
        System.out.println("真正的方法执行后！");
        System.out.println("收尾款！");
        return object;
    }
}
