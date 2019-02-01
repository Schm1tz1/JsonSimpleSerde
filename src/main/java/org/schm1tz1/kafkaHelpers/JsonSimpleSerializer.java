package org.schm1tz1.kafkaHelpers;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.json.simple.JSONObject;

import java.util.Map;

public class JsonSimpleSerializer implements Serializer<JSONObject> {
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    public byte[] serialize(String topic, JSONObject data) {
        try {
            if (data == null)
                return null;
            else
                return data.toJSONString().getBytes();
        } catch (Exception e) {
            throw new SerializationException("Error when serializing JSONObject to byte[]. Stacktrace: " + e.getStackTrace().toString());
        }
    }

    public void close() {

    }
}
