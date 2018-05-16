package com.pet;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.masterslave.StatefulRedisMasterSlaveConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 10/05/2018.
 */
@RestController
public class InitController {

    @Autowired
    StatefulRedisMasterSlaveConnection connection;
    //StatefulRedisConnection connection;

    @RequestMapping("/init")
    public void initConnection() throws InterruptedException {

            connection.sync().set("who_master", "im_probably_master");
            System.out.println(connection.sync().get("who_master"));

    }
}
