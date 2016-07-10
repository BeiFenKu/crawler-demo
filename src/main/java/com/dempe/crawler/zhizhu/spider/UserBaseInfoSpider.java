package com.dempe.crawler.zhizhu.spider;

import com.dempe.crawler.CrawSpider;
import com.dempe.crawler.zhizhu.model.UserBaseInfo;
import com.dempe.crawler.zhizhu.pipeline.UserBaseInfoPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

/**
 * 用户基本信息抓取，注解方式爬取
 *
 * @author Ming
 * @Description TODO
 * @date: 2016年1月27日--下午12:11:17
 */
@Component
public class UserBaseInfoSpider implements CrawSpider {

    private static final String START_URL = "http://www.zhihu.com/people/excited-vczh";
    @Autowired
    private UserBaseInfoPipeline userBaseInfoPipeline;
    private Site site = Site
            .me()
            .setCycleRetryTimes(5)
            .setRetryTimes(5)
            .setSleepTime(1000)
            .setTimeOut(3 * 60 * 1000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
            .setCharset("UTF-8");


    public void crawl() {
        OOSpider.create(site, userBaseInfoPipeline, UserBaseInfo.class)
                .addUrl(START_URL)
                .thread(4).run();
    }
}
