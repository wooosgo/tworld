package com.pet;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.Utf8StringCodec;
import io.lettuce.core.masterslave.MasterSlave;
import io.lettuce.core.masterslave.StatefulRedisMasterSlaveConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jonas on 09/05/2018.
 */

@Configuration
public class AppConfig {

    @Bean
    //public StatefulRedisMasterSlaveConnection<String, String> SentinelConnection() {
    public StatefulRedisMasterSlaveConnection<String, String> SentinelConnection() {

        /*RedisClient redisClient = RedisClient
                .create("redis://localhost:6379/");
        StatefulRedisConnection<String, String> connection
                = redisClient.connect();
        */
        RedisClient redisClient = RedisClient.create();

        // URI format
        // redis-sentinel :// [: password@] host1[: port1] [, host2[: port2]] [, hostN[: portN]] [/ database][?[timeout=timeout[d|h|m|s|ms|us|ns]] [&_sentinelMasterId=sentinelMasterId_] [&_database=database_]]

        StatefulRedisMasterSlaveConnection<String, String> connection = MasterSlave.connect(redisClient, new Utf8StringCodec(),
                //RedisURI.create("redis-sentinel://10.1.0.63:26379,10.1.0.65:26380,10.1.0.66:26381#mymaster"));
                RedisURI.create("redis-sentinel://10.100.253.204:26379#mymaster"));

        return connection;
    }
}
