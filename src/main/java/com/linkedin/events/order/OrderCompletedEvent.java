package com.linkedin.events.order;

import lombok.Data;

@Data
public class OrderCompletedEvent {

	private final Order order;

}
