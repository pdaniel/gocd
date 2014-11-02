package com.thoughtworks.go.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnvironmentsVariablesHolder {
    static Map<String,String> envVariables = new HashMap<String, String>();
    public void addVariable(String name,String value){
        envVariables.put(name,value);
    }
    public static String getVariable(String name){
        return envVariables.get(name);
    }
}
