package com.application.trading.handlers;

public interface ISignalHandler {
	/**
     * abstract method to handle the signals
     * @param signal the signal for which algorithm needs to be invoked
     */
	void handleSignal(int signal);
}