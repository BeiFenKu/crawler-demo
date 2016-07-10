package com.dempe.crawler.qqzone.spider;

import com.dempe.crawler.CrawSpider;
import com.dempe.crawler.qqzone.pipeline.ZanPipeline;
import com.dempe.crawler.qqzone.processor.ZanProcessor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * Created with IntelliJ IDEA.
 * User: Dempe
 * Date: 2016/7/10 0010
 * Time: 下午 9:46
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ZanSpider implements CrawSpider {

    private final static Logger LOGGER = Logger.getLogger(ZanSpider.class);

    @Autowired
    private ZanProcessor zanProcessor;

    @Autowired
    private ZanPipeline zanPipeline;

    public void crawl() {
        Spider.create(new ZanProcessor()).thread(10)
                .addUrl(zanProcessor.getZanUrl(0))
                .addPipeline(zanPipeline)
                .run();

        LOGGER.info("数据下载完成......");
    }
}
