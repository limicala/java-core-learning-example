package org.javacore.annotation.controller;

@MyController
@RequestUrl(url = "/user")
public class UserController {

    @RequestUrl(url = "login.do")
    public void login(){
        System.out.println("Login");
    }

    @RequestUrl(url = "aView.do")
    public void aaa(){
        System.out.println("aaa");
    }
}
