package com.gener.ek.screens;

import javax.swing.*;

public class Index extends JFrame {

	public Index() {
		setTitle("Individual registration validator and generator (CPF)");
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		JPanel index = new JPanel();
		index.setLayout(null);
		JLabel title = new JLabel("Create or Validate?");
		title.setBounds(230, 30, 150, 15);
		JButton createdButton = new JButton("Create");
		JButton validatedButton = new JButton("Validate");
		createdButton.setBounds(33, 75, 250, 50);
		validatedButton.setBounds(316, 75, 250, 50);

		createdButton.addActionListener(e -> new CreatedScreen());
		validatedButton.addActionListener(e -> new ValidateScreen());

		index.add(title);
		index.add(createdButton);
		index.add(validatedButton);
		add(index);
		setVisible(true);

	}


}

