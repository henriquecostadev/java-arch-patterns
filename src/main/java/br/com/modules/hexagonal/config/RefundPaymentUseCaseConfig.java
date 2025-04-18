package br.com.modules.hexagonal.config;

import br.com.modules.hexagonal.adapter.out.UpdatePaymentAdapter;
import br.com.modules.hexagonal.application.core.use_case.FindPaymentByIdUseCase;
import br.com.modules.hexagonal.application.core.use_case.RefundPaymentUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@RequestScoped
public class RefundPaymentUseCaseConfig {

    @Inject
    private FindPaymentByIdUseCase findPaymentByIdUseCase;

    @Inject
    private UpdatePaymentAdapter updatePaymentAdapter;

    @Produces
    public RefundPaymentUseCase produce() {
        return new RefundPaymentUseCase(findPaymentByIdUseCase, updatePaymentAdapter);
    }

}
