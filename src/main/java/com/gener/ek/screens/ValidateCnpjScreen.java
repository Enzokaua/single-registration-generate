package com.gener.ek.screens;

import com.gener.ek.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class ValidateCnpjScreen extends JFrame {

    public ValidateCnpjScreen() {
        setTitle("Validate CNPJ");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        JPanel validateScreen = new JPanel();
        validateScreen.setLayout(null);
        JLabel title = new JLabel("Insert your value:");
        title.setBounds(100, 20, 150, 15);
        JButton backToIndexButton = new JButton("Back");
        JButton validatedNumericButton = new JButton("Validate Num");
        JButton validadeAlphaButton = new JButton("Validate Alph");
        validatedNumericButton.setBounds(30, 80, 140, 40);
        validadeAlphaButton.setBounds(230, 80, 140, 40);
        backToIndexButton.setBounds(430, 80, 140, 40);
        JTextArea textArea = new JTextArea();
        textArea.setBounds(250, 20, 150, 15);
        JLabel resultLabel = new JLabel();
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setBounds(425, 20, 200, 15);

        backToIndexButton.addActionListener(e -> {new HomepageScreen(); dispose();});
        validatedNumericButton.addActionListener(e -> {
            if (Boolean.TRUE.equals(Utils.isValidateCnpj(textArea.getText()))) {
                resultLabel.setText("VALID");
                resultLabel.setForeground(Color.GREEN);

            } else {
                resultLabel.setText("INVALID");
                resultLabel.setForeground(Color.RED);

            }
        });

        validadeAlphaButton.addActionListener(e -> {
            if (Boolean.TRUE.equals(Utils.isValidAlphanumericCnpj(textArea.getText()))) {
                resultLabel.setText("VALID");
                resultLabel.setForeground(Color.GREEN);

            } else {
                resultLabel.setText("INVALID");
                resultLabel.setForeground(Color.RED);

            }
        });

        validateScreen.add(resultLabel);
        validateScreen.add(textArea);
        validateScreen.add(validatedNumericButton);
        validateScreen.add(validadeAlphaButton);
        validateScreen.add(backToIndexButton);
        validateScreen.add(title);
        add(validateScreen);
        setVisible(true);

    }


}

