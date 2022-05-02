package com.iceye.sbdb.pojo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Root {

    public Signature signature;
    public int count;
//    public Fields fields;
//    public List<SBDBData> data;
    public ArrayList<String> fields;
    public ArrayList<ArrayList<String>> data;

}
