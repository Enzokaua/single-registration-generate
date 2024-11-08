package com.gener.ek.screens;

import com.gener.ek.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class CreatedScreen extends JFrame {

	public CreatedScreen() {
		setTitle("CPF Generator");
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		JPanel createdScreen = new JPanel();
		createdScreen.setLayout(null);
		JCheckBox formatCheckBox = new JCheckBox("Formatter?");
		JLabel title = new JLabel("CPF valid: " + Utils.makeCpf(true));
		JButton refactorButton = new JButton("Refactor");
		JButton backToIndexButton = new JButton("Back");
		title.setFont(new Font("Arial", Font.BOLD, 14));
		formatCheckBox.setBounds(425, 30, 120, 15);
		title.setBounds(230, 30, 250, 15);
		refactorButton.setBounds(33, 75, 250, 50);
		backToIndexButton.setBounds(316, 75, 250, 50);

		refactorButton.addActionListener(e -> {
			boolean formatCpf = formatCheckBox.isSelected();
			title.setText("CPF valid: " + Utils.makeCpf(formatCpf));
		});

		backToIndexButton.addActionListener(e -> new Index());
		createdScreen.add(formatCheckBox);
		createdScreen.add(title);
		createdScreen.add(backToIndexButton);
		createdScreen.add(refactorButton);
		add(createdScreen);
		setVisible(true);

	}

}

