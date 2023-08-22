import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;

public class Manager extends JFrame {

	private JPanel contentPane;
	private JTextField Manager95;
	private JTextField Manager98;
	private JTextField ManagerDiesel;
	private JTextField MainosLause;
	
	private MainosTolppa mainostolppa = new MainosTolppa();
	private JButton btnTankit;
	private BensaTankit bensatankit = new BensaTankit();



	/**
	 * Create the frame.
	 */
	public Manager() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Manager.class.getResource("/Img/Gas.png")));
		setTitle("Manager");
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 465, 336);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ManagerOtsikko1 = new JLabel("Aseta polttoaineiden hinnat");
		ManagerOtsikko1.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		ManagerOtsikko1.setBounds(142, 48, 166, 16);
		contentPane.add(ManagerOtsikko1);
		
		JLabel ManagerOtsikko95 = new JLabel("95");
		ManagerOtsikko95.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ManagerOtsikko95.setBounds(116, 75, 61, 16);
		contentPane.add(ManagerOtsikko95);
		
		JLabel ManagerOtsikko98 = new JLabel("98");
		ManagerOtsikko98.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ManagerOtsikko98.setBounds(116, 112, 61, 16);
		contentPane.add(ManagerOtsikko98);
		
		JLabel ManagerOtsikkoDiesel = new JLabel("Diesel");
		ManagerOtsikkoDiesel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ManagerOtsikkoDiesel.setBounds(116, 148, 61, 16);
		contentPane.add(ManagerOtsikkoDiesel);
		
		Manager95 = new JTextField();
		Manager95.setBounds(187, 73, 71, 26);
		contentPane.add(Manager95);
		Manager95.setColumns(10);
		
		
		Manager98 = new JTextField();
		Manager98.setColumns(10);
		Manager98.setBounds(187, 110, 71, 26);
		contentPane.add(Manager98);
		
		ManagerDiesel = new JTextField();
		ManagerDiesel.setColumns(10);
		ManagerDiesel.setBounds(187, 146, 71, 26);
		contentPane.add(ManagerDiesel);
		
		JLabel ManagerYksikko = new JLabel("€/Litra");
		ManagerYksikko.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		ManagerYksikko.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ManagerYksikko.setBounds(268, 75, 61, 16);
		contentPane.add(ManagerYksikko);
		
		JLabel ManagerYksikko_1 = new JLabel("€/Litra");
		ManagerYksikko_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ManagerYksikko_1.setBounds(268, 112, 61, 16);
		contentPane.add(ManagerYksikko_1);
		
		JLabel ManagerYksikko_2 = new JLabel("€/Litra");
		ManagerYksikko_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ManagerYksikko_2.setBounds(268, 148, 61, 16);
		contentPane.add(ManagerYksikko_2);
		
		
		
		JLabel ManagerOtsikko2 = new JLabel("Aseta päivän tarjous");
		ManagerOtsikko2.setHorizontalAlignment(SwingConstants.CENTER);
		ManagerOtsikko2.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		ManagerOtsikko2.setBounds(142, 183, 166, 16);
		contentPane.add(ManagerOtsikko2);
		
		MainosLause = new JTextField();
		MainosLause.setColumns(10);
		MainosLause.setBounds(101, 204, 228, 26);
		contentPane.add(MainosLause);
		
		JButton FetchPrice = new JButton("Hae hinnat");
		FetchPrice.addActionListener(new ActionListener() {
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

				
				Manager95.setText(hinnat.get(0));
				Manager98.setText(hinnat.get(1));
				ManagerDiesel.setText(hinnat.get(2)); 
				MainosLause.setText(hinnat.get(3));
			}
		});
		
		JButton SaveButton = new JButton("Tallenna");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			ArrayList<String> hinnat = new ArrayList<>();
				
			hinnat.add(Manager95.getText());
			hinnat.add(Manager98.getText());
			hinnat.add(ManagerDiesel.getText());
			hinnat.add(MainosLause.getText());
		
				
			try {
				printArrayListToFile(hinnat, "src/img/hinnat");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

				
			}
		});
		SaveButton.setBounds(294, 241, 117, 29);
		contentPane.add(SaveButton);
		
	
		FetchPrice.setBounds(166, 241, 117, 29);
		contentPane.add(FetchPrice);
		
		JButton OpenMainos = new JButton("Avaa infotaulu");
		OpenMainos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainostolppa.setVisible(true);
			
				
			}
		});
		OpenMainos.setBounds(39, 241, 117, 29);
		contentPane.add(OpenMainos);
		
		btnTankit = new JButton("Tankkien hallinta");
		btnTankit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bensatankit.setVisible(true);
			}
		});
		btnTankit.setBounds(270, 11, 169, 26);
		contentPane.add(btnTankit);
	}
	
	public static void printArrayListToFile(ArrayList<String> arrayList, String filename) throws IOException {
	    PrintWriter writer = new PrintWriter(filename);
	    for (String line : arrayList) {
	        writer.println(line);
	    }
	    writer.close();
	}
}
