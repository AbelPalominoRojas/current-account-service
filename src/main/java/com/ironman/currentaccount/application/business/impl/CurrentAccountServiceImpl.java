package com.ironman.currentaccount.application.business.impl;

import com.ironman.currentaccount.application.business.CurrentAccountService;
import com.ironman.currentaccount.application.exception.ApplicationException;
import com.ironman.currentaccount.application.exception.ExceptionCatalog;
import com.ironman.currentaccount.application.mapper.CurrentAccountMapper;
import com.ironman.currentaccount.application.model.api.SavingsAccountFacility;
import com.ironman.currentaccount.application.repository.SavingsAccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@ApplicationScoped
public class CurrentAccountServiceImpl implements CurrentAccountService {
  private final SavingsAccountRepository savingsAccountRepository;
  private final CurrentAccountMapper currentAccountMapper;

  @Override
  public Optional<SavingsAccountFacility> retrieve(String savingsAccountId) {
    try {
      return savingsAccountRepository
          .findBySavingsAccountId(savingsAccountId)
          .map(currentAccountMapper::toAccountFacility);
    } catch (ApplicationException e) {
      log.error("Error retrieving savings account facility with id {}", savingsAccountId, e);
      throw e;
    } catch (Exception e) {
      log.error(
          "Unexpected error retrieving savings account facility with id {}", savingsAccountId, e);
      throw ExceptionCatalog.APPLICATION_ERROR.buildException();
    }
  }
}
