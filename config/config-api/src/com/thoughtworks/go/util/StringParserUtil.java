package com.thoughtworks.go.util;


import java.io.File;
import java.util.logging.FileHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParserUtil {

    public static String parseEnvVars(String src){
        String src_ = src;
        final Pattern pattern = Pattern.compile("\\$\\{([^}]*)\\}");
        Matcher matcher = pattern.matcher(src);
        if (matcher.find()) {
            if(EnvironmentsVariablesHolder.getVariable(matcher.group(1))!=null)
            src_ = src.replace("${"+matcher.group(1)+"}", EnvironmentsVariablesHolder.getVariable(matcher.group(1)));
            System.out.println(matcher.group(1));
        }
        return src_;
    }



}
