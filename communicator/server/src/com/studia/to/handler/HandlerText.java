package com.studia.to.handler;

public class HandlerText extends HandlerMessage {

    public HandlerText() {
        setHandlerMessage(new HandlerCapture());
    }

    @Override
    public void handle(String type, byte[] input) {
        if(type.equals("t")){
            System.out.println(new String(input));
        }
        else{
            handlerMessage.handle(type,input);
        }

    }
}
