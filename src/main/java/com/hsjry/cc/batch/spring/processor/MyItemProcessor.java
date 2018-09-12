package com.hsjry.cc.batch.spring.processor;

import com.hsjry.cc.batch.spring.dao.model.PublicCcSmsSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 步骤数据处理器
 */
@Component
@Scope("step")
public class MyItemProcessor implements ItemProcessor<PublicCcSmsSign, PublicCcSmsSign> {
	
	private final static Logger log = LoggerFactory.getLogger(MyItemProcessor.class);
			
	@Value("#{jobParameters['jobDate']}")
	private String jobDate;

	public PublicCcSmsSign process(PublicCcSmsSign item) throws Exception {
		item.setUpdateBy("admin");
		item.setUpdateTime(new Date());
		log.info("执行【第2步】 : " + item.getSignContent());
		if(1 == 1) {
			throw new NullPointerException();
		}
		return item;
	}

}
