package com.ride.learnspringaop;

import com.ride.learnspringaop.aopexample.business.BusinessService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private BusinessService1 businessService1;

    public LearnSpringAopApplication(BusinessService1 businessService1) {
        this.businessService1 = businessService1;
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringAopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Max value returned is {}", businessService1.calculateMax());
        logger.info("Min value returned is {}", businessService1.calculateMin());
    }
}
