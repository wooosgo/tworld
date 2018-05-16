package com.pet;

import io.lettuce.core.masterslave.StatefulRedisMasterSlaveConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedsentApplicationTests {

/*	@Autowired
	StatefulRedisMasterSlaveConnection connection;

	@Test
	public void contextLoads() throws InterruptedException{

			connection.sync().set("who_master", "im_probably_master");
			System.out.println(connection.sync().get("who_master"));

	}
*/
}
