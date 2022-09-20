package interfaces.model.services;

import java.time.LocalDate;

import interfaces.model.entities.Contract;
import interfaces.model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota); 
			
			contract.getInstallments().add(new Installment(addMonths(contract.getDate(), i), fullQuota));
		}
	}
	
	private LocalDate addMonths(LocalDate date, int months) {
		return date.atStartOfDay().plusMonths(months).toLocalDate();
	}
	
}
