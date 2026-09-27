package com.ironman.currentaccount.application.model.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDateTimeEntity {

  private String accountDateType;
  private DateTimeEntity accountDate;
}
