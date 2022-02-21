package com.isuperone.lining.queue;

import com.isuperone.lining.config.RabbitConfig;
import com.isuperone.lining.model.entity.biz.BizTaskTerminalData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: Lining
 * @description: 消息消费者
 * @author: Joe
 * @create: 2020-06-07 14:56
 **/
public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String data) {
        logger.info("接收处理队列A当中的消息： " + data);
        String NOW_TIME = new Date().toString();
        logger.info( "第一个广播模式的消费者在"+NOW_TIME+"从theFirstOneBroadcastQueue取得的消息是"+ data);
    }

}
