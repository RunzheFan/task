package com.rzf.task.service;

import com.rzf.task.entity.Feed;
import com.rzf.task.entity.FeedData;
import com.rzf.task.util.RSSFeedParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadFeedDataImpl implements ReadFeedData {

    @Override
    public List<FeedData> readData() {
        List<FeedData> list = new ArrayList<FeedData>();
        //rss file URL
        RSSFeedParser parser = new RSSFeedParser("https://www.javaworld.com/index.rss");
        Feed feed = parser.readFeed();
        for (FeedData message : feed.getMessages()) {
            list.add(message);
        }
        return list;
    }
}
