package prolab2;

import java.util.ArrayList;

class makas extends nesne {

	private int keskinlik;
	
	public makas() {
		
		this.keskinlik=2;
	}
	
	@Override
	public double etki_hesapla(ArrayList<String> Nesneler,int i) {
		double etki = 0;
		double a;
		a=0.2;
		if(Nesneler.get(i)=="tas")
		{
			etki=(this.keskinlik)/((1-a)*2);
		}
		if(Nesneler.get(i)=="kagit")
		{
			etki=(this.keskinlik)/((a)*2);
		}
		if(Nesneler.get(i)=="agir_tas")
		{
			etki=(this.keskinlik)/((1-a)*2*2);
		}
		if(Nesneler.get(i)=="ozel_kagit")
		{
			etki=(this.keskinlik)/((a)*2*2);
		}
		
		
	
	return etki;
	}

	

	@Override 
	public void durumGuncelle(double etki) {
		
		double son=getDayaniklilik()-etki;
		setDayaniklilik(son);
		
		
	}

	public int getKeskinlik() {
		return keskinlik;
	}

	public void setKeskinlik(int keskinlik) {
		this.keskinlik = keskinlik;
	}

	@Override
	public void durumGuncelle() {
		int son=getSeviye_puani()+20;
		setSeviye_puani(son);
		
		
	}

}
