package com.yun.common.util;

import com.yun.common.entity.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.Map.Entry;


public class CommonUtils {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	
	public static String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	
	public static Map<String, Object> getParameterMap(HttpServletRequest request) {
		// 파라미터 이름
		Enumeration paramNames = request.getParameterNames();

		// 저장할 맵
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 맵에 저장
		while(paramNames.hasMoreElements()) {
			String name	= paramNames.nextElement().toString();
            String value = request.getParameter(name);

            String type = "";

			if(value == null || "".equals(value)){
                type = "null";
                paramMap.put(name, null);
            }else if(!isStringInt(value)) {
                type = "string";
                try{
                    value = URLDecoder.decode(request.getParameter(value), "UTF-8");
                }catch (Exception e){

                }

                paramMap.put(name, StringUtil.xxsReplace((String)value));
            }else{

			    if(value.length() > 1 && value.startsWith("0")){
                    type = "string";
                    try{
                        value = URLDecoder.decode(request.getParameter(value), "UTF-8");
                    }catch (Exception e){

                    }
                    paramMap.put(name, StringUtil.xxsReplace((String)value));
                }else{
                    type = "number";
                    paramMap.put(name, Integer.parseInt(value));
                }
            }

            logger.debug(name + " : " + value + " : "  + type);

		}
		// 결과반환
		return paramMap;
	}



    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }




}
