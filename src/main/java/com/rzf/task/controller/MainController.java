package com.rzf.task.controller;

import com.rzf.task.entity.FeedData;
import com.rzf.task.service.QueryData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * index controller to show last 10 records localhost:8080/
 */
@RestController
public class MainController {

    @Resource
    QueryData msgReader;

    @RequestMapping("/")
    public List<FeedData> index() throws Exception {
        List<FeedData> msgList = new ArrayList<FeedData>();
        msgList = msgReader.getTopMsg();
        return msgList;
    }
}
