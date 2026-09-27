package com.ironman.currentaccount.application.repository;

import com.ironman.currentaccount.application.exception.ExceptionCatalog;
import com.ironman.currentaccount.application.model.entity.SavingsAccountEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class SavingsAccountRepository
    implements PanacheMongoRepositoryBase<SavingsAccountEntity, String> {

  public Optional<SavingsAccountEntity> findByCustomerId(String customerId) {
    try {
      return find(
              "customerReference.partyIdentification.partyIdentification.identifierValue",
              customerId)
          .firstResultOptional();
    } catch (Exception e) {
      log.error("Error finding SavingsAccountEntity by customerId: {}", customerId, e);
      throw ExceptionCatalog.DATABASE_ERROR.buildException();
    }
  }

  public Optional<SavingsAccountEntity> findBySavingsAccountId(String savingsAccountId) {
    try {
      return find(
              "accountDetail.accountIdentification.accountIdentification.identifierValue",
              savingsAccountId)
          .firstResultOptional();
    } catch (Exception e) {
      log.error("Error finding SavingsAccountEntity by savingsAccountId: {}", savingsAccountId, e);
      throw ExceptionCatalog.DATABASE_ERROR.buildException();
    }
  }
}
