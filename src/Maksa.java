import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Maksa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton nappi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Maksa dialog = new Maksa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Maksa() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Maksa.class.getResource("/Img/Gas.png")));
		setTitle("Maksa");
		setBounds(100, 100, 420, 381);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		{
			textField = new JTextField();
			textField.setBackground(Color.LIGHT_GRAY);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textField.setBounds(52, 48, 126, 23);
			contentPanel.add(textField);
			textField.setColumns(10);
			
			nappi = new JButton("7");
			nappi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textField.setText(textField.getText() + "*");
				}
			});
			nappi.setFont(new Font("Tahoma", Font.PLAIN, 20));
			nappi.setBounds(52, 95, 51, 43);
			contentPanel.add(nappi);
		}
		}
		{
			JButton nappi_8 = new JButton("8");
			nappi_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(textField.getText() + "*");
				}
			});
			nappi_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
			nappi_8.setBounds(112, 95, 51, 43);
			contentPanel.add(nappi_8);
		}
		{
			JButton nappi_9 = new JButton("9");
			nappi_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(textField.getText() + "*");
				}
			});
			nappi_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
			nappi_9.setBounds(175, 95, 51, 43);
			contentPanel.add(nappi_9);
		}
		{
			JButton btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(textField.getText() + "*");
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(52, 151, 51, 43);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton = new JButton("1");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(textField.getText() + "*");
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(52, 207, 51, 43);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton = new JButton("5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(textField.getText() + "*");
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(112, 151, 51, 43);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton = new JButton("6");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(textField.getText() + "*");
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(175, 151, 51, 43);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton = new JButton("2");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(textField.getText() + "*");
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(112, 207, 51, 43);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton = new JButton("3");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(textField.getText() + "*");
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton.setBounds(175, 207, 51, 43);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("0");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(textField.getText() + "*");
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_1.setBounds(52, 266, 111, 40);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnC = new JButton("C");
			btnC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText("");
						
				}
			});
			btnC.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnC.setBounds(175, 263, 51, 43);
			contentPanel.add(btnC);
		}
		{
			JButton nappi_peruuta = new JButton("Peruuta");
			nappi_peruuta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
						int result = JOptionPane.showConfirmDialog(null,"Suljetaanko?", "Warning!", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
						//printToFile("Program is closed");
						System.exit(0);
								}
				}
				
			});
			nappi_peruuta.setFont(new Font("Tahoma", Font.PLAIN, 18));
			nappi_peruuta.setBounds(238, 97, 111, 97);
			contentPanel.add(nappi_peruuta);
		}
		{
			JButton nappi_OK = new JButton("OK");
			nappi_OK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
							
				try {
						//String tmp_saldo;
						//tmp_saldo = "" + (Integer.parseInt(label_saldo.getText())	+ Integer.parseInt(textField_talletusmaara.getText()));
						
						int result = JOptionPane.showConfirmDialog(null, "Tulostetaanko kuitti?","Kuitti",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if( result == JOptionPane.OK_OPTION ) {
						//label_setText();
						//textField.setText("T�ss� kuitti. Ole Hyv� ja Kiitos k�ynnist�");
					//	}
						//if( result == JOptionPane.NO_OPTION ) {
						//textField_talletusmaara.setText("");
						}
						
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Kiitos k�ynnist�");
						//textField_talletusmaara.setText("Kiitos k�ynnist�");
					}
					

				}

							});
			nappi_OK.setFont(new Font("Tahoma", Font.PLAIN, 18));
			nappi_OK.setBounds(238, 207, 111, 99);
			contentPanel.add(nappi_OK);
		}
}
// Leena Pasanen