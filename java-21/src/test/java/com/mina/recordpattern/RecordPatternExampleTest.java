package com.mina.recordpattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecordPatternExampleTest {

  @Test
  public void shouldReturnDepositType() {
    Transaction transaction = new Transaction("Deposit", 10000);
    String transactionType = RecordPatternExample.getTransactionType(transaction);

    assertEquals("Deposit", transactionType);
  }

  @Test
  public void shouldReturnWithdrawalType() {
    Transaction transaction = new Transaction("Withdrawal", 5000);
    String transactionType = RecordPatternExample.getTransactionType(transaction);

    assertEquals("Withdrawal", transactionType);
  }

  @Test
  public void shouldReturnUnknown() {
    Transaction transaction = new Transaction("Refund", 2000);
    String transactionType = RecordPatternExample.getTransactionType(transaction);

    assertEquals("Unknown transaction type", transactionType);
  }

  @Test
  public void shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> RecordPatternExample.getTransactionType(null));
  }
}