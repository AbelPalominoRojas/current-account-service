package com.ironman.currentaccount.application.mapper;

import com.ironman.currentaccount.application.model.api.*;
import com.ironman.currentaccount.application.model.entity.*;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
    componentModel = MappingConstants.ComponentModel.JAKARTA_CDI,
    uses = {CurrentAccountEnumValueResolver.class})
public interface CurrentAccountMapper {

  @Mapping(target = "customerReference", source = "customerReference")
  @Mapping(target = "accountType", source = "accountType")
  @Mapping(target = "accountDetail", source = "accountDetail")
  SavingsAccountFacility toAccountFacility(SavingsAccountEntity account);

  @Mapping(target = "partyIdentification", source = "partyIdentification")
  InvolvedParty toCustomerReference(CustomerReferenceEntity customer);

  @Mapping(target = "partyIdentificationType", source = "partyIdentificationType")
  @Mapping(target = "partyIdentification", source = "partyIdentification")
  PartyIdentification toPartyIdentification(PartyIdentificationEntity identification);

  @Mapping(target = "identifierValue", source = "identifierValue")
  Identifier toIdentifierValue(IdentifierEntity identification);

  @Mapping(target = "accountStatus", source = "accountStatus")
  @Mapping(target = "accountIdentification", source = "accountIdentification")
  @Mapping(target = "accountDates", source = "accountDates")
  @Mapping(target = "accountBalance", source = "accountBalance")
  @Mapping(target = "accountName", source = "accountName")
  Account toAccountDetail(AccountDetailEntity accountDetail);

  @Mapping(target = "accountStatusType", source = "accountStatusType")
  AccountStatus toAccountStatus(AccountStatusEntity accountStatus);

  @Mapping(target = "accountIdentificationType", source = "accountIdentificationType")
  @Mapping(target = "accountIdentification", source = "accountIdentification")
  AccountIdentification toAccountIdentification(AccountIdentificationEntity accountIdentification);

  @IterableMapping(elementTargetType = AccountDateTime.class)
  List<AccountDateTime> toAccountDates(List<AccountDateTimeEntity> accountDates);

  @Mapping(target = "accountDateType", source = "accountDateType")
  @Mapping(target = "accountDate", source = "accountDate")
  AccountDateTime toAccountDateTime(AccountDateTimeEntity accountDateTime);

  @Mapping(target = "dateTimeContent", source = "dateTimeContent")
  @Mapping(target = "timeZoneCode", source = "timeZoneCode")
  DateTimeRecord toAccountDate(DateTimeEntity accountDate);

  @Mapping(target = "balanceAmount", source = "balanceAmount")
  AccountBalance toAccountBalance(AccountBalanceEntity accountBalance);

  @Mapping(target = "amountValue", source = "amountValue")
  @Mapping(target = "amountCurrency", source = "amountCurrency")
  Amount toBalanceAmount(AmountEntity balanceAmount);

  @Mapping(target = "accountCurrencyType", source = "accountCurrencyType")
  AccountCurrency toBalanceCurrency(AccountCurrencyEntity balanceCurrency);

  @Mapping(target = "name", source = "name")
  Name toAccountName(AccountNameEntity accountName);
}
