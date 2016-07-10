package com.dempe.crawler.qqzone.spider;

import com.dempe.crawler.CrawSpider;
import com.dempe.crawler.qqzone.pipeline.ShuoShuoPipeline;
import com.dempe.crawler.qqzone.processor.ShuoShuoProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Dempe
 * Date: 2016/7/10 0010
 * Time: 下午 9:46
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ShuoShuoSpider implements CrawSpider {

    @Autowired
    private ShuoShuoProcessor pageProcessor;

    @Autowired
    private ShuoShuoPipeline shuoShuoPipeline;

    @Override
    public void crawl() {
        us.codecraft.webmagic.Spider.create(pageProcessor).thread(10)
                .addUrl(pageProcessor.getStart_url().replace("page", "0"))
                .addPipeline(shuoShuoPipeline)
                .run();

    }
}
