package com.studia.to.state;

public class StopState implements State {
    private Context context;

    @Override
    public void doAction(Context context, String string) {
        System.out.println("The connection is closed");
    }
}
