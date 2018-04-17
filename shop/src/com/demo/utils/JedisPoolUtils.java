package com.demo.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * redis数据库连接池工具类
 */
public class JedisPoolUtils {
    private static JedisPool pool;

    static{
        //1.加载配置文件
        InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("JedisPoolUtils.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.加载数据库连接池配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxidle")));
        config.setMinIdle(Integer.parseInt(pro.getProperty("minidle")));
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxtotal")));
        pool = new JedisPool(config,pro.getProperty("url"), Integer.parseInt(pro.getProperty("port")));

    }

    /**
     * 返回jedis链接对象
     * @return jedis对象
     */
    public static Jedis getJedis(){
        return pool.getResource();
    }
}
