package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ConsulterAeroPorts extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ConsulterAeroPorts() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List list = new List();
		list.setBounds(10, 35, 355, 194);
		for(int i=0;i<MainR.aeroports.size();i++) {
			String s ="Aeroport :"+MainR.aeroports.get(i).name+" KeroRestant :"+MainR.aeroports.get(i).KeroR+"/"+MainR.aeroports.get(i).CapaciteKero+" Nombres d'avions:"+MainR.aeroports.get(i).avions.size()+"/"+MainR.aeroports.get(i).capaciteAv;
		list.add(s);
		}
		contentPane.add(list);
		
		JButton Refill = new JButton("Remplire");
		Refill.setBounds(395, 127, 89, 23);
		Refill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				MainR.aeroports.get(list.getSelectedIndex()).KeroR=MainR.aeroports.get(list.getSelectedIndex()).CapaciteKero;
				c();
			}
		});
		contentPane.add(Refill);
	}
	public void c() {
	this.setVisible(false);
		this.dispose();
	}
}
