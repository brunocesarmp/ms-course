package dev.brunocesar.hrpayroll.services;

import org.springframework.stereotype.Service;

import dev.brunocesar.hrpayroll.entities.Payment;
import dev.brunocesar.hrpayroll.entities.Worker;
import dev.brunocesar.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	private final WorkerFeignClient workerFeignClient;

	public PaymentService(WorkerFeignClient workerFeignClient) {
		this.workerFeignClient = workerFeignClient;
	}

	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
