package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller ctlr = new Controller();

    public SimpleGUIWithFileChooser(){
        JPanel canvas = new JPanel();
        JPanel canvas2 = new JPanel();
        JTextField textField = new JTextField();
        JButton browseButton = new JButton("Browse...");
        JFileChooser fileChooser = new JFileChooser();
    
        canvas.setLayout(new BorderLayout());
        canvas2.setLayout(new BorderLayout());

        canvas2.add(textField, BorderLayout.CENTER);
        canvas2.add(browseButton, BorderLayout.LINE_END);
        canvas.add(canvas2, BorderLayout.NORTH);

        textField.setEditable(false);
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (fileChooser.showSaveDialog(fileChooser)) {
                    case JFileChooser.APPROVE_OPTION:
                        ctlr.setCurrentFile(fileChooser.getSelectedFile());
                        textField.setText(ctlr.getCurrentFile().getPath());
                        break;

                    case JFileChooser.CANCEL_OPTION:
                        JOptionPane.showMessageDialog(frame, "There was an error due to the file choosing.");
                        break;
                
                    default:
                        break;
                }
                

            }
        });

        frame.setContentPane(canvas);
        frame.setTitle("SimpleGUIWithFileChooser");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
