package com.test.microservice.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.internal.core.metadata.DefaultEndPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

import java.net.InetSocketAddress;

@Configuration
public class CassandraConfiguration {
    @Value("${cassandra.datacenter}")
    private String datacenter;
    @Value("${cassandra.keyspace}")
    private String keyspace;
    @Value("${cassandra.port}")
    private int port;
    @Value("${cassandra.address}")
    private String address;
    public @Bean CqlSession session() {
        return CqlSession.builder().withKeyspace(keyspace).withLocalDatacenter(datacenter).addContactEndPoint(new DefaultEndPoint(new InetSocketAddress(address, port))).build();
    }
}
