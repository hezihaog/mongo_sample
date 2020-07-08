package com.tensquare.spit.controller;

import com.itcast.mongodb.pojo.PageResult;
import com.itcast.mongodb.pojo.Result;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 吐槽业务控制器
 */
@RestController
//处理跨域
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {
    @Autowired
    private SpitService spitService;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 查询所有数据
     */
    @GetMapping("/findAll")
    public Result<List<Spit>> findAll() {
        return Result.ok(spitService.findAll());
    }

    /**
     * 根据Id查询
     */
    @GetMapping("/{id}")
    public Result<Spit> findOne(@PathVariable String id) {
        return Result.ok(spitService.findById(id));
    }

    /**
     * 增加一条数据
     */
    @PostMapping("/add")
    public Result<?> add(@RequestBody Spit spit) {
        spitService.add(spit);
        return Result.ok("添加成功");
    }

    /**
     * 更新数据
     */
    @PutMapping("/{id}")
    public Result<?> update(@RequestBody Spit spit, @PathVariable String id) {
        spit.set_id(id);
        spitService.update(spit);
        return Result.ok("修改成功");
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public Result<?> deleteById(@PathVariable String id) {
        spitService.deleteById(id);
        return Result.ok("删除成功");
    }

    /**
     * 分页查询，获取评论列表
     *
     * @param parentId 上级Id
     * @param page     当前页码
     * @param size     一页多少条
     */
    @GetMapping("/comment/{parentId}/{page}/{size}")
    public Result<PageResult<Spit>> findByParentId(@PathVariable String parentId,
                                                   @PathVariable int page,
                                                   @PathVariable int size) {
        Page<Spit> pageList = spitService.findByParentId(parentId, page, size);
        //数据
        List<Spit> contentList = pageList.getContent();
        long totalElements = pageList.getTotalElements();
        int totalPages = pageList.getTotalPages();
        PageResult<Spit> pageResult = new PageResult<>(contentList, totalElements, totalPages);
        return Result.ok(pageResult);
    }

    /**
     * 增加点赞数
     */
    @PutMapping("/thumbup/{id}")
    public Result<?> updateThumbup(String id) {
        //先这么写，后续会改成登录用户的Id
        String userid = "2023";
        String key = "thumbup_" + userid + "_" + id;
        Object value = redisTemplate.opsForValue().get(key);
        if (value != null) {
            //点过赞了
            return Result.fail("你已经点过赞了");
        } else {
            //没有点赞过，点赞
            spitService.updateThumbup(id);
            redisTemplate.opsForValue().set(key, "1");
            return Result.ok();
        }
    }
}