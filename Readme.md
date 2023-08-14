### Trading Application

This application invokes a Trading Algorithm based on a signal received.


* Signals can be passed to the application via end point `POST /signals/{signal}`
* The Configuration for signals is now managed in `signal_config.yaml`under `resources/static`
* The config could be moved to a in memory store or a conventional database when the number of
configurations will increase and will be difficult to manage.
* Tests have been adding to verify the currently supported signals.