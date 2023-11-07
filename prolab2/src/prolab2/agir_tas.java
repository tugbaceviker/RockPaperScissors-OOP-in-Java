package prolab2;

import java.util.ArrayList;

class agir_tas extends tas {
	private int sicaklik;
	
	public agir_tas() {
		
		this.sicaklik=2;
	}

	public int getSicaklik() {
		return sicaklik;
	}

	public void setSicaklik(int sicaklik) {
		this.sicaklik = sicaklik;
	}
	@Override
	public double etki_hesapla(ArrayList<String> Nesneler, int i) {
		double etki=0;
		double a;
		a=0.2;
		if(Nesneler.get(i)=="makas")
		{
			etki=(getKatilik()*this.sicaklik)/(a*2);
		}
		if(Nesneler.get(i)=="kagit")
		{
			etki=(getKatilik()*this.sicaklik)/((1-a)*2);
		}
		if(Nesneler.get(i)=="usta_makas")
		{
			etki=(getKatilik()*this.sicaklik)/(a*2*2);
		}
		if(Nesneler.get(i)=="ozel_kagit")
		{
			etki=(getKatilik()*this.sicaklik)/((1-a)*2*2);
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
