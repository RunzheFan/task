package com.rzf.task.service;

import com.rzf.task.entity.FeedData;

import java.util.List;

public interface ReadFeedData {

    //get feedData list from rss file
    public List<FeedData> readData();

}
