package penggajian;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;

public class MenuEntry extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEntry frame = new MenuEntry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuEntry() {
		setTitle("Menu Entry");
		setBounds(500, 200, 434, 212);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmExit);
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		JMenuItem mntmEntryData = new JMenuItem("Entry Data");
		mnTools.add(mntmEntryData);
		JMenuItem mntmViewData = new JMenuItem("View Data");
		mntmViewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuView mv = new MenuView();
				mv.setVisible(true);
			}
		});
		mnTools.add(mntmViewData);
		JMenu mnOther = new JMenu("Other");
		menuBar.add(mnOther);
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Project UAS OOP \n" + "Yoga Purna Irawan \n" + "16111129");
			}
		});
		mnOther.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnEntryPegawai = new JButton("Entry Pegawai");
		btnEntryPegawai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryPegawai ep = new EntryPegawai();
				ep.setVisible(true);
			}
		});
		btnEntryPegawai.setBounds(34, 40, 160, 23);
		contentPane.add(btnEntryPegawai);
		JButton btnEntryGaji = new JButton("Entry Gaji");
		btnEntryGaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryGaji eg = new EntryGaji();
				eg.setVisible(true);
			}
		});
		btnEntryGaji.setBounds(233, 40, 160, 23);
		contentPane.add(btnEntryGaji);
		JButton btnEntryWilayahKerja = new JButton("Entry Wilayah");
		btnEntryWilayahKerja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryWilayah ew = new EntryWilayah();
				ew.setVisible(true);
			}
		});
		btnEntryWilayahKerja.setBounds(34, 91, 160, 23);
		contentPane.add(btnEntryWilayahKerja);
		JButton btnEntryJabatan = new JButton("Entry Jabatan");
		btnEntryJabatan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryJabatan ej = new EntryJabatan();
				ej.setVisible(true);
			}
		});
		btnEntryJabatan.setBounds(233, 91, 160, 23);
		contentPane.add(btnEntryJabatan);
	}
}
