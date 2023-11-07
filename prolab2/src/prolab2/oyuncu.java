package prolab2;

import java.util.ArrayList;

abstract class oyuncu {
	private String oyuncuAdi;
	private int oyuncuID;
	private double skor;
	private ArrayList<nesne> nesneler;
	private ArrayList<String>nesneAdlari;
	
	public oyuncu(String ad,int id,ArrayList<nesne> nesneler,ArrayList<String> nesneAdlari)
	{
		this.oyuncuAdi=ad;
		this.oyuncuID=id;
		this.skor=0;
		this.nesneler=nesneler;
		this.nesneAdlari=nesneAdlari;
		
	}

	
	public String getOyuncuAdi() {
		return oyuncuAdi;
	}
	public void setOyuncuAdi(String oyuncuAdi) {
		this.oyuncuAdi = oyuncuAdi;
	}
	public int getOyuncuID() {
		return oyuncuID;
	}
	public void setOyuncuID(int oyuncuID) {
		this.oyuncuID = oyuncuID;
	}
	public double getSkor() {
		return skor;
	}
	public void setSkor(double skor) {
		this.skor = skor;
	}
	abstract public void SkorGoster();
	abstract public int nesneSec();
	public void nesneYazdir()
	{
		System.out.println("nesneler = "+getNesneAdlari());
	}
	
	
	public ArrayList<nesne> getNesneler() {
		return nesneler;
	}
	public void setNesneler(ArrayList<nesne> nesneler) {
		this.nesneler = nesneler;
	}


	public ArrayList<String> getNesneAdlari() {
		return nesneAdlari;
	}


	public void setNesneAdlari(ArrayList<String> nesneAdlari) {
		this.nesneAdlari = nesneAdlari;
	}
	

}
