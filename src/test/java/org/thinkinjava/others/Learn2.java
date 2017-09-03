package org.thinkinjava.others;

import org.junit.Test;

class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Users {
    private User user1;

    private User user2;

    public Users(){
        user1 = new User();
    }
    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
}
public class Learn2 {

    @Test
    public void test01(){
        User user = new User();
        user.setName("aaa");

        Users users = new Users();
    }
}
