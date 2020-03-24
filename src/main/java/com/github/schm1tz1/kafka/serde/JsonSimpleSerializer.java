package com.github.schm1tz1.kafka.serde;

import org.apache.kafka.common.serialization.Serializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.util.Map;

public class JsonSimpleSerializer implements Serializer<JSONObject> {

    private static final Logger logger = LogManager.getRootLogger();

    /**
     * Configure this class.
     *
     * @param configs configs in key/value pairs
     * @param isKey   whether is for key or value
     */
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    /**
     * Convert JSONObject into a byte array.
     *
     * @param topic topic associated with data
     * @param data  JSONObject
     * @return serialized bytes
     */
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

    /**
     * Close this serializer.
     * <p>
     * This method must be idempotent as it may be called multiple times.
     */
    public void close() {

    }
}
