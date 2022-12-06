package com.test.microservice.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfiguration {
    protected String getKeyspaceName() {
        return "datacenter1";
    }
    public @Bean CqlSession session() {
        return CqlSession.builder().withKeyspace("bank_microservice").build();
    }
}
