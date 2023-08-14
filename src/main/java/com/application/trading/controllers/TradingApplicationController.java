package com.application.trading.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.trading.handlers.ISignalHandler;




@RestController
public class TradingApplicationController {
	private static Logger logger = LoggerFactory.getLogger(TradingApplicationController.class);
	
	@Autowired
	private ISignalHandler signalHandler;
	
	@PostMapping("/signals/{signal}")
	public String ProcessSignals(
			@PathVariable("signal") Integer signal
		) {
		try {
			signalHandler.handleSignal(signal);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error running Alogorithm", e);
			return "Failed";
		}
		return "Success";
	}
}
