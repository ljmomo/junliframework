package com.junli.common.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
/**
 * @author lijun
 * @time 2018-02-06 14:16
 */
public class RestTempleUtils {
    @Resource
    private RestTemplate restTemplate;

    public  void post(){
        Map<String,Object> params = new HashMap<>();
        Map map = restTemplate.postForObject("http://HELLO-SERVICE/getbook1", params, Map.class);
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("http://HELLO-SERVICE/getbook2", params, Map.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        if(statusCode==HttpStatus.OK){

        }

    }

    public <T> T doGet(String url, Class<T> resultType) {
        return restTemplate.getForObject(url, resultType);
    }

    public <T> T doPost(String url,Object request,Class<T> resultType){
       return restTemplate.postForObject(url, request,resultType);
    }
}
