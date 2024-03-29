package com.dempe.crawler.zhizhu.pipeline;

import com.dempe.crawler.zhizhu.model.UserDetailInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;


/**
 * @author Ming
 * @Description TODO
 * @date: 2016年1月27日--上午9:42:23
 * 采用了    非注解方式    进行数据爬取，在插入数据库的时候，可对每一个字段进行处理，灵活性高，但比较麻烦
 */
@Component
public class UserDetailInfoPipeline implements Pipeline {

    private final static Logger LOGGER = Logger.getLogger(UserDetailInfoPipeline.class);

    @Override
    public void process(ResultItems resultItems, Task task) {
        UserDetailInfo record = new UserDetailInfo();
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            //System.out.println(entry.getKey() + ":\t" + entry.getValue());
            if (null != entry.getValue()) {
                switch (entry.getKey()) {
                    case "pageUrl":
                        record.setPageurl(entry.getValue().toString());
                        break;
                    case "nickname":
                        record.setNickname(entry.getValue().toString());
                        break;
                    case "business":
                        record.setBusiness(entry.getValue().toString());
                        break;
                    case "employment":
                        record.setEmployment(entry.getValue().toString());
                        break;
                    case "position":
                        record.setPosition(entry.getValue().toString());
                        break;
                    case "gender":
                        record.setGender(entry.getValue().toString());
                        break;
                    case "shares":
                        record.setShares(Integer.valueOf((String) entry.getValue()));
                        break;
                    case "collecters":
                        record.setCollecters(Integer.valueOf((String) entry.getValue()));
                        break;
                    case "education":
                        record.setEducation(entry.getValue().toString());
                        break;
                    case "educationExtra":
                        record.setEducationextra(entry.getValue().toString());
                        break;
                    case "status":
                        record.setStatus(entry.getValue().toString());
                        break;
                    default:
                        break;
                }
                LOGGER.info("UserDetailInfo : " + record);
            }
        }

    }
}
