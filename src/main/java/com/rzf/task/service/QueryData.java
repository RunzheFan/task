package com.rzf.task.service;

import com.rzf.task.entity.FeedData;

import java.util.List;

public interface QueryData {

    //get last 10 record
    public List<FeedData> getTopMsg() throws Exception;
}
