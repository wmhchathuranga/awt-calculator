/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.calculator;

/**
 *
 * @author Harshana Chathuranga
 */
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class AWTCalculator implements ActionListener {

    String[] inputs = new String[3];
    Frame frame;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAdd, bSub, bMul, bDiv, bEq, bSqrt, bClear, bDel, bPer;
    Panel mainPanel;
    Panel numberPanel;
    TextField textField;
    GridLayout gridLayout;
    int Total;

    AWTCalculator() {
        frame = new Frame("Calcualtor");
        frame.setLayout(new BorderLayout());
        inputs[0] = "";
        inputs[1] = "";
        inputs[2] = "";

        // ========== Main Panel ==========
        mainPanel = new Panel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        textField = new TextField();
        textField.setColumns(15);
        textField.setText("0");
        textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        Font font1 = new Font("Arial", Font.PLAIN, 30);
        Font font2 = new Font("Arial", Font.PLAIN, 18);
        textField.setFont(font1);
        textField.setEditable(false);
        textField.setBackground(Color.BLACK);
        textField.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setFont(font2);

        // ========== Number Panel ==========

        numberPanel = new Panel();
        gridLayout = new GridLayout(4, 4);
        gridLayout.setHgap(2);
        gridLayout.setVgap(2);
        numberPanel.setLayout(gridLayout);

        b0 = new Button("0");
        b0.addActionListener(this);

        bSqrt = new Button("√");
        bSqrt.addActionListener(this);

        bSqrt.setBackground(Color.gray);
        bSqrt.setForeground(Color.WHITE);

        bPer = new Button("%");
        bPer.addActionListener(this);

        bPer.setBackground(Color.gray);
        bPer.setForeground(Color.WHITE);

        b1 = new Button("1");
        b1.addActionListener(this);

        b2 = new Button("2");
        b2.addActionListener(this);

        b3 = new Button("3");
        b3.addActionListener(this);

        b4 = new Button("4");
        b4.addActionListener(this);

        b5 = new Button("5");
        b5.addActionListener(this);

        b6 = new Button("6");
        b6.addActionListener(this);

        b7 = new Button("7");
        b7.addActionListener(this);

        b8 = new Button("8");
        b8.addActionListener(this);

        b9 = new Button("9");
        b9.addActionListener(this);

        b0.setBackground(Color.DARK_GRAY);
        b1.setBackground(Color.DARK_GRAY);
        b2.setBackground(Color.DARK_GRAY);
        b3.setBackground(Color.DARK_GRAY);
        b4.setBackground(Color.DARK_GRAY);
        b4.setBackground(Color.DARK_GRAY);
        b5.setBackground(Color.DARK_GRAY);
        b6.setBackground(Color.DARK_GRAY);
        b7.setBackground(Color.DARK_GRAY);
        b8.setBackground(Color.DARK_GRAY);
        b9.setBackground(Color.DARK_GRAY);

        b0.setForeground(Color.WHITE);
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);
        b4.setForeground(Color.WHITE);
        b5.setForeground(Color.WHITE);
        b6.setForeground(Color.WHITE);
        b7.setForeground(Color.WHITE);
        b8.setForeground(Color.WHITE);
        b9.setForeground(Color.WHITE);

        bAdd = new Button("+");
        bAdd.addActionListener(this);

        bSub = new Button("-");
        bSub.addActionListener(this);

        bMul = new Button("*");
        bMul.addActionListener(this);

        bDiv = new Button("/");
        bDiv.addActionListener(this);

        bEq = new Button("=");
        bEq.addActionListener(this);

        bAdd.setBackground(Color.lightGray);
        bAdd.setForeground(Color.DARK_GRAY);

        bSub.setBackground(Color.lightGray);
        bSub.setForeground(Color.DARK_GRAY);

        bMul.setBackground(Color.lightGray);
        bMul.setForeground(Color.DARK_GRAY);

        bDiv.setBackground(Color.lightGray);
        bDiv.setForeground(Color.DARK_GRAY);

        bClear = new Button("AC");
        bClear.addActionListener(this);

        bDel = new Button("Del");
        bDel.addActionListener(this);

        bDel.setBackground(Color.gray);
        bDel.setForeground(Color.WHITE);

        bClear.setBackground(Color.lightGray);
        bClear.setForeground(Color.DARK_GRAY);

        bEq.setBackground(Color.lightGray);
        bEq.setForeground(Color.DARK_GRAY);

        b0.setPreferredSize(new Dimension(80, 60));
        // Row 1
        numberPanel.add(b1);
        numberPanel.add(b2);
        numberPanel.add(b3);
        numberPanel.add(bAdd);
        // Row 2
        numberPanel.add(b4);
        numberPanel.add(b5);
        numberPanel.add(b6);
        numberPanel.add(bSub);
        // Row 3
        numberPanel.add(b7);
        numberPanel.add(b8);
        numberPanel.add(b9);
        numberPanel.add(bMul);
        // Row 4
        numberPanel.add(bSqrt);
        numberPanel.add(b0);
        numberPanel.add(bPer);
        numberPanel.add(bDiv);
        // Row 5

        Panel lastRow = new Panel(new GridLayout(1, 2));

        bEq.setPreferredSize(new Dimension(160, 60));
        lastRow.add(bClear);
        lastRow.add(bEq);
        mainPanel.add(lastRow, BorderLayout.SOUTH);

        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(numberPanel, BorderLayout.CENTER);

        MenuBar menuBar = new MenuBar();

        Menu More = new Menu("More");
        Menu About = new Menu("About");
        MenuItem aboutMenuItem = new MenuItem("Creator");
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and show the alert dialog
                Dialog alert = new Dialog(frame, "Creator", true);
                alert.setSize(100, 300);
                int x = frame.getX() + frame.getWidth() / 2 - alert.getWidth() / 2;
                int y = frame.getY() + frame.getHeight() / 2 - alert.getHeight() / 2;
                alert.setLocation(x, y);
                Label message1 = new Label(
                        "Hi, there. I am Harshana Chathuranga.");
                message1.setAlignment(Label.CENTER);
                Label message2 = new Label(
                        "An Undergraduate in JavaInstitute for Advanced Technology");
                message2.setAlignment(Label.CENTER);

                Button okButton = new Button("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        alert.dispose(); // Close the dialog
                    }
                });
                Panel panel = new Panel(new GridLayout(3, 1));
                panel.add(message1);
                panel.add(message2);
                panel.add(okButton);
                alert.add(panel);
                alert.pack();
                alert.setVisible(true);
            }
        });
        About.add(aboutMenuItem);

        MenuItem Temperature = new MenuItem("Temperature");
        MenuItem Length = new MenuItem("Length");

        More.add(Temperature);
        More.add(Length);

        menuBar.add(More);
        menuBar.add(About);

        frame.setMenuBar(menuBar);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setBounds(580, 240, 0, 0);
        frame.setTitle("AWT Calculator");
        frame.pack();
        frame.setVisible(true);
        frame.setBackground(Color.lightGray);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                super.windowClosing(e);
                System.exit(0);
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Object pressed = e.getSource();
        if (Total != 0) {
            Total = 0;
            textField.setText(null);
        }
        if (pressed.equals(bEq) && inputs[0] != "" && inputs[1] != "") {
            inputs[2] = textField.getText();

            try {

                Total = 0;

                int input1 = Integer.parseInt(inputs[0]);
                String operation = inputs[1];
                int input2 = Integer.parseInt(inputs[2]);

                System.out.println(input1);
                System.out.println(input2);

                if (bAdd.getLabel().compareTo(operation) == 0) {
                    Total = input1 + input2;
                }

                if (bSub.getLabel().compareTo(operation) == 0) {
                    Total = input1 - input2;
                }
                if (bMul.getLabel().compareTo(operation) == 0) {
                    Total = input1 * input2;
                }
                if (bDiv.getLabel().compareTo(operation) == 0) {
                    Total = input1 / input2;
                }
                textField.setText(String.valueOf(Total));

                inputs[0] = "";
                inputs[1] = "";
                inputs[2] = "";

            } catch (Exception err) {
                textField.setText("0");
                inputs[0] = "";
                inputs[1] = "";
                inputs[2] = "";
                Total = 0;
                System.out.println(err);
            }
        }

        if (textField.getText().contentEquals("0"))
            textField.setText(null);

        if (inputs[1] != "" && inputs[2] == "")
            textField.setText(null);

        if (pressed.equals(b0) && !textField.getText().contentEquals("0")) {
            textField.setText(textField.getText() + b0.getLabel());
        }
        if (pressed.equals(b1)) {
            textField.setText(textField.getText() + b1.getLabel());
        }
        if (pressed.equals(b2)) {
            textField.setText(textField.getText() + b2.getLabel());
        }
        if (pressed.equals(b3)) {
            textField.setText(textField.getText() + b3.getLabel());
        }
        if (pressed.equals(b4)) {
            textField.setText(textField.getText() + b4.getLabel());
        }
        if (pressed.equals(b5)) {
            textField.setText(textField.getText() + b5.getLabel());
        }
        if (pressed.equals(b6)) {
            textField.setText(textField.getText() + b6.getLabel());
        }
        if (pressed.equals(b7)) {
            textField.setText(textField.getText() + b7.getLabel());
        }
        if (pressed.equals(b8)) {
            textField.setText(textField.getText() + b8.getLabel());
        }
        if (pressed.equals(b9)) {
            textField.setText(textField.getText() + b9.getLabel());
        }
        if (pressed.equals(bSqrt)) {

            double value = Double.parseDouble(textField.getText());
            value = Math.sqrt(value);
            String sqrt = String.valueOf(value);
            textField.setText(sqrt);
        }

        if (pressed.equals(bPer)) {
            Double value = Double.parseDouble(textField.getText());
            value = value * 0.01;
            String percentage = String.valueOf(value);
            textField.setText(percentage);
        }

        if (inputs[1] != "")
            inputs[2] = textField.getText();

        if (pressed.equals(bDel)) {
            if (textField.getText().length() > 0)
                textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            else
                textField.setText("0");
        }
        if (pressed.equals(bClear))
            textField.setText("0");

        if (pressed.equals(bAdd)) {
            inputs[0] = textField.getText();
            textField.setText(bAdd.getLabel());
            inputs[1] = textField.getText();
        }

        if (pressed.equals(bSub)) {
            inputs[0] = textField.getText();
            textField.setText(bSub.getLabel());
            inputs[1] = textField.getText();
        }

        if (pressed.equals(bMul)) {
            inputs[0] = textField.getText();
            textField.setText(bMul.getLabel());
            inputs[1] = textField.getText();
        }

        if (pressed.equals(bDiv)) {
            inputs[0] = textField.getText();
            textField.setText(bDiv.getLabel());
            inputs[1] = textField.getText();
        }

        // Should be at the end

        if (textField.getText().length() == 0)
            textField.setText("0");
    }

    public static void main(String[] args) {
        new AWTCalculator();
    }
}
