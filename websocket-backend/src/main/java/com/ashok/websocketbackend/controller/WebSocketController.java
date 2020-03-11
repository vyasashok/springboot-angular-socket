package com.ashok.websocketbackend.controller;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/send/message") 
	public void onRecieveMessage(String message){
		
		logger.debug(message);
		
		template.convertAndSend("/chat", message);
	}

}
