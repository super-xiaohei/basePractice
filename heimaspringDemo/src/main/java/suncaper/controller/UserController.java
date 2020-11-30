package suncaper.controller;

import suncaper.service.Impl.UserviceImpl;

/**
 * @author zyq
 * @date 2020/11/6 - 15:53
 */
public class UserController {

    public static void main(String[] args) {
        UserviceImpl uservice = new UserviceImpl();
        uservice.say();
    }
}
