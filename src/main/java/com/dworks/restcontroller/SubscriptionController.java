package com.dworks.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dworks.dto.model.EventDTO;
import com.dworks.dto.model.NotifyResponse;
import com.dworks.enums.ResponseCodes;
import com.dworks.exceptions.AccountNotFoundException;
import com.dworks.exceptions.DataReadOrWriteException;
import com.dworks.service.EventServiceProcessor;
import com.dworks.utils.EventFetchAndSignService;

/**
 * @author dhairyashil
 *
 */
@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	private EventServiceProcessor eventService;

	@Autowired
	private EventFetchAndSignService eventFetchAndSignService;

	
	/**
	 * @param requestUrl
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/create")
	public NotifyResponse create(@RequestParam(value = "url") String requestUrl) {
		eventFetchAndSignService.getEvent(requestUrl);
		EventDTO eventDTO = null;
		try {

			eventDTO = eventFetchAndSignService.getEvent(requestUrl);
			eventService.createSubscriptionEvent(eventDTO);

		} catch (Exception e) {
			return new NotifyResponse(false, ResponseCodes.INVALID_RESPONSE_ERROR_CODE,
					ResponseCodes.INVALID_RESPONSE_ERROR_MESSAGE);
		}
		return new NotifyResponse(true, eventDTO.getPayload().getAccount().getAccountIdentifier());
	}

	/**
	 * @param requestUrl
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/change")
	public NotifyResponse change(@RequestParam(value = "url") String requestUrl) {

		String accountId = null;
		try {
			
			EventDTO event = eventFetchAndSignService.getEvent(requestUrl);
			accountId = event.getPayload().getAccount().getAccountIdentifier();
			eventService.updateSubscriptionEvent(event);
			
		} catch (AccountNotFoundException e) {
			return new NotifyResponse(false, ResponseCodes.ACCOUNT_NOT_FOUND_ERROR_CODE,
					ResponseCodes.ACCOUNT_NOT_FOUND_ERROR_MESSAGE.concat(accountId));
		} catch (DataReadOrWriteException e) {
			return new NotifyResponse(false, ResponseCodes.INVALID_RESPONSE_ERROR_CODE,
					ResponseCodes.INVALID_RESPONSE_ERROR_MESSAGE);
		}
		return new NotifyResponse(true);
	}

	/**
	 * @param requestUrl
	 * @return
	 */
	/**
	 * @param requestUrl
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/cancel")
	public NotifyResponse cancel(@RequestParam(value = "url") String requestUrl) {
		String accountId = null;
		try {

			EventDTO event = eventFetchAndSignService.getEvent(requestUrl);
			accountId = event.getPayload().getAccount().getAccountIdentifier();
			eventService.cancelSubscriptionEvent(event);

		} catch (AccountNotFoundException e) {
			return new NotifyResponse(false, ResponseCodes.ACCOUNT_NOT_FOUND_ERROR_CODE,
					ResponseCodes.ACCOUNT_NOT_FOUND_ERROR_MESSAGE.concat(accountId));
		} catch (DataReadOrWriteException e) {
			return new NotifyResponse(false, ResponseCodes.INVALID_RESPONSE_ERROR_CODE,
					ResponseCodes.INVALID_RESPONSE_ERROR_MESSAGE);
		}
		return new NotifyResponse(true);
	}
}
