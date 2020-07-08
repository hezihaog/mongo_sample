package com.itcast.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * 条件查询
 */
public class MongoDemo1 {
    public static void main(String[] args) {
        //创建连接
        MongoClient client = new MongoClient("127.0.0.1");
        //打开数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        //获取集合（相当于表）
        MongoCollection<Document> spit = spitdb.getCollection("spit");

        //重点：条件查询，构建条件
        BasicDBObject bson = new BasicDBObject("userid", "1013");

        //查询所有记录
        FindIterable<Document> documents = spit.find(bson);
        for (Document document : documents) {
            System.out.println("---------------------------------------------");
            System.out.println("内容：" + document.getString("content"));
            System.out.println("用户Id：" + document.getString("userid"));
            System.out.println("浏览量：" + document.getInteger("visits"));
            System.out.println("---------------------------------------------");
        }
        //关闭连接
        client.close();
    }
}