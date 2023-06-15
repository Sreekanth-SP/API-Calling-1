package org.geekster;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData {
    public static void fetchingData() throws Exception{

        String urlStr ="https://api.chucknorris.io/jokes/random";
        URL url = new URL(urlStr);
        HttpURLConnection urlConnection =  (HttpURLConnection) url.openConnection();
        int responseCode = urlConnection.getResponseCode();

        if(responseCode==200){
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine =null;

            while ((readLine = br.readLine()) !=null){
                apiData.append(readLine);
            }
            br.close();

            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());

            System.out.println(jsonAPIResponse);
            System.out.println(jsonAPIResponse.get("categories"));
            System.out.println(jsonAPIResponse.get("created_at"));
            System.out.println(jsonAPIResponse.get("icon_url"));
            System.out.println(jsonAPIResponse.get("id"));
            System.out.println(jsonAPIResponse.get("updated_at"));
            System.out.println(jsonAPIResponse.get("url"));
            System.out.println(jsonAPIResponse.get("value"));
        }
        else{
            System.out.println("Calling API is not working!!!");
        }

    }
}
