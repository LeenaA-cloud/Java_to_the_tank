import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class Bensamittari extends JDialog {
	private Tankkaus tankkaus = new Tankkaus();
	private final JPanel contentPanel = new JPanel();
	private JTextField Manager95;
	private JTextField Manager98;
	private JTextField ManagerDiesel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Bensamittari dialog = new Bensamittari();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Bensamittari() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Bensamittari.class.getResource("/Img/Gas.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Manager95 = new JTextField();
		Manager95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Manager95.setBounds(115, 86, 96, 27);
		contentPanel.add(Manager95);
		Manager95.setColumns(10);
		
		Manager98 = new JTextField();
		Manager98.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Manager98.setBounds(115, 135, 96, 27);
		contentPanel.add(Manager98);
		Manager98.setColumns(10);
		
		ManagerDiesel = new JTextField();
		ManagerDiesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ManagerDiesel.setBounds(115, 185, 96, 33);
		contentPanel.add(ManagerDiesel);
		ManagerDiesel.setColumns(10);
		
		JButton btnNewButton = new JButton("P\u00E4ivit\u00E4 hinnat");
		btnNewButton.addActionListener(new ActionListener() {
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
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(115, 30, 169, 33);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tankaa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tankkaus=new Tankkaus();
				tankkaus.setVisible(true);
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(272, 187, 115, 31);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("95");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 83, 51, 33);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("98");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(64, 135, 55, 33);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Diesel");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(47, 195, 77, 21);
		contentPanel.add(lblNewLabel_2);
	}
}
/// Leena Pasanen
