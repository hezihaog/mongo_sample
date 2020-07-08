package com.tensquare.comment.controller;

import com.itcast.mongodb.pojo.Result;
import com.tensquare.comment.pojo.Comment;
import com.tensquare.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论模块控制器
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 增加评论
     */
    @PostMapping("/save")
    public Result<?> save(@RequestBody Comment comment) {
        commentService.add(comment);
        return Result.ok("提交成功");
    }

    /**
     * 删除评论
     *
     * @param id 评论Id
     */
    @DeleteMapping("/{id}")
    public Result<?> deleteById(@PathVariable String id) {
        commentService.deleteById(id);
        return Result.ok("删除成功");
    }

    /**
     * 根据文章Id，查询评论列表
     *
     * @param articleId 文章Id
     */
    @GetMapping("/article/{articleId}")
    public Result<List<Comment>> findByArticleId(@PathVariable String articleId) {
        List<Comment> resultList = commentService.findByArticleId(articleId);
        return Result.ok(resultList);
    }
}