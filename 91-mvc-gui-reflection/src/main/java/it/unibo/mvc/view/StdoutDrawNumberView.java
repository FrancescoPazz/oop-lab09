package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class StdoutDrawNumberView implements DrawNumberView {    
    private static final String NEW_GAME = ": a new game starts!\n";

    @Override
    public void start() {
        System.out.println("This view is started.");
    }
    
    @Override
    public void result(DrawResult res) {
        switch (res) {
            case YOU_WON, YOU_LOST -> System.out.println(res.getDescription() + NEW_GAME);
            case YOURS_HIGH, YOURS_LOW -> System.out.println(res.getDescription());
            default -> throw new IllegalStateException("Unknown game state");
        }
    }
    
    @Override
    public void setController(DrawNumberController observer) {
        System.out.println("The controller: " + observer + " has been mounted correctly.");        
    }
    
}
