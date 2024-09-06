package com.velb.SecondMs.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class SecondMsConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @Value(value = "${cluster.kafka.topic.first-topic}")
    private String firstTopic;

    @Value(value = "${cluster.kafka.topic.second-topic}")
    private String secondTopic;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public KafkaConsumer<String,String> kafkaConsumer() {
        Properties consumerProperties = new Properties();
        consumerProperties.put("bootstrap.servers", bootstrapAddress);
        consumerProperties.put("group.id", groupId);
        consumerProperties.put("zookeeper.session.timeout.ms", "6000");
        consumerProperties.put("zookeeper.sync.time.ms","2000");
        consumerProperties.put("auto.commit.enable", "false");
        consumerProperties.put("auto.commit.interval.ms", "1000");
        consumerProperties.put("consumer.timeout.ms", "-1");
        consumerProperties.put("max.poll.records", "1");
        consumerProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<>(consumerProperties);
        kafkaConsumer.subscribe(List.of(secondTopic));
        return kafkaConsumer;
    }

    @Bean
    public KafkaProducer<String, String> kafkaProducer() {
        Properties producerProperties = new Properties();
        producerProperties.put("bootstrap.servers", bootstrapAddress);
        producerProperties.put("acks", "all");
        producerProperties.put("retries", 0);
        producerProperties.put("batch.size", 16384);
        producerProperties.put("linger.ms", 1);
        producerProperties.put("buffer.memory", 33554432);
        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return new KafkaProducer<>(producerProperties);
    }

    @Bean
    public NewTopic firstTopic() {
        return TopicBuilder.name(firstTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic secondTopic() {
        return TopicBuilder.name(secondTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
