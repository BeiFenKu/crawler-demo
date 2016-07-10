package com.dempe.crawler.qqzone;

import com.dempe.crawler.CrawSpider;
import com.dempe.crawler.qqzone.spider.ShuoShuoSpider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Dempe
 * Date: 2016/7/10 0010
 * Time: 下午 9:44
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class QQZoneCrawMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(QQZoneCrawMain.class, args);
        CrawSpider shuoShuoSpider = context.getBean(ShuoShuoSpider.class);
        shuoShuoSpider.crawl();
//        CrawSpider zanSpider = context.getBean(ZanSpider.class);
//        zanSpider.crawl();


    }
}
