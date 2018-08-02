package com.group1.core.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.*;

public class ResultBody implements Serializable {


    public static final String STATUS_ERROR = "0";
    public static final String STATUS_SUCCESS = "1";

    private String status;
    private String message;
    private Map<String,Object> data;

    public String getStatus() {
        if (status == null) {
            List errors = null;
            if (data != null && (errors = (List) data.get("errors")) != null && errors.size() > 0) {
                return STATUS_ERROR;
            }else{
                return STATUS_SUCCESS;
            }
        }
        return status;
    }

    public ResultBody() {
        data = new HashMap<>();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setData(String key,Object value) {
        data.put(key,value);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void addError(String key, String val) {
        ObjectError error = new ObjectError(key, val);
        getErrors().add(error);
    }

    @JsonIgnore
    public List<ObjectError> getErrors() {
        List<ObjectError> errors = (List<ObjectError>) getData("errors");
        if (errors == null) {
            errors = new ArrayList<>();
            addData("errors", errors);
        }
        return errors;
    }

    public void addError(ObjectError error) {
        getErrors().add(error);
    }

    public void addErrors(List<ObjectError> errors){
        getErrors().addAll(errors);
    }

    public void addData(String key, Object value) {
        if (data == null) {
            data = new LinkedHashMap<>();
        }
        data.put(key, value);
    }

    public Object getData(String key){
        if (data == null) {
            data = new LinkedHashMap<>();
        }
        return data.get(key);
    }
}
