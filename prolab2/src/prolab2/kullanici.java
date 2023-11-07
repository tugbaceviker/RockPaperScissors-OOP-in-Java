package prolab2;

import java.util.ArrayList;
import java.util.Scanner;

class kullanici extends oyuncu {

	ArrayList<Integer> temp=new ArrayList<>();
	
	public kullanici(String ad,int id,ArrayList<nesne> nesneler,ArrayList<String> nesneAdlari) {
		super(ad,id,nesneler,nesneAdlari);
		
	}
	
	@Override
	public void SkorGoster() {
		System.out.println("K1 in skoru =  "+getSkor());
		
	}

	@Override
	public int nesneSec() {
		Scanner scan=new Scanner(System.in);
		int secilen=72;
		if(temp.size()==0)
		{
			for(int i=0;i<(getNesneler().size());i++)
			{
			System.out.print(""+getNesneAdlari().get(i));
			getNesneler().get(i).nesnePuaniGoster();
			}
		System.out.println("Savasmak istediginiz indisteki nesneyi seciniz");
		secilen=scan.nextInt();
		temp.add(secilen);
		return secilen;
		}
		
		if(temp.size()==1 || temp.size()==2 || temp.size()==3 || temp.size()==4)
		{
			for(int i=0;i<(getNesneler().size());i++)
			{
				if(temp.contains(i))
				{
					System.out.println("Tüm Nesneleri Kullanmadan ayni nesneyi birden fazla kullnamazsin");
				}
				if(!temp.contains(i)) 
				{
					System.out.print(""+getNesneAdlari().get(i));
					getNesneler().get(i).nesnePuaniGoster();
				}
			
			}
			System.out.println("Savasmak istediginiz nesneyi girinz");
			secilen=scan.nextInt();
			while(temp.contains(secilen))
			{
				System.out.println("Tum nesnlerr secilmeden aynisi secilemez tekrar seciniz !!");
				secilen=scan.nextInt();
			}
			if(!temp.contains(secilen))
			{
				temp.add(secilen);
				return secilen;
			}
			
			
		}
		if(temp.size()==5)
		{
			for(int i=0;i<(getNesneler().size());i++)
			{
			System.out.print(""+getNesneAdlari().get(i));
			getNesneler().get(i).nesnePuaniGoster();
			}
		System.out.println("Savasmak istediginiz indisteki nesneyi seciniz");
		secilen=scan.nextInt();
		return secilen;
		}
		return secilen;
		
		
		
		
		
	}
	
	

}
