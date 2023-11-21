package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    private final Controller ctrl = new SimpleController();

    public SimpleGUI() {
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        JPanel canvas2 = new JPanel();
        canvas.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);

        JButton printButton = new JButton("Print");
        JButton historyButton = new JButton("Show history");

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctrl.setString(textField.getText());
                ctrl.printCurrentString();
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(ctrl.getPrintedHistory().toString());
            }
        });

        canvas2.add(printButton, BorderLayout.WEST);
        canvas2.add(historyButton, BorderLayout.EAST);
        
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(canvas2, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setTitle("SimpleGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
