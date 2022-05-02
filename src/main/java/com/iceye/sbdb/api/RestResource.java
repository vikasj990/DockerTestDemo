package com.iceye.sbdb.api;

import io.restassured.response.Response;
import org.testng.log4testng.Logger;

import java.util.Map;

import static com.iceye.sbdb.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    private static Logger Log;

    static {
        try {
            Log = Logger.getLogger(Class.forName(RestResource.class.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Response get() {
        Log.info("get() without any parameters");
        return given(getRequestSpec()).
                when().get().
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(Map QueryParams) {
        Log.info("get() with query parameters" + QueryParams);
        return given(getRequestSpec()).queryParams(QueryParams).when().get().
                then().spec(getResponseSpec()).
                extract().
                response();
    }

}
