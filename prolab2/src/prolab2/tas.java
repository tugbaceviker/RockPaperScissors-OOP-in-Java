package prolab2;

import java.util.ArrayList;

class tas extends nesne {
	
	private int katilik;
	
	public tas() {
		this.katilik=2;
		
	}
	
	@Override
	public double etki_hesapla(ArrayList<String> Nesneler,int i) {
		double etki=0;
		double a;
		a=0.2;
		if(Nesneler.get(i)=="makas")
		{
			etki=(this.katilik)/(a*2);
		}
		if(Nesneler.get(i)=="kagit")
		{
			etki=(this.katilik)/((1-a)*2);
		}
		if(Nesneler.get(i)=="usta_makas")
		{
			etki=(this.katilik)/(a*2*2);
		}
		if(Nesneler.get(i)=="ozel_kagit")
		{
			etki=(this.katilik)/((1-a)*2*2);
		}
		
		
	
	return etki;
	}
	


	@Override 
	public void durumGuncelle(double etki) {
		
		double son=getDayaniklilik()-etki;
		setDayaniklilik(son);
		
		
	}

	public int getKatilik() {
		return katilik;
	}

	public void setKatilik(int katilik) {
		this.katilik = katilik;
	}

	@Override
	public void durumGuncelle() {
		int son=getSeviye_puani()+20;
		setSeviye_puani(son);
		
	}
	

}
