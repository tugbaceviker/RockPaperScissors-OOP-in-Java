package prolab2;

import java.util.ArrayList;

class ozel_kagit extends kagit {

	private int kalinlik;
	
	public ozel_kagit() {
		
		this.kalinlik=2;
	}

	public int getKalinlik() {
		return kalinlik;
	}

	public void setKalinlik(int kalinlik) {
		this.kalinlik = kalinlik;
	}
	@Override
	public double etki_hesapla(ArrayList<String> Nesneler, int i) {
		double etki=0;
		double a;
		a=0.2;
		if(Nesneler.get(i)=="makas")
		{
			etki=(getNufuz()*this.kalinlik)/((1-a)*2);
		}
		if(Nesneler.get(i)=="tas")
		{
			etki=(getNufuz()*this.kalinlik)/((a)*2);
		}
		if(Nesneler.get(i)=="usta_makas")
		{
			etki=(getNufuz()*this.kalinlik)/((1-a)*2*2);
		}
		if(Nesneler.get(i)=="agir_tas")
		{
			etki=(getNufuz()*this.kalinlik)/((a)*2*2);
		}
		
		
	
	return etki;
	
	}
@Override
public void durumGuncelle(double etki) {
	// TODO Auto-generated method stub
	super.durumGuncelle(etki);
}
@Override
public void durumGuncelle() {
	// TODO Auto-generated method stub
	super.durumGuncelle();
}
}
