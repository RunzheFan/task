package com.rzf.task.dao;

import com.rzf.task.entity.FeedData;

import java.util.List;
import java.util.Map;

public interface FeedDataDao {

    //save feedData
    public void save(FeedData message);

    //delete feedData
    public void delete();

    //query last 10 feedData
    public List<Map<String, Object>> getTopFeedData();
}
