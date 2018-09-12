package com.hsjry.cc.batch.spring.tasklet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class Tasklet3 implements Tasklet {
	
	private static Logger log = LoggerFactory.getLogger(Tasklet3.class);

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		log.info("执行【第3步】");
		Thread.sleep(15000);
		return RepeatStatus.FINISHED;
	}

}
