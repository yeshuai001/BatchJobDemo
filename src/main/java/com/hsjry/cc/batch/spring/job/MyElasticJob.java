package com.hsjry.cc.batch.spring.job;

import com.wandaph.tt.api.ShardingContext;
import com.wandaph.tt.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MyElasticJob implements SimpleJob {

    private final static Logger log = LoggerFactory.getLogger(MyElasticJob.class);

    @Autowired
    @Qualifier("taskJob")
    private Job job;
    @Autowired
    private JobLauncher jobLauncher;

    @Override
    public void execute(ShardingContext context) {
        log.info("------------- 任务【MyElasticJob】开始执行 -------------");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        JobParametersBuilder builder = new JobParametersBuilder();
        builder.addString("uuid", UUID.randomUUID().toString().replace("-","").toUpperCase());
        builder.addString("elasticJobClass","com.hsjry.cc.batch.spring.job.MyElasticJob");

        try {
            JobExecution jobExecution = jobLauncher.run(job, builder.toJobParameters());
            while (jobExecution.isRunning()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (JobExecutionAlreadyRunningException e) {
            log.info("任务执行失败 : " + e.getMessage());
            throw new RuntimeException(e);
        } catch (JobRestartException e) {
            log.info("任务执行失败 : " + e.getMessage());
            throw new RuntimeException(e);
        } catch (JobInstanceAlreadyCompleteException e) {
            log.info("任务执行失败 : " + e.getMessage());
            throw new RuntimeException(e);
        } catch (JobParametersInvalidException e) {
            log.info("任务执行失败 : " + e.getMessage());
            throw new RuntimeException(e);
        }
        log.info("------------- 任务【MyElasticJob】执行结束 -------------");
    }
}
