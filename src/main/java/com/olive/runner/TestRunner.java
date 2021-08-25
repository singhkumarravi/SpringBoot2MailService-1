package com.olive.runner;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.olive.serive.MailService;
@Component
public class TestRunner  implements CommandLineRunner {
	@Autowired
	private MailService ms;
	
	@Override
	public void run(String... args) throws Exception {
		//Resource File=new FileSystemResource("C:\\Users\\USER\\Pictures\\Screenshots\\Screenshot (14).png");
		
	//boolean send=ms.sendEmail("ravisingh@olivecrypto.com",null,null,"Health Issue","Welcome to Ravi Kumar",null);
	boolean send=ms.sendEmail("ajit@olivecrypto.com",null,null,"Health Issue","Welcome to Ravi Kumar",null);
	if(send)
		System.out.println("mail send");
	else
		System.out.println("mail not send");
	}

}
