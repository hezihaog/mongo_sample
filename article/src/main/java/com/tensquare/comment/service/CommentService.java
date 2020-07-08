package com.tensquare.comment.service;

import com.tensquare.comment.pojo.Comment;
import com.tensquare.comment.dao.CommentDao;
import com.itcast.mongodb.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 评论表Service
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 增加评论
     */
    public void add(Comment comment) {
        comment.set_id(idWorker.nextId() + "");
        comment.setPublishdate(new Date());
        commentDao.save(comment);
    }

    /**
     * 删除评论
     *
     * @param id 评论Id
     */
    public void deleteById(String id) {
        commentDao.deleteById(id);
    }

    /**
     * 根据文章Id，查询评论列表
     *
     * @param articleId 文章Id
     */
    public List<Comment> findByArticleId(String articleId) {
        return commentDao.findByArticleid(articleId);
    }
}