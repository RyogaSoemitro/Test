package penggajian;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EntryWilayah extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_IDWilayah;
	private JTextField textField_Wilayah;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryWilayah frame = new EntryWilayah();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void clear() {
		textField_IDWilayah.setText("");
		textField_Wilayah.setText("");
	}
	public EntryWilayah() {
		setTitle("Entry Wilayah");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormEntryWilayah = new JLabel("Form Entry Wilayah");
		lblFormEntryWilayah.setFont(new Font("Calibri", Font.BOLD, 12));
		lblFormEntryWilayah.setBounds(133, 33, 162, 14);
		contentPane.add(lblFormEntryWilayah);
		
		
		textField_IDWilayah = new JTextField();textField_IDWilayah.setFont(new Font("Calibri", Font.BOLD, 11));
		textField_IDWilayah.setColumns(10);
		textField_IDWilayah.setBounds(176, 80, 65, 20);
		contentPane.add(textField_IDWilayah);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Calibri", Font.BOLD, 11));
		label_1.setBounds(150, 83, 16, 14);
		contentPane.add(label_1);
		
		JLabel lblIdWilayah = new JLabel("ID Wilayah");
		lblIdWilayah.setFont(new Font("Calibri", Font.BOLD, 11));
		lblIdWilayah.setBounds(37, 83, 103, 14);
		contentPane.add(lblIdWilayah);
		
		JLabel lblWilayah = new JLabel("Wilayah");
		lblWilayah.setFont(new Font("Calibri", Font.BOLD, 11));
		lblWilayah.setBounds(37, 134, 84, 14);
		contentPane.add(lblWilayah);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Calibri", Font.BOLD, 11));
		label_4.setBounds(150, 134, 16, 14);
		contentPane.add(label_4);
		
		textField_Wilayah = new JTextField();
		textField_Wilayah.setFont(new Font("Calibri", Font.BOLD, 11));
		textField_Wilayah.setColumns(10);
		textField_Wilayah.setBounds(176, 131, 119, 20);
		contentPane.add(textField_Wilayah);
		
		JButton button_1 = new JButton("Simpan");
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Connect k = new Connect();
				Connection mysql = k.getConnection();
				try {
					Statement stat = mysql.createStatement();
					String sql = "INSERT INTO wilayah VALUES('"
					+ textField_IDWilayah.getText()+"','"
							+
					textField_Wilayah.getText()+"');";
					int i = stat.executeUpdate(sql);
					if (i==1) {
						JOptionPane.showMessageDialog(null, "Entry Data Berhasil");
						}
					clear();
					}
				catch (Exception ex) {
					JOptionPane.showInputDialog(null,
							ex.getMessage());
					}
				}
			});
		button_1.setFont(new Font("Calibri", Font.BOLD, 11));
		button_1.setBounds(61, 192, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Clear Form");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clear();
				}
			});
		button_2.setFont(new Font("Calibri", Font.BOLD, 11));
		button_2.setBounds(314, 130, 110, 23);
		contentPane.add(button_2);JButton button_3 = new JButton("Update");
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect k = new Connect();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "UPDATE wilayah SET wilayah='"
							+ textField_Wilayah.getText()
							+ "'WHERE id_wilayah='"
							+ textField_IDWilayah.getText()+"';";
					int i = state.executeUpdate(sql);

					if (i==1) {
						JOptionPane.showMessageDialog(null, "Data"
								+ "Berhasil di Update");
						}
					clear();
					}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							ex.getMessage());
					}
				}
			});
		button_3.setFont(new Font("Calibri", Font.BOLD, 11));
		button_3.setBounds(282, 192, 89, 23);
		contentPane.add(button_3);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect k = new Connect();
				Connection mysql = k.getConnection();
				try {
				Statement state = mysql.createStatement();
				String sql = "DELETE FROM wilayah"
						+" WHERE id_wilayah ='"
						+textField_IDWilayah.getText()+"'";
				int i = state.executeUpdate (sql);
				if (i==1) {
					JOptionPane.showMessageDialog(null, "Data Deleted");
					}
			}
			catch (Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		}
});
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 11));
		btnDelete.setBounds(172, 191, 89, 23);
		contentPane.add(btnDelete);
		
		JButton Cari = new JButton("Cari");
		Cari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Cari;
				Connect k = new Connect();
				Connection mysql = k.getConnection();
				try {
					Cari=textField_IDWilayah.getText();
					Statement state = mysql.createStatement();
					String sql = "SELECT * FROM wilayah "
					+ "WHERE id_wilayah LIKE '"+Cari+"'";
					ResultSet res = state.executeQuery(sql);
					if (res.next()) {
						textField_IDWilayah.setText(res.getString(1));
						textField_Wilayah.setText(res.getString(2));
						} else {
							JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
							}
					}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							ex.getMessage());
					}
				}
			});
		Cari.setFont(new Font("Calibri", Font.BOLD, 11));
		Cari.setBounds(342, 79, 65, 23);
		contentPane.add(Cari);
		}
	}