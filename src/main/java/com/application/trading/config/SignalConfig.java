package com.application.trading.config;

import com.application.trading.models.Signal;
import com.application.trading.models.Signals;

import java.io.InputStream;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

@Configuration
public class SignalConfig {
	/**
     * Reads SignalConfig from the .yaml
     * @param signal the signal for which algorithm needs to be invoked
     * @return the status of algorithm whether `Success` or `Failed`
     */
	
//	TODO: consider moving the config to DB/memory store when size increases. 
	public List<Signal> LoadYaml() {
		Yaml yaml = new Yaml(new Constructor(Signals.class));
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("static/signal_config.yml");
		Signals signals = yaml.load(inputStream);
		return signals.getSignals();
	}
}
