package com.kaola.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaola.common.EasyUIDataGridResult;
import com.kaola.common.jedis.JedisClient;
import com.kaola.common.utils.IDUtils;
import com.kaola.common.utils.KLResult;
import com.kaola.dao.TbItemDao;
import com.kaola.dao.TbItemDescDao;
import com.kaola.pojo.TbItem;
import com.kaola.pojo.TbItemDesc;
import com.kaola.service.ItemService;

/**
 * Author:Zhoumc
 * Description:
 * DATA:18:15 2017/10/23
 */
@Service
public class ItemServiceImpl  implements ItemService{

    @Autowired
    private TbItemDao tbItemDao;

    @Autowired
    private TbItemDescDao tbItemDescDao;

    @Autowired
    private TbItemDescDao itemDescDao;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource
    private Destination topicDestination;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public TbItem getItemById(long itemId) {
        //查询缓存
        try {

        }catch (Exception e){
            e.printStackTrace();
        }

        //缓存中没有，查询数据库

        return tbItemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {

        PageHelper.startPage(page,rows);
        List<TbItem> list = tbItemDao.SelectBy();
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        long total = pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }

    @Override
    public KLResult addItem(TbItem item, String desc) {

        //生成商品id
        final long itemId = IDUtils.genItemId();
        //补全商品item属性
        item.setId(itemId);
        //1 ：正常
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //向商品表插入数据
        tbItemDao.insert(item);
        //创建一个商品描述表对应的pojo对象
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        tbItemDescDao.insert(itemDesc);

        jmsTemplate.send(topicDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(itemId + "");
                return textMessage;
            }
        });
        return KLResult.ok();
    }

    @Override
    public TbItemDesc getItemDescById(long itemId) {
        TbItemDesc tbItemDesc = itemDescDao.selectByPrimaryKey(itemId);
        return tbItemDesc;
    }
}
