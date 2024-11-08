package com.gener.ek;

import com.gener.ek.screens.Index;

import javax.swing.*;

public class App extends JFrame {
    public static void main(String[] args) {
		SwingUtilities.invokeLater(Index::new);
	}
}

