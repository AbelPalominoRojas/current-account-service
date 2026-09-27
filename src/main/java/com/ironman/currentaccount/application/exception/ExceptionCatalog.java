package com.ironman.currentaccount.application.exception;

import static com.ironman.currentaccount.application.exception.ApplicationException.ExceptionType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionCatalog {
  DATABASE_ERROR(
      "CUSER0001",
      ExceptionType.INTERNAL_SERVER_ERROR,
      "An unexpected error occurred in the database service."),
  APPLICATION_ERROR(
      "CUSER0002",
      ExceptionType.INTERNAL_SERVER_ERROR,
      "An unexpected error occurred, please try again later.");

  private final String code;
  private final ExceptionType exceptionType;
  private final String message;

  public ApplicationException buildException(Object... args) {
    String formattedMessage = String.format(message, args);

    return new ApplicationException(code, exceptionType, formattedMessage);
  }
}
