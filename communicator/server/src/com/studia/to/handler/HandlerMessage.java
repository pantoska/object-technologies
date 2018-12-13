package com.studia.to.handler;

public abstract class HandlerMessage {
    public HandlerMessage handlerMessage;

    public void setHandlerMessage(HandlerMessage handlerMessage) {
        this.handlerMessage = handlerMessage;
    }

    public abstract void handle(String type, byte[] input);

}
