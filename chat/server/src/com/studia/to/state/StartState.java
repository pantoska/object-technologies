package com.studia.to.state;

public class StartState implements State {
    Context contextRef;

    public StartState(Context contextRef) {
        this.contextRef = contextRef;
    }

    @Override
    public void doAction() {

    }
}
