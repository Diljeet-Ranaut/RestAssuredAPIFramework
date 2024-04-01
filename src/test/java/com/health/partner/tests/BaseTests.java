package com.health.partner.tests;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTests {
    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("Method Name: " + m.getName());
        System.out.println("Thread ID : " + Thread.currentThread().getId());
    }
}
