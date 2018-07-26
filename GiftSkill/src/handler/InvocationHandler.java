package handler;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
//import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;


import org.json.*;

public class InvocationHandler implements RequestHandler {

    
    //Start invocation -> Who do you want to gift to
    // ->Gives name -> Check match in db (give response accordingly)
    // Lists wishlist by item ->>waits for response
    
    
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("GiftIntent"));
    }
    
    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "sup: ";
        
        try {
            URL url = new URL ("https://maps.googleapis.com/maps/api/place/nearbysearch/json" + 
                    "?location=-33.8670522,151.1957362" + 
                    "&radius=500" + 
                    "&types=food" + 
                    "&name=harbour" + 
                    "&key=AIzaSyBDW3JksuqUTTTfw7Zl8zwAOgyfPFIzKSk");
            
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            
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

            in.close();

            
      
            
            
            con.disconnect();
            
            
            
            
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Gift", speechText)
                .withReprompt(speechText)
                .build();
    }
}
