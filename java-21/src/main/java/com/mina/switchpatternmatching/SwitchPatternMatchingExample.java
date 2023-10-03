package com.mina.switchpatternmatching;

public class SwitchPatternMatchingExample {

  public static String getTransactionType(Transaction transaction) {
    return switch (transaction) {
      case null:
        throw new IllegalArgumentException("Transaction can't be null.");
      case Deposit deposit when deposit.getAmount() > 0: //  Guarded pattern with when clause
        yield "Deposit";
      case Withdrawal withdrawal:
        yield "Withdrawal";
      default:
        yield "Unknown transaction type";
    };
  }
}
