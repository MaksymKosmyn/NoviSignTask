package com.novisign.task.API.Service.dbconfig;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@ComponentScan
@EntityScan("com.novisign.task.API.Service.entity")
@EnableJpaRepositories("com.novisign.task.API.Service.repositories")
@PropertySource("classpath:db-config.properties")
public class DBConfiguration {

    private Logger logger;

    public DBConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }

    @Bean
    public DataSource dataSource() {
        logger.info("dataSource() invoked");

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

        DataSource dataSource = (builder.setType(EmbeddedDatabaseType.H2).addScript("classpath:testdb/schema.sql")
                .addScript("classpath:testdb/data.sql").build());

        logger.info("dataSource = " + dataSource);

        return dataSource;
    }
}
