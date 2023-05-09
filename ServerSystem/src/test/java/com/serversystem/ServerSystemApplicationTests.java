package com.serversystem;

import com.serversystem.common.rabbitmq.HelloSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerSystemApplicationTests {

	@Autowired
	private HelloSender helloSender;

	@Test
	void contextLoads() {
		helloSender.send();
	}

	@Test
	void topicOneSend() {
		helloSender.sendOne();
	}

	@Test
	void topicTwoSend() {
		helloSender.sendTwo();
	}

	@Test
	void fanoutSend(){
		helloSender.fanoutSend();
	}

}
