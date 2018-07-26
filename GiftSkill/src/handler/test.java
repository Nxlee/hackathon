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
                    "?location=-33.8670522,151.1957362" + 
                    "&radius=500" + 
                    "&types=food" + 
                    "&name=harbour" + 
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
            
            System.out.println(ja.length());
            
            for(int i = 0; i < 3; i++) {
                JSONObject obj2 = ja.getJSONObject(i);
                System.out.println(obj2.getString("name"));
            }
            /*
            Iterator itr = ja.iterator();
            Iterator<Map.Entry> itr2;
           /* while(itr.hasNext()) {
                itr2 = ((Map) itr.next()).entrySet().iterator();
                while(itr2.hasNext()) {
                    Map.Entry pair = itr2.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                }
            }
            */
 
            
            //System.out.println("done");
            //System.out.println(name);
             
             
           // System.out.println(content);
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
