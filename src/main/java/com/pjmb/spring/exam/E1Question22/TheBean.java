package com.pjmb.spring.exam.E1Question22;
// All lifecycle callbacks, annotations and a BeanPostProcessor implementation are used in conjunction in below example.
// While starting and stopping the Spring boot application once what would be the output?


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class TheBean implements InitializingBean, DisposableBean {

    Logger logger = LoggerFactory.getLogger(BeanPostProcessorImpl.class);
    public TheBean() {
        logger.info("Bean's constructor");
    }

    public void initMethod() {
        logger.info("Bean's init-method");
    }

    public void destroyMethod() {
        logger.info("Bean's destroy-method");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("@PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("@PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("InitializingBean's afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("DisposableBean's destroy");
    }
}
