package com.thoughtworks.go.util;

import com.thoughtworks.go.domain.FetchHandler;
import com.thoughtworks.go.domain.FileHandler;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HandlerUtil {
    public static void rebuildFileHandle(FetchHandler handler){
        File path = handler.getArtifact();
        String pathStr = path.getAbsolutePath();
        pathStr = parseEnvVars(pathStr);
        handler.setArtifact(new File(pathStr));
        String srcFile = handler.getSrcFile();
        srcFile = parseEnvVars(srcFile);
        handler.setSrcFile(srcFile);
    }

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
