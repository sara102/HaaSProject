
package com.haas.mobile.networklayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by sara on 5/8/2016.
 */
public class NetworkHandler {

    public String httpGet (Map<String ,String> params,String methodID) throws Exception
    {
        for (Map.Entry<String, String> entry : params.entrySet())
        {
            methodID +="?"+entry.getKey()+"="+entry.getValue();
        }
        URL serviceURL = new URL(methodID);
        HttpURLConnection connection =(HttpURLConnection) serviceURL.openConnection();
//        connection.setConnectTimeout(timeout);
        connection.setRequestMethod("GET");
        connection.connect();
        return  readStream(connection.getInputStream());
    }


    public String httpPost (Map<String ,String> params,String methodID) throws Exception {
        String encodedParams="";
        URL serviceURL = new URL(methodID);
        HttpURLConnection connection = (HttpURLConnection) serviceURL.openConnection();
//        connection.setConnectTimeout(timeout);
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        for (Map.Entry<String, String> entry : params.entrySet())
        {
            encodedParams =URLEncoder.encode(entry.getKey(), "UTF-8")
                    +"="+  URLEncoder.encode(entry.getValue(), "UTF-8") + "&";
        }
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write( encodedParams );
        wr.flush();
        wr.close();
        return readStream(connection.getInputStream());
    }

    private  String readStream(InputStream in) throws IOException{
        StringBuilder response = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in)) ;

        String nextLine = "";
        while ((nextLine = reader.readLine()) != null) {
            response.append(nextLine);
        }
        if(reader!=null){
            reader.close();}
        return response.toString();
    }

}
