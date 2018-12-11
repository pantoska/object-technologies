package com.studia.to.handler;

import com.studia.to.state.Context;

public class HandlerText extends HandlerMessage {
    Context context = new Context();

    public HandlerText() {
        setHandlerMessage(new HandlerCapture());
    }

    @Override
    public void handle(String type, byte[] input) {
        if(type.equals("t")){
            System.out.println(new String(input));
            context.setState("Stop");
        }
        else{
            handlerMessage.handle(type,input);
        }

    }

    public Context getContext() {
        return context;
    }
}
