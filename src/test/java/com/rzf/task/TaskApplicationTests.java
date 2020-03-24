package com.rzf.task;

import static org.junit.Assert.assertEquals;

import com.rzf.task.entity.FeedData;
import com.rzf.task.service.ReadFeedData;
import com.rzf.task.service.QueryData;
import com.rzf.task.util.MapToBean;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcOperations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TaskApplicationTests {

    @Autowired
    private JdbcOperations jdbcTemplate;

    @Autowired
    QueryData queryData;

    @Autowired
    ReadFeedData readFeedData;

    @Before
    public void before() {
        System.out.println("Start test=============");
    }

    @After
    public void after() {
        System.out.println("End test=============");
    }

    @Test
    void contextLoads() throws Exception {
        List<FeedData> rssdata = readFeedData();
        List<FeedData> dbdata = getFeedData();
        assertEquals(rssdata, dbdata);
    }

    //get data from database
    public List<FeedData> getFeedData() throws Exception {
        List<Map<String, Object>> feedDataList = new ArrayList<Map<String, Object>>();
        String sql = "SELECT title, link, author, description, pubDate, creator FROM FEED_DATA";
        feedDataList = jdbcTemplate.queryForList(sql);
        List<FeedData> feedData = new ArrayList<FeedData>();
        for(Map<String, Object> mapData:feedDataList){
            FeedData Data = (FeedData)MapToBean.mapToBean(mapData, FeedData.class);
            feedData.add(Data);
        }
        return feedData;
    }

    //read data from rss
    public List<FeedData>  readFeedData(){
        List<FeedData> list = new ArrayList<FeedData>();
        list = readFeedData.readData();
        for(FeedData Data:list){
        }
        return list;
    }

}
