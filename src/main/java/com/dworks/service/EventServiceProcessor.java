package com.dworks.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dworks.dto.model.AccountDTO;
import com.dworks.dto.model.EventDTO;
import com.dworks.enums.AccountStatus;
import com.dworks.exceptions.AccountNotFoundException;
import com.dworks.exceptions.DataReadOrWriteException;
import com.dworks.model.Account;
import com.dworks.model.Event;
import com.dworks.repository.AccountRepository;
import com.dworks.repository.EventRepository;

@Service
public class EventServiceProcessor {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private EventRepository eventRepo;

	@Transactional
	public boolean createSubscriptionEvent(EventDTO eventDTO) throws Exception {
		Event subscription = new Event(eventDTO);
		Account account = accountRepository.save(new Account(AccountStatus.ACTIVE));
		
		subscription.getPayload().setAccount(account);
		eventDTO.getPayload().setAccount(new AccountDTO(account));

		try {
			eventRepo.save(subscription);
		} catch (Exception ex) {
			throw new DataReadOrWriteException("Error while creating subscription");
		}
		return true;
	}
	
	@Transactional
	public boolean updateSubscriptionEvent(EventDTO eventDTO) {
		String accountId = null;
		try {
			accountId = eventDTO.getPayload().getAccount().getAccountIdentifier();
			Event existingEvent = eventRepo.findByPayloadAccountAccountIdentifier(accountId);
			
			if(existingEvent == null) {
				throw new AccountNotFoundException("Account Not present");
			}
			Event subscription = new Event(eventDTO);
			subscription.setId(existingEvent.getId());
			eventRepo.save(subscription);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account Not present with accountId : " + accountId);
		} catch (Exception ex) {
			throw new DataReadOrWriteException("Error while creating subscription");
		}
		
		return true;
	}
	
	@Transactional
	public boolean cancelSubscriptionEvent(EventDTO eventDTO) {
		String accountId = null;
		try {
			accountId = eventDTO.getPayload().getAccount().getAccountIdentifier();
			
			Account account = accountRepository.findOne(accountId);
			if(account == null)
				throw new AccountNotFoundException("Account Not present with accountId : " + accountId);
			account.setStatus(AccountStatus.INACTIVE);
			accountRepository.save(account);
			
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account Not present with accountId : " + accountId);
		} catch (Exception ex) {
			throw new DataReadOrWriteException("Error while creating subscription");
		}
		return true;
	}
}
