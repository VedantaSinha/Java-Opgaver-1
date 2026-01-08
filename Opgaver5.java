import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Opgaver5 extends JFrame implements ActionListener {

    JTextField cField;
    JTextField fField;
    JButton cButton;
    JButton fButton;

    public static void main(String[] args) {
        Opgaver5 w = new Opgaver5();
        w.setTitle("Celsius / Fahrenheit");
        w.setSize(400, 120);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setVisible(true);
    }

    public Opgaver5() {
        setup();
    }

    void setup() {
        getContentPane().setLayout(new GridLayout(2, 2));

        cField = new JTextField("");
        fField = new JTextField("");

        cButton = new JButton("C -> F");
        fButton = new JButton("F -> C");

        cButton.addActionListener(this);
        fButton.addActionListener(this);

        getContentPane().add(cField);
        getContentPane().add(cButton);
        getContentPane().add(fField);
        getContentPane().add(fButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cButton) {
            convertCtoF();
        } else if (e.getSource() == fButton) {
            convertFtoC();
        }
    }

    void convertCtoF() {
        try {
            double c = Double.valueOf(cField.getText().trim());
            double f = c * 9.0 / 5.0 + 32.0;
            fField.setText(Double.toString(f));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Celsius value");
        }
    }

    void convertFtoC() {
        try {
            double f = Double.valueOf(fField.getText().trim());
            double c = (f - 32.0) * 5.0 / 9.0;
            cField.setText(Double.toString(c));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Fahrenheit value");
        }
    }
}
