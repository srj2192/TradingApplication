package com.application.trading.models;

import java.util.List;

public class Signal {
	
	private Integer id;
	
	private List<SignalParam> params;
	
	private boolean algo;
	
	private boolean setup;
	
	private boolean reverse;
	
	private boolean calculate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public boolean isAlgo() {
		return algo;
	}

	public void setAlgo(boolean algo) {
		this.algo = algo;
	}

	public boolean isSetup() {
		return setup;
	}

	public void setSetup(boolean setup) {
		this.setup = setup;
	}

	public boolean isReverse() {
		return reverse;
	}

	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	public boolean isCalculate() {
		return calculate;
	}

	public void setCalculate(boolean calculate) {
		this.calculate = calculate;
	}

	public List<SignalParam> getParams() {
		return params;
	}

	public void setParams(List<SignalParam> params) {
		this.params = params;
	}
	
	
}
