package penggajian;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Menu() {
		setBackground(new Color(0, 102, 0));
		setForeground(Color.WHITE);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 425, 213);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
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
				mntmEntryData.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MenuEntry me = new MenuEntry();
						me.setVisible(true);
						}
					});
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
						JOptionPane.showMessageDialog(null, "Project UAS OOP \n"
					+ "Yoga Purna Irawan \n"
								+ "16111129"
					);
						}
					});
				mnOther.add(mntmAbout);
				
				contentPane = new JPanel();
				contentPane.setForeground(Color.WHITE);
				contentPane.setBackground(Color.WHITE);
				contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JTextArea txtrselamatdatang = new JTextArea();
				txtrselamatdatang.setBackground(new Color(204, 255, 204));
				txtrselamatdatang.setForeground(Color.BLACK);
				txtrselamatdatang.setFont(new Font("Console",Font.BOLD, 16));
				txtrselamatdatang.setEditable(false);
				txtrselamatdatang.setLineWrap(true);
				txtrselamatdatang.setText("               ====PROJECT UAS OOP==== \r\n\n ''JAVA DEKSTOP PROGRAM PENGGAJIAN''");
				txtrselamatdatang.setBounds(10, 11, 389, 131);
				contentPane.add(txtrselamatdatang);
				}
	}