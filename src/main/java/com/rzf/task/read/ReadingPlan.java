package com.rzf.task.read;

import com.rzf.task.dao.FeedDataDao;
import com.rzf.task.entity.Feed;
import com.rzf.task.entity.FeedData;
import com.rzf.task.service.ReadFeedData;
import com.rzf.task.util.RSSFeedParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 * Read data from rss file every minute
 */
@Component
public class ReadingPlan{

    @Resource
    FeedDataDao feedDataDao;
    @Resource
    ReadFeedData readFeedData;

    //timer
    @Scheduled(fixedRate = 60000)
    public void readingPlan() {
        System.out.println("Start reading data from rss file.");
        //delete old data
        feedDataDao.delete();
        //get data
        List<FeedData> list = new ArrayList<FeedData>();
        list = readFeedData.readData();
        for(FeedData data:list){
            feedDataDao.save(data);
        }
    }
}
