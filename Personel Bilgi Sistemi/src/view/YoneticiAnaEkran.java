package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.VeriTabani;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class YoneticiAnaEkran extends JFrame {

	private JPanel contentPane;
	static private JTable table;
    static DefaultTableModel model=new DefaultTableModel();
    static Object[] kolonlar={"Kimlik Numarasý","Ad","Soyad","Departman","Pozisyon","Telefon"};
    static Object[] satirlar=new Object[6];
    
	
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiAnaEkran frame = new YoneticiAnaEkran();
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
	public YoneticiAnaEkran() {
		Image anaEkran=new ImageIcon(this.getClass().getResource("/anaEkran.png")).getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 664, 154);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		model.setColumnIdentifiers(kolonlar);
		table.setBounds(298, 343, 102, 64);
	
		
		
		JButton btnNewButton = new JButton("D\u00FCzenle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Duzenle duzenle=new Duzenle();
				
				VeriTabani.vtBaglan();
				ResultSet resultSet=VeriTabani.vtKisiAra(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
				
				try {
					
					while(resultSet.next())
					{
						duzenle.textFieldKimlikNo.setText(resultSet.getString("kimlikNo"));
						duzenle.textFieldAd.setText(resultSet.getString("ad"));
						duzenle.textFieldSoyad.setText(resultSet.getString("soyad"));
						duzenle.textFieldDogumYeri.setText(resultSet.getString("dogumYeri"));
						duzenle.textFieldTelefon.setText(resultSet.getString("telefonNo"));
						duzenle.textFieldDogumTarihi.setText(resultSet.getString("dogumTarihi"));
						duzenle.textFieldDepartman.setText(resultSet.getString("departman"));
						duzenle.textFieldCalistigiPozisyon.setText(resultSet.getString("pozisyon"));
						duzenle.textFieldHastaliklar.setText(resultSet.getString("hastaliklari"));
						duzenle.textFieldEnSonCalistigi.setText(resultSet.getString("sonFirmaAdi"));
						duzenle.editorPaneAdres.setText(resultSet.getString("adres"));
						duzenle.textFieldSifre.setText(resultSet.getString("sifre"));
						
						if(resultSet.getString("cinsiyet").equalsIgnoreCase("erkek"))
							duzenle.comboBoxCinsiyet.setSelectedIndex(0);
						else
							duzenle.comboBoxCinsiyet.setSelectedIndex(1);
						
						if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("ilkokul"))
							{
							duzenle.comboBoxOgrenimDurumu.setSelectedIndex(0);
							}
						else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("ortaokul"))
							{
							duzenle.comboBoxOgrenimDurumu.setSelectedIndex(1);
							}
						else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("lise"))
							{
							duzenle.comboBoxOgrenimDurumu.setSelectedIndex(2);
							}
						else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("Önlisans"))
							{
							duzenle.comboBoxOgrenimDurumu.setSelectedIndex(3);
							}
						else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("lisans"))
							{
							duzenle.comboBoxOgrenimDurumu.setSelectedIndex(4);
							}
						else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("Yuksek lisans"))
						{
							duzenle.comboBoxOgrenimDurumu.setSelectedIndex(5);
						}
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			    duzenle.setVisible(true);
				VeriTabani.vtBaglantiKapat();
				
				
			}
		});
		btnNewButton.setBounds(569, 287, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeriTabani.vtBaglan();
				ResultSet resultSet=VeriTabani.vtPersonelListele();
				guiListele(resultSet);
				VeriTabani.vtBaglantiKapat();
			}
		});
		btnListele.setBounds(456, 287, 89, 23);
		contentPane.add(btnListele);
		
		
		
		textField = new JTextField();
		textField.setBounds(20, 287, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnYeniKayt = new JButton("Yeni Kay\u0131t");
		btnYeniKayt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YeniKayitOlustur yeniKayitOlustur=new YeniKayitOlustur();
				yeniKayitOlustur.setVisible(true);
				
			}
		});
		btnYeniKayt.setBounds(456, 427, 89, 23);
		contentPane.add(btnYeniKayt);
		
		JButton btnNewButton_1 = new JButton("Sil");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VeriTabani.vtBaglan();
				VeriTabani.vtKisiSil(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
				ResultSet resultSet=VeriTabani.vtPersonelListele();
				guiListele(resultSet);
				VeriTabani.vtBaglantiKapat();
			}
		});
		btnNewButton_1.setBounds(569, 427, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnAra = new JButton("Ara");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VeriTabani.vtBaglan();
				String arama=textField.getText();
				guiListele(VeriTabani.vtKisiAra(arama));
				VeriTabani.vtBaglantiKapat();
				
				
				
			}
		});
		btnAra.setBounds(123, 287, 89, 23);
		contentPane.add(btnAra);
		
		JLabel labelGirisArkaPlan = new JLabel("");
		labelGirisArkaPlan.setIcon(new ImageIcon(anaEkran));
		labelGirisArkaPlan.setBounds(0, 0, 700, 500);
		contentPane.add(labelGirisArkaPlan);
		
		scrollPane.setViewportView(table);
		setLocationRelativeTo(null);
	}
	
	public static void guiListele(ResultSet resultSet)
	{
		try {
			model.setRowCount(0);
			
			while(resultSet.next())
			{
				satirlar[0]=resultSet.getString("kimlikNo");
				satirlar[1]=resultSet.getString("ad");
				satirlar[2]=resultSet.getString("soyad");
				satirlar[3]=resultSet.getString("departman");
				satirlar[4]=resultSet.getString("pozisyon");
				satirlar[5]=resultSet.getString("telefonNo");
				model.addRow(satirlar);
			}
			table.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
