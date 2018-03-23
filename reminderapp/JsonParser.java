package edu.niu.z1805839.reminderapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Kiran on 3/23/2018.
 */

public class JsonParser {
    private URL urlin;
    private static InputStream is = null;
    private static JSONObject jObj = null;
    private static JSONArray jArray = null;
    private String jsonStr = "string to pass back";
    public JsonParser() {
        //Empty
    }

    public JSONObject getJSONFromUrl(String url) {
        HttpURLConnection urlConnection;
        try {

            urlin = new URL(url);
            urlConnection = (HttpURLConnection)urlin.openConnection();
            is = new BufferedInputStream(urlConnection.getInputStream());
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            urlConnection.disconnect();
            jsonStr = sb.toString();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        }
        finally {
            try {
                jObj = new JSONObject(jsonStr);
            }
            catch (JSONException je) {
                je.printStackTrace();
            }// end catch
        }// end finally
        return jObj;
    }
}
