package com.linkedin.events.promotion;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.linkedin.events.CustomerRegisteredEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PromotionListeners {

	private final PromotionService promotionService;

	@EventListener(condition = "#event.customer.newsletter")
	public void onRegistrationEvent(CustomerRegisteredEvent event) {
		promotionService.applyPromotion(event.getCustomer());
	}

}
