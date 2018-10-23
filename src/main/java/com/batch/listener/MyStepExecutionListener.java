package com.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;

/**
 * 步骤执行监听器
 */
@Component
public class MyStepExecutionListener implements StepExecutionListener {

	private final static Logger log = LoggerFactory.getLogger(MyStepExecutionListener.class);
	private static final ThreadLocal<Long> timeHandler = new ThreadLocal<Long>();
	
	@PreDestroy
	public void destroy() {
		timeHandler.remove();
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		timeHandler.set(System.currentTimeMillis());
		log.info("【第2步】执行前");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		log.info("【第2步】执行后");
		timeHandler.set(null);
		return ExitStatus.COMPLETED;
	}

}
