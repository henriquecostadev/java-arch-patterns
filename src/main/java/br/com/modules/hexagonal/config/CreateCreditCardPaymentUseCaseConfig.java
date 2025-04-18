package br.com.modules.hexagonal.config;

import br.com.modules.hexagonal.adapter.out.AuthorizeCreditCardAdapter;
import br.com.modules.hexagonal.adapter.out.InsertPaymentAdapter;
import br.com.modules.hexagonal.adapter.out.PublishNewPaymentAdapter;
import br.com.modules.hexagonal.adapter.out.UpdatePaymentAdapter;
import br.com.modules.hexagonal.application.core.use_case.CreateCreditCardPaymentUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@RequestScoped
public class CreateCreditCardPaymentUseCaseConfig {

    @Inject
    private InsertPaymentAdapter insertPaymentAdapter;

    @Inject
    private AuthorizeCreditCardAdapter authorizeCreditCardAdapter;

    @Inject
    private UpdatePaymentAdapter updatePaymentAdapter;

    @Inject
    private PublishNewPaymentAdapter publishNewPaymentAdapter;

    @Produces
    public CreateCreditCardPaymentUseCase produce() {
        return new CreateCreditCardPaymentUseCase(
                insertPaymentAdapter,
                authorizeCreditCardAdapter,
                updatePaymentAdapter,
                publishNewPaymentAdapter
        );
    }

}
