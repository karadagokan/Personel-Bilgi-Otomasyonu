package model;

import java.io.ObjectInputStream.GetField;
import java.sql.*;

import com.mysql.jdbc.Connection;

public class VeriTabani {

	static Connection connection = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null;

	/*
	 * public static void main(String[] args) {
	 * 
	 * vtBaglan();
	 * 
	 * KisiBilgileri kisiBilgileri2 = new KisiBilgileri("323288", "okan", "karadag",
	 * "erkek", "macunköy", "malatya", "09.05.1995", "452145241",
	 * "okan.kar@hotmail.com", "lise", "kütüphane", "kovuldum", "it", "stajyer",
	 * "ab", "yok", true, "1234"); vtKisiEkle(kisiBilgileri2); //
	 * vtPersonelListele(); // vtKisiGuncelle("323288", "adnan", "karabag", "erkek",
	 * "macunköy", "malatya", // "09.05.1995", "452145241", "okan.kar@hotmail.com",
	 * "lise", "kütüphane", // "kovuldum", "it", "stajyer", "ab", "yok", true,
	 * "1234"); // vtKisiSil("323288"); vtBaglantiKapat();
	 * 
	 * }
	 */

	public static void vtBaglan() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.err.println("Hatalý Driver : " + e);
			return;
		}

		try {

			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/personelvt?useSSL=false",
					"root", "1234");
		} catch (SQLException e) {

			System.err.println("Baglanti Hatasý : " + e);
		}

	}

	public static void vtBaglantiKapat() {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Baglantý Kapatma Hatasý : " + e);
			}

		if (preparedStatement != null)
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.err.println("Sorgu kapatma hatasý : " + e);
			}

	}

	public static void vtKisiEkle(KisiBilgileri kisiBilgileri) {
		String sorgu = "insert into personelvt.personel(kimlikNo,ad,soyad,cinsiyet,adres,dogumYeri,dogumTarihi,telefonNo,email,ogrenimDurumu,sonFirmaAdi,ayrilmaSebebi,departman,pozisyon,kanGrubu,hastaliklari,yoneticiMi,sifre) values('"
				+ kisiBilgileri.getKimlikNo() + "','" + kisiBilgileri.getAd() + "','" + kisiBilgileri.getSoyad() + "','"
				+ kisiBilgileri.getCinsiyet() + "','" + kisiBilgileri.getAdres() + "','" + kisiBilgileri.getDogumYeri()
				+ "','" + kisiBilgileri.getDogumTarihi() + "','" + kisiBilgileri.getTelefonNo() + "','"
				+ kisiBilgileri.getEmail() + "','" + kisiBilgileri.getOgrenimDurumu() + "','"
				+ kisiBilgileri.getSonFirmaAdi() + "','" + kisiBilgileri.getAyrilmaSebebi() + "','"
				+ kisiBilgileri.getDepartman() + "','" + kisiBilgileri.getPozisyon() + "','"
				+ kisiBilgileri.getKanGrubu() + "','" + kisiBilgileri.getHastaliklari() + "',"
				+ kisiBilgileri.isYoneticiMi() + ",'" + kisiBilgileri.getSifre() + "')";

		try {
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Kiþi eklerken sorgulama hatasý : " + e);
		}
	}

	public static void vtKisiSil(String kimlikNo) {
		String sorgu = "delete from personelvt.personel where kimlikNo=?";

		try {
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kimlikNo);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Kisi silinirken hata : " + e);
		}

	}

	public static void vtKisiGuncelle(String kimlikNo, String ad, String soyad, String cinsiyet, String adres,
			String dogumYeri, String dogumTarihi, String telefonNo, String email, String ogrenimDurumu,
			String sonFirmaAdi, String ayrilmaSebebi, String departman, String pozisyon, String kanGrubu,
			String hastaliklari, boolean yoneticiMi, String sifre) {
		String sorgu = "update personelvt.personel set ad=?,soyad=?,cinsiyet=?,adres=?,dogumYeri=?,dogumTarihi=?,telefonNo=?,email=?,ogrenimDurumu=?,sonFirmaAdi=?,ayrilmaSebebi=?,departman=?,pozisyon=?,kanGrubu=?,hastaliklari=?,yoneticiMi=?,sifre=? where kimlikNo=?";

		try {
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, ad);
			preparedStatement.setString(2, soyad);
			preparedStatement.setString(3, cinsiyet);
			preparedStatement.setString(4, adres);
			preparedStatement.setString(5, dogumYeri);
			preparedStatement.setString(6, dogumTarihi);
			preparedStatement.setString(7, telefonNo);
			preparedStatement.setString(8, email);
			preparedStatement.setString(9, ogrenimDurumu);
			preparedStatement.setString(10, sonFirmaAdi);
			preparedStatement.setString(11, ayrilmaSebebi);
			preparedStatement.setString(12, departman);
			preparedStatement.setString(13, pozisyon);
			preparedStatement.setString(14, kanGrubu);
			preparedStatement.setString(15, hastaliklari);
			preparedStatement.setBoolean(16, yoneticiMi);
			preparedStatement.setString(17, sifre);
			preparedStatement.setString(18, kimlikNo);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Kiþi güncellerken hata: " + e);
		}

	}

	public static ResultSet vtPersonelListele() {
		String sorgu = "select *from personelvt.personel";

		try {
			preparedStatement = connection.prepareStatement(sorgu);
			resultSet = preparedStatement.executeQuery();

		} catch (SQLException e) {
			System.out.println("Listelenirken Hata : " + e);
		}

		return  resultSet;

	}

	public static ResultSet vtKisiAra(String arama) {
		String sorgu = "select *from personelvt.personel where kimlikNo like '%"
				+ arama + "%' or ad like '%" + arama + "%' or soyad like '%" + arama + "%'";

		
		try {
			preparedStatement = connection.prepareStatement(sorgu);
			resultSet = preparedStatement.executeQuery();

			

		} catch (SQLException e) {
			System.out.println("Kisi aranirken hata : " + e);
		}

		return resultSet;
	}

	public static boolean girisDogrula(String kimlikNo, String sifre) {
		String sorgu = "select *from personelvt.personel where kimlikNo=?";

		try {
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kimlikNo);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getString("sifre").equalsIgnoreCase(sifre))

					return true;
			}

		} catch (SQLException e) {
			System.out.println("Hatalý giris dogrulama sorgusu : " + e);
		}

		return false;
	}
	
	public static boolean kayitOlusturmaOnay(String kimlikNo)
	{
		String sorgu="select *from personelvt.personel where kimlikNo=?";
		try {
			preparedStatement=connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kimlikNo);
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	public static boolean yoneticiMi(String kimlikNo) {

		KisiBilgileri kisiBilgileri = new KisiBilgileri();

		String sorgu = "select *from personelvt.personel where kimlikNo=?";

		try {
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kimlikNo);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getBoolean("yoneticiMi"))

					return true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
