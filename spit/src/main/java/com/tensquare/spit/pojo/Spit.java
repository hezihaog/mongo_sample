package com.tensquare.spit.pojo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 吐槽表实体
 */
public class Spit implements Serializable {
    /**
     * 主键Id
     */
    @Id
    private String _id;
    /**
     * 发布的内容
     */
    private String content;
    /**
     * 发布时间
     */
    private Date publishtime;
    /**
     * 用户Id
     */
    private String userid;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 浏览量
     */
    private Integer visits;
    /**
     * 缩略图
     */
    private Integer thumbup;
    /**
     * 分享数量
     */
    private Integer share;
    /**
     * 评论数
     */
    private Integer comment;
    /**
     * 状态
     */
    private String state;
    /**
     * 父节点的Id
     */
    private String parentid;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getThumbup() {
        return thumbup;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Spit{" +
                "_id='" + _id + '\'' +
                ", content='" + content + '\'' +
                ", publishtime=" + publishtime +
                ", userid='" + userid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", visits=" + visits +
                ", thumbup=" + thumbup +
                ", share=" + share +
                ", comment=" + comment +
                ", state='" + state + '\'' +
                ", parentid='" + parentid + '\'' +
                '}';
    }
}