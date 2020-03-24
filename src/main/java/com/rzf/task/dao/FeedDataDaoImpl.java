package com.rzf.task.dao;

import com.rzf.task.entity.FeedData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class FeedDataDaoImpl implements FeedDataDao {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(FeedData message) {
        String sql = "INSERT INTO FEED_DATA (TITLE,DESCRIPTION,LINK,AUTHOR,PUBDATE,CREATOR) VALUES ('"
                + message.getTitle() + "','" + message.getDescription() + "','" + message.getLink() + "','"
                + message.getAuthor() + "','" + message.getPubDate() + "','" + message.getCreator() + "')";
        jdbcTemplate.update(sql);
    }

    @Override
    public void delete() {
        String sql = "delete from feed_data";
        jdbcTemplate.execute(sql);
    }

    @Override
    public List<Map<String, Object>> getTopFeedData() {
        List<Map<String, Object>> msgList = new ArrayList<Map<String, Object>>();
        String sql = "SELECT title, link, author, description, pubDate, creator FROM FEED_DATA ORDER BY ID DESC LIMIT 10";
        msgList = jdbcTemplate.queryForList(sql);
        return msgList;
    }
}
