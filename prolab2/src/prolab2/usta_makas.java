package prolab2;

import java.util.ArrayList;

class usta_makas extends makas {
	private int direnc;
	
	public usta_makas() {
		
		this.direnc=2;
	}

	public int getDirenc() {
		return direnc;
	}

	public void setDirenc(int direnc) {
		this.direnc = direnc;
	}
	@Override
	public double etki_hesapla(ArrayList<String> Nesneler, int i) {
		double etki = 0;
		double a;
		a=0.2;
		if(Nesneler.get(i)=="tas")
		{
			etki=(getKeskinlik()*this.direnc)/((1-a)*2);
		}
		if(Nesneler.get(i)=="kagit")
		{
			etki=(getKeskinlik()*this.direnc)/((a)*2);
		}
		if(Nesneler.get(i)=="agir_tas")
		{
			etki=(getKeskinlik()*this.direnc)/((1-a)*2*2);
		}
		if(Nesneler.get(i)=="ozel_kagit")
		{
			etki=(getKeskinlik()*this.direnc)/((a)*2*2);
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
