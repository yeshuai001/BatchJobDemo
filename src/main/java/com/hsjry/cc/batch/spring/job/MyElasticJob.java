package com.hsjry.cc.batch.spring.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.batch.core.Job;
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

public class MyElasticJob implements SimpleJob {

    @Autowired
    @Qualifier("taskJob")
    private Job job;
    @Autowired
    private JobLauncher jobLauncher;

    @Override
    public void execute(ShardingContext context) {
        System.out.println("------------- 任务开始 -------------");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateText = df.format(new Date());
        JobParametersBuilder builder = new JobParametersBuilder();
        builder.addString("jobDate", dateText);
        builder.addDate("jobTime", new Date());

        try {
            jobLauncher.run(job, builder.toJobParameters());
        } catch (JobExecutionAlreadyRunningException e) {
            System.out.println("任务执行失败 : " + e.getMessage());
            throw new RuntimeException(e);
        } catch (JobRestartException e) {
            System.out.println("任务执行失败 : " + e.getMessage());
            throw new RuntimeException(e);
        } catch (JobInstanceAlreadyCompleteException e) {
            System.out.println("任务执行失败 : " + e.getMessage());
            throw new RuntimeException(e);
        } catch (JobParametersInvalidException e) {
            System.out.println("任务执行失败 : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
