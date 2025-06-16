package com.gener.ek;

import com.gener.ek.screens.HomepageScreen;

import javax.swing.*;

public class App extends JFrame {
    public static void main(String[] args) {
		SwingUtilities.invokeLater(HomepageScreen::new);
	}
}

