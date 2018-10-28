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

public class ViewWilayah extends JFrame {
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	public Object[][] isiTable = null;
	private JTable tableWilayah;
	JScrollPane scrollTable = new JScrollPane();
	String[] header = { "ID Wilayah ", "Wilayah" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewWilayah frame = new ViewWilayah();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewWilayah() {
		setTitle("View Wilayah Kerja");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("Table View Gaji");
		label.setFont(new Font("Calibri", Font.BOLD, 12));
		label.setBounds(159, 23, 96, 14);
		contentPane.add(label);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 65, 363, 214);
		contentPane.add(scrollPane);
		tableWilayah = new JTable();
		scrollPane.setViewportView(tableWilayah);
		Connect k = new Connect();
		Connection mysql = k.getConnection();
		try {
			Statement state = mysql.createStatement();
			String sql = "Select * from wilayah";
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
				isiTable[x][0] = res.getString("id_wilayah");
				isiTable[x][1] = res.getString("wilayah");
				x++;
			}
			tableWilayah.setModel(new DefaultTableModel(isiTable, header));
			getContentPane().add(scrollTable, BorderLayout.NORTH);
			state.close();
			res.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}