package com.ironman.currentaccount.application.model.entity;

import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailEntity {

  private AccountStatusEntity accountStatus;
  private AccountIdentificationEntity accountIdentification;
  private List<AccountDateTimeEntity> accountDates;
  private AccountBalanceEntity accountBalance;
  private AccountNameEntity accountName;
}
