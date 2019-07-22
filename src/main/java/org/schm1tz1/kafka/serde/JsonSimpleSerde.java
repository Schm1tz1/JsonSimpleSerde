package org.schm1tz1.kafka.serde;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;
import org.json.simple.JSONObject;

import java.util.Map;

public class JsonSimpleSerde implements Serde<JSONObject> {
    /**
     * Configure this class, which will configure the underlying serializer and deserializer.
     *
     * @param configs configs in key/value pairs
     * @param isKey   whether is for key or value
     */
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    /**
     * Close this serde class, which will close the underlying serializer and deserializer.
     * This method has to be idempotent because it might be called multiple times.
     */
    @Override
    public void close() {

    }

    @Override
    public Serializer<JSONObject> serializer() {
        return new JsonSimpleSerializer();
    }

    @Override
    public Deserializer<JSONObject> deserializer() {
        return new JsonSimpleDeserializer();
    }
}
