package com.group1.core.utils;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestClientUtils {


    private static WebTarget target = null;// ClientBuilder.newClient().target(ApplicationConstant.REST_URL_DOCTOR_REMOTE);

    /**
     * jersey post
     * @param url 请求的服务器
     * @param path 服务器的路径
     * @param param
     * @param queryParam
     * @param rtnClass
     * @param <T> 实体类
     * @return
     */
    public static <T> T post(String url, String path, Object param, Map<String, Object> queryParam, Class<T> rtnClass){
        if (url != null) {
            target = ClientBuilder.newClient().target(url);
        }
        WebTarget pathTarget = target.path(path);

        Set<String> keys = queryParam.keySet();
        for (String string : keys) {
            pathTarget = pathTarget.queryParam(string, queryParam.get(string));
        }
        //logger.info(pathTarget.getUri().toString());
        return pathTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(param, MediaType.APPLICATION_JSON_TYPE), rtnClass);
    }

    public static <T> T headerPost(String url, String path, Object param, Map<String, Object> queryParam, Class<T> rtnClass,Map<String, Object> headerParam){
        if (url != null) {
            target = ClientBuilder.newClient().target(url);
        }
        WebTarget pathTarget = target.path(path);

        Set<String> keys = queryParam.keySet();
        for (String string : keys) {
            pathTarget = pathTarget.queryParam(string, queryParam.get(string));
        }
        Builder request = pathTarget.request(MediaType.APPLICATION_JSON_TYPE);
        keys = headerParam.keySet();
        for (String string : keys) {
            request = request.header(string, headerParam.get(string));
        }
        //logger.info(pathTarget.getUri().toString());
        return request.post(Entity.entity(param, MediaType.APPLICATION_JSON_TYPE), rtnClass);
    }

    public static <T> T post(String url, String path, Object param, Class<T> rtnClass){
        if (url != null) {
            target = ClientBuilder.newClient().target(url);
        }
        WebTarget pathTarget = target.path(path);
        return pathTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(param, MediaType.APPLICATION_JSON_TYPE), rtnClass);
    }

    public static String postText(String url, String path, Object param){
        if (url != null) {
            target = ClientBuilder.newClient().target(url);
        }
        WebTarget pathTarget = target.path(path);
//		pathTarget.request("").post()
        return pathTarget.request(MediaType.TEXT_PLAIN)
                .post(Entity.entity(param, MediaType.APPLICATION_JSON_TYPE),String.class);
    }

    public static <T> T get(String url, String path, Map<String, Object> params, Class<T> rtnClass){
        if (url != null) {
            target = ClientBuilder.newClient().target(url);
        }
        WebTarget pathTarget = target.path(path);
        Set<String> keys = params.keySet();
        for (String string : keys) {
            pathTarget = pathTarget.queryParam(string, params.get(string));
        }

        return pathTarget.request().get(rtnClass);
    }


    public static <T> T delete(String url, String path, Map<String, Object> params, Class<T> rtnClass){
        if (url != null) {
            target = ClientBuilder.newClient().target(url);
        }
        WebTarget pathTarget = target.path(path);
        Set<String> keys = params.keySet();
        for (String string : keys) {
            pathTarget = pathTarget.queryParam(string, params.get(string));
        }

        return pathTarget.request().delete(rtnClass);
    }

    public static <T> T put(String url, String path, Object param, Map<String, Object> queryParam, Class<T> rtnClass){
        if (url != null) {
            target = ClientBuilder.newClient().target(url);
        }
        WebTarget pathTarget = target.path(path);

        Set<String> keys = queryParam.keySet();
        for (String string : keys) {
            pathTarget = pathTarget.queryParam(string, queryParam.get(string));
        }
        return pathTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(param, MediaType.APPLICATION_JSON_TYPE), rtnClass);
    }


    public static <T> T get(String url,String path,Class<T> rtnClass){
        if (url != null) {
            target = ClientBuilder.newClient().target(url);
        }
        WebTarget pathTarget = target.path(path);

        return pathTarget.request().get(rtnClass);
    }

}