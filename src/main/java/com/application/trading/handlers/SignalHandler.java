package com.application.trading.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.trading.algo.Algo;
import com.application.trading.config.SignalConfig;
import com.application.trading.models.Signal;
import com.application.trading.models.SignalParam;

@Component
public class SignalHandler implements ISignalHandler {
	
	@Autowired
	private SignalConfig signalConfig;
	
	@Autowired
	private Algo algo;

	@Override
	public void handleSignal(int signal) {
		
		
		List<Signal> signals = signalConfig.LoadYaml();
		Signal signalConfig = signals.stream()
				.filter((sig) -> sig.getId() == signal)
				.findAny()
				.orElse(null);
		if (signalConfig != null) {
			if (signalConfig.isAlgo()) algo.doAlgo();
			if (signalConfig.isSetup()) algo.setUp();
			if (signalConfig.isReverse()) algo.reverse();
			if (signalConfig.isCalculate()) algo.performCalc();
			for (SignalParam param : signalConfig.getParams()) {
			  algo.setAlgoParam(
					  Integer.parseInt(param.getParam()),
					  Integer.parseInt(param.getValue()));
			}
			algo.submitToMarket();
		} else {
			algo.cancelTrades();
		}
	}
}
