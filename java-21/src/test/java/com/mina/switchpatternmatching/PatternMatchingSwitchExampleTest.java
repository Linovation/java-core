package com.mina.switchpatternmatching;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatternMatchingSwitchExampleTest {

  @Test
  public void shouldReturnDepositType() {
    Transaction transaction = new Deposit(10000);
    String transactionType = SwitchPatternMatchingExample.getTransactionType(transaction);

    assertEquals("Deposit", transactionType);
  }

  @Test
  public void shouldReturnUnknown_withInvalidAmount() {
    Transaction transaction = new Deposit(0);
    String transactionType = SwitchPatternMatchingExample.getTransactionType(transaction);

    assertEquals("Unknown transaction type", transactionType);
  }

  @Test
  public void shouldReturnWithdrawalType() {
    Transaction transaction = new Withdrawal(5000);
    String transactionType = SwitchPatternMatchingExample.getTransactionType(transaction);

    assertEquals("Withdrawal", transactionType);
  }

  @Test
  public void shouldReturnUnknown() {
    Transaction transaction = new Transaction(2000);
    String transactionType = SwitchPatternMatchingExample.getTransactionType(transaction);

    assertEquals("Unknown transaction type", transactionType);
  }

  @Test
  public void shouldThrowException() {
    assertThrows(IllegalArgumentException.class,
        () -> SwitchPatternMatchingExample.getTransactionType(null));
  }
}