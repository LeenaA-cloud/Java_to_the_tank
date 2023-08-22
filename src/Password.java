import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class Password extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JLabel label1;
	private JLabel label2;
	private JButton nappi1;

	private Manager manager = new Manager();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password frame = new Password();
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
	public Password() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Password.class.getResource("/Img/Gas.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setBounds(156, 67, 163, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JPasswordField();
		textField2.setBounds(156, 107, 163, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		((JPasswordField) textField2).setEchoChar('*');
		
		label1 = new JLabel("K\u00E4ytt\u00E4j\u00E4tunnus");
		label1.setBounds(58, 70, 112, 14);
		contentPane.add(label1);
		
		label2 = new JLabel("Salasana");
		label2.setBounds(58, 110, 112, 14);
		contentPane.add(label2);
		
		nappi1 = new JButton("Kirjaudu");
		nappi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			
				 
				 String oikea_kayttajatunnus = textField1.getText();
				 String oikea_salasana = crypt(textField2.getText()); 
				 
				 
					
					//System.out.println(oikea_kayttajatunnus);
					//System.out.println(oikea_salasana);
					
					
					try {
						
						Scanner in = new Scanner(new File("src/img/logins"));
			            while (in.hasNextLine())
			            {
			              String s = in.nextLine();  
			              String[] sArray = s.split(",");
			              
			              //System.out.println(sArray[0]); //Just to verify that file is being read
			              //System.out.println(sArray[1]);

			              
			              if (oikea_kayttajatunnus.equals(sArray[0]) && oikea_salasana.equals(sArray[1]))
			              {
			                	manager.setVisible(true);
			                	Password.this.dispose();
			              }
			              else
			              {
			                JOptionPane.showMessageDialog(null,
			                    "Tarkista tunnus ja salasana!", "Virhe!",
			                    JOptionPane.ERROR_MESSAGE);
			              }
			            }
			            
			            in.close();
			            
			        } catch (FileNotFoundException e) {
			            JOptionPane.showMessageDialog(null,
			                    "Tunnustiedostoa ei löydy!", "Virhe!",
			                    JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		nappi1.setBounds(156, 176, 163, 23);
		contentPane.add(nappi1);
	}
	
	public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        MessageDigest digester;
        try {
            digester = MessageDigest.getInstance("MD5");

            digester.update(str.getBytes());
            byte[] hash = digester.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
// Leena Pasanen

}
