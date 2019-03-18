package com.x.ic.smc.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.x.base.exception.SystemException;

public final class HttpClientUtil {
    private HttpClientUtil() {
    }

    private static final Logger LOG = LogManager.getLogger(HttpClientUtil.class);

    // public static String sendPostRequest1(String url, String data, Map<String, String> header)
    // throws Exception {
    // HttpClient httpclient = new DefaultHttpClient();
    // HttpPost httpPost = new HttpPost(new URL(url).toURI());
    // for (Map.Entry<String, String> entry : header.entrySet()) {
    // httpPost.setHeader(entry.getKey(), entry.getValue());
    // }
    // StringEntity dataEntity = new StringEntity(data, ContentType.APPLICATION_JSON);
    // httpPost.setEntity(dataEntity);
    // CloseableHttpResponse response = httpclient.execute(httpPost);
    // BufferedReader reader = null;
    // try {
    // if (response.getStatusLine().getStatusCode() == 200) {
    // HttpEntity entity = response.getEntity();
    // reader = new BufferedReader(new InputStreamReader(entity.getContent(), "utf-8"));
    // StringBuilder buffer = new StringBuilder();
    // String tempStr;
    // while ((tempStr = reader.readLine()) != null) {
    // buffer.append(tempStr);
    // }
    // return buffer.toString();
    // } else {
    // throw new SystemException("error code " + response.getStatusLine().getStatusCode()
    // + ":" + response.getStatusLine().getReasonPhrase());
    // }
    // } finally {
    // if (reader != null) {
    // reader.close();
    // }
    // response.close();
    // httpclient.close();
    // }
    // }
    public static HttpResponse sendPostRequest(String url, String data, Map<String, String> header)
            throws SystemException {
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(new URL(url).toURI());
            if (header != null) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
            StringEntity dataEntity = new StringEntity(data, ContentType.APPLICATION_JSON);
            httpPost.setEntity(dataEntity);
            return httpclient.execute(httpPost);
        } catch (MalformedURLException e) {
            throw new SystemException(e);
        } catch (URISyntaxException e) {
            throw new SystemException(e);
        } catch (ClientProtocolException e) {
            throw new SystemException(e);
        } catch (IOException e) {
            throw new SystemException(e);
        }
    }

    public static HttpResponse send(String address, String param) {
        LOG.info("restful address : " + address);
        LOG.info("param : " + param);
        HttpResponse result = null;
        result = HttpClientUtil.sendPostRequest(address, param, null);
        LOG.info("result : " + result);
        return result;
    }

    /*
     * public static String sendGet(String url, Map<String, String> parameters) { StringBuffer
     * buffer = new StringBuffer(); BufferedReader in = null; StringBuffer sb = new StringBuffer();
     * String params = ""; try {
     * 
     * if (parameters.size() == 1) { for (String name : parameters.keySet()) {
     * sb.append(name).append("=") .append(java.net.URLEncoder.encode(parameters.get(name),
     * "UTF-8")); } params = sb.toString(); } else { for (String name : parameters.keySet()) {
     * sb.append(name).append("=") .append(java.net.URLEncoder.encode(parameters.get(name),
     * "UTF-8")) .append("&"); } String temp_params = sb.toString(); params =
     * temp_params.substring(0, temp_params.length() - 1); } String full_url = url + "?" + params;
     * LOG.info("restful address : " + full_url);
     * 
     * URL connURL = new URL(full_url);
     * 
     * java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL .openConnection();
     * 
     * httpConn.connect();
     * 
     * in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8")); String
     * line;
     * 
     * while ((line = in.readLine()) != null) { buffer.append(line); } } catch (Exception e) {
     * e.printStackTrace(); } finally { try { if (in != null) { in.close(); } } catch (IOException
     * ex) { ex.printStackTrace(); } } return buffer.toString(); }
     */

}
