package org.javacore.annotation.controller;

@MyController
public class IndexController {

    @RequestUrl(url = "aa.do")
    public void aa(){
        System.out.println("aa");
    }

    @RequestUrl(url = "cc")
    public void bb(){
        System.out.println("bb");
    }
}
