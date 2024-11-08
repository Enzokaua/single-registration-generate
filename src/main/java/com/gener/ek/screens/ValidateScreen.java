package com.gener.ek.screens;

import com.gener.ek.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class ValidateScreen extends JFrame {

    public ValidateScreen() {
        setTitle("Validate CPF");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        JPanel validateScreen = new JPanel();
        validateScreen.setLayout(null);
        JLabel title = new JLabel("Insert your value:");
        title.setBounds(100, 20, 150, 15);
        JButton backToIndexButton = new JButton("Back");
        JButton validatedButton = new JButton("Validate");
        validatedButton.setBounds(33, 75, 250, 50);
        backToIndexButton.setBounds(316, 75, 250, 50);
        JTextArea textArea = new JTextArea();
        textArea.setBounds(250, 20, 150, 15);
		JLabel resultLabel = new JLabel();
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setBounds(425, 20, 200, 15);

        backToIndexButton.addActionListener(e -> new Index());
        validatedButton.addActionListener(e -> {
            if (Boolean.TRUE.equals(Utils.isValidateCpf(textArea.getText()))) {
                resultLabel.setText("VÁLIDO");
                resultLabel.setForeground(Color.GREEN);

            } else {
                resultLabel.setText("INVÁLIDO");
                resultLabel.setForeground(Color.RED);

            }
        });

		validateScreen.add(resultLabel);
        validateScreen.add(textArea);
        validateScreen.add(validatedButton);
        validateScreen.add(backToIndexButton);
        validateScreen.add(title);
        add(validateScreen);
        setVisible(true);

    }


}

