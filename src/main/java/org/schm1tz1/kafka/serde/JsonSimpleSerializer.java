package org.schm1tz1.kafka.serde;

import org.apache.kafka.common.serialization.Serializer;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import java.util.Map;

public class JsonSimpleSerializer implements Serializer<JSONObject> {

    private static final Logger logger = Logger.getRootLogger();

    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    public byte[] serialize(String topic, JSONObject data) {
        try {
            if (data == null)
                return null;
            else
                return data.toJSONString().getBytes();
        } catch (Exception e) {
            //throw new SerializationException("Error when serializing JSONObject to byte[]. Stacktrace: " + e.getStackTrace().toString());
            logger.fatal("Error when serializing JSONObject to byte[].", e);
        }
        return null;
    }

    public void close() {

    }
}
