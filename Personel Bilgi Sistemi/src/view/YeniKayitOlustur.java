package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.KisiBilgileri;
import model.VeriTabani;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YeniKayitOlustur extends JFrame {

	private JPanel contentPane;
	static JTextField textFieldKimlikNo;
	static JTextField textFieldAd;
	static JTextField textFieldSoyad;
	static final ButtonGroup buttonGroup = new ButtonGroup();
	static JTextField textFieldDogumYeri;
	static JTextField textFieldTelefon;
	static JTextField textFieldDogumTarihi;
	static JTextField textFieldDepartman;
	static JTextField textFieldCalistigiPozisyon;
	static JTextField textFieldHastaliklar;
	static JTextField textFieldEnSonCalistigi;
	static int sayac=0;
	static JTextField textFieldSifre;
	static JEditorPane editorPaneAdres;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YeniKayitOlustur frame = new YeniKayitOlustur();
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
	public YeniKayitOlustur() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 650, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTc = new JLabel("TC Kimlik no");
		labelTc.setBounds(71, 33, 86, 14);
		contentPane.add(labelTc);
		
		textFieldKimlikNo = new JTextField();
		textFieldKimlikNo.setBounds(144, 30, 86, 20);
		contentPane.add(textFieldKimlikNo);
		textFieldKimlikNo.setColumns(10);
		
		JLabel labelAd = new JLabel("Ad");
		labelAd.setBounds(116, 63, 41, 14);
		contentPane.add(labelAd);
		
		JLabel labelSoyad = new JLabel("Soyad");
		labelSoyad.setBounds(99, 93, 58, 14);
		contentPane.add(labelSoyad);
		
		JLabel labelCinsiyet = new JLabel("Cinsiyet");
		labelCinsiyet.setBounds(91, 123, 70, 14);
		contentPane.add(labelCinsiyet);
		
		JLabel labelAdres = new JLabel("Adres");
		labelAdres.setBounds(91, 295, 46, 14);
		contentPane.add(labelAdres);
		
		JLabel labelDoumYeri = new JLabel("Do\u011Fum Yeri");
		labelDoumYeri.setBounds(75, 153, 71, 14);
		contentPane.add(labelDoumYeri);
		
		JLabel labelrenimDurumu = new JLabel("\u00D6\u011Frenim Durumu");
		labelrenimDurumu.setBounds(44, 230, 102, 14);
		contentPane.add(labelrenimDurumu);
		
		JLabel labelTelefonNo = new JLabel("Telefon no");
		labelTelefonNo.setBounds(78, 183, 71, 14);
		contentPane.add(labelTelefonNo);
		
		JLabel labelEnSonalt = new JLabel("En son \u00E7al\u0131\u015Ft\u0131\u011F\u0131 firma");
		labelEnSonalt.setBounds(23, 260, 141, 14);
		contentPane.add(labelEnSonalt);
		
		textFieldAd = new JTextField();
		textFieldAd.setBounds(144, 60, 86, 20);
		contentPane.add(textFieldAd);
		textFieldAd.setColumns(10);
		
		textFieldSoyad = new JTextField();
		textFieldSoyad.setBounds(144, 90, 86, 20);
		contentPane.add(textFieldSoyad);
		textFieldSoyad.setColumns(10);
		
		JLabel labelDepartman = new JLabel("Departman\u0131");
		labelDepartman.setBounds(348, 153, 80, 14);
		contentPane.add(labelDepartman);
		
		JLabel labelaltPozisyon = new JLabel("\u00C7al\u0131\u015Ft\u0131\u011F\u0131 pozisyon");
		labelaltPozisyon.setBounds(322, 183, 116, 14);
		contentPane.add(labelaltPozisyon);
		
		JLabel labelHastalklar = new JLabel("Hastal\u0131klar\u0131");
		labelHastalklar.setBounds(352, 230, 74, 14);
		contentPane.add(labelHastalklar);
		
		JLabel labelDoumTarihi = new JLabel("Do\u011Fum tarihi");
		labelDoumTarihi.setBounds(343, 123, 86, 14);
		contentPane.add(labelDoumTarihi);
		
		JLabel labelYneticilikDurumu = new JLabel("Y\u00F6neticilik durumu");
		labelYneticilikDurumu.setBounds(391, 30, 116, 14);
		contentPane.add(labelYneticilikDurumu);
		
		JLabel labelifre = new JLabel("\u015Eifre");
		labelifre.setBounds(254, 340, 46, 14);
		contentPane.add(labelifre);
		
		JComboBox comboBoxCinsiyet = new JComboBox();
		comboBoxCinsiyet.setModel(new DefaultComboBoxModel(new String[] {"Erkek", "Kad\u0131n"}));
		comboBoxCinsiyet.setBounds(144, 120, 86, 20);
		contentPane.add(comboBoxCinsiyet);
		
		JRadioButton rdbtnEvet = new JRadioButton("Evet");
		buttonGroup.add(rdbtnEvet);
		rdbtnEvet.setBounds(376, 56, 70, 23);
		contentPane.add(rdbtnEvet);
		
		JRadioButton rdbtnHayr = new JRadioButton("Hay\u0131r");
		buttonGroup.add(rdbtnHayr);
		rdbtnHayr.setBounds(454, 56, 64, 23);
		contentPane.add(rdbtnHayr);
		
		textFieldDogumYeri = new JTextField();
		textFieldDogumYeri.setBounds(144, 150, 86, 20);
		contentPane.add(textFieldDogumYeri);
		textFieldDogumYeri.setColumns(10);
		
		textFieldTelefon = new JTextField();
		textFieldTelefon.setBounds(144, 180, 86, 20);
		contentPane.add(textFieldTelefon);
		textFieldTelefon.setColumns(10);
		
		textFieldDogumTarihi = new JTextField();
		textFieldDogumTarihi.setBounds(421, 120, 86, 20);
		contentPane.add(textFieldDogumTarihi);
		textFieldDogumTarihi.setColumns(10);
		
		textFieldDepartman = new JTextField();
		textFieldDepartman.setBounds(421, 150, 86, 20);
		contentPane.add(textFieldDepartman);
		textFieldDepartman.setColumns(10);
		
		textFieldCalistigiPozisyon = new JTextField();
		textFieldCalistigiPozisyon.setBounds(421, 180, 86, 20);
		contentPane.add(textFieldCalistigiPozisyon);
		textFieldCalistigiPozisyon.setColumns(10);
		
		JComboBox comboBoxOgrenimDurumu = new JComboBox();
		comboBoxOgrenimDurumu.setModel(new DefaultComboBoxModel(new String[] {"\u0130lkokul", "Ortaokul", "Lise", "\u00D6nlisans", "Lisan", "Y\u00FCksek Lisans"}));
		comboBoxOgrenimDurumu.setBounds(144, 227, 86, 20);
		contentPane.add(comboBoxOgrenimDurumu);
		
		textFieldHastaliklar = new JTextField();
		textFieldHastaliklar.setBounds(421, 227, 86, 20);
		contentPane.add(textFieldHastaliklar);
		textFieldHastaliklar.setColumns(10);
		
		textFieldEnSonCalistigi = new JTextField();
		textFieldEnSonCalistigi.setBounds(144, 257, 86, 20);
		contentPane.add(textFieldEnSonCalistigi);
		textFieldEnSonCalistigi.setColumns(10);
		
		
		editorPaneAdres = new JEditorPane();
		editorPaneAdres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(editorPaneAdres.getText().length()>128)
					editorPaneAdres.setText(editorPaneAdres.getText().substring(0, editorPaneAdres.getText().length()-1));
					
				}
				
				
			
		});
		editorPaneAdres.setBounds(144, 285, 455, 36);
		contentPane.add(editorPaneAdres);
		
		textFieldSifre = new JTextField();
		textFieldSifre.setColumns(10);
		textFieldSifre.setBounds(294, 337, 86, 20);
		contentPane.add(textFieldSifre);
		
		JButton btnAnaMenu = new JButton("\u00C7\u0131k");
		btnAnaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnAnaMenu.setBounds(71, 374, 115, 29);
		contentPane.add(btnAnaMenu);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VeriTabani.vtBaglan();
		    if(VeriTabani.kayitOlusturmaOnay(textFieldKimlikNo.getText()))
		    {
		    	JOptionPane.showMessageDialog(null, "Boyle bir kullanýcý oluþturulmuþ");
		    	
		    }else
		    {
		    	String cinsiyetYaz,ogrenimDurumu=null;
		    	if(comboBoxCinsiyet.getSelectedIndex()==0)
		    		cinsiyetYaz="Kadýn";
		    	else
		    		cinsiyetYaz="Erkek";
		    	
		    	if(comboBoxOgrenimDurumu.getSelectedIndex()==0)
		    		ogrenimDurumu="ilkokul";
		    	else if(comboBoxOgrenimDurumu.getSelectedIndex()==1)
		    		ogrenimDurumu="ortaokul";
		    	else if(comboBoxOgrenimDurumu.getSelectedIndex()==2)
		    		ogrenimDurumu="lise";
		    	else if(comboBoxOgrenimDurumu.getSelectedIndex()==3)
		    		ogrenimDurumu="önlisans";
		    	else if(comboBoxOgrenimDurumu.getSelectedIndex()==4)
		    		ogrenimDurumu="lisans";
		    	else if(comboBoxOgrenimDurumu.getSelectedIndex()==5)
		    		ogrenimDurumu="Yuksek Lisans";
		    	
		    	
		    	KisiBilgileri kisiBilgileri=new KisiBilgileri(textFieldKimlikNo.getText(), textFieldAd.getText(), textFieldSoyad.getText(), cinsiyetYaz, editorPaneAdres.getText(), textFieldDogumYeri.getText(), textFieldDogumTarihi.getText(), textFieldTelefon.getText(), null, ogrenimDurumu, textFieldEnSonCalistigi.getText(), null, textFieldDepartman.getText(), textFieldCalistigiPozisyon.getText(), null, textFieldHastaliklar.getText(), false, textFieldSifre.getText());
		    	VeriTabani.vtKisiEkle(kisiBilgileri);
		    }
		    
			}
		});
		btnKaydet.setBounds(473, 374, 115, 29);
		contentPane.add(btnKaydet);
		
		
	}
}
