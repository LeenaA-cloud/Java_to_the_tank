import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Tankkaus extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Maksa maksa = new Maksa();
	private JComboBox comboBox;
	private JButton kuitille_nappi;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField maaraArea;
	private JLabel lblNewLabel_4;
	
	String filename = "src/Img/tilaukset.txt";
	String filename2 = "src/Img/kuitti.txt";
	private JButton tallenna_nappi;
	private JTextArea textArea8;
	
	double maara;
	String E95;
	String E98;
	String Diesel;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tankkaus frame = new Tankkaus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Tankkaus() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tankkaus.class.getResource("/img/Gas.png")));
		setTitle("Tankkaus");
		
		File f = new File(filename);
		if(!f.exists()) { 
		    alustaTiedosto();
		}
		
		setBounds(100, 100, 568, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton maksamaan_nappi = new JButton("Maksamaan");
			maksamaan_nappi.setForeground(Color.BLACK);
			maksamaan_nappi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					maksa=new Maksa();
					maksa.setVisible(true);
					kirjoitaTiedostoon2(textArea8.getText(),filename2);
				}
			
			});
			maksamaan_nappi.setFont(new Font("Tahoma", Font.PLAIN, 22));
			maksamaan_nappi.setBounds(359, 250, 179, 51);
			contentPanel.add(maksamaan_nappi);
		
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.addItem("E95");
		comboBox.addItem("E98");
		comboBox.addItem("Diesel");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(187, 95, 142, 22);
		contentPanel.add(comboBox);
		
		kuitille_nappi = new JButton("Kuitille: ");
		kuitille_nappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = (String) comboBox.getSelectedItem();
				java.util.Date date = new java.util.Date();
				String maara = (String)maaraArea.getSelectedText();
				
				textArea8.setText("P�iv�m��r� :" + date + "\nSumma: " + "\nLitrat: "+ maara + "\nTyyppi: " + value);
				
			}
		});
		kuitille_nappi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		kuitille_nappi.setBounds(12, 210, 123, 35);
		contentPanel.add(kuitille_nappi);
		
		lblNewLabel = new JLabel("Polttoaine");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(78, 93, 97, 22);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("M\u00E4\u00E4r\u00E4");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(92, 153, 86, 22);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Valitse polttoaine, Sy\u00F6t\u00E4 M\u00E4\u00E4r\u00E4 >Tallenna, Kuitille, Maksamaan");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(24, 29, 503, 35);
		contentPanel.add(lblNewLabel_2);
		
		maaraArea = new JTextField();
		maaraArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		maaraArea.setBounds(194, 152, 123, 29);
		contentPanel.add(maaraArea);
		maaraArea.setColumns(10);
		
		lblNewLabel_4 = new JLabel("l");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(333, 155, 56, 16);
		contentPanel.add(lblNewLabel_4);
		
		tallenna_nappi = new JButton("Tallenna ");
		tallenna_nappi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tallenna_nappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
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
				
				String maara_95;
				String maara_98;
				String maara_diesel;
				
				maara_95 = tankit.get(0);
				maara_98 = tankit.get(1);
				maara_diesel = tankit.get(2);

				int maara_95_int = Integer.parseInt(maara_95);
				int maara_98_int = Integer.parseInt(maara_98);
				int maara_diesel_int = Integer.parseInt(maara_diesel);
				
				int valittu = comboBox.getSelectedIndex();
				
				String tankattava_maara_str = maaraArea.getText();
				int tankattava_maara_int = Integer.parseInt(tankattava_maara_str);
				
				int tankattava_maara95_int = maara_95_int - tankattava_maara_int;
				String tankattava_maara95_str = Integer.toString(tankattava_maara95_int);
				
				int tankattava_maara98_int = maara_98_int - tankattava_maara_int;
				String tankattava_maara98_str = Integer.toString(tankattava_maara98_int);
				
				int tankattava_maaradiesel_int = maara_diesel_int - tankattava_maara_int;
				String tankattava_maaradiesel_str = Integer.toString(tankattava_maaradiesel_int);
				
				
			if (valittu == 0)
			{
			tankit.set(0, tankattava_maara95_str);					
					
			try {
				printArrayListToFile(tankit, "src/Img/tankit.txt");
				} catch (Exception e2) {
					e2.printStackTrace();
			}
			return;
			}
			
			if (valittu == 1)
			{
				tankit.set(1, tankattava_maara98_str);
					
			try {
				printArrayListToFile(tankit, "src/Img/tankit.txt");
				} catch (Exception e2) {
					e2.printStackTrace();		
			}
			return;
			}
		
			if (valittu == 2)
			{
			tankit.set(2, tankattava_maaradiesel_str);
			
			try {
				printArrayListToFile(tankit, "src/Img/tankit.txt");
				} catch (Exception e2) {
					e2.printStackTrace();		
			}
			return;
			}		
		}
		
	});
		tallenna_nappi.setBounds(370, 154, 168, 27);
		contentPanel.add(tallenna_nappi);
		
		textArea8 = new JTextArea();
		textArea8.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		textArea8.setBounds(168, 210, 179, 91);
		contentPanel.add(textArea8);
		}
	}
	
	
	public static void printArrayListToFile(ArrayList<String> arrayList, String filename) throws IOException {
	    PrintWriter writer = new PrintWriter(filename);
	    for (String line : arrayList) {
	        writer.println(line);
	    }
	    writer.close();
	}
	
	public void kirjoitaTiedostoon(String txt, String filename) {
		try {
			//java.util.Date date = new java.util.Date();
			// Valinta true lopussa aiheuttaa sen, ett� ei ylikirjoiteta vaan jatketaan olemassa olevan per��n
			FileWriter fwriter = new FileWriter(filename, true);
			//fwriter.write(date.toString());
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void kirjoitaTiedostoon2(String txt, String filename) {
		try {
			java.util.Date date = new java.util.Date();
			// Valinta true lopussa aiheuttaa sen, ett� ei ylikirjoiteta vaan jatketaan olemassa olevan per��n
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(date.toString());
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void alustaTiedosto() {
		String kirjoitettava = "E95 = 1000\n"
				+ "E98= 2000\n"
				+ "Diesel = 3000";
	
		kirjoitaTiedostoon(kirjoitettava, filename);
	}
}
// Leena Pasanen