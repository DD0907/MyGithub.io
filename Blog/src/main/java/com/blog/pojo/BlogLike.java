package com.blog.pojo;

public class BlogLike {
    private Integer id;

    private Integer likeId;

    private Integer blogId;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}