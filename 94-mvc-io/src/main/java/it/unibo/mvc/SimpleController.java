package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleController implements Controller interface.
 * It represent the controller of the SimpleGUI app.
 */
public final class SimpleController implements Controller {
    private final int HISTORY_INITIAL_CAPACITY = 0;

    private final List<String> history = new ArrayList<>(HISTORY_INITIAL_CAPACITY);
    private String current;

    @Override
    public void setString(String str) throws NullPointerException {
        if(str == null){
            throw new NullPointerException();
        }
        this.current = str;    
    }

    @Override
    public String getString() {
        return this.current;    
    }

    @Override
    public List<String> getPrintedHistory() {
        return history;
    }

    @Override
    public void printCurrentString() throws IllegalStateException {
        if(this.current == null){
            throw new IllegalStateException();
        }
        this.history.add(this.current);
        System.err.println(this.current);
    }
}
