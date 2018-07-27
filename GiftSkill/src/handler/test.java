package handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.Map;


public class test {
    public static void main(String[] args) {
        try {
            URL url = new URL ("https://maps.googleapis.com/maps/api/place/nearbysearch/json" + 
                    "?location=47.6062,-122.3321" + 
                    "&radius=50000" + 
                    "&types=night_club" + 
                    "&key=AIzaSyBDW3JksuqUTTTfw7Zl8zwAOgyfPFIzKSk");
            
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            
            /*Map<String, String> parameters = new HashMap<>();
            parameters.put("param1",  "val");
            
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamString(parameters));
            out.flush();
            out.close();
            */
            
            //int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputline;
            StringBuffer content = new StringBuffer();
            while((inputline = in.readLine()) != null) {
                content.append(inputline);
            }
            
            JSONObject obj = new JSONObject(content.toString());
            
            JSONArray ja = (JSONArray)obj.get("results");
            
            //System.out.println(ja.length());
            
            for(int i = 0; i < ja.length() % 7; i++) {
                JSONObject obj2 = ja.getJSONObject(i);
                System.out.println(obj2.getString("name"));
            }

            in.close();

            
      
            
            
            con.disconnect();
            
            
            
            
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
