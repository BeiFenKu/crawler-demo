package com.dempe.crawler.zhizhu;

/**
 * Created with IntelliJ IDEA.
 * User: Dempe
 * Date: 2016/7/10 0010
 * Time: 下午 8:13
 * To change this template use File | Settings | File Templates.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ZhihuCrawlMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ZhihuCrawlMain.class, args);

        UserDetailInfoSpider userDetailInfoSpider = context.getBean(UserDetailInfoSpider.class);
        userDetailInfoSpider.crawl();
        UserBaseInfoSpider userBaseInfoSpider = context.getBean(UserBaseInfoSpider.class);
        userBaseInfoSpider.crawl();


    }
}
