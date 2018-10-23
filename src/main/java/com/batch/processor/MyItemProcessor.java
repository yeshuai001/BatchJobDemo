package com.batch.processor;

import com.batch.dao.model.MyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 步骤数据处理器
 */
@Component
@Scope("step")
public class MyItemProcessor implements ItemProcessor<MyModel, MyModel> {
	
	private final static Logger log = LoggerFactory.getLogger(MyItemProcessor.class);

	public MyModel process(MyModel item) throws Exception {
		item.setUpdateBy("admin");
		item.setUpdateTime(new Date());
		log.info("执行【第2步】 : " + item.getSignContent());
		if(1 == 1) {
			throw new NullPointerException();
		}
		return item;
	}

}
