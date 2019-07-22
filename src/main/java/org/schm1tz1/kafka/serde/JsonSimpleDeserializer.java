package org.schm1tz1.kafka.serde;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Map;

public class JsonSimpleDeserializer implements Deserializer<JSONObject> {
    private static final Logger logger = Logger.getRootLogger();
    private String encoding = "UTF8";
    private JSONParser jsonParser = null;


    JsonSimpleDeserializer() {
        jsonParser = new JSONParser();
    }

    public void configure(Map<String, ?> configs, boolean isKey) {

    }

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

    public void close() {

    }
}
