package com.mina.switchpatternmatching;

public sealed class Transaction permits Deposit, Withdrawal {

  private double amount;

  public Transaction(double amount) {
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

}
