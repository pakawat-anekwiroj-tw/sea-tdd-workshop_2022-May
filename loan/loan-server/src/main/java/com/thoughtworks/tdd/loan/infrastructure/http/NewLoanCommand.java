package com.thoughtworks.tdd.loan.infrastructure.http;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class NewLoanCommand {
  @Min(0)
  @NotNull
  private int amount;
  @Min(0)
  @NotNull
  private int durationInDays;

  public NewLoanCommand() {
  }

  public NewLoanCommand(int amount, int durationInDays) {
    this.amount = amount;
    this.durationInDays = durationInDays;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getDurationInDays() {
    return durationInDays;
  }

  public void setDurationInDays(int durationInDays) {
    this.durationInDays = durationInDays;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NewLoanCommand newLoanCommand = (NewLoanCommand) o;
    return amount == newLoanCommand.amount && durationInDays == newLoanCommand.durationInDays;
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, durationInDays);
  }
}
