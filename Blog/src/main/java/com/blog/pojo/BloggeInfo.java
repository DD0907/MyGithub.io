package com.blog.pojo;

public class BloggeInfo {
    private Integer id;

    private Integer bloggerId;

    private String phone;

    private String about;

    private String intro;

    private String nickname;

    private Integer avatarId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBloggerId() {
        return bloggerId;
    }

    public void setBloggerId(Integer bloggerId) {
        this.bloggerId = bloggerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }
}