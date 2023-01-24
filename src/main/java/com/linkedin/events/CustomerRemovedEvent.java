package com.linkedin.events;

import com.linkedin.events.customer.Customer;

import lombok.Data;

@Data
public class CustomerRemovedEvent {

	private final Customer customer;
	
}
