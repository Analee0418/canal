package com.alibaba.otter.canal.client.adapter.rdb.test.sync;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.otter.canal.client.adapter.rdb.RdbAdapter;
import com.alibaba.otter.canal.client.adapter.support.Dml;

public class OracleSyncTest {

    private RdbAdapter rdbAdapter;

    @Before
    public void init() {
        rdbAdapter = Common.init();
    }

    @Test
    public void test01() {
        Dml dml = new Dml();
        dml.setDestination("example");
        dml.setTs(new Date().getTime());
        dml.setType("INSERT");
        dml.setDatabase("mytest");
        dml.setTable("user");
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> data = new LinkedHashMap<>();
        dataList.add(data);
        data.put("id", 1L);
        data.put("name", "Eric");
        data.put("role_id", 1L);
        data.put("c_time", new Date());
        data.put("test1", "sdfasdfawe中国asfwef");
        dml.setData(dataList);

        rdbAdapter.sync(dml);
    }

    @Test
    public void test02() {
        Dml dml = new Dml();
        dml.setDestination("example");
        dml.setTs(new Date().getTime());
        dml.setType("UPDATE");
        dml.setDatabase("mytest");
        dml.setTable("user");
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> data = new LinkedHashMap<>();
        dataList.add(data);
        data.put("id", 1L);
        data.put("name", "Eric2");
        dml.setData(dataList);
        List<Map<String, Object>> oldList = new ArrayList<>();
        Map<String, Object> old = new LinkedHashMap<>();
        oldList.add(old);
        old.put("name", "Eric");
        dml.setOld(oldList);

        rdbAdapter.sync(dml);
    }

}
