package com.test.microservice.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfiguration {
    @Value("${cassandra.datacenter}")
    private String datacenter;
    @Value("${cassandra.keyspace}")
    private String keyspace;
    protected String getKeyspaceName() {
        return datacenter;
    }
    public @Bean CqlSession session() {
        return CqlSession.builder().withKeyspace(keyspace).build();
    }
}
