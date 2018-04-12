package com.blog.pojo;

public class BlogComment {
    private Integer id;

    private Integer blogId;

    private Integer spokesmanId;

    private Integer listenerId;

    private Integer state;

    private String releaseTime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getSpokesmanId() {
        return spokesmanId;
    }

    public void setSpokesmanId(Integer spokesmanId) {
        this.spokesmanId = spokesmanId;
    }

    public Integer getListenerId() {
        return listenerId;
    }

    public void setListenerId(Integer listenerId) {
        this.listenerId = listenerId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}