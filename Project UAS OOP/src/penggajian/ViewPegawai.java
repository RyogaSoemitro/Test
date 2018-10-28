package penggajian;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;

public class ViewPegawai extends JFrame {
	private static final long serialVersionUID = 1L;
	public Object[][] isiTable = null;
	private JPanel contentPane;
	private JTable tablePegawai;
	JScrollPane scrollTable = new JScrollPane();
String[] header = {"Nama","jabatan", "Nominal Gaji"};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPegawai frame = new ViewPegawai();
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
	public ViewPegawai() {
		setTitle("View Pegawai");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("Table View Pegawai");
		label.setFont(new Font("Calibri", Font.BOLD, 12));
		label.setBounds(288, 26, 130, 14);
		contentPane.add(label);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 65, 633, 214);
		contentPane.add(scrollPane);
		tablePegawai = new JTable();
		scrollPane.setViewportView(tablePegawai);
		Connect k = new Connect();
		Connection mysql = k.getConnection();
		try {
			Statement state = mysql.createStatement();
			String sql = "select a.nama,b.jabatan,c.nominal from pegawai a join jabatan b on a.id_gaji=b.id_gaji join gaji c on b.id_gaji=c.id_gaji";
			ResultSet res = state.executeQuery(sql);
			ResultSetMetaData meta = res.getMetaData();
			int kolom = meta.getColumnCount();
			int baris = 0;
			while (res.next()) {
				baris = res.getRow();
			}
			isiTable = new Object[baris][kolom];
			int x = 0;
			res.beforeFirst();
			while (res.next()) {
				isiTable[x][0] = res.getString("nama");
				isiTable[x][1] = res.getString("jabatan");
				isiTable[x][2] = res.getString("nominal");
//				isiTable[x][3] = res.getString("Nomor_telpon");
//				isiTable[x][4] = res.getString("id_Jabatan");
//				isiTable[x][5] = res.getString("id_wilayah");
				x++;
			}
			tablePegawai.setModel(new DefaultTableModel(isiTable, header));
			getContentPane().add(scrollTable, BorderLayout.NORTH);
			state.close();
			res.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
