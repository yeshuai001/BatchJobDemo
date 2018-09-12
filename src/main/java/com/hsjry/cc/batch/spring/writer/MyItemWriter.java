package com.hsjry.cc.batch.spring.writer;

import com.hsjry.cc.batch.spring.dao.model.PublicCcSmsSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

import java.util.List;

public class MyItemWriter implements ItemStreamWriter<PublicCcSmsSign>{

    private final static Logger log = LoggerFactory.getLogger(MyItemWriter.class);


    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        log.info("MyItemWriter : open");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        log.info("MyItemWriter : update");
    }

    @Override
    public void close() throws ItemStreamException {
        log.info("MyItemWriter : close");
    }

    @Override
    public void write(List<? extends PublicCcSmsSign> list) throws Exception {
        log.info("MyItemWriter : write");
        for(PublicCcSmsSign smsSign : list){
            log.info("signId = " + smsSign.getSignId());
            log.info("signCode = " + smsSign.getSignCode());
            log.info("signContent = " + smsSign.getSignContent());
        }
    }
}
