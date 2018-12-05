package com.studia.to.state;

public class Context {
    private State state;
    private String text;

    public Context(String text) {
        this.text = text;
        this.state = new StartState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void doAction(String text) {
        this.state.doAction(this,text);
    }

    public void close() {
        this.state = new StopState();
    }
}
