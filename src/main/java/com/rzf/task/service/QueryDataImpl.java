package com.rzf.task.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rzf.task.dao.FeedDataDao;
import com.rzf.task.entity.FeedData;
import com.rzf.task.util.MapToBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QueryDataImpl implements QueryData {

    @Resource
    FeedDataDao feedDataDao;

    //read last 10 records from database
    @Override
    public List<FeedData> getTopMsg() throws Exception {
        List<Map<String, Object>> msgList = new ArrayList<Map<String, Object>>();
        msgList = feedDataDao.getTopFeedData();
        List<FeedData> feedDataList = new ArrayList<FeedData>();
        for(Map<String, Object> mapData:msgList){
            FeedData feedData = (FeedData) MapToBean.mapToBean(mapData, FeedData.class);
            feedDataList.add(feedData);
        }
        return feedDataList;
    }



}
