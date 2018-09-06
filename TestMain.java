import gui.controls.Button;
import gui.controls.RadioButton;
import gui.controls.Label;
import gui.controls.ProgressBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * test main class
 */
public class TestMain extends JFrame implements Runnable {



    TestMain(){
// frame create and ser
        this.setSize(600,150);
        this.setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        this.getContentPane().setLayout(new FlowLayout());

        //button create and set
        Button button = new Button("Button");
        button.setFont(new Font("Verdana",Font.PLAIN,22));

// progressbar create and set
        ProgressBar progressBar = new ProgressBar(400,50);
        progressBar.setValue(75);
        progressBar.setStringEnabled(true);
//label create and set
        Label label = new Label("Label");
        label.setFont(new Font("Verdana",Font.PLAIN,20));
//label create and set

        RadioButton radioButton = new RadioButton(true);
        radioButton.setText("radioButton");





// add components in JFrame
        this.getContentPane().add(radioButton);
      this.getContentPane().add(progressBar);
       this.getContentPane().add(button);
      this.getContentPane().add(label);





    }


// main method
    public static void main(String[] args) {

        Thread thread = new Thread(new TestMain());
        thread.start();

    }

    @Override
    public void run() {
        this.setVisible(true);
    }
}
