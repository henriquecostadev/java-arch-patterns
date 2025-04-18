package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.port.in.ListPaymentsInputPort;
import br.com.modules.hexagonal.application.port.out.SelectAllPaymentsOutputPort;

import java.util.List;

public class ListPaymentUseCase implements ListPaymentsInputPort {

    private final SelectAllPaymentsOutputPort selectAllPaymentsOutputPort;

    public ListPaymentUseCase(SelectAllPaymentsOutputPort selectAllPaymentsOutputPort) {
        this.selectAllPaymentsOutputPort = selectAllPaymentsOutputPort;
    }

    @Override
    public List<Payment> list() {
        return selectAllPaymentsOutputPort.selectAll();
    }

}
