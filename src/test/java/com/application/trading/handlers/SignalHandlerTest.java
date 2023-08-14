package com.application.trading.handlers;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.application.trading.algo.Algo;
import com.application.trading.config.SignalConfig;
import com.application.trading.models.Signal;
import com.application.trading.models.SignalParam;

@ExtendWith(MockitoExtension.class)
public class SignalHandlerTest {
	
	@Mock
	private SignalConfig signalConfig = new SignalConfig();
	
	@Mock
    private Algo algo;
	
	@InjectMocks
    private SignalHandler signalHandler;
	
	@BeforeEach
	private void setUp() {
	    MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void TestHandlerSignal1() {
		Signal signal1Config = new Signal();
		SignalParam signal1param = new SignalParam();
		signal1param.setParam("1");
		signal1param.setValue("60");
		List<SignalParam> signal1params = Arrays.asList(signal1param);
		signal1Config.setId(1);
		signal1Config.setParams(signal1params);
		List<Signal> signalList = Arrays.asList(signal1Config);
		Mockito.when(signalConfig.LoadYaml()).thenReturn(signalList);
		signalHandler.handleSignal(1);
		Mockito.verify(algo, Mockito.times(1)).setAlgoParam(1, 60);
	}
	
	@Test
	void TestHandlerSignal2() {
		Signal signal2Config = new Signal();
		SignalParam signal2param = new SignalParam();
		signal2param.setParam("2");
		signal2param.setValue("90");
		List<SignalParam> signal2params = Arrays.asList(signal2param);
		signal2Config.setId(2);
		signal2Config.setParams(signal2params);
		signal2Config.setAlgo(true);
		signal2Config.setSetup(true);
		List<Signal> signalList = Arrays.asList(signal2Config);
		Mockito.when(signalConfig.LoadYaml()).thenReturn(signalList);
		signalHandler.handleSignal(2);
		Mockito.verify(algo, Mockito.times(1)).setAlgoParam(2, 90);
	}
	
	@Test
	void TestHandlerSignal3() {
		Signal signal3Config = new Signal();
		SignalParam signal3param = new SignalParam();
		signal3param.setParam("2");
		signal3param.setValue("90");
		List<SignalParam> signal3params = Arrays.asList(signal3param);
		signal3Config.setId(3);
		signal3Config.setParams(signal3params);
		signal3Config.setAlgo(true);
		signal3Config.setSetup(true);
		List<Signal> signalList = Arrays.asList(signal3Config);
		Mockito.when(signalConfig.LoadYaml()).thenReturn(signalList);
		signalHandler.handleSignal(3);
		Mockito.verify(algo, Mockito.times(1)).setAlgoParam(2, 90);
	}
	
	@Test
	void TestHandlerSignalRandom() {
		signalHandler.handleSignal(1);
		Mockito.verify(algo, Mockito.times(1)).cancelTrades();
	}

}
