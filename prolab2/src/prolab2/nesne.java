package prolab2;

import java.util.ArrayList;

abstract class nesne {
	
	private double dayaniklilik;
	private int seviye_puani;
	
	public nesne() {
		
		this.dayaniklilik=20;
		this.seviye_puani=0;
	}
	
	public double getDayaniklilik() {
		return dayaniklilik;
	}
	public void setDayaniklilik(double dayaniklilik) {
		this.dayaniklilik = dayaniklilik;
	}
	public int getSeviye_puani() {
		return seviye_puani;
	}
	public void setSeviye_puani(int seviye_puani) {
		this.seviye_puani = seviye_puani;
	}
	public void nesnePuaniGoster()
	{
		System.out.println("  Dayaniklilik="+this.dayaniklilik+"  Seviye Puani="+this.seviye_puani);
	}
	abstract public void durumGuncelle(double etki);

	public abstract double etki_hesapla(ArrayList<String> nesneler, int s2);

	public abstract void durumGuncelle();
	
}
