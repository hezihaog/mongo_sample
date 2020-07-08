package com.itcast.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;

/**
 * 插入数据
 */
public class MongoDemo3 {
    public static void main(String[] args) {
        //创建连接
        MongoClient client = new MongoClient("127.0.0.1");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合（相当于表）
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        //构建数据
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("content", "我要吐槽");
        map.put("userid", "9999");
        map.put("visits", 123);
        map.put("publishtime", new Date());
        //插入数据
        Document document = new Document(map);
        spit.insertOne(document);

        //关闭连接
        client.close();
    }
}