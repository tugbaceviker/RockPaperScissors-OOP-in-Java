package prolab2;

import java.util.ArrayList;

class kagit extends nesne {

	private int nufuz;
	
	public kagit() {
		
		this.nufuz=2;
	}
	
	@Override
	public double etki_hesapla(ArrayList<String> Nesneler,int i) {
		double etki=0;
		double a;
		a=0.2;
		if(Nesneler.get(i)=="makas")
		{
			etki=(this.nufuz)/((1-a)*2);
		}
		if(Nesneler.get(i)=="tas")
		{
			etki=(this.nufuz)/((a)*2);
		}
		if(Nesneler.get(i)=="usta_makas")
		{
			etki=(this.nufuz)/((1-a)*2*2);
		}
		if(Nesneler.get(i)=="agir_tas")
		{
			etki=(this.nufuz)/((a)*2*2);
		}
		
		
	
	return etki;
	}

	

	@Override 
	public void durumGuncelle(double etki) {
		
		double son=getDayaniklilik()-etki;
		setDayaniklilik(son);
		
		
	}

	public int getNufuz() {
		return nufuz;
	}

	public void setNufuz(int nufuz) {
		this.nufuz = nufuz;
	}

	@Override
	public void durumGuncelle() {
		int son=getSeviye_puani()+20;
		setSeviye_puani(son);
		
		
	}

}
