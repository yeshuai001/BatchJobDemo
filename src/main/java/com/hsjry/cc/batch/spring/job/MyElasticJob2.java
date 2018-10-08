package com.hsjry.cc.batch.spring.job;

import com.wandaph.tt.api.ShardingContext;
import com.wandaph.tt.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyElasticJob2 implements SimpleJob {

    private final static Logger log = LoggerFactory.getLogger(MyElasticJob2.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("------------- 任务【MyElasticJob2】开始执行 -------------");
        log.info("------------- 任务【MyElasticJob2】执行结束 -------------");
    }
}
