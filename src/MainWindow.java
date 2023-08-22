import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JButton MainButton1;
	private JButton MainButton2;
	private JLabel MainKuva1;
	
	private Password password = new Password();
	private Bensamittari bensamittari = new Bensamittari();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Img/Gas.png")));
		setTitle("Tankille.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 349);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Welcome = new JLabel("Tervetuloa - Tankille.com");
		Welcome.setForeground(Color.WHITE);
		Welcome.setBackground(Color.WHITE);
		Welcome.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		Welcome.setBounds(53, 17, 345, 73);
		contentPane.add(Welcome);
		
		MainButton1 = new JButton("Asiakas");
	//	ImageIcon img = createImageIcon("img/ok.png");
		
		//Image img = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
	//	MainButton1.setIcon(new ImageIcon(img));
		MainButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MainButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					bensamittari.dispose();
					bensamittari = new Bensamittari();
					bensamittari.setVisible(true);
		
			}
		});
		MainButton1.setBounds(53, 257, 166, 29);
		contentPane.add(MainButton1);
		
		MainButton2 = new JButton("Tuki");
		MainButton2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MainButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password.dispose();
				password = new Password();
				password.setVisible(true);
			}
		});
		MainButton2.setBounds(254, 257, 175, 29);
		contentPane.add(MainButton2);
		
		MainKuva1 = new JLabel("");
		MainKuva1.setBounds(0,0,500,300);
		contentPane.add(MainKuva1);
		
		ImageIcon icon = createImageIcon("img/gasstation.jpg", "Bensaa");
		 MainKuva1.setIcon(icon); 
		
		
	}
	 protected ImageIcon createImageIcon(String path, String description) {
	        java.net.URL imgURL = getClass().getResource(path);
	        if (imgURL != null) {
	            ImageIcon icon = new ImageIcon(imgURL, description);
	            Image img = icon.getImage();
	            Image newImg = img.getScaledInstance(MainKuva1.getWidth(), MainKuva1.getHeight(), Image.SCALE_SMOOTH);
	            ImageIcon newImc = new ImageIcon(newImg);
	           
	            return newImc;
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	 }
	// Leena Pasanen
}
