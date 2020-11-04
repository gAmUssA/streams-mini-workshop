package io.confluent.developer.ccloud.demo.kstream;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

import io.confluent.developer.ccloud.demo.kstream.topic.TopicConfig;
import io.confluent.developer.ccloud.demo.kstream.topic.TransactionRequestTopicConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@EnableKafka
@SpringBootApplication
@Slf4j(topic = "Data Generator")
@RequiredArgsConstructor
public class DataGeneratorApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(DataGeneratorApplication.class, args);
  }

  // TOPICS
  @Bean
  NewTopic transactionRequestTopic(TransactionRequestTopicConfig topicConfig) {
    return createTopic(topicConfig);
  }

  private NewTopic createTopic(TopicConfig topicConfig) {
    log.info("Creating topic {}...", topicConfig.getName());
    return TopicBuilder.name(topicConfig.getName())
        .partitions(topicConfig.getPartitions())
        .replicas(topicConfig.getReplicationFactor())
        .compact()
        .build();
  }
  // end TOPIC

  @Override
  public void run(String... args) {
    log.info("DataGen running...");
  }

}