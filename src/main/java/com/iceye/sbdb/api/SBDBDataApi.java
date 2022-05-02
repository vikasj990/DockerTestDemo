package com.iceye.sbdb.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iceye.sbdb.pojo.Fields;
import com.iceye.sbdb.pojo.Root;
import com.iceye.sbdb.utils.DeserialisationUtils;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class SBDBDataApi {
    static Logger Log;

    static {
        try {
            Log = Logger.getLogger(Class.forName(SBDBDataApi.class.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Root get() throws JsonProcessingException {
        Response response = RestResource.get();
        ResponseBody body = response.getBody();
        Root data = (Root) DeserialisationUtils.convertResponsetoRootObject(body);
        Assert.assertEquals(response.getStatusCode(),200);
        Log.info("SBDB get() method without query param executed sucessfully.");
        return data;
    }

    public static Root get(Map<String,String> queryparams) throws JsonProcessingException {
        Response response = RestResource.get(queryparams);
        ResponseBody body = response.getBody();
        Root data = (Root) DeserialisationUtils.convertResponsetoRootObject(body);
        Assert.assertEquals(response.getStatusCode(),200);
        Log.info("SBDB get() method with query param executed sucessfully." + queryparams);
        return data;
    }

    public static Map<String,String> MapDatawithFields(ArrayList<String> data)
    {
        Map<String, String> fieldsdata = new LinkedHashMap<String, String>();
        fieldsdata.put(Fields.DES.getFieldName(), data.get(0));
        fieldsdata.put(Fields.ORBIT_ID.getFieldName(), data.get(1));
        fieldsdata.put(Fields.JD.getFieldName(), data.get(2));
        fieldsdata.put(Fields.CD.getFieldName(), data.get(3));
        fieldsdata.put(Fields.DIST.getFieldName(), data.get(4));
        fieldsdata.put(Fields.DIST_MIN.getFieldName(), data.get(5));
        fieldsdata.put(Fields.DIST_MAX.getFieldName(), data.get(6));
        fieldsdata.put(Fields.V_REL.getFieldName(), data.get(7));
        fieldsdata.put(Fields.V_INF.getFieldName(), data.get(8));
        fieldsdata.put(Fields.T_SIGMA_F.getFieldName(), data.get(9));
        fieldsdata.put(Fields.H.getFieldName(), data.get(10));
        Log.info("Mapping SBDB data with fileds are done." + fieldsdata);
        return fieldsdata;
    }
}
