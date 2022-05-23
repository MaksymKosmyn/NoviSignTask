package com.novisign.task.API.Service.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import static org.springframework.kafka.support.serializer.JsonDeserializer.VALUE_DEFAULT_TYPE;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class APIServiceConfig {
    @Bean
    public ProducerFactory<String, String> kafkaUUIDProducerFactory() {
        Map<String, Object> configProps = getProducerConfig();
        configProps.put(VALUE_DEFAULT_TYPE, String.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaUUIDProducerTemplate(
            ProducerFactory<String, String> kafkaEventProducerFactory) {
        return new KafkaTemplate<>(kafkaEventProducerFactory);
    }

    private Map<String, Object> getProducerConfig() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        return configProps;
    }

    @Bean
    public NewTopic compactTopicExample() {
        return TopicBuilder.name("license_v1")
                .partitions(3)
                .replicas(1)
                .compact()
                .build();
    }

    @Bean
    @Primary
    public AdminClient adminClient() {
        return KafkaAdminClient.create(Map.of(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"));
    }
}
