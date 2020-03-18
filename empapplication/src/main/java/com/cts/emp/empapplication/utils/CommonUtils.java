package com.cts.emp.empapplication.utils;


import java.security.MessageDigest;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.emp.empapplication.constants.StatusCode;
import com.cts.emp.empapplication.entities.Employee;
import com.cts.emp.empapplication.responses.CustomErrorDetails;
import com.cts.emp.empapplication.responses.Response;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {

	static ObjectMapper mapper = new ObjectMapper();
	private static String addStr = "globalPORTALAccessKEY";
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	private static HttpSession session = null;

	
	
	public static String encriptString(String strToEncript) {

		String returnString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(strToEncript.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			returnString = sb.toString();
			return returnString;
		} catch (Exception ex) {
			ex.printStackTrace();
			return returnString;
		}
	}

	
	
	public static String encriptURL(String urlString) {

		Hashtable<String, String> map = new Hashtable<String, String>();
		map.put("url", urlString);
		map.put("accessKey", addStr);

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(map.toString().getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	public static String getJson(Object obj) {
		try {
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error("getJsonResponse:Error in json processing: ", e);
		}
		return "";
	}

	public static Response getResponseObject(String message) {
		Response response = new Response();
		response.setStatus(StatusCode.SUCCESS.name());
		response.setMessage(message);
		return response;
	}

	public static CustomErrorDetails getErrorResponse(String title, String detail) {
		CustomErrorDetails errorObject = new CustomErrorDetails();
		errorObject.setTitle(title);
		errorObject.setDetails(detail);
		return errorObject;
	}


}
