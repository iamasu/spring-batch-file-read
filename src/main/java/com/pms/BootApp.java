package com.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Asu
 */
@SpringBootApplication
@ComponentScan({"com.pms"})
public class BootApp {

    public static void main(String[] args) {

        SpringApplication.run(new Object[]{BootApp.class}, args);

    }

}
