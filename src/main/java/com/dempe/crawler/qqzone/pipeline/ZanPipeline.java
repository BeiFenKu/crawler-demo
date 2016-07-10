package com.dempe.crawler.qqzone.pipeline;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dempe.crawler.qqzone.model.Friend;
import com.dempe.crawler.qqzone.model.Zan;
import com.dempe.crawler.utils.HelpUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZanPipeline implements Pipeline {

    private final static Logger LOGGER = Logger.getLogger(ZanPipeline.class);

    public void process(ResultItems resultItems, Task task) {
        String zanJson = resultItems.get("zan");
        String shuoshuo_id = resultItems.get("shuoshuo_id");
        String host_id = resultItems.get("host_id");

        String zanString = new JsonPathSelector("$.data").select(zanJson);

        JSONArray jsonArray = JSONObject.parseObject(zanString).getJSONArray("like_uin_info");

        //add Friend
        addFriend(jsonArray, host_id);
        //add Zan
        addZan(jsonArray, shuoshuo_id);

    }

    /**
     * @param jsonArray
     */
    private void addZan(JSONArray jsonArray, String shuoshuo_id) {

        List<Zan> zan_list = new ArrayList<Zan>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Zan zan = new Zan();
            zan.setFriend_id(jsonObject.getLongValue("fuin"));
            zan.setShuoshuo_id(shuoshuo_id);
            zan.setHost_id(Long.parseLong(HelpUtils.getHost_id()));

            zan_list.add(zan);
        }
        LOGGER.info("zan_list : " + zan_list);
    }

    /**
     * @param jsonArray
     */
    private void addFriend(JSONArray jsonArray, String host_id) {

        List<Friend> friend_list = new ArrayList<Friend>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            Friend friend = new Friend();
            friend.setFriend_id(jsonObject.getLongValue("fuin"));
            friend.setFriend_name(jsonObject.getString("nick"));

            String gender = jsonObject.getString("gender");
            if ("男".equals(gender)) {
                friend.setFriend_gender(1);
            } else {
                friend.setFriend_gender(0);
            }

            friend.setFriend_constellation(jsonObject.getString("constellation"));
            friend.setFriend_address(jsonObject.getString("addr"));

            friend_list.add(friend);
        }

        LOGGER.info("friend_list : " + friend_list);
    }

}
