package com.blog.pojo;

public class BlogStatistics {
    private Integer id;

    private Integer blogId;

    private Integer commentCount;

    private Integer viewCount;

    private Integer replyCommentCount;

    private Integer collectCount;

    private Integer shareCount;

    private Integer admireCount;

    private Integer likeCount;

    private String releaseTime;

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

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getReplyCommentCount() {
        return replyCommentCount;
    }

    public void setReplyCommentCount(Integer replyCommentCount) {
        this.replyCommentCount = replyCommentCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getAdmireCount() {
        return admireCount;
    }

    public void setAdmireCount(Integer admireCount) {
        this.admireCount = admireCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
}