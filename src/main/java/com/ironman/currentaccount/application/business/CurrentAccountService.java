package com.ironman.currentaccount.application.business;

import com.ironman.currentaccount.application.model.api.SavingsAccountFacility;
import java.util.Optional;

public interface CurrentAccountService {
  Optional<SavingsAccountFacility> retrieve(String savingsAccountId);
}
