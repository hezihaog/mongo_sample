package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 吐槽表Dao层
 */
public interface SpitDao extends MongoRepository<Spit, String> {
    /**
     * 根据上级Id查询吐槽列表
     */
    Page<Spit> findByParentid(String parentid, Pageable pageable);
}