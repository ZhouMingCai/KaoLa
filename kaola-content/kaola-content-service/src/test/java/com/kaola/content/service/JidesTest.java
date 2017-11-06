package com.kaola.content.service;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:16:30 2017/11/6
 */
public class JidesTest {

    @Test
    public void  testJedis() throws  Exception{
        //创建一个 Jedis对象 ，参数host,port
        Jedis jedis = new Jedis("116.196.122.90",6379);
        jedis.set("test123","my frist jedis test");
        String string = jedis.get("test123");
        System.out.print(string);
        jedis.close();
    }

    @Test
    public  void  testJedisPool() throws  Exception{
        //创建一个连接池对象。参数为port host
        JedisPool jedisPool = new JedisPool("116.196.122.90",6379);
        //从连接池中获取一个连接——jedis对象
        Jedis jedis = jedisPool.getResource();
        String string = jedis.get("test123");
        System.out.print(string);
        //使用Jedis 操作 Redis ，连接池为单例
        jedis.close();
        jedisPool.close();

    }

    @Test
    public  void  testJedisCluter() throws  Exception{
        //创建一个 JedisCluster 对象，参数nodes为set类型 ,set 中 包含多个 HostAndPort

        Set<HostAndPort>  nodes = new HashSet<>();
        nodes.add(new HostAndPort("116.196.122.90",7001));
        nodes.add(new HostAndPort("116.196.122.90",7002));
        nodes.add(new HostAndPort("116.196.122.90",7003));
        nodes.add(new HostAndPort("116.196.122.90",7004));
        nodes.add(new HostAndPort("116.196.122.90",7005));
        nodes.add(new HostAndPort("116.196.122.90",7006));

        JedisCluster jedisCluster = new JedisCluster(nodes);
        jedisCluster.set("test","123");
        String string = jedisCluster.get("test");
        System.err.print(string);

        jedisCluster.close();
    }
}
