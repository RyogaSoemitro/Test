package penggajian;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EntryJabatan extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_IdJabatan;
	private JTextField textField_Jabatan;
	private JTextField textField_IDGaji;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryJabatan frame = new EntryJabatan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void clear() {
		textField_IdJabatan.setText("");
		textField_Jabatan.setText("");
		textField_IDGaji.setText("");
	}

public EntryJabatan() {
	setTitle("Entry Jabatan");
	setBounds(500, 200, 450, 300);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(204, 255, 204));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblFormEntryJabatan = new JLabel("Form Entry Jabatan");
	lblFormEntryJabatan.setFont(new Font("calibri", Font.BOLD, 12));
	lblFormEntryJabatan.setBounds(153, 11, 133, 14);
	contentPane.add(lblFormEntryJabatan);
	
	JLabel lblIdJabatan = new JLabel("ID Jabatan");
	lblIdJabatan.setFont(new Font("Calibri", Font.BOLD, 11));
	lblIdJabatan.setBounds(49, 60, 65, 14);
	contentPane.add(lblIdJabatan);
	
	JLabel lblJabatan = new JLabel("Jabatan");
	lblJabatan.setFont(new Font("Calibri", Font.BOLD, 11));
	lblJabatan.setBounds(49, 108, 46, 14);
	contentPane.add(lblJabatan);

	JLabel label = new JLabel(":");
	label.setFont(new Font("Calibri", Font.BOLD, 11));
	label.setBounds(124, 60, 16, 14);
	contentPane.add(label);
	
	JLabel label_1 = new JLabel(":");
	label_1.setFont(new Font("Calibri", Font.BOLD, 11));
	label_1.setBounds(124, 108, 16, 14);
	contentPane.add(label_1);
	
	textField_IdJabatan = new JTextField();
	textField_IdJabatan.setFont(new Font("TCalibri", Font.BOLD, 11));
	textField_IdJabatan.setBounds(150, 57, 65, 20);
	contentPane.add(textField_IdJabatan);
	textField_IdJabatan.setColumns(10);
	
	textField_Jabatan = new JTextField();
	textField_Jabatan.setFont(new Font("Calibri", Font.BOLD, 11));
	textField_Jabatan.setBounds(150, 105, 96, 20);
	contentPane.add(textField_Jabatan);
	textField_Jabatan.setColumns(10);
	
	
	JLabel lblIdGaji = new JLabel("ID Gaji");
	lblIdGaji.setFont(new Font("Calibri", Font.BOLD, 11));
	lblIdGaji.setBounds(49, 150, 65, 14);
	contentPane.add(lblIdGaji);
	
	JLabel label_3 = new JLabel(":");
	label_3.setFont(new Font("Calibri", Font.BOLD, 11));
	label_3.setBounds(124, 150, 16, 14);
	contentPane.add(label_3);
	
	textField_IDGaji = new JTextField();
	textField_IDGaji.setFont(new Font("Calibri", Font.BOLD, 11));
	textField_IDGaji.setColumns(10);
	textField_IDGaji.setBounds(150, 147, 65, 20);
	contentPane.add(textField_IDGaji);
	
	JButton btnSimpan = new JButton("Simpan");
	btnSimpan.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Connect k = new Connect();
			Connection mysql = k.getConnection();
			try {
				Statement stat = mysql.createStatement();
				String sql = "INSERT INTO jabatan VALUES ('"
				+textField_IdJabatan.getText()+"','"
						+ textField_Jabatan.getText()+"','"
				+ textField_IDGaji.getText()+"');";
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
	btnSimpan.setFont(new Font("Calibri", Font.BOLD, 11));
	btnSimpan.setBounds(64, 193, 89, 23);
	contentPane.add(btnSimpan);
	
	JButton btnClear = new JButton("Clear Form");
	btnClear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clear();
			}
		});
	btnClear.setFont(new Font("Calibri", Font.BOLD, 11));
	btnClear.setBounds(302, 146, 110, 23);
	contentPane.add(btnClear);
	
	
	JButton Cari = new JButton("Cari");
	Cari.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String Cari;
			Connect k = new Connect();
		Connection mysql = k.getConnection();
		try {
			Cari=textField_IdJabatan.getText();
			Statement state = mysql.createStatement();
			String sql = "SELECT * FROM jabatan WHERE id_jabatan like '"+Cari+"'";
//			+ " WHERE id_gaji Like '"+Cari+"'";
			ResultSet res = state.executeQuery(sql);
			if (res.next()) {
				textField_IdJabatan.setText(res.getString(1));
				textField_Jabatan.setText(res.getString(2));
				textField_IDGaji.setText(res.getString(3));
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
	Cari.setBounds(335, 56, 65, 23);
	contentPane.add(Cari);
	
	
	JButton btnDelete = new JButton("Delete");
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Connect k = new Connect();
			Connection mysql = k.getConnection();
			try {
			Statement state = mysql.createStatement();
			String sql = "DELETE FROM jabatan"
					+" WHERE id_jabatan ='"
					+textField_IdJabatan.getText()+"'";
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
	btnDelete.setBounds(178, 193, 89, 23);
	contentPane.add(btnDelete);
	
	JButton btnUpdate_1= new JButton("Update");
	btnUpdate_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Connect k = new Connect();
		Connection mysql = k.getConnection();
		try {Statement state = mysql.createStatement();
		String sql = "UPDATE jabatan SET Jabatan='"
		+ textField_Jabatan.getText()+"',id_gaji='"
				+ textField_IDGaji.getText()+"'WHERE id_jabatan='"
		+textField_IdJabatan.getText()+"';";
		int i = state.executeUpdate(sql);
		if (i==1) {
			JOptionPane.showMessageDialog(null, "DataBerhasil di Update");
			}
		clear();
		}
		catch (Exception ex) {JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		}
		});
	btnUpdate_1.setFont(new Font("Calibri", Font.BOLD, 11));
	btnUpdate_1.setBounds(293, 192, 89, 23);
	contentPane.add(btnUpdate_1);
	}
}
