package com.ironman.currentaccount.application.model.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DateTimeEntity {

  private String dateTimeContent;
  private String timeZoneCode;
}
