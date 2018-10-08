package com.hsjry.cc.batch.spring.reader;

import com.hsjry.cc.batch.spring.dao.model.PublicCcSmsSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.*;

import java.util.Date;


public class MyItemReader implements ItemStreamReader{

    private final static Logger log = LoggerFactory.getLogger(MyItemReader.class);

    private static int flag = 1;

    @Override
    public Object read() throws Exception {
        PublicCcSmsSign smsSign = new PublicCcSmsSign();
        smsSign.setJobDate(new Date().toString());
        smsSign.setSignId(2);
        smsSign.setSignCode("PHJR");
        smsSign.setSignContent("普惠金融");
        log.info("MyItemReader : read");
        flag++;
        if(flag > 2){
            log.info("执行【第1步】结束");
            return null;
        }
        return smsSign;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {}

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {}

    @Override
    public void close() throws ItemStreamException {}

}
