package prolab2;

import java.util.ArrayList;
import java.util.Random;

class bilgisayar extends oyuncu {
	
	ArrayList<Integer> temp=new ArrayList<>();

	public bilgisayar(String ad, int id,ArrayList<nesne> nesneler,ArrayList<String> nesneAdlari) {
		super(ad,id,nesneler,nesneAdlari);
	}

	@Override
	public void SkorGoster() {
		System.out.println("in skoru =  "+getSkor());
		
	}

	@Override
	public int nesneSec() {
		int secilen =72;
		System.out.println("Savasacak nesne rastgele seciliyor");
		Random r=new Random();
		int g=getNesneler().size();
		int deger=g-1;
		if(temp.size()==0)
		{
			if(deger==0)
			{
				temp.add(0);
				
				return 0;
			}
			else {
			 secilen=r.nextInt(deger);
				temp.add(secilen);
			
					
			return secilen;
			
				
			}
		}
		if(temp.size()==1 || temp.size()==2 || temp.size()==3 )
		{
			if(deger==0)
			{
				temp.add(0);
				
				return 0;
			}
			else {
				
			    secilen=r.nextInt(deger);
				while(temp.contains(secilen))
				{
					 secilen=r.nextInt(deger);
				}
				if(!temp.contains(secilen))
				{
					temp.add(secilen);
					
					return secilen;
				}
			
				
			
			
				
			}
		}
		if(temp.size()==4)
		{
			if(deger==0)
			{
				temp.add(0);
				
				return 0;
			}
			if(!temp.contains(0))
			{temp.add(0);
			
				return 0;
			}
			if(!temp.contains(1))
			{temp.add(1);
		
				return 1;
			}
			if(!temp.contains(2))
			{temp.add(2);
			
				return 2;
			}
			if(!temp.contains(3))
			{temp.add(3);
			
				return 3;
			}
			if(!temp.contains(4))
			{temp.add(4);
			
				return 4;
			}
		}
		if(temp.size()==5)
		{
			if(deger==0)
			{
				return 0;
			}
			else {
				secilen=r.nextInt(deger);
				
			
			
			
			return secilen;
		}
		
		
			
		}
		return secilen;
		
	}

	

}
