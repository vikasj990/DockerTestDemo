package com.iceye.sbdb.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iceye.sbdb.api.ConstantQueryParameters;
import com.iceye.sbdb.api.SBDBDataApi;
import com.iceye.sbdb.pojo.Fields;
import com.iceye.sbdb.pojo.Root;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.iceye.sbdb.api.SBDBDataApi.MapDatawithFields;
@Listeners(com.iceye.sbdb.Listeners.ListenerImpl.class)
public class SBDBDataApiTest {

    @Story("get the all entries")
    @Link("https://ssd-api.jpl.nasa.gov/cad.api")
    @Issue("1234567")
    @Description("this is the description")
    @Test(description = "Get All entries")
    public void getWithoutAnyParameter() throws JsonProcessingException {
        Root root = SBDBDataApi.get();
        Map m = MapDatawithFields(root.data.get(0));
        Assert.assertTrue(m.get(Fields.ORBIT_ID.getFieldName()).equals("6"));

    }

    @Story("get the some specific entries")
    @Link("https://ssd-api.jpl.nasa.gov/cad.api")
    @Issue("1234567")
    @Description("this is the description")
    @Test(description = "Get Specific entries")
    public void getWithqueryParameter() throws JsonProcessingException {
        Map queryparams = new LinkedHashMap<String, Object>();
        queryparams.put(ConstantQueryParameters.DES, "433");
        queryparams.put(ConstantQueryParameters.DATE_MIN, "1900-01-01");
        queryparams.put(ConstantQueryParameters.DATE_MAX, "2100-01-01");
        queryparams.put(ConstantQueryParameters.DIST_MAX, "0.2");
        Root root = SBDBDataApi.get(queryparams);
        Map m = MapDatawithFields(root.data.get(0));
        System.out.println("Orbit_id: " + m.get(Fields.ORBIT_ID.getFieldName()));
        Assert.assertTrue(m.get(Fields.ORBIT_ID.getFieldName()).equals("659"));

    }

    @Test
    public void FailTestcase() {
        int i = 10 / 0;
    }

}
