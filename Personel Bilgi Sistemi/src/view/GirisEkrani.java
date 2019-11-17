package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import model.VeriTabani;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
//Okan Karadað Tarafýndan Yapýlmýþtýr.
public class GirisEkrani extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSifre;
	private JTextField textFieldKimlikNo;
	static boolean girisDurumu=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani frame = new GirisEkrani();
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
	public GirisEkrani() {
		UIManager.put("ToolTip.background", new ColorUIResource(255, 247, 200)); 
		Image girisEkrani=new ImageIcon(this.getClass().getResource("/girisEkrani.jpg")).getImage().getScaledInstance(720, 520, Image.SCALE_DEFAULT);
		Image bilgiButon=new ImageIcon(this.getClass().getResource("/bilgiButon2.png")).getImage();

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textFieldSifre = new JTextField();
		textFieldSifre.setBounds(301, 198, 118, 20);
		contentPane.add(textFieldSifre);
		textFieldSifre.setColumns(10);
		contentPane.add(textFieldSifre);
		
		textFieldKimlikNo = new JTextField();
		textFieldKimlikNo.setBounds(301, 138, 118, 20);
		contentPane.add(textFieldKimlikNo);
		textFieldKimlikNo.setColumns(10);
		contentPane.add(textFieldKimlikNo);
		
		
		
		
		JLabel labelTcKimlikNo = new JLabel("TC Kimlik No");
		labelTcKimlikNo.setForeground(Color.WHITE);
		labelTcKimlikNo.setBounds(222, 141, 80, 14);
		contentPane.add(labelTcKimlikNo);
		
		JLabel labelSifre = new JLabel("\u015Eifre");
		labelSifre.setForeground(Color.WHITE);
		labelSifre.setBounds(256, 201, 46, 14);
		contentPane.add(labelSifre);
		
		
		JButton btnGiriYap = new JButton("Giri\u015F Yap");
		btnGiriYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VeriTabani.vtBaglan();
				
				if(VeriTabani.girisDogrula(textFieldKimlikNo.getText(),textFieldSifre.getText()))
				{
					if(VeriTabani.yoneticiMi(textFieldKimlikNo.getText())) {
						YoneticiAnaEkran yoneticiAnaEkran=new YoneticiAnaEkran();
						yoneticiAnaEkran.setVisible(true);
						girisDurumu=true;
						setVisible(false);
					}else
					{
						CalisanAnaEkran calisanAnaEkran=new CalisanAnaEkran();
						calisanAnaEkran.setVisible(true);
						girisDurumu=true;
						
						
						ResultSet resultSet=VeriTabani.vtKisiAra(textFieldKimlikNo.getText());
						
						try {
							while(resultSet.next())
							{
								CalisanAnaEkran.textFieldKimlikNo.setText(resultSet.getString("kimlikNo"));
								CalisanAnaEkran.textFieldAd.setText(resultSet.getString("ad"));
								CalisanAnaEkran.textFieldSoyad.setText(resultSet.getString("soyad"));
								CalisanAnaEkran.textFieldDogumYeri.setText(resultSet.getString("dogumYeri"));
								CalisanAnaEkran.textFieldTelefon.setText(resultSet.getString("telefonNo"));
								CalisanAnaEkran.textFieldDogumTarihi.setText(resultSet.getString("dogumTarihi"));
								CalisanAnaEkran.textFieldDepartman.setText(resultSet.getString("departman"));
								CalisanAnaEkran.textFieldCalistigiPozisyon.setText(resultSet.getString("pozisyon"));
								CalisanAnaEkran.textFieldHastaliklar.setText(resultSet.getString("hastaliklari"));
								CalisanAnaEkran.textFieldEnSonCalistigi.setText(resultSet.getString("sonFirmaAdi"));
								
								CalisanAnaEkran.textFieldSifre.setText(resultSet.getString("sifre"));
								if(resultSet.getString("cinsiyet").equals("erkek"))
								CalisanAnaEkran.comboBoxCinsiyet.setSelectedIndex(0);
								else
									CalisanAnaEkran.comboBoxCinsiyet.setSelectedIndex(1);
								
								calisanAnaEkran.editorPaneAdres.setText(resultSet.getString("adres"));
								
								if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("ilkokul"))
									{
									CalisanAnaEkran.comboBoxOgrenimDurumu.setSelectedIndex(0);
									}
								else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("ortaokul"))
									{
									CalisanAnaEkran.comboBoxOgrenimDurumu.setSelectedIndex(1);
									}
								else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("lise"))
									{
									CalisanAnaEkran.comboBoxOgrenimDurumu.setSelectedIndex(2);
									}
								else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("Önlisans"))
									{
									CalisanAnaEkran.comboBoxOgrenimDurumu.setSelectedIndex(3);
									}
								else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("lisans"))
									{
									CalisanAnaEkran.comboBoxOgrenimDurumu.setSelectedIndex(4);
									}
								else if(resultSet.getString("ogrenimDurumu").equalsIgnoreCase("Yuksek lisans"))
								{
								CalisanAnaEkran.comboBoxOgrenimDurumu.setSelectedIndex(5);
								}
									
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						setVisible(false);
					}
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Yanlýþ þifre veya Kimlik Numarasý");
				}
				
			}
		});
		btnGiriYap.setBounds(252, 252, 89, 23);
		contentPane.add(btnGiriYap);
		
		JButton btnKaytOl = new JButton("Kay\u0131t Ol");
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(girisDurumu==true)
				{
					CalisanAnaEkran calisanAnaEkran=new CalisanAnaEkran();
					calisanAnaEkran.setVisible(true);
					setVisible(false);
				}
				else
				{
					CalisanAnaEkran calisanAnaEkran=new CalisanAnaEkran();
					calisanAnaEkran.setVisible(true);
					calisanAnaEkran.btnNewButton.setVisible(false);
					calisanAnaEkran.btnKaydet.setBounds(484, 373, 115, 29);
					setVisible(false);
				}
				
			}
		});
		btnKaytOl.setBounds(371, 252, 89, 23);
		contentPane.add(btnKaytOl);
		
		JLabel buttonInfo = new JLabel("");
		buttonInfo.setIcon(new ImageIcon(bilgiButon));
		buttonInfo.setToolTipText("Okan Karadag Tarafýndan Yapýlmýþtýr.");
		//buttonInfo.setSize(new Dimension(35,30));
		buttonInfo.setBounds(615, 28, 35, 30);
		contentPane.add(buttonInfo);
		
	
		JLabel labelGirisArkaPlan = new JLabel("");
		labelGirisArkaPlan.setIcon(new ImageIcon(girisEkrani));
		labelGirisArkaPlan.setBounds(5, 5, 700, 500);
		contentPane.add(labelGirisArkaPlan);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		
		
	}
}
