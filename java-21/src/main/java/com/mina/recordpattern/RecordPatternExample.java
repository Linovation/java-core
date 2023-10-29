package com.mina.recordpattern;

/*
Record pattern matching is a way to match the Record’s type and access its components in a single step.
 */
public class RecordPatternExample {

  // I'm using "_" for readability here, this won't compile
  public static String getTransactionType(Transaction transaction) {
    return switch (transaction) {
      case null -> throw new IllegalArgumentException("Transaction can not be null.");
      case Transaction(String type, double amount) when type.equals("Deposit") && amount > 0 -> "Deposit";
      case Transaction(String type, _) when type.equals("Withdrawal") -> "Withdrawal";
      case Transaction(_,_) -> "Unknown transaction type";
    };
  }
}
