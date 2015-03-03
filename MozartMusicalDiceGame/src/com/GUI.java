package com;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI {
	static boolean firstplay = true;
	
	public static void main(String[] args) {
		new GUI();
	}
	
	GUI() {
		JFrame guiFrame = new JFrame();
		JLabel jlabelsequence = new JLabel("Unique Waltz Sequence:");
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Mozart Waltz Generator - (NOT THREAD SAFE)");
		guiFrame.setSize(1000, 250);
		guiFrame.setLocationRelativeTo(null);
		
		JButton playButton = new JButton("Play Waltz");
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				StdAudio.play(Methods.runningsample);
			}
		});
		
		JButton saveButton = new JButton("Save Waltz");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				StdAudio.save(Methods.savefilename + ".wav", Methods.runningsample);
				Methods.savefilename = "";
				saveButton.setEnabled(false);
			}
		});
		
		JButton newWaltzButton = new JButton("Generate new Waltz");
		newWaltzButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (firstplay == true) {
					playButton.setEnabled(true);
					firstplay = false;
				}
				Methods.generateWaltzNameAndFilename();
				Methods.savefilename = Methods.outputfilename;
				jlabelsequence.setText("Unique Waltz Sequence: " + Methods.outputfilename);
				Methods.generateWaltzAudio();
				Methods.outputfilename = "";
				saveButton.setEnabled(true);
			}
		});
		
		guiFrame.add(jlabelsequence, BorderLayout.NORTH);
		guiFrame.add(playButton, BorderLayout.WEST);
		guiFrame.add(saveButton, BorderLayout.EAST);
		guiFrame.add(newWaltzButton, BorderLayout.SOUTH);
		guiFrame.setVisible(true);
		playButton.setEnabled(false);
		saveButton.setEnabled(false);
	}
	
}