package io.agileintelligence.ppmtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class PpmtoolApplication {

    public static void main(String[] args) {
        ApplicationContext ct = SpringApplication.run(PpmtoolApplication.class, args);
        String[] beanArray = ct.getBeanDefinitionNames();
    }

}
