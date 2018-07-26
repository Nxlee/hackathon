package handler;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
//import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

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
        String speechText = "Here are some people you can gift to: ";
        //Query database, append them to end of string
        
        
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Gift", speechText)
                .withReprompt(speechText)
                .build();
    }
}
