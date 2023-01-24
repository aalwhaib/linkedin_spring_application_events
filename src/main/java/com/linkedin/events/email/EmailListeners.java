package com.linkedin.events.email;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.linkedin.events.CustomerRegisteredEvent;
import com.linkedin.events.CustomerRemovedEvent;
import com.linkedin.events.order.OrderCompletedEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailListeners {

	private final EmailService emailService;

	@EventListener
	public void onRegisterEvent(CustomerRegisteredEvent event) {
		emailService.sendRegisterEmail(event.getCustomer());
	}

	@EventListener
	public void onRemovedEvent(CustomerRemovedEvent event) {
		emailService.sendCustomerRemovedEmail(event.getCustomer());
	}

	@EventListener
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void onOrderCompletedEvent(OrderCompletedEvent event) {
		emailService.sendOrderEmail(event.getOrder());
	}
}
