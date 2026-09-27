package com.ironman.currentaccount.application.model.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmountEntity {

  private String amountValue;
  private AccountCurrencyEntity amountCurrency;
}
