import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;




public class BensaTankit extends JFrame {

	private JPanel contentPane;
	private JLabel Tankki1;
	private JLabel Tankki2;
	private JLabel Tankki3;
	private JButton nappi_tilaus;
	
	private BensaTilaukset tilaukset = new BensaTilaukset();
	//private SalasanaIkkuna salasana = new SalasanaIkkuna();
	
	String filename = "src/Img/tankit.txt";
	
	private JLabel maara_95;
	private JButton paivita_tankit;
	private JLabel maara_98;
	private JLabel maara_diesel;
	private JLabel litramaara;
	private JLabel litramaara_1;
	private JLabel litramaara_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BensaTankit frame = new BensaTankit();
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
	public BensaTankit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BensaTankit.class.getResource("/Img/Gas.png")));
		setTitle("Polttoainetankkien tarkkailu ja hallinta");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Tankki1 = new JLabel("95");
		Tankki1.setFont(new Font("Dialog", Font.BOLD, 18));
		Tankki1.setHorizontalAlignment(SwingConstants.CENTER);
		Tankki1.setBounds(58, 26, 70, 22);
		contentPane.add(Tankki1);
		
		Tankki2 = new JLabel("98");
		Tankki2.setFont(new Font("Dialog", Font.BOLD, 18));
		Tankki2.setHorizontalAlignment(SwingConstants.CENTER);
		Tankki2.setBounds(58, 78, 70, 22);
		contentPane.add(Tankki2);
		
		Tankki3 = new JLabel("Diesel");
		Tankki3.setFont(new Font("Dialog", Font.BOLD, 18));
		Tankki3.setHorizontalAlignment(SwingConstants.CENTER);
		Tankki3.setBounds(58, 123, 70, 22);
		contentPane.add(Tankki3);
		
		nappi_tilaus = new JButton("Tilaa lis\u00E4\u00E4 polttoainetta");
		nappi_tilaus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tilaukset.setVisible(true);
//				salasana.dispose();
//				salasana = new SalasanaIkkuna();
//				salasana.setVisible(true);
				
				
			}
		});
		nappi_tilaus.setBounds(125, 227, 185, 23);
		contentPane.add(nappi_tilaus);
		
		maara_95 = new JLabel("");
		maara_95.setFont(new Font("Dialog", Font.BOLD, 16));
		maara_95.setHorizontalAlignment(SwingConstants.CENTER);
		maara_95.setBounds(180, 26, 70, 22);
		contentPane.add(maara_95);
  
		
		paivita_tankit = new JButton("P\u00E4ivit\u00E4 tankkien tilanne");
		paivita_tankit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> tankit = new ArrayList<>();
				 
				try (BufferedReader br = new BufferedReader(new FileReader("src/Img/tankit.txt"))) {
				    while (br.ready()) {
				        tankit.add(br.readLine());
				    }
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				maara_95.setText(tankit.get(0));
				maara_98.setText(tankit.get(1));
				maara_diesel.setText(tankit.get(2));
				
				
				String str_maara_95;
				String str_maara_98;
				String str_maara_diesel;
				
				str_maara_95 = tankit.get(0);
				str_maara_98 = tankit.get(1);
				str_maara_diesel = tankit.get(2);
 	
				int maara_95_int = Integer.parseInt(str_maara_95);
				int maara_98_int = Integer.parseInt(str_maara_98);
				int maara_diesel_int = Integer.parseInt(str_maara_diesel);
		
				if (maara_95_int < 100 || maara_98_int < 100 || maara_diesel_int < 100)
				{
					JOptionPane.showMessageDialog(null, "Polttoaine v�hiss�! Tee lis�tilaus.");
				}
				
				}
			
		});
		paivita_tankit.setBounds(125, 193, 185, 23);
		contentPane.add(paivita_tankit);
		
		maara_98 = new JLabel("");
		maara_98.setFont(new Font("Dialog", Font.BOLD, 16));
		maara_98.setHorizontalAlignment(SwingConstants.CENTER);
		maara_98.setBounds(180, 78, 70, 22);
		contentPane.add(maara_98);
		
		maara_diesel = new JLabel("");
		maara_diesel.setFont(new Font("Dialog", Font.BOLD, 16));
		maara_diesel.setHorizontalAlignment(SwingConstants.CENTER);
		maara_diesel.setBounds(180, 123, 70, 22);
		contentPane.add(maara_diesel);
		
		litramaara = new JLabel("litraa");
		litramaara.setFont(new Font("Dialog", Font.BOLD, 12));
		litramaara.setHorizontalAlignment(SwingConstants.CENTER);
		litramaara.setBounds(299, 28, 70, 22);
		contentPane.add(litramaara);
		
		litramaara_1 = new JLabel("litraa");
		litramaara_1.setFont(new Font("Dialog", Font.BOLD, 12));
		litramaara_1.setHorizontalAlignment(SwingConstants.CENTER);
		litramaara_1.setBounds(299, 80, 70, 22);
		contentPane.add(litramaara_1);
		
		litramaara_2 = new JLabel("litraa");
		litramaara_2.setFont(new Font("Dialog", Font.BOLD, 12));
		litramaara_2.setHorizontalAlignment(SwingConstants.CENTER);
		litramaara_2.setBounds(299, 125, 70, 22);
		contentPane.add(litramaara_2);
	}
	public String lueTiedostosta(String filename) {

		String alltext = "";

		try {
		FileReader freader = new FileReader(filename);
		BufferedReader br = new BufferedReader(freader);
		String line; 
		while ((line = br.readLine()) != null) {
		alltext = alltext + line;
		br.close();
		}
		
		} catch (Exception e) {
		e.printStackTrace();
		alltext = "";
		}

		return alltext;
		}
}
// Leena Pasanen
