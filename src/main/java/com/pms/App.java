package com.pms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        String springConfig = "spring/batch/jobs/headerFooterSample.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

    }
}
