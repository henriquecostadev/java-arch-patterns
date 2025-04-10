package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.ports.in.ListPaymentsInputPort;
import br.com.modules.hexagonal.application.ports.out.SelectAllPaymentsOutputPort;

import java.util.List;

public class ListPaymentsUseCase implements ListPaymentsInputPort {

    private final SelectAllPaymentsOutputPort selectAllPaymentsOutputPort;

    public ListPaymentsUseCase(SelectAllPaymentsOutputPort selectAllPaymentsOutputPort) {
        this.selectAllPaymentsOutputPort = selectAllPaymentsOutputPort;
    }

    @Override
    public List<Payment> list() {
        return selectAllPaymentsOutputPort.selectAll();
    }

}
