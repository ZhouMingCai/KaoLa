package com.kaola.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.kaola.common.jedis.JedisClient;
import com.kaola.common.utils.JsonUtils;
import com.kaola.common.utils.KLResult;
import com.kaola.content.spi.ContentService;
import com.kaola.dao.TbContentDao;
import com.kaola.pojo.TbContent;

/**
 * Author:Zhoumc
 * Description:内容管理
 * DATA:10:45 2017/11/6
 */
public class ContentServiceImpl implements ContentService {

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private TbContentDao contentDao;

    @Value("${CONTENT_LIST}")
    private String CONTENT_LIST;

    @Override
    public KLResult addContent(TbContent content) {
        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentDao.insert(content);
        //缓存同步，删除缓存中对应的数据
        jedisClient.hdel(CONTENT_LIST,content.getCategoryId().toString());
        return KLResult.ok();
    }

    @Override
    public List<TbContent> getContentListByCid(long cid) {
        //查询缓存
        try {
            //如果缓存中有，则直接相应结果
            String json = jedisClient.hget(CONTENT_LIST,cid+"");
            if (StringUtils.isNoneBlank(json)){
                List<TbContent> list = JsonUtils.jsonToList(json,TbContent.class);
                return list;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        List<TbContent> list = contentDao.queryById(cid);
        //把结果添加到缓存
        try {
            jedisClient.hset(CONTENT_LIST,cid+"", JsonUtils.objectToJson(list));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
