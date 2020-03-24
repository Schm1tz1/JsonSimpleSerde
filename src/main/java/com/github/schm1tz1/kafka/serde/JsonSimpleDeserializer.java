package com.github.schm1tz1.kafka.serde;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Map;

public class JsonSimpleDeserializer implements Deserializer<JSONObject> {
    private static final Logger logger = LogManager.getRootLogger();
    private String encoding = "UTF8";
    private JSONParser jsonParser = null;

    JsonSimpleDeserializer() {
        jsonParser = new JSONParser();
    }

    /**
     * Configure this class.
     *
     * @param configs configs in key/value pairs
     * @param isKey   whether is for key or value
     */
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    /**
     * Deserialize a record value from a byte array into a JSOnObject.
     *
     * @param topic topic associated with the data
     * @param data  serialized bytes; may be null; implementations are recommended to handle null by returning a value or null rather than throwing an exception.
     * @return JSONObject
     */
    public JSONObject deserialize(String topic, byte[] data) {
        try {
            if (data != null) {
                String jsonString = new String(data, encoding);
                return (JSONObject) jsonParser.parse(jsonString);
            }
        } catch (Exception e) {
            //throw new SerializationException("Error when deserializing byte[] to JSONObject. Stacktrace: " + e.getStackTrace().toString());
            logger.fatal("Error when deserializing byte[] to JSONObject.");
        }
        return null;
    }

    /**
     *
     */
    public void close() {

    }
}
