package org.example;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame {
    JTextField tempInput, tempOutput;
    ButtonListener buttonListener;
    JLabel inputLabel, convertLabel, outputLabel, imgLabel;
    JComboBox comboBox1, comboBox2;

    public Main() {
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        setTitle("TEMPERATURE CONVERTER");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] s1 = {"Celsius", "Fahrenheit", "Kelvin"};
        comboBox1 = new JComboBox(s1);
        comboBox1.setBounds(200, 20, 90, 20);
        add(comboBox1);

        String[] s2 = {"Celsius", "Fahrenheit", "Kelvin"};
        comboBox2 = new JComboBox(s2);
        comboBox2.setBounds(100, 90, 90, 20);
        add(comboBox2);

        inputLabel = new JLabel("Temperature");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        inputLabel.setSize(270, 20);
        inputLabel.setLocation(0, 20);

        convertLabel = new JLabel("Convert to: ");
        convertLabel.setFont(new Font("Arial", Font.BOLD, 14));
        convertLabel.setSize(270, 20);
        convertLabel.setLocation(0, 90);

        tempInput = new JTextField(10);
        tempInput.setSize(40, 20);
        tempInput.setLocation(120, 20);

        tempOutput = new JTextField(10);
        tempOutput.setSize(120, 20);
        tempOutput.setLocation(90, 190);

        outputLabel = new JLabel("Output:");
        outputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        outputLabel.setSize(270, 20);
        outputLabel.setLocation(0, 190);

        JButton button = new JButton("Convert");
        button.setSize(80, 30);
        button.setLocation(130, 130);
        button.setBackground(Color.LIGHT_GRAY);
        buttonListener = new ButtonListener();
        button.addActionListener(buttonListener);

        imgLabel = new JLabel("");
        imgLabel.setIcon(new ImageIcon("images.png"));
        imgLabel.setBounds(190, 30, 438, 200);

        c.add(outputLabel);
        c.add(convertLabel);
        c.add(inputLabel);
        c.add(tempInput);
        c.add(tempOutput);
        c.add(button);
        c.add(comboBox1);
        c.add(comboBox2);
        c.add(imgLabel);
        tempOutput.setEditable(false);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String temp = (String) comboBox1.getSelectedItem();
            String tempConvert = (String) comboBox2.getSelectedItem();

            if (temp.equals("Celsius") && tempConvert.equals("Fahrenheit")) {
                double c = Double.parseDouble(tempInput.getText());
                double f = c * 1.8 + 32;
                tempOutput.setText(String.valueOf(f));
            } else if (temp.equals("Celsius") && tempConvert.equals("Kelvin")) {
                double c = Double.parseDouble(tempInput.getText());
                double k = c + 273;
                tempOutput.setText(String.valueOf(k));
            } else if (temp.equals("Celsius") && tempConvert.equals("Celsius")) {
                double c = Double.parseDouble(tempInput.getText());
                tempOutput.setText(String.valueOf(c));
            }

            if (temp.equals("Fahrenheit") && tempConvert.equals("Celsius")) {
                double f = Double.parseDouble(tempInput.getText());
                double c = (f - 32) * 5 / 9;
                tempOutput.setText(String.valueOf(c));
            } else if (temp.equals("Fahrenheit") && tempConvert.equals("Kelvin")) {
                double f = Double.parseDouble(tempInput.getText());
                double k = (f - 32) * 5 / 9 + 273.15;
                tempOutput.setText(String.valueOf(k));
            } else if (temp.equals("Fahrenheit") && tempConvert.equals("Fahrenheit")) {
                double f = Double.parseDouble(tempInput.getText());
                tempOutput.setText(String.valueOf(f));
            }

            if (temp.equals("Kelvin") && tempConvert.equals("Fahrenheit")) {
                double k = Double.parseDouble(tempInput.getText());
                double f = (k * (5 / 9)) - 459.67;
                tempOutput.setText(String.valueOf(f));
            } else if (temp.equals("Kelvin") && tempConvert.equals("Celsius")) {
                double k = Double.parseDouble(tempInput.getText());
                double c = k - 273;
                tempOutput.setText(String.valueOf(c));
            } else if (temp.equals("Kelvin") && tempConvert.equals("Kelvin")) {
                double k = Double.parseDouble(tempInput.getText());
                tempOutput.setText(String.valueOf(k));
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}