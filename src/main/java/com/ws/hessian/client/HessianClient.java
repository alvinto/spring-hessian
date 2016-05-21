package com.ws.hessian.client;

import com.caucho.hessian.client.HessianProxyFactory;
import com.ws.hessian.server.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;

/**
 * Created by alvin on 2016/5/21.
 */
public class HessianClient {
    public static void main(String[] args) {
        //-------直接使用Hessian--------
        try {
            HessianProxyFactory proxyFactory = new HessianProxyFactory();
            MyService myService = (MyService)proxyFactory.create(MyService.class, "http://127.0.0.1:8080/myservice/hessian");
            System.out.println(myService.doSomething("hahaha"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //-------直接使用Hessian--------

        //-----------使用Spring+Hessian-----------
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MyService myService1 = (MyService) applicationContext.getBean("myService");
        System.out.println(myService1.doSomething("spring hessian"));
    }
}
