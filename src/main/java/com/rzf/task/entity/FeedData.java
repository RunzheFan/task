package com.rzf.task.entity;

/*
 * Represents one RSS message
 */
public class FeedData {
    String title;
    String description;
    String link;
    String author;
    String pubDate;
    String creator;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "FeedMessage [title=" + title + ", description=" + description
                + ", link=" + link + ", author=" + author + ", pubDate=" + pubDate
                +  ", creator=" + creator
                + "]";
    }

    @Override
    public int hashCode(){
        return title.hashCode()+description.hashCode()+description.hashCode()+link.hashCode()
                +author.hashCode()+pubDate.hashCode()+creator.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(this.getClass()!=obj.getClass()) return false;
        FeedData feedData = (FeedData)obj;
        return title.equals(feedData.title)&&description.equals(feedData.description)&&link.equals(feedData.link)
                &&author.equals(feedData.author)&&pubDate.equals(feedData.pubDate)&&creator.equals(feedData.creator);
    }

}
