package com.tensquare.spit;

import com.tensquare.spit.SpitApplication;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 吐槽模块测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpitApplication.class)
public class SpitTest {
    @Autowired
    private SpitService spitService;

    /**
     * 查询吐槽列表
     */
    @Test
    public void testFindByParentId() {
        Page<Spit> page = spitService.findByParentId("3", 1, 5);
        List<Spit> resultList = page.getContent();
        for (Spit spit : resultList) {
            System.out.println(spit);
        }
    }
}