package com.group1.merchant.service.impl;

import com.group1.core.utils.JsonUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JerseyJsonService {

    public static <T, R> R post(Client client, String uri, String path, T object, Class<R> rtnClass) {
        R  rtnObject= null;
        WebTarget webTarget = client.target(uri).path(path);

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.post(Entity.entity(object, MediaType.APPLICATION_JSON_TYPE));

        System.out.println(response.getStatus());
        rtnObject = (R)JsonUtil.jsonToObject(response.readEntity(String.class), rtnClass);
        return rtnObject;
    }

    public static <T,R> R get(Client client, String uri, String path, T object, Class<R> rtnClass) {
        R rtnObject = null;
        WebTarget webTarget = client.target(uri).path(path).path((String)object);

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();

        rtnObject = (R)JsonUtil.jsonToObject(response.readEntity(String.class), rtnClass);

        System.out.println(response.getStatus());
        return rtnObject;
    }

    public static <T,R> R put(Client client, String uri, String path, T object, Class<R> rtnClass) {
        R  rtnObject= null;
        WebTarget webTarget = client.target(uri).path(path);

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.put(Entity.entity(object, MediaType.APPLICATION_JSON_TYPE));

        System.out.println(response.getStatus());
        rtnObject = (R)JsonUtil.jsonToObject(response.readEntity(String.class), rtnClass);
        return rtnObject;
    }

    public static <T,R> R delete(Client client, String uri, String path, T object, Class<R> rtnClass) {
        R rtnObject = null;
        WebTarget webTarget = client.target(uri).path(path);

        Invocation.Builder invocationBuilder =  webTarget.request();
        Response response = invocationBuilder.delete();

        System.out.println(response.getStatus());
        rtnObject = (R)JsonUtil.jsonToObject(response.readEntity(String.class), rtnClass);

        return rtnObject;
    }
}
