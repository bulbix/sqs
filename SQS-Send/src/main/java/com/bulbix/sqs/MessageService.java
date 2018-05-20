package com.bulbix.sqs;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.SqsMessageHeaders;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.model.Message;

@Component
public class MessageService {
	
	@Autowired
	QueueMessagingTemplate messagingTemplate;
	  
	public void send(String topicName, Object message, String number) {
		Map<String,Object> attributes = new HashMap<>();
		attributes.put("phone", number);
		attributes.put(SqsMessageHeaders.SQS_GROUP_ID_HEADER, "sms");
		attributes.put(SqsMessageHeaders.SQS_DEDUPLICATION_ID_HEADER, UUID.randomUUID().toString());
	    messagingTemplate.convertAndSend(topicName, message, attributes);
	}
	
//	@SqsListener("sms")
//	public void receiveMessage(String message, 
//	  @Header("SenderId") String senderId) {
//	   System.out.println(message);
//	}

}
