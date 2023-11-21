package it.unibo.mvc.controller;

import it.unibo.mvc.api.DrawNumber;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * This class implements the game controller. It orchestrates the game, exposes methods to its observers
 * (the boundaries), and sends results to them.
 */
public final class DrawNumberControllerImpl implements DrawNumberController {

    private final DrawNumber model;
    private final Collection<DrawNumberView> views;

    /**
     * Builds a new game controller provided a game model.
     *
     * @param model the implementation of the game model
     */
    public DrawNumberControllerImpl(final DrawNumber model) {
        this.model = model;
        this.views = new ArrayList<>();
    }

    @Override
    public void addView(final DrawNumberView newView) {
        Objects.requireNonNull(newView, "Cannot set a null view");
        /* if (this.view != null) {
            throw new IllegalStateException("The view is already set! Multiple views are not supported");
        }*/
        this.views.add(newView);
        newView.setController(this);
        newView.start();
    }

    @Override
    public void newAttempt(final int n) {
        for (DrawNumberView drawNumberView : views) {
            Objects.requireNonNull(drawNumberView, "There is no view attached!").result(model.attempt(n));
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        /*
         * A bit harsh. A good application should configure the graphics to exit by
         * natural termination when closing is hit. To do things more cleanly, attention
         * should be paid to alive threads, as the application would continue to persist
         * until the last thread terminates.
         */
        System.exit(0);
    }

}
