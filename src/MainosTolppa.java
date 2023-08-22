import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainosTolppa extends JFrame {

	private JPanel contentPane;
	private JLabel MainosKuva1;


	/**
	 * Create the frame.
	 */
	public MainosTolppa() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainosTolppa.class.getResource("/Img/Gas.png")));
		setTitle("Ulkotolppa");
		
		
		ArrayList<String> hinnat = new ArrayList<>();
		 
		try (BufferedReader br = new BufferedReader(new FileReader("src/img/hinnat"))) {
		    while (br.ready()) {
		        hinnat.add(br.readLine());
		    }
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 270, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MainosKuva1 = new JLabel("");
		MainosKuva1.setBounds(83, 26, 104, 152);
		contentPane.add(MainosKuva1);
		ImageIcon icon = createImageIcon("img/bensaa.png", "Bensaa");
		 MainosKuva1.setIcon(icon); 
		 
		 JLabel MainosText1 = new JLabel("Tankille.com");
		 MainosText1.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		 MainosText1.setHorizontalAlignment(SwingConstants.CENTER);
		 MainosText1.setBounds(53, 204, 163, 50);
		 contentPane.add(MainosText1);
		 
		 JLabel Mainos95 = new JLabel("");
		 Mainos95.setHorizontalAlignment(SwingConstants.CENTER);
		 Mainos95.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		 Mainos95.setBounds(53, 276, 163, 16);
		 contentPane.add(Mainos95);
		 Mainos95.setText("95   "+hinnat.get(0)+"   €/L");
		 
		 
		 JLabel Mainos98 = new JLabel("");
		 Mainos98.setHorizontalAlignment(SwingConstants.CENTER);
		 Mainos98.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		 Mainos98.setBounds(53, 317, 163, 16);
		 contentPane.add(Mainos98);
		 Mainos98.setText("98   "+hinnat.get(1)+"   €/L");
		 
		 JLabel MainosDiesel = new JLabel("");
		 MainosDiesel.setHorizontalAlignment(SwingConstants.CENTER);
		 MainosDiesel.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		 MainosDiesel.setBounds(6, 356, 224, 16);
		 contentPane.add(MainosDiesel);
		 MainosDiesel.setText("Diesel   "+hinnat.get(2)+"   €/L");
		 
		 JLabel MainosTarjous = new JLabel("");
		 MainosTarjous.setHorizontalAlignment(SwingConstants.CENTER);
		 MainosTarjous.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
		 MainosTarjous.setBounds(53, 436, 163, 31);
		 contentPane.add(MainosTarjous);
		 MainosTarjous.setText(hinnat.get(3));
		 
		 JLabel MainosText2 = new JLabel("+");
		 MainosText2.setHorizontalAlignment(SwingConstants.CENTER);
		 MainosText2.setForeground(new Color(0, 128, 0));
		 MainosText2.setFont(new Font("Helvetica Neue", Font.BOLD, 36));
		 MainosText2.setBounds(110, 393, 50, 31);
		 contentPane.add(MainosText2);
		 
		 JButton Update = new JButton("*");
		 Update.setForeground(new Color(0, 128, 0));
		 Update.setVerticalAlignment(SwingConstants.TOP);
		 Update.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		 Update.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		ArrayList<String> hinnat = new ArrayList<>();
				 
				try (BufferedReader br = new BufferedReader(new FileReader("src/img/hinnat"))) {
				    while (br.ready()) {
				        hinnat.add(br.readLine());
				    }
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				Mainos95.setText("95   "+hinnat.get(0)+"   €/L");
				Mainos98.setText("98   "+hinnat.get(1)+"   €/L");
				MainosDiesel.setText("Diesel   "+hinnat.get(2)+"   €/L");
				MainosTarjous.setText(hinnat.get(3));
				
		 	}
		 });
		 Update.setBounds(114, 477, 42, 31);
		 contentPane.add(Update);
		
		
		
	}
	
	protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL, description);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(MainosKuva1.getWidth(), MainosKuva1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc = new ImageIcon(newImg);
           
            return newImc;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
 }
}
// Leena Pasanen