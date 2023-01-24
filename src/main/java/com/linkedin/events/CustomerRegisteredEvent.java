package com.linkedin.events;

import com.linkedin.events.customer.Customer;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomerRegisteredEvent {
	
	private final Customer customer;
	
}
