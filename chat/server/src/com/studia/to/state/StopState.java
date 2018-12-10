package com.studia.to.state;

public class StopState implements State{
    Context contextRef;

    public StopState(Context contextRef) {
        this.contextRef = contextRef;
    }

    @Override
    public void doAction() {

    }
}
