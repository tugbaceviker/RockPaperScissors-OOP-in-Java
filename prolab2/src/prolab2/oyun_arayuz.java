package prolab2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.html.HTMLFrameElement;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class oyun_arayuz extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					oyun_arayuz frame = new oyun_arayuz();
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
	
	public oyun_arayuz() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Taş-Kağıt-Makas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1404, 851);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("KULLANICI-BİLGİSAYAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oyun2 oyun2=new oyun2();
				oyun2.setVisible(true);
				
	
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 52));
		btnNewButton.setBounds(42, 330, 618, 283);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("TAŞ-KAĞIT-MAKAS");
		lblNewLabel.setBounds(454, 10, 572, 82);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 68));
		contentPane.add(lblNewLabel);
		
		JButton btnBilgisayarbilgisayar = new JButton("BİLGİSAYAR-BİLGİSAYAR");
		btnBilgisayarbilgisayar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oyun1 oyun1=new oyun1 ();
				oyun1.setVisible(true);
			
				
			}
		});
		btnBilgisayarbilgisayar.setFont(new Font("Tahoma", Font.PLAIN, 52));
		btnBilgisayarbilgisayar.setBounds(728, 330, 618, 283);
		contentPane.add(btnBilgisayarbilgisayar);
	}
}
