package io.confluent.developer.ccloud.demo.kstream.data.domain.transaction;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

  public enum Type {
    DEPOSIT, WITHDRAW
  }

  String guid;
  String account;
  BigDecimal amount;
  Type type;
  String currency;
  String country;
}
