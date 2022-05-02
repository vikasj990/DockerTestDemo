package com.iceye.sbdb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iceye.sbdb.pojo.Root;
import io.restassured.response.ResponseBody;
import org.testng.log4testng.Logger;

public class DeserialisationUtils {
    private static Logger Log;

    static {
        try {
            Log = Logger.getLogger(Class.forName(DeserialisationUtils.class.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object convertResponsetoRootObject(ResponseBody responseBody) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Log.info("Response:" + responseBody.asString());
        return mapper.readValue(responseBody.asString(), Root.class);
    }

}
