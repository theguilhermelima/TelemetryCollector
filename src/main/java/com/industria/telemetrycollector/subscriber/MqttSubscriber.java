package com.industria.telemetrycollector.subscriber;

import org.eclipse.paho.client.mqttv3.*;

public class MqttSubscriber {

    private MqttClient client;

    public MqttSubscriber(String brokerUrl) {
        try {
            client = new MqttClient(brokerUrl, MqttClient.generateClientId());

            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);

            client.connect(options);

            System.out.println("📡 Subscriber conectado ao broker");

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(String topic) {
        try {
            client.subscribe(topic, (t, msg) -> {
                String payload = new String(msg.getPayload());
                System.out.println("📥 Recebido: " + payload);
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}