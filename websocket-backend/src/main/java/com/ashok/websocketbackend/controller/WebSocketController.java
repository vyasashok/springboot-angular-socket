package com.ashok.websocketbackend.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/send/message") 
	public void onRecieveMessage(String message){
		template.convertAndSend("/chat", message);
	}

}
