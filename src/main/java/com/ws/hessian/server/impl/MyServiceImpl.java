package com.ws.hessian.server.impl;

import com.ws.hessian.server.MyService;

/**
 * Created by alvin on 2016/5/21.
 */
public class MyServiceImpl implements MyService {
    @Override
    public String doSomething(String s) {
        System.out.println("Hello,Hessian!");
        return s;
    }
}
