package io.confluent.developer.ccloud.demo.kstream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import io.confluent.developer.ccloud.demo.kstream.data.domain.transaction.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j(topic = "TransactionRequest")
@RequiredArgsConstructor
class SimpleTransactionRequestConsumer {

  @KafkaListener(groupId = "txRequestConsumer", topics = {"transaction-request"})
  public void listen(ConsumerRecord<String, Transaction> record) {
    log.info("received request with id {} and value {}", record.key(), record.value());
  }
}
