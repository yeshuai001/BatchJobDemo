package com.batch.job;

import com.wandaph.tt.api.ShardingContext;
import com.wandaph.tt.spring.job.AbstractSimpleBatchJob;
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
import java.util.UUID;

public class MyJob extends AbstractSimpleBatchJob {

    private final static Logger log = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void doExecute(Job job, JobLauncher jobLauncher, JobParametersBuilder builder, ShardingContext context) {
        log.info("------------- 任务开始执行 -------------");
        builder.addString("uuid", UUID.randomUUID().toString().replace("-","").toUpperCase());

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
        log.info("------------- 任务执行结束 -------------");
    }
}
