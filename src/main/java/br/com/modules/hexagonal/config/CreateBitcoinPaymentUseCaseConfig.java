package br.com.modules.hexagonal.config;

import br.com.modules.hexagonal.adapter.out.InsertPaymentAdapter;
import br.com.modules.hexagonal.adapter.out.PublishNewPaymentAdapter;
import br.com.modules.hexagonal.adapter.out.UpdatePaymentAdapter;
import br.com.modules.hexagonal.adapter.out.WithdrawBitcoinAdapter;
import br.com.modules.hexagonal.application.core.use_case.CreateBitcoinPaymentUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@RequestScoped
public class CreateBitcoinPaymentUseCaseConfig {

    @Inject
    private InsertPaymentAdapter insertPaymentAdapter;

    @Inject
    private WithdrawBitcoinAdapter withdrawBitcoinAdapter;

    @Inject
    private UpdatePaymentAdapter updatePaymentAdapter;

    @Inject
    private PublishNewPaymentAdapter publishNewPaymentAdapter;

    @Produces
    public CreateBitcoinPaymentUseCase produce() {
        return new CreateBitcoinPaymentUseCase(
                insertPaymentAdapter,
                withdrawBitcoinAdapter,
                updatePaymentAdapter,
                publishNewPaymentAdapter
        );
    }

}
