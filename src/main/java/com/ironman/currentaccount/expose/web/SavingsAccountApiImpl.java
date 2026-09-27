package com.ironman.currentaccount.expose.web;

import com.ironman.currentaccount.application.business.CurrentAccountService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class SavingsAccountApiImpl implements SavingsAccountApi {
  private final CurrentAccountService currentAccountService;

  @Override
  public Response retrieve(String savingsAccountId) {
    var response = currentAccountService.retrieve(savingsAccountId);

    if (response.isEmpty()) {
      return Response.status(Response.Status.NO_CONTENT).build();
    }

    return Response.ok(response).build();
  }
}
