package com.dempe.crawler.zhizhu;


import com.dempe.crawler.zhizhu.pipeline.UserDetailInfoPipeline;
import com.dempe.crawler.zhizhu.processor.UserDetailInfoProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * 用户详细信息抓取， 非注解方式
 *
 * @author Ming
 * @Description TODO
 * @date: 2016年1月27日--下午12:11:17
 */
@Component
public class UserDetailInfoSpider implements Crawl {

    private static final String START_URL = "http://www.zhihu.com/people/excited-vczh";

    @Autowired
    private UserDetailInfoPipeline userDetailInfoPipeline;

    public void crawl() {
        Spider.create(new UserDetailInfoProcessor())
                .addUrl(START_URL)
                .addPipeline(userDetailInfoPipeline)
                //.setScheduler(new FileCacheQueueScheduler("/usr/zhihu/cache"))
                //.setDownloader(new HttpClientDownloaderExtend("/about"))
                .thread(1).run();
    }

}
