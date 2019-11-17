package model;

public class KisiBilgileri {
	
	private String kimlikNo;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String adres;
    private String dogumYeri;
    private String dogumTarihi;
    private String telefonNo;
    private String email=null;
    private String ogrenimDurumu;
    private String sonFirmaAdi;
    private String ayrilmaSebebi=null;
    private String departman;
    private String pozisyon;
    private String kanGrubu=null;
    private String hastaliklari;
    private boolean yoneticiMi=false;
    
    public KisiBilgileri() {
		// TODO Auto-generated constructor stub
	}
    
    private String sifre;
	public KisiBilgileri(String kimlikNo, String ad, String soyad, String cinsiyet, String adres, String dogumYeri,
			String dogumTarihi, String telefonNo, String email, String ogrenimDurumu, String sonFirmaAdi,
			String ayrilmaSebebi, String departman, String pozisyon, String kanGrubu, String hastaliklari,
			boolean yoneticiMi, String sifre) {
		super();
		this.kimlikNo = kimlikNo;
		this.ad = ad;
		this.soyad = soyad;
		this.cinsiyet = cinsiyet;
		this.adres = adres;
		this.dogumYeri = dogumYeri;
		this.dogumTarihi = dogumTarihi;
		this.telefonNo = telefonNo;
		this.email = email;
		this.ogrenimDurumu = ogrenimDurumu;
		this.sonFirmaAdi = sonFirmaAdi;
		this.ayrilmaSebebi = ayrilmaSebebi;
		this.departman = departman;
		this.pozisyon = pozisyon;
		this.kanGrubu = kanGrubu;
		this.hastaliklari = hastaliklari;
		this.yoneticiMi = yoneticiMi;
		this.sifre = sifre;
	}
	public String getKimlikNo() {
		return kimlikNo;
	}
	public void setKimlikNo(String kimlikNo) {
		this.kimlikNo = kimlikNo;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getDogumYeri() {
		return dogumYeri;
	}
	public void setDogumYeri(String dogumYeri) {
		this.dogumYeri = dogumYeri;
	}
	public String getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(String dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	public String getTelefonNo() {
		return telefonNo;
	}
	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOgrenimDurumu() {
		return ogrenimDurumu;
	}
	public void setOgrenimDurumu(String ogrenimDurumu) {
		this.ogrenimDurumu = ogrenimDurumu;
	}
	public String getSonFirmaAdi() {
		return sonFirmaAdi;
	}
	public void setSonFirmaAdi(String sonFirmaAdi) {
		this.sonFirmaAdi = sonFirmaAdi;
	}
	public String getAyrilmaSebebi() {
		return ayrilmaSebebi;
	}
	public void setAyrilmaSebebi(String ayrilmaSebebi) {
		this.ayrilmaSebebi = ayrilmaSebebi;
	}
	public String getDepartman() {
		return departman;
	}
	public void setDepartman(String departman) {
		this.departman = departman;
	}
	public String getPozisyon() {
		return pozisyon;
	}
	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}
	public String getKanGrubu() {
		return kanGrubu;
	}
	public void setKanGrubu(String kanGrubu) {
		this.kanGrubu = kanGrubu;
	}
	public String getHastaliklari() {
		return hastaliklari;
	}
	public void setHastaliklari(String hastaliklari) {
		this.hastaliklari = hastaliklari;
	}
	public boolean isYoneticiMi() {
		return yoneticiMi;
	}
	public void setYoneticiMi(boolean yoneticiMi) {
		this.yoneticiMi = yoneticiMi;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	

    
    
    
}
