package com.ironman.currentaccount.application.model.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountIdentificationEntity {

  private String accountIdentificationType;
  private IdentifierEntity accountIdentification;
}
