package com.dempe.crawler.zhizhu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface Crawl {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/config/spring-*.xml");


}
