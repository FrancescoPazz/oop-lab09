package it.unibo.mvc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberSwingView;
import it.unibo.mvc.view.DrawNumberOutputView;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws Exception {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);

        for (int i = 0; i < 3; i++) {
            app.addView(loadClass(getQualifiedName(DrawNumberOutputView.class)));
            app.addView(loadClass(getQualifiedName(DrawNumberSwingView.class)));
        }

    }

    private static String getQualifiedName(Class<?> class1) {
        return class1.getName();
    }

    private static DrawNumberView loadClass(String name) throws Exception {

        Class<?> viewClass;
        Constructor<?> constViewClass;
        DrawNumberView newView;

        viewClass = Class.forName(name);
        constViewClass = viewClass.getConstructor();
        newView = (DrawNumberView)constViewClass.newInstance();
        return newView;
    }

}
