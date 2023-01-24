package com.linkedin.events.customer;

import com.linkedin.events.CustomerRegisteredEvent;
import com.linkedin.events.CustomerRemovedEvent;
import com.linkedin.events.email.EmailService;
import lombok.RequiredArgsConstructor;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerService
{

    private final CustomerRepository customerRepository;

    private final EmailService emailService;
    
    private final ApplicationEventPublisher eventPublisher;

    public void register(Customer customer)
    {
        customerRepository.save(customer);
        emailService.sendRegisterEmail(customer);
        
        eventPublisher.publishEvent(new CustomerRegisteredEvent(customer));

        //promotion
        //external calls
        //crm
    }

    public void remove(Customer customer)
    {
        customerRepository.delete(customer);
        eventPublisher.publishEvent(new CustomerRemovedEvent(customer));
    }
}
