package com.ironman.currentaccount.application.model.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyIdentificationEntity {

  private String partyIdentificationType;
  private IdentifierEntity partyIdentification;
}
