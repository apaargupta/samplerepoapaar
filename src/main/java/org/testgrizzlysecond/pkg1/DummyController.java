package org.testgrizzlysecond.pkg1;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

@Path("/")
public class DummyController {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        //someMethodToReturnJSON();
        //            JSONObject jsonObject = readJsonFromUrl("https://jsonplaceholder.typicode.com/todos/1");
//            System.out.println(jsonObject);
//        final StringBuilder stringBuilder = new StringBuilder("[\n");
//        anotherMethod().forEach(jsonObj -> stringBuilder.append(jsonObj.toString() + ",\n"));
//        stringBuilder.replace(stringBuilder.lastIndexOf(","), stringBuilder.lastIndexOf(",")+1, "");
//        stringBuilder.append("]");
        JSONArray jsonArray = new JSONArray();
        return anotherMethod().forEach((JSONObject) jsonObj -> jsonArray).toString();
        //return "Got it! Swag hai bhai ka!";
    }

    private  JSONArray anotherMethod() {
        try {
            return new JSONArray(IOUtils.toString(new URL("https://jsonplaceholder.typicode.com/todos/"), Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

//    private void someMethodToReturnJSON() {
//        URL url = new URL("https://jsonplaceholder.typicode.com/todos/");
//        HttpURLConnection conn = null;
//        try {
//            conn = (HttpURLConnection) url.openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            conn.setRequestMethod("GET");
//        } catch (ProtocolException e) {
//            e.printStackTrace();
//        }
//        conn.setRequestProperty("Accept", "application/json");
//
//        try {
//            if (conn.getResponseCode() != 200) {
////                throw new RuntimeException("Failed : HTTP error code : "
////                        + conn.getResponseCode());
//                System.out.println("Just log and chill");
//            } else {
//                conn.getResponseMessage()
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}