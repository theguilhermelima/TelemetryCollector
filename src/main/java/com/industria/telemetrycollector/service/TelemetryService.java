package com.industria.telemetrycollector.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;

@Service
public class TelemetryService {

    @Autowired
    private InfluxDBClient influxDBClient;

    public void salvarTelemetria(String maquinaId, Double temperatura) {
        WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();

        Point point = Point
          .measurement("sensor_data")
          .addTag("maquina_id", maquinaId)
          .addField("temp", temperatura)
          .time(Instant.now(), WritePrecision.NS);

        writeApi.writePoint(point);
    }
}
