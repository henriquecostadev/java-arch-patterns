package br.com.modules.hexagonal.config;

import br.com.modules.hexagonal.adapter.out.SelectAllPaymentsAdapter;
import br.com.modules.hexagonal.application.core.use_case.ListPaymentUseCase;
import jakarta.enterprise.context.RequestScoped;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@RequestScoped
public class ListPaymentUseCaseConfig {

    @Inject
    private SelectAllPaymentsAdapter selectAllPaymentsAdapter;

    @Produces
    public ListPaymentUseCase produce() {
        return new ListPaymentUseCase(selectAllPaymentsAdapter);
    }

}
