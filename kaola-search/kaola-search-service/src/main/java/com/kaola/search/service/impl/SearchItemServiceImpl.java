package com.kaola.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaola.common.pojo.SearchItem;
import com.kaola.common.utils.KLResult;
import com.kaola.search.mapper.SearchItemMapper;
import com.kaola.search.service.SearchItemService;

/**
 * Author:Zhoumc
 * Description:
 * DATA:16:40 2017/10/31
 */
@Service
public class SearchItemServiceImpl  implements SearchItemService {


    @Autowired
    private SearchItemMapper searchItemMapper;

    @Autowired
    private SolrServer solrServer;

    @Override
    public KLResult getAllSearchItems() {
        try {
            List<SearchItem> itemList = searchItemMapper.getSearchItemList();
            for (SearchItem searchItem : itemList){
                SolrInputDocument document = new SolrInputDocument();
                //向文档对象中添加域
                document.addField("id", searchItem.getId());
                document.addField("item_title", searchItem.getTitle());
                document.addField("item_sell_point", searchItem.getSell_point());
                document.addField("item_price", searchItem.getPrice());
                document.addField("item_image", searchItem.getImage());
                document.addField("item_category_name", searchItem.getCategory_name());
                solrServer.add(document);
            }
            //提交
            solrServer.commit();
            return KLResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            KLResult.build(500,e.getMessage());
        }

        return null;
    }
}
