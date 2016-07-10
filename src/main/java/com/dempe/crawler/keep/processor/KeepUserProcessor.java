package com.dempe.crawler.keep.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: Dempe
 * Date: 2016/7/10 0010
 * Time: 下午 2:31
 * To change this template use File | Settings | File Templates.
 */
public class KeepUserProcessor implements PageProcessor {
    private static final String START_URL = "http://api.gotokeep.com/v1.1/people/560a8f9af493a43bf856e098/running/record";

    /**
     * GET https://api.gotokeep.com/v1.1/people/560a8f9af493a43bf856e098/running/record HTTP/1.1
     * x-device-id: 86136503065819464cc2ef40ec911111b4ae6d4b
     * X-KEEP-FROM: android
     * X-KEEP-TIMEZONE: Asia/Shanghai
     * X-KEEP-CHANNEL: xiaomi
     * X-DEVICE: Xiaomi-Redmi Note 3
     * X-KEEP-VERSION: 3.6.1
     * Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1Nzc3YmZlYzI2MDJjZjNmMDU4NDA3NTgiLCJ1c2VybmFtZSI6IkRlbXBlIiwiYXZhdGFyIjoiaHR0cDovL3EucWxvZ28uY24vcXFhcHAvMTEwMzcyNzQ0Ni81MzE1QjlERDEwRTRCREMwRDNDQjZCNTcxQkEyRTQzMy8xMDAiLCJpYXQiOjE0NjgxMTk1ODgsImV4cCI6MTQ3MDcxMTU4OCwiaXNzIjoiaHR0cDovL3d3dy5nb3Rva2VlcC5jb20vIn0.VvyK8qyPagy2Adqb8-U6-zmyU32jgBBq-dCGgOcvlro
     * User-Agent: Dalvik/2.1.0 (Linux; U; Android 5.0.2; Redmi Note 3 MIUI/V7.2.5.0.LHNCNDA)
     * Host: api.gotokeep.com
     * Connection: Keep-Alive
     * Accept-Encoding: gzip
     */
    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(300).setTimeOut(3 * 60 * 1000)

            .setUserAgent("Dalvik/2.1.0 (Linux; U; Android 5.0.2; Redmi Note 3 MIUI/V7.2.5.0.LHNCNDA)")
            .addHeader("x-device-id", "86136503065819464cc2ef40ec911111b4ae6d4b")
            .addHeader("X-KEEP-FROM", "android")
            .addHeader("X-KEEP-TIMEZONE", "Asia/Shanghai")
            .addHeader("X-KEEP-CHANNEL", "xiaomi")
            .addHeader("X-DEVICE", "Xiaomi-Redmi Note 3")
            .addHeader("X-KEEP-VERSION", "3.6.1")

            .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1Nzc3YmZlYzI2MDJjZjNmMDU4NDA3NTgiLCJ1c2VybmFtZSI6IkRlbXBlIiwiYXZhdGFyIjoiaHR0cDovL3EucWxvZ28uY24vcXFhcHAvMTEwMzcyNzQ0Ni81MzE1QjlERDEwRTRCREMwRDNDQjZCNTcxQkEyRTQzMy8xMDAiLCJpYXQiOjE0NjgxMTk1ODgsImV4cCI6MTQ3MDcxMTU4OCwiaXNzIjoiaHR0cDovL3d3dy5nb3Rva2VlcC5jb20vIn0.VvyK8qyPagy2Adqb8-U6-zmyU32jgBBq-dCGgOcvlro")
            .addHeader("Connection", "Keep-Alive")
            .addHeader("Accept-Encoding", "gzip");


    @Override
    public void process(Page page) {
        System.out.println(page);

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new KeepUserProcessor()).addUrl(START_URL)
                .thread(1).run();
    }
}
