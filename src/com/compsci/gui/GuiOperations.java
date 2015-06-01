package com.compsci.gui;

import java.awt.Color;

public class GuiOperations {

	public static void changeColor(Color newColor) {
		if (!FrameHandle.getOutputPane().getBackground().equals(newColor) && newColor != null) {
			FrameHandle.getOutputPane().setBackground(newColor);
		}
	}
	
	public static void openPropertiesDialog() {
		if (FrameHandle.getPropertiesDialog() == null) {
			FrameHandle.setPropertiesDialog(new PropertiesDialog());
		}
		else {
			FrameHandle.getPropertiesDialog().setVisible(true);
		}
	}
	
	public static void closePropertiesDialog() {
		if (FrameHandle.getPropertiesDialog() != null) {
			FrameHandle.getPropertiesDialog().setVisible(false);
			FrameHandle.getPropertiesDialog().dispose();
		}
	}
	
	public static void switchToConsole() {
		if (LoginPanel.isDisplayed()) {
			if (FrameHandle.getFrame() != null) {
				FrameHandle.getFrame().remove(FrameHandle.getLoginPanel());
				LoginPanel.setDisplayed(false);
				
				FrameHandle.setupConsole();
				FrameHandle.getPropertiesItem().setEnabled(true);
				FrameHandle.getFrame().revalidate();
				FrameHandle.getFrame().repaint();
				System.out.println("DONE");
			}
		}
	}
}
