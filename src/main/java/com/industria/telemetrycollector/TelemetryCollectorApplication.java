package com.industria.telemetrycollector;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.industria.telemetrycollector.subscriber.MqttSubscriber;

@SpringBootApplication
public class TelemetryCollectorApplication {
	public static void main(String[] args) {
				// Iniciar o Subscribe
		MqttSubscriber subscriber = new MqttSubscriber("tcp://broker.hivemq.com:1883");
		subscriber.subscribe("telemetry/topic");
	}

}
