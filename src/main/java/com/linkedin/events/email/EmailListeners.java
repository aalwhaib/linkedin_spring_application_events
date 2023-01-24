package com.linkedin.events.email;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.linkedin.events.CustomerRegisteredEvent;
import com.linkedin.events.CustomerRemovedEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailListeners {

	private final EmailService emailService;

	@EventListener
	public void onRegisterEvent(CustomerRegisteredEvent event) {
		emailService.sendRegisterEmail(event.getCustomer());
	}

	public void onRemovedEvent(CustomerRemovedEvent event) {
		emailService.sendCustomerRemovedEmail(event.getCustomer());
	}

}
