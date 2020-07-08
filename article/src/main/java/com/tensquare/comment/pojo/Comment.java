package com.tensquare.comment.pojo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论实体
 */
public class Comment implements Serializable {
    @Id
    private String _id;
    /**
     * 文章Id
     */
    private String articleid;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 用户Id
     */
    private String userid;
    /**
     * 父节点Id
     */
    private String parentid;
    /**
     * 发布时间
     */
    private Date publishdate;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }
}