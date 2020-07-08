package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import com.itcast.mongodb.util.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 吐槽表Service层
 */
@Service
public class SpitService {
    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询所有记录
     */
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据主键查询Id
     */
    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }

    /**
     * 增加数据
     */
    public void add(Spit spit) {
        //设置主键Id
        spit.set_id(idWorker.nextId() + "");
        //发布时间
        spit.setPublishtime(new Date());
        //浏览量
        spit.setVisits(0);
        //分享量
        spit.setShare(0);
        //点赞数
        spit.setThumbup(0);
        //回复数
        spit.setComment(0);
        //状态
        spit.setState("1");
        String parentid = spit.getParentid();
        //存在上级id，那么父节点的吐槽回复数+1
        if (StringUtils.isNotBlank(parentid)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(parentid));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spit");
        }
        spitDao.save(spit);
    }

    /**
     * 更新数据
     */
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 根据Id删除记录
     */
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    /**
     * 根据上级Id查询吐槽列表
     *
     * @param parentId 上级Id
     * @param page     分页页码
     * @param size     每页大小
     */
    public Page<Spit> findByParentId(String parentId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return spitDao.findByParentid(parentId, pageRequest);
    }

    /**
     * 点赞数量+1
     *
     * @param id 吐槽Id
     */
    public void updateThumbup(String id) {
        //按id查询
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        //更新数量
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spit");
    }
}