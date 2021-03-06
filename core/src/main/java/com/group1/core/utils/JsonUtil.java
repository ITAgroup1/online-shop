package com.group1.core.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group1.core.entity.complaint.Complaint;


public class JsonUtil {
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
	}

	public static <T> T mapToObject(Map map , Class<T> clazz){
		try {
			String json = mapper.writeValueAsString(map);
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> listToObject(List list, Class<T> tClass){
		try {
			TypeReference typeReference = new TypeReference<List<T>>() {};
			String jsonStr = mapper.writeValueAsString(list);
			return mapper.readValue(jsonStr, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	/**
	 * object转json
	 * @param obj
	 * @return
	 */
	public static String objectToJson(Object obj) {
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

	/**
	 * json转Object
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static<T> T jsonToObject(String jsonStr, Class<T> clazz) {
		T obj = null;
		try {
			obj = mapper.readValue(jsonStr, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
