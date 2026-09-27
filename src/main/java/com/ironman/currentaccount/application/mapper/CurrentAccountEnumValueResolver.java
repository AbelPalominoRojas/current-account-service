package com.ironman.currentaccount.application.mapper;

import com.ironman.currentaccount.application.model.api.AccountDatetimeTypeValues;
import com.ironman.currentaccount.application.model.api.AccountIdentificationTypeValues;
import com.ironman.currentaccount.application.model.api.AccountStatusTypeValues;
import com.ironman.currentaccount.application.model.api.AccountTypeValues;
import com.ironman.currentaccount.application.model.api.CurrencyTypeValues;
import com.ironman.currentaccount.application.model.api.PartyIdentificationTypeValues;
import java.util.Arrays;
import java.util.function.Function;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrentAccountEnumValueResolver {

  public static PartyIdentificationTypeValues resolvePartyIdentificationType(String value) {
    return resolveEnumValue(
        value, PartyIdentificationTypeValues.class, PartyIdentificationTypeValues::getValue);
  }

  public static AccountTypeValues resolveAccountType(String value) {
    return resolveEnumValue(value, AccountTypeValues.class, AccountTypeValues::getValue);
  }

  public static AccountStatusTypeValues resolveAccountStatusType(String value) {
    return resolveEnumValue(
        value, AccountStatusTypeValues.class, AccountStatusTypeValues::getValue);
  }

  public static AccountIdentificationTypeValues resolveAccountIdentificationType(String value) {
    return resolveEnumValue(
        value, AccountIdentificationTypeValues.class, AccountIdentificationTypeValues::getValue);
  }

  public static AccountDatetimeTypeValues resolveAccountDatetimeType(String value) {
    return resolveEnumValue(
        value, AccountDatetimeTypeValues.class, AccountDatetimeTypeValues::getValue);
  }

  public static CurrencyTypeValues resolveCurrencyType(String value) {
    return resolveEnumValue(value, CurrencyTypeValues.class, CurrencyTypeValues::getValue);
  }

  private static <T extends Enum<T>> T resolveEnumValue(
      String value, Class<T> enumType, Function<T, String> valueExtractor) {
    if (value == null || value.isBlank()) {
      return null;
    }

    String normalizedValue = value.trim();

    return Arrays.stream(enumType.getEnumConstants())
        .filter(enumValue -> valueExtractor.apply(enumValue) != null)
        .filter(enumValue -> valueExtractor.apply(enumValue).equalsIgnoreCase(normalizedValue))
        .findFirst()
        .orElse(null);
  }
}
