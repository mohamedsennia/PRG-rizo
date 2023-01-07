package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	public JPanel contentPane;
	JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 775, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		panel.setBounds(0, 0, 748, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		 

	
	
		
		JButton AjouterVol = new JButton("Ajouter un vol");
		AjouterVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainR.aj=new AjouterVol();
				MainR.aj.setVisible(true);
				
			}
		});
		AjouterVol.setBounds(479, 129, 218, 23);
		panel.add(AjouterVol);
		
		JButton Réacheminer = new JButton("R\u00E9acheminer un vol");
		Réacheminer.setBounds(479, 203, 218, 23);
		panel.add(Réacheminer);
		
		JButton Autre = new JButton("Autre param\u00E8tres");
		Autre.setBounds(479, 279, 218, 23);
		panel.add(Autre);
		
	
	}
}
