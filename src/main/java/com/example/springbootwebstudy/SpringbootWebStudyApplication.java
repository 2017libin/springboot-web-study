package com.example.springbootwebstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootWebStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebStudyApplication.class, args);
    }

}
