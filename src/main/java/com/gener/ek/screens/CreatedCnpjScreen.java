package com.gener.ek.screens;

import com.gener.ek.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class CreatedCnpjScreen extends JFrame {

	public CreatedCnpjScreen() {
		setTitle("CNPJ Generator");
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		JPanel createdScreen = new JPanel();
		createdScreen.setLayout(null);
		JCheckBox formatCheckBox = new JCheckBox("Formatter?");
		JLabel title = new JLabel("CNPJ Valid: " + Utils.makeCnpj(true));
		JButton refactorButton = new JButton("Refactor");
		JButton alfanumericButton = new JButton("Alpha");
		JButton backToIndexButton = new JButton("Back");
		title.setFont(new Font("Arial", Font.BOLD, 14));
		formatCheckBox.setBounds(425, 30, 120, 15);
		title.setBounds(30, 20, 540, 25);
		refactorButton.setBounds(33, 75, 160, 50);
		alfanumericButton.setBounds(210, 75, 160, 50);
		backToIndexButton.setBounds(390, 75, 160, 50);

		refactorButton.addActionListener(e -> {
			boolean formatCnpj = formatCheckBox.isSelected();
			title.setText("CNPJ Num: " + Utils.makeCnpj(formatCnpj));
		});

		alfanumericButton.addActionListener(e -> {
			boolean formatCnpjAlpha = formatCheckBox.isSelected();
			title.setText("CNPJ Alpha: " + Utils.makeAlphanumericCnpj(formatCnpjAlpha));
		});

		backToIndexButton.addActionListener(e -> {new HomepageScreen(); dispose();});
		createdScreen.add(formatCheckBox);
		createdScreen.add(title);
		createdScreen.add(backToIndexButton);
		createdScreen.add(refactorButton);
		createdScreen.add(alfanumericButton);
		add(createdScreen);
		setVisible(true);

	}

}

