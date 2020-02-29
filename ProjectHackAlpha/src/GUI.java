import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{

    //lets the code know whether to continuously rotate
    private boolean flag = false;
    //speed of rotation
    private int speed = 5;
    //degrees it will rotate if not in continuous mode
    private int degrees = 360;
    //button to switch between continuous and single rotation
    private JButton button = new JButton("Continuous Mode");
    //loads Jpanel rotating image with the image bug1.png
    //private RotatingImage image = new RotatingImage("textbook_examples/ch12/fig12_06_07/bug1.png");
    //makes a slider that will control speed with max value of 10 and min of 0
    private JSlider slider = new JSlider(0,10);
    //text field that will control how far the image will rotate in single rotation mode
    private JTextField text = new JTextField("0");
    //timer that tells the image to rotate
    private Timer timer;

    public GUI() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText( Integer.toString( 1000+Integer.parseInt(text.getText())));
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adds the text button and slider to the rotating image
        setLayout(new GridLayout(1,3));
        add(text);
        add(button);
        add(slider);
        timer.start();
        //changes if in continuous rotation or single rotation and changes the text on the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               text.setText( Integer.toString( speed+Integer.parseInt(text.getText())));
            }
        });
        //when the user press enter the text box is checked for an integer and saves the value if it is between 1 and 360 otherwise sets the
        //degrees to 0 then sets the image position to 0 degrees and restarts the timer
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isInt(text.getText())){
                    degrees = Integer.parseInt(text.getText());
                    if(degrees <= 0 || degrees > 360){
                        degrees = 360;
                        text.setText("360");
                    }
                    timer.start();
                }
            }
        });
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                speed = slider.getValue();
            }
        });
        timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //in single rotation mode

            }
        });
        timer.start();
        pack();
        setVisible(true);
    }
    static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            // s is a valid integer
            return true;
        } catch (NumberFormatException a) {
            return false;
        }
    }

    public static void main(String arg[]) {
        GUI a = new GUI();
        a.setSize(600,600);
    }
}



