package dev.brunocesar.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.brunocesar.hrpayroll.entities.Payment;
import dev.brunocesar.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	private final PaymentService service;

	public PaymentResource(PaymentService service) {
		this.service = service;
	}

	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		var payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}

}
