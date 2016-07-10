package com.dempe.crawler.zhizhu.pipeline;

import com.dempe.crawler.zhizhu.model.UserBaseInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

@Component("UserBaseInfoPipeline")
public class UserBaseInfoPipeline implements PageModelPipeline<UserBaseInfo> {

    private final static Logger LOGGER = Logger.getLogger(UserBaseInfoPipeline.class);

    @Override
    public void process(UserBaseInfo t, Task task) {
        LOGGER.info("userBaseInfo:" + t);

    }

}
