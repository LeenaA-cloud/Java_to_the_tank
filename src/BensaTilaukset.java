import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JList;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class BensaTilaukset extends JFrame {

	private JPanel contentPane;
	private JLabel tilattava_polttoaine_txt;
	private JLabel tilattava_maara_txt;
	private JTextField syote_tilattava_maara;
	private JButton nappi_tilaa;

	

	private Choice polttoaineen_valinta;
	
	String tilaukset = "src/Img/tilaukset.txt";


	/**
	 * Create the frame.
	 */
	public BensaTilaukset() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BensaTilaukset.class.getResource("/Img/Gas.png")));
		setTitle("Polttoaineen tilaus");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tilattava_polttoaine_txt = new JLabel("Tilattava polttoaine:");
		tilattava_polttoaine_txt.setFont(new Font("Dialog", Font.BOLD, 14));
		tilattava_polttoaine_txt.setBounds(38, 39, 150, 29);
		contentPane.add(tilattava_polttoaine_txt);
		
		tilattava_maara_txt = new JLabel("Tilattava m\u00E4\u00E4r\u00E4/l:");
		tilattava_maara_txt.setFont(new Font("Dialog", Font.BOLD, 14));
		tilattava_maara_txt.setBounds(38, 144, 150, 29);
		contentPane.add(tilattava_maara_txt);
	
		
		syote_tilattava_maara = new JTextField();
		syote_tilattava_maara.setBounds(230, 148, 109, 20);
		contentPane.add(syote_tilattava_maara);
		syote_tilattava_maara.setColumns(10);
		
		nappi_tilaa = new JButton("L\u00E4het\u00E4 tilaus");
		nappi_tilaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(syote_tilattava_maara.getText().isEmpty())
				{	
					JOptionPane.showMessageDialog(null, "Lis�� polttoaineen m��r�!", null, JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				ArrayList<String> tankit = new ArrayList<>();
				 
				try (BufferedReader br = new BufferedReader(new FileReader("src/Img/tankit.txt"))) {
				    while (br.ready()) {
				        tankit.add(br.readLine());
				    }
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
					//System.out.println(e1);
				}
				
				String maara_95;
				String maara_98;
				String maara_diesel;
				
				maara_95 = tankit.get(0);
				maara_98 = tankit.get(1);
				maara_diesel = tankit.get(2);
			
				
				
				int maara_95_int = Integer.parseInt(maara_95);
				int maara_98_int = Integer.parseInt(maara_98);
				int maara_diesel_int = Integer.parseInt(maara_diesel);
				
			
					int valittu = polttoaineen_valinta.getSelectedIndex();
				
				
					String kayttajan_syote_txt = syote_tilattava_maara.getText();
					int kayttajan_syote_int = Integer.parseInt(kayttajan_syote_txt);
				
							
					int tilattava_maara_95 = maara_95_int + kayttajan_syote_int;
					String tilattava_maara_95txt = Integer.toString(tilattava_maara_95);
					
					int tilattava_maara_98 = maara_98_int + kayttajan_syote_int;
					String tilattava_maara_98txt = Integer.toString(tilattava_maara_98);
					
					int tilattava_maara_diesel = maara_diesel_int + kayttajan_syote_int;
					String tilattava_maara_dieseltxt = Integer.toString(tilattava_maara_diesel);
					
					syote_tilattava_maara.setText("");
					polttoaineen_valinta.select(0);
							
							
					if(kayttajan_syote_int == 0)
					{
					JOptionPane.showMessageDialog(null, "Tilauksen m��r� ei voi olla 0 litraa!", null, JOptionPane.ERROR_MESSAGE);
					return;
					}
						
	
					if(valittu == 1)
					{
					JOptionPane.showMessageDialog(null, "Tilaus l�hetetty!");
					kirjoitaTiedostoon("Tilattu 95-bensiini� " + kayttajan_syote_txt + " litraa", tilaukset);	
					tankit.set(0, tilattava_maara_95txt);
					
					try {
						printArrayListToFile(tankit, "src/Img/tankit.txt");
						} catch (Exception e2) {
							e2.printStackTrace();
					}
					return;
					}
					
					if(valittu == 2)
					{	
					
					JOptionPane.showMessageDialog(null, "Tilaus l�hetetty!");
					kirjoitaTiedostoon("Tilattu 98-bensiini� " + kayttajan_syote_txt + " litraa", tilaukset);
					tankit.set(1, tilattava_maara_98txt);
					try {
						printArrayListToFile(tankit, "src/Img/tankit.txt");
						} catch (Exception e2) {
							e2.printStackTrace();
					}
					return;
					}
					
					if(valittu == 3)
					{
					
					JOptionPane.showMessageDialog(null, "Tilaus l�hetetty!");
					kirjoitaTiedostoon("Tilattu dieseli� " + kayttajan_syote_txt + " litraa", tilaukset);
					tankit.set(2, tilattava_maara_dieseltxt);
					
					
					try {
						printArrayListToFile(tankit, "src/Img/tankit.txt");
						} catch (Exception e2) {
							e2.printStackTrace();
					}
					return;
					}
									
					if(valittu == 0) 
					{
						JOptionPane.showMessageDialog(null, "Valitse tilattava polttoaine!", null, JOptionPane.ERROR_MESSAGE);
					return;
					}
					
					
							
				syote_tilattava_maara.setText("");
				polttoaineen_valinta.select(0);
									
			}		
				
		});	
	
	
		nappi_tilaa.setBounds(229, 211, 150, 23);
		contentPane.add(nappi_tilaa);
		
		polttoaineen_valinta = new Choice();
		polttoaineen_valinta.setBounds(230, 39, 109, 20);
		contentPane.add(polttoaineen_valinta);
		polttoaineen_valinta.add("Valitse...");
		polttoaineen_valinta.add("95");
		polttoaineen_valinta.add("98");
		polttoaineen_valinta.add("Diesel");

	}
	
	public static void printArrayListToFile(ArrayList<String> arrayList, String filename) throws IOException {
	    PrintWriter writer = new PrintWriter(filename);
	    for (String line : arrayList) {
	        writer.println(line);
	    }
	    writer.close();
	}
	
	public String lueTiedostosta(String filename) {

		String alltext = "";

		try {
		FileReader freader = new FileReader(filename);
		BufferedReader br = new BufferedReader(freader);
		String line; 
		while ((line = br.readLine()) != null) {
		alltext = alltext + line + "\n";
		br.close();
		}
		
		} catch (Exception e) {
		e.printStackTrace();
		alltext = "";
		}
		
		return alltext;
		}
	
	
	
	public void kirjoitaTiedostoon(String txt, String filename) {;
	
		try {
			java.util.Date date = new java.util.Date();
			FileWriter fwriter = new FileWriter(tilaukset, true);
			fwriter.write(date.toString() + " ");
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
	}
	}

	}
	
// Leena Pasanen
