package com.kaola.search.service;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:15:38 2017/10/31
 */
public class TestSolrJ {


    @Test
    public void addDocument() throws Exception{

        SolrServer solrServer = new HttpSolrServer("http://116.196.122.90:8080/solr/collection1");

        SolrInputDocument document = new SolrInputDocument();

        document.addField("id","doc01");

        document.addField("item_title","测试商品01");
        document.addField("item_price",1000);
        solrServer.add(document);

        solrServer.commit();
    }

    @Test
    public void delDocument() throws Exception{
        SolrServer solrServer = new HttpSolrServer("http://116.196.122.90:8080/solr/collection1");

        solrServer.deleteById("doc01");

        solrServer.commit();
    }
}
