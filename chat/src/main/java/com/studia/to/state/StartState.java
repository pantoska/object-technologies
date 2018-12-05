package com.studia.to.state;

public class StartState implements State{
    private Context context;

    @Override
    public void doAction(Context context,String string) {
        context.setText(string);
    }

}
