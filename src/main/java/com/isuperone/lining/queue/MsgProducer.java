package com.isuperone.lining.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isuperone.lining.model.dto.task.ImportDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AbstractExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @program: Lining
 * @description: 消息的生产者
 * @author: Joe
 * @create: 2020-06-07 14:53
 **/
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    RabbitAdmin rabbitAdmin;


    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
        rabbitTemplate.setConfirmCallback(this);
    }

    public void createExchage(Long taskID){
        String exchage = "fanoutExchange." + taskID;
        FanoutExchange fanoutExchange = new FanoutExchange(exchage);
        addExchange(fanoutExchange);
    }

    /**
     *
     * @param decodeData 解码的后数据
     * @param encodeData 解码前的数据
     * @param taskID 任务ID
     * @throws JsonProcessingException
     */
    public void sendMsg(HashMap<String, String> decodeData, HashMap<String, String> encodeData ,String taskID) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        ImportDataDto importDataDto = new ImportDataDto();
        importDataDto.setDecodeData(decodeData);
        importDataDto.setEncodeData(encodeData);
        String exchage = "fanoutExchange." + taskID;
        FanoutExchange fanoutExchange = new FanoutExchange(exchage);
        addExchange(fanoutExchange);
        String dataStr = om.writeValueAsString(importDataDto);
        rabbitTemplate.convertAndSend(exchage, "", dataStr);
    }

    /**
     *
     * @param decodeData 解码的后数据
     * @param encodeData 解码前的数据
     * @throws JsonProcessingException
     */
    public void sendLocalMsg(HashMap<String, String> decodeData, HashMap<String, String> encodeData,HashMap<String,Object> calData) throws JsonProcessingException {
        String exchage = "fanoutExchange.";
        FanoutExchange fanoutExchange = new FanoutExchange(exchage);
        addExchange(fanoutExchange);
        ObjectMapper om = new ObjectMapper();
        ImportDataDto importDataDto = new ImportDataDto();
        importDataDto.setDecodeData(decodeData);
        importDataDto.setEncodeData(encodeData);
        importDataDto.setCalData(calData);
        String dataStr = om.writeValueAsString(importDataDto);
        rabbitTemplate.convertAndSend(exchage, "", dataStr);
    }

    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info(" 回调id:" + correlationData);
        if (ack) {
            logger.info("消息成功消费");
        } else {
            logger.info("消息消费失败:" + cause);
        }
    }

    /**
     * 创建Exchange
     *
     * @param exchange
     */
    private void addExchange(AbstractExchange exchange) {
        rabbitAdmin.declareExchange(exchange);
    }


    /**
     * 创建一个指定的Queue
     *
     * @param queue
     * @return queueName
     */
    private String addQueue(Queue queue) {
        return rabbitAdmin.declareQueue(queue);
    }

}

