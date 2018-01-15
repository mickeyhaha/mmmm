package com.holo.utils;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 商户可参考本类编写发送请求方法，也可直接使用本类
 */

public class HttpClientUtils {

   static CloseableHttpClient httpclient = HttpClients.createDefault();
    /**
     * 发送json
     *
     * @return
     */
    public static String sendJson(String url, String json) {
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            HttpEntity postEntity = new StringEntity(json, "utf-8");
            httpPost.setEntity(postEntity);
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
           return EntityUtils.toString(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 发送post
     * @param url    url
     * @param params 参数
     * @return
     */
    public static  String sendPost(String url, Map<String,Object> params) {
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);

            List<NameValuePair> nvps = new ArrayList<>();
            if(params!=null){
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()==null?null:entry.getValue().toString()));
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps,"UTF-8"));
            response = httpclient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    /**
     * 发送post
     * @param url    url
     * @param json json文本串
     * @return
     */
    public static  String sendPostByJson(String url, String json) {
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);

            StringEntity requestEntity = new StringEntity(json,"utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);
            response = httpclient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    /**
     * 发送get
     * @param url    url
     * @param params 参数
     * @return
     */
    public static  String sendGet(String url, Map<String,Object> params) {
        CloseableHttpResponse response = null;
        try {
            StringBuffer stringBuffer=new StringBuffer(url);
            Boolean flag=false;
            if (url.indexOf("?")<0){
                flag=true;
            }
            if(params!=null){
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    if (flag){
                        stringBuffer.append("?"+entry.getKey()+"="+entry.getValue());
                        flag=false;
                    }else {
                        stringBuffer.append("&"+entry.getKey()+"="+entry.getValue());
                    }
                }
            }
            HttpGet httpGet = new HttpGet(stringBuffer.toString());
            response = httpclient.execute(httpGet);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
