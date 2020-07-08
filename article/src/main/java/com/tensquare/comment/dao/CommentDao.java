package com.tensquare.comment.dao;

import com.tensquare.comment.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 评论表Dao
 */
public interface CommentDao extends MongoRepository<Comment, String> {
    /**
     * 根据文章Id，查询评论列表
     *
     * @param articleid 文章Id
     */
    List<Comment> findByArticleid(String articleid);
}