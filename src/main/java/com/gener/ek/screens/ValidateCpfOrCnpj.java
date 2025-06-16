package com.gener.ek.screens;

import javax.swing.*;

public class ValidateCpfOrCnpj extends JFrame {

	public ValidateCpfOrCnpj() {
		setTitle("Validate Field");
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		JPanel index = new JPanel();
		index.setLayout(null);
		JLabel title = new JLabel("Validate CPF or CNPJ?");
		title.setBounds(230, 30, 150, 15);
		JButton cpfButton = new JButton("CPF");
		JButton cnpjButton = new JButton("CNPJ");
		cpfButton.setBounds(33, 75, 250, 50);
		cnpjButton.setBounds(316, 75, 250, 50);

		cpfButton.addActionListener(e -> {new ValidateCpfScreen(); dispose();});
		cnpjButton.addActionListener(e -> {new ValidateCnpjScreen(); dispose();});

		index.add(title);
		index.add(cpfButton);
		index.add(cnpjButton);
		add(index);
		setVisible(true);

	}


}

