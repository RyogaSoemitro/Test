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

public class EntryPegawai extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_IDPegawai;
	private JTextField textField_Nama;
	private JTextField textField_Alamat;
	private JTextField textField_Nomor_telpon;
	private JTextField textField_IDJabatan;
	private JTextField textField_Wilayah;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryPegawai frame = new EntryPegawai();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void clear() {
		textField_Alamat.setText("");
		textField_IDJabatan.setText("");
		textField_IDPegawai.setText("");
		textField_Nama.setText("");
		textField_Nomor_telpon.setText("");
		textField_Wilayah.setText("");
	}

	public EntryPegawai() {
		setTitle("Entry Pegawai");
		setBounds(500, 200, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormEntryPegawai = new JLabel("Form Entry Pegawai");
		lblFormEntryPegawai.setFont(new Font("Calibri", Font.BOLD, 12));
		lblFormEntryPegawai.setBounds(167, 36, 133, 14);
		contentPane.add(lblFormEntryPegawai);
		
		textField_IDPegawai = new JTextField();
		textField_IDPegawai.setFont(new Font("Calibri", Font.BOLD, 11));
		textField_IDPegawai.setColumns(10);
		textField_IDPegawai.setBounds(164, 82, 65, 20);
		contentPane.add(textField_IDPegawai);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Calibri", Font.BOLD, 11));
		label_1.setBounds(138, 85, 16, 14);
		contentPane.add(label_1);
		
		JLabel lblIdPegawai = new JLabel("ID Pegawai");
		lblIdPegawai.setFont(new Font("Calibri", Font.BOLD, 11));
		lblIdPegawai.setBounds(45, 85, 65, 14);
		contentPane.add(lblIdPegawai);
		
		JLabel Nama = new JLabel("Nama");
		Nama.setFont(new Font("Calibri", Font.BOLD, 11));
		Nama.setBounds(45, 121, 46, 14);
		contentPane.add(Nama);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Calibri", Font.BOLD, 11));
		label_4.setBounds(138, 121, 16, 14);
		contentPane.add(label_4);
		
		textField_Nama = new JTextField();
		textField_Nama.setFont(new Font("Calibri", Font.BOLD, 11));
		textField_Nama.setColumns(10);
		textField_Nama.setBounds(164, 118, 133, 20);
		contentPane.add(textField_Nama);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setFont(new Font("Calibri", Font.BOLD, 11));
		lblAlamat.setBounds(45, 154, 46, 14);
		contentPane.add(lblAlamat);
		
		JLabel label_2 = new JLabel(":");
		label_2.setFont(new Font("Calibri", Font.BOLD, 11));
		label_2.setBounds(138, 154, 16, 14);
		contentPane.add(label_2);
		
		textField_Alamat = new JTextField();
		textField_Alamat.setFont(new Font("Calibri", Font.BOLD, 11));
		textField_Alamat.setColumns(10);
		textField_Alamat.setBounds(164, 150, 133, 20);
		contentPane.add(textField_Alamat);
		
		JLabel lblNoHp = new JLabel("Nomor telpon");
		lblNoHp.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNoHp.setBounds(45, 186, 46, 14);
		contentPane.add(lblNoHp);
		
		JLabel label_3 = new JLabel(":");
		label_3.setFont(new Font("Calibri", Font.BOLD, 11));
		label_3.setBounds(138, 186, 16, 14);
		contentPane.add(label_3);
		
		textField_Nomor_telpon = new JTextField();
		textField_Nomor_telpon.setFont(new Font("Calibri", Font.BOLD, 11));
		textField_Nomor_telpon.setColumns(10);
		textField_Nomor_telpon.setBounds(164, 183, 133, 20);
		contentPane.add(textField_Nomor_telpon);
		
		JLabel lblIdJabatan = new JLabel("ID Jabatan");
		lblIdJabatan.setFont(new Font("Calibri", Font.BOLD, 11));
		lblIdJabatan.setBounds(45, 219, 65, 14);
		contentPane.add(lblIdJabatan);
		
		JLabel label_5 = new JLabel(":");
		label_5.setFont(new Font("Calibri", Font.BOLD, 11));
		label_5.setBounds(138, 219, 16, 14);
		contentPane.add(label_5);
		
		textField_IDJabatan = new JTextField();
		textField_IDJabatan.setFont(new Font("Calibri", Font.BOLD, 11));
		textField_IDJabatan.setColumns(10);
		textField_IDJabatan.setBounds(164, 216, 65, 20);
		contentPane.add(textField_IDJabatan);
		
		JLabel lblIdWilayah = new JLabel("ID Wilayah");
		lblIdWilayah.setFont(new Font("Calibri", Font.BOLD, 11));
		lblIdWilayah.setBounds(45, 250, 82, 14);
		contentPane.add(lblIdWilayah);
		
		JLabel label_6 = new JLabel(":");
		label_6.setFont(new Font("Calibri", Font.BOLD, 11));
		label_6.setBounds(137, 250, 16, 14);
		contentPane.add(label_6);
		
		textField_Wilayah = new JTextField();
		textField_Wilayah.setFont(new Font("Calibri", Font.BOLD, 11));
		textField_Wilayah.setColumns(10);
		textField_Wilayah.setBounds(163, 247, 65, 20);
		contentPane.add(textField_Wilayah);
		
		JButton button_1 = new JButton("Simpan");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect k = new Connect();
				Connection mysql = k.getConnection();
				try {
					Statement stat = mysql.createStatement();
					String sql = "INSERT INTO pegawai VALUES ('"
					+textField_IDPegawai.getText()+"','"
					+ textField_Nama.getText()+"','"
					+ textField_Alamat.getText()+"','"
					+ textField_Nomor_telpon.getText()+"','"
					+textField_IDJabatan.getText()+"','"
					+ textField_Wilayah.getText()+"');";
					int i = stat.executeUpdate(sql);
					if (i==1) {
						JOptionPane.showMessageDialog(null, "EntryData Berhasil");
						}
					clear();
					}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							ex.getMessage());
					}
				}
			});
		
		button_1.setFont(new Font("Calibri", Font.BOLD, 11));
		button_1.setBounds(53, 316, 89, 23);
		contentPane.add(button_1);
		JButton button_2 = new JButton("Clear Form");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clear();
				}
			});
		
		button_2.setFont(new Font("Calibri", Font.BOLD, 11));
		button_2.setBounds(314, 260, 110, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Update");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect k = new Connect();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "UPDATE pegawai SET nama='"
					+ textField_Nama.getText()+"',"
							+ "alamat='"
					+ textField_Alamat.getText()+"',"
							+ "nomor_telpon='"
					+ textField_Nomor_telpon.getText()+"',"
							+ "id_Jabatan='"
					+ textField_IDJabatan.getText()+"',"
							+ "id_wilayah='"
					+ textField_Wilayah.getText()+"'"
							+ "WHERE id_pegawai='"
					+textField_IDPegawai.getText()+"';";
					int i = state.executeUpdate(sql);
					if (i==1) {
						JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
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
		button_3.setBounds(314, 316, 89, 23);
		contentPane.add(button_3);
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect k = new Connect();
				Connection mysql = k.getConnection();
				try {
				Statement state = mysql.createStatement();
				String sql = "DELETE FROM pegawai"
						+" WHERE id_pegawai ='"
						+textField_IDPegawai.getText()+"'";
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
		btnDelete.setBounds(187, 315, 89, 23);
		contentPane.add(btnDelete);
		
		JButton Cari = new JButton("Cari");
		Cari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Cari;
				Connect k = new Connect();
				Connection mysql = k.getConnection();
				try {
					Cari=textField_IDPegawai.getText();
					Statement state = mysql.createStatement();
					String sql = "SELECT * FROM pegawai WHERE id_pegawai LIKE '"+Cari+"'";
					ResultSet res = state.executeQuery(sql);
					if (res.next()) {
						textField_IDPegawai.setText(res.getString(1));
						textField_Nama.setText(res.getString(2));
						textField_Alamat.setText(res.getString(3));
						textField_Nomor_telpon.setText(res.getString(4));
						textField_IDJabatan.setText(res.getString(5));
						textField_Wilayah.setText(res.getString(6));
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
		Cari.setBounds(344, 215, 65, 23);
		contentPane.add(Cari);
		}
	}
