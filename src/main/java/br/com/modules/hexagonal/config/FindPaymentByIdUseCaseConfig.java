package br.com.modules.hexagonal.config;

import br.com.modules.hexagonal.adapter.out.SelectPaymentByIdAdapter;
import br.com.modules.hexagonal.application.core.use_case.FindPaymentByIdUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@RequestScoped
public class FindPaymentByIdUseCaseConfig {

    @Inject
    private SelectPaymentByIdAdapter selectPaymentByIdAdapter;

    @Produces
    public FindPaymentByIdUseCase produce() {
        return new FindPaymentByIdUseCase(selectPaymentByIdAdapter);
    }

}
