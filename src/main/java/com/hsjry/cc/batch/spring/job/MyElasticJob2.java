package com.hsjry.cc.batch.spring.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyElasticJob2 implements SimpleJob {

    private final static Logger log = LoggerFactory.getLogger(MyElasticJob2.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("------------- 任务【MyElasticJob2】开始 -------------");
        log.info("------------- 任务【MyElasticJob2】结束 -------------");
    }
}
