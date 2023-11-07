package prolab2;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.random.*;
public class oyun {
	static Scanner scan=new Scanner(System.in);
	static Random r=new Random();
	static boolean sonuc=false;
	static File file=new File("oyun.txt");
	static oyun_arayuz arayuz;
	public static void main(String[] args) throws IOException {
		
	
		arayuz=new oyun_arayuz();
		
		arayuz.setVisible(true);
		  if (!file.exists()) {
	            file.createNewFile();
	        }
		
		
	}
	public static void kpc() throws IOException
	{
		FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write("Kullanici-Pc oyunu");
        bWriter.write("\n");

		System.out.println("Kullanici olusturuluyor");
		System.out.println("ID giriniz");
		int id=scan.nextInt();
		scan.nextLine();
		System.out.println("Ad giriniz");
		String ad=scan.nextLine();
		
		ArrayList<nesne> k1N=new ArrayList<>();
		ArrayList<String> k1NA=new ArrayList<>();
		System.out.println("Kullanici icin nesneleri giriniz");
		for(int i=0;i<5;i++)
		{
			System.out.println("(0)-Tas   (1)-Kagit   (2)-Makas");
			System.out.println(""+(i+1)+". nesneyi giriniz");
			int no=scan.nextInt();
			if(no==0) {
				
				nesne tas=new tas();
				k1N.add(tas);
				String adi="tas";
				k1NA.add(adi);
				
				
			}
			if(no==1) {
				
				
				nesne kagit=new kagit();
				k1N.add(kagit);
				String adi="kagit";
				k1NA.add(adi);
			}
			if(no==2) {
				
				nesne makas=new makas();
				k1N.add(makas);
				String adi="makas";
				k1NA.add(adi);
			}
			
			
		}
		oyuncu k1=new kullanici(ad, id,k1N,k1NA);
		k1.nesneYazdir();
		
		
		System.out.println("Bilgisayar 1 olusturuluyor");
		System.out.println("ID giriniz");
		int id1=scan.nextInt();
		scan.nextLine();
		System.out.println("Ad giriniz");
		String ad1=scan.nextLine();
		ArrayList<String> b1NA=new ArrayList<>();
		ArrayList<nesne> b1N=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			int no=r.nextInt(3);
			
			if(no==0) {
				
				nesne tas=new tas();
				b1N.add(tas);
				String adi="tas";
				b1NA.add(adi);
				
				
			}
			if(no==1) {
				
				
				nesne kagit=new kagit();
				b1N.add(kagit);
				String adi="kagit";
				b1NA.add(adi);
			}
			if(no==2) {
				
				nesne makas=new makas();
				b1N.add(makas);
				String adi="makas";
				b1NA.add(adi);
			}
			
			
		}
		oyuncu b1=new bilgisayar(ad1, id1,b1N,b1NA);
		b1.nesneYazdir();
		System.out.println("Hamle sayisinin giriniz");
		int hamle=scan.nextInt();
		
		for(int j=1;j<(hamle+1);j++)
		{
			System.out.println(""+j+". hamledesiniz");
			bWriter.write(""+j+". hamledesiniz");
			bWriter.write("\n");
			System.err.println("Savasacak nesneler belirleniyor");
			bWriter.write("Savasacak nesneler belirleniyor");
			bWriter.write("\n");
			int s1=k1.nesneSec();
			int s2=b1.nesneSec();
			System.out.print("Kullanicinin nesnesi="+k1.getNesneAdlari().get(s1));
			bWriter.write("Kullanicinin nesnesi="+k1.getNesneAdlari().get(s1));
			bWriter.write("\n");
			k1.getNesneler().get(s1).nesnePuaniGoster();
			System.out.print("Bilgisayar 1in nesnesi="+b1.getNesneAdlari().get(s2));
			bWriter.write("Kullanicinin nesnesi="+b1.getNesneAdlari().get(s2));
			bWriter.write("\n");
			b1.getNesneler().get(s2).nesnePuaniGoster();
			if(k1.getNesneAdlari().get(s1)==b1.getNesneAdlari().get(s2))
			{
				System.out.println("Nesneler aynı tür. Birbirlerine zarar veremiyor");
				bWriter.write("Nesneler aynı tür. Birbirlerine zarar veremiyor");
				bWriter.write("\n");
				
			}
			else if(k1.getNesneAdlari().get(s1)=="tas" && b1.getNesneAdlari().get(s2)=="agir_tas" || k1.getNesneAdlari().get(s1)=="agir_tas" && b1.getNesneAdlari().get(s2)=="tas" || k1.getNesneAdlari().get(s1)=="makas" && b1.getNesneAdlari().get(s2)=="usta_makas" || k1.getNesneAdlari().get(s1)=="usta_makas" && b1.getNesneAdlari().get(s2)=="makas" ||k1.getNesneAdlari().get(s1)=="kagit" && b1.getNesneAdlari().get(s2)=="ozel_kagit" || k1.getNesneAdlari().get(s1)=="ozel_kagit" && b1.getNesneAdlari().get(s2)=="kagit")
			{
				System.out.println("Nesneler aynı tür. Birbirlerine zarar veremiyor");
				bWriter.write("Nesneler aynı tür. Birbirlerine zarar veremiyor");
				bWriter.write("\n");
			}
			
			else {
				{
					double etki1=k1.getNesneler().get(s1).etki_hesapla(b1.getNesneAdlari(),s2);
					System.out.println("k1 oyuncusunun b1 oyuncususne veriği etki :  "+etki1);
					bWriter.write("k1 oyuncusunun b1 oyuncususne veriği etki :  "+etki1);
					bWriter.write("\n");
					double etki2=b1.getNesneler().get(s2).etki_hesapla(k1.getNesneAdlari(),s1);
					System.out.println("b1 oyuncusunun k1 oyuncususne veriği etki :  "+etki2);
					bWriter.write("k1 oyuncusunun b1 oyuncususne veriği etki :  "+etki2);
					bWriter.write("\n");
					k1.getNesneler().get(s1).durumGuncelle(etki2);
					b1.getNesneler().get(s2).durumGuncelle(etki1);
					System.out.println("Nesnelerin son dayanikliklari\nk1 nesnesi:    "+k1.getNesneler().get(s1).getDayaniklilik()+"\nb1 nesnesi:   "+b1.getNesneler().get(s2).getDayaniklilik());
					bWriter.write("Nesnelerin son dayanikliklari\nk1 nesnesi:    "+k1.getNesneler().get(s1).getDayaniklilik()+"\nb1 nesnesi:   "+b1.getNesneler().get(s2).getDayaniklilik());
					bWriter.write("\n");
					if(k1.getNesneler().get(s1).getDayaniklilik()<=0)
					{
						System.out.println("K1 in nesnesi oldu");
						bWriter.write("K1 in nesnesi oldu");
						bWriter.write("\n");
						k1.getNesneler().remove(s1);
						k1.getNesneAdlari().remove(s1);
						b1.getNesneler().get(s2).durumGuncelle();;
						System.out.println("B1 in nesnesinn seviye puani arttirildi");
						bWriter.write("B1 in nesnesinn seviye puani arttirildi");
						bWriter.write("\n");
						if(b1.getNesneler().get(s2).getSeviye_puani()>=30)
						{
							if(b1.getNesneAdlari().get(s2)=="tas")
							{
								String isim="agir_tas";
								nesne agir_tas=new agir_tas();
								b1.getNesneler().set(s2, agir_tas);
								b1.getNesneAdlari().set(s2, isim);
								System.out.println("Tas nesnesi agir tasa donduruludu");
								bWriter.write("Tas nesnesi agir tasa donduruludu");
								bWriter.write("\n");
								
							}
							if(b1.getNesneAdlari().get(s2)=="kagit")
							{
								String isim="ozel_kagit";
								nesne ozel_kagit=new ozel_kagit();
								b1.getNesneler().set(s2, ozel_kagit);
								b1.getNesneAdlari().set(s2, isim);
								System.out.println("Kagit nesnesi ozel kagita donduruludu");
								bWriter.write("Kagit nesnesi ozel kagita donduruludu");
								bWriter.write("\n");							
							}
							if(b1.getNesneAdlari().get(s2)=="makas")
							{
								String isim="usta_makas";
								nesne usta_makas=new usta_makas();
								b1.getNesneler().set(s2, usta_makas);
								b1.getNesneAdlari().set(s2, isim);
								System.out.println("Makas nesnesi usta makasa donduruludu");	
								bWriter.write("Makas nesnesi usta makasa donduruludu");
								bWriter.write("\n");
							}
							
						}
						
						
						
					}
					if(b1.getNesneler().get(s2).getDayaniklilik()<=0)
					{
						System.out.println("B1 in nesnesi oldu");
						bWriter.write("B1 in nesnesi oldu");
						bWriter.write("\n");
						b1.getNesneler().remove(s2);
						b1.getNesneAdlari().remove(s2);
						k1.getNesneler().get(s1).durumGuncelle();
						System.out.println("K1 in nesnesinn seviye puani arttirildi");
						bWriter.write("\n");
						bWriter.write("K1 in nesnesinn seviye puani arttirildi");
						if(k1.getNesneler().get(s1).getSeviye_puani()>=30)
						{
							if(k1.getNesneAdlari().get(s1)=="tas")
							{
								String isim="agir_tas";
								nesne agir_tas=new agir_tas();
								k1.getNesneler().set(s1, agir_tas);
								k1.getNesneAdlari().set(s1, isim);
								System.out.println("Tas nesnesi agir tasa donduruludu");
								
								bWriter.write("Tas nesnesi agir tasa donduruludu");
								bWriter.write("\n");							
							}
							
							if(k1.getNesneAdlari().get(s1)=="kagit")
							{
								String isim="ozel_kagit";
								nesne ozel_kagit=new ozel_kagit();
								k1.getNesneler().set(s1, ozel_kagit);
								k1.getNesneAdlari().set(s1, isim);
								System.out.println("Kagit nesnesi ozel kagita donduruludu");
								bWriter.write("Kagit nesnesi ozel kagita donduruludu");
							
								bWriter.write("\n");
							}
							if(k1.getNesneAdlari().get(s1)=="makas")
							{
								String isim="usta_makas";
								nesne usta_makas=new usta_makas();
								k1.getNesneler().set(s1, usta_makas);
								k1.getNesneAdlari().set(s1, isim);
								System.out.println("Makas nesnesi usta makasa donduruludu");
								bWriter.write("Makas nesnesi usta makasa donduruludu");
								bWriter.write("\n");
								
							}
							
						}
						
						
						
					}
					
					
				if(b1.getNesneler().size()==0)
				{
					System.out.println("B1 oyuncusunun nesneleri tükendi");
					bWriter.write("B1 oyuncusunun nesneleri tükendi");
					bWriter.write("\n");
					System.out.println("K1 oyuncusunun oyunu kazandi");
					bWriter.write("K1 oyuncusunun oyunu kazandi");
					bWriter.write("\n");
					sonuc=true;
					break;
					
					
					
				}
				if(k1.getNesneler().size()==0)
				{
					System.out.println("K1 oyuncusunun nesneleri tükendi");
					bWriter.write("K1 oyuncusunun nesneleri tükendi");
					bWriter.write("\n");
					System.out.println("B1 oyuncusunun oyunu kazandi");
					bWriter.write("B1 oyuncusunun oyunu kazandi");
					bWriter.write("\n");
					sonuc=true;
					
					break;
					
					
					
				}
				}
				
				
			}
			
			
			
		}
		
		
		
		if(!sonuc)
		{
			System.out.println("Hamle sayisi bitti.Kazanan hesaplaniyor");
			bWriter.write("Hamle sayisi bitti.Kazanan hesaplaniyor");
			bWriter.write("\n");
			double sonuc1=0;
			double sonuc2=0;
			for(int a=0;a<k1.getNesneler().size();a++)
			{
				sonuc1=sonuc1+k1.getNesneler().get(a).getDayaniklilik();
			}
			for(int a=0;a<b1.getNesneler().size();a++)
			{
				sonuc2=sonuc2+b1.getNesneler().get(a).getDayaniklilik();
			}
			k1.setSkor(sonuc1);
			b1.setSkor(sonuc2);
			if(k1.getSkor()>b1.getSkor())
			{
				k1.SkorGoster();
				System.out.print("B1");
				bWriter.write("B1");
				bWriter.write("\n");
				b1.SkorGoster();
				System.out.println("K1 oyuncusu Kazandi");
				bWriter.write("K1 oyuncusu Kazandi");
				bWriter.write("\n");
			}
			
			if(b1.getSkor()>k1.getSkor())
			{
				k1.SkorGoster();
				System.out.print("B1");
				bWriter.write("B1");
				bWriter.write("\n");
				b1.SkorGoster();
				System.out.println("B1 oyuncusu Kazandi");
				bWriter.write("B1 oyuncusu Kazandi");
				bWriter.write("\n");			
			}
			if(k1.getSkor()==b1.getSkor())
			{
				k1.SkorGoster();
				System.out.print("B1");
				bWriter.write("B1");
				bWriter.write("\n");
				b1.SkorGoster();
				System.out.println("Oyun berabere bitti");
				bWriter.write("Oyun berabere bitti");
				bWriter.write("\n");
			}
			
			
		}
        bWriter.close();

	}
	
	public static void pcpc() throws IOException
	{
		String text="";
		arayuz.setVisible(false);
		FileWriter fileWriter = new FileWriter(file, false);
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
       
        bWriter.write("Bilgisayar 1 olusturuluyor");
		bWriter.write("\n");
		
		int id=12345;
		String ad="pc1";
		
		ArrayList<nesne> b1N=new ArrayList<>();
		ArrayList<String> b1NA=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			int no=r.nextInt(3);
			
			if(no==0) {
				
				nesne tas=new tas();
				b1N.add(tas);
				String adi="tas";
				b1NA.add(adi);
				
				
			}
			if(no==1) {
				
			
				nesne kagit=new kagit();
				b1N.add(kagit);
				String adi="kagit";
				b1NA.add(adi);
			}
			if(no==2) {
				
				nesne makas=new makas();
				b1N.add(makas);
				String adi="makas";
				b1NA.add(adi);
				
			}
			
			
		}
		oyuncu b1=new bilgisayar(ad, id,b1N,b1NA);
		
		b1.nesneYazdir();
		
		
		 bWriter.write("Bilgisayar 2 olusturuluyor");
			bWriter.write("\n");
		
		int id1=6789;
		String ad1="pc2";
		ArrayList<String> b2NA=new ArrayList<>();
		ArrayList<nesne> b2N=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			int no=r.nextInt(3);
			
			if(no==0) {
				
				nesne tas=new tas();
				b2N.add(tas);
				String adi="tas";
				b2NA.add(adi);
				
			}
			if(no==1) {
				
				
				nesne kagit=new kagit();
				b2N.add(kagit);
				String adi="kagit";
				b2NA.add(adi);
			}
			if(no==2) {
				
				nesne makas=new makas();
				b2N.add(makas);
				String adi="makas";
				b2NA.add(adi);
				
			}
			
			
		}
		oyuncu b2=new bilgisayar(ad1, id1,b2N,b2NA);
		b2.nesneYazdir();
		
		oyun11 oyun11=new oyun11();
		String input=JOptionPane.showInputDialog("Hamle sayisini giriniz :");
		int hamle=Integer.parseInt(input);
		for(int j=1;j<(hamle+1);)
		{
			
			System.out.println(""+j+". hamledesiniz");
			text="\n"+j+". hamledesiniz";
			 bWriter.write(""+j+". hamledesiniz");
				bWriter.write("\n");
			System.out.println("Savasacak nesneler belirleniyor");
		    text=text+ "\n"+"Savasacak nesneler belirleniyor";
		    
			
			 bWriter.write("Savasacak nesneler belirleniyor");
				bWriter.write("\n");
			int s1=b1.nesneSec();
			int s2=b2.nesneSec();
			
			System.out.print("Bilgisayar 1in nesnesi="+b1.getNesneAdlari().get(s1));
			text=text+ "\n"+"Bilgisayar 1in nesnesi="+b1.getNesneAdlari().get(s1);
			 bWriter.write("Bilgisayar 1in nesnesi="+b1.getNesneAdlari().get(s1));
				bWriter.write("\n");
			b1.getNesneler().get(s1).nesnePuaniGoster();
			System.out.print("Bilgisayar 2in nesnesi="+b2.getNesneAdlari().get(s2));
			text=text+ "\n"+"Bilgisayar 2in nesnesi="+b2.getNesneAdlari().get(s2);
			 bWriter.write("Bilgisayar 2in nesnesi="+b2.getNesneAdlari().get(s2));
				bWriter.write("\n");
			b2.getNesneler().get(s2).nesnePuaniGoster();
			if(b1.getNesneAdlari().get(s1)==b2.getNesneAdlari().get(s2))
			{
				System.out.println("Nesneler aynı tür. Birbirlerine zarar veremiyor");
				text=text+ "\n"+"Nesneler aynı tür. Birbirlerine zarar veremiyor";
				 bWriter.write("Nesneler aynı tür. Birbirlerine zarar veremiyor");
					bWriter.write("\n");
					JOptionPane.showMessageDialog(null, text);
					oyun11.tut(j);
					j=oyun11.arttir();
				
				
			}
			else if(b1.getNesneAdlari().get(s1)=="tas" && b2.getNesneAdlari().get(s2)=="agir_tas" || b1.getNesneAdlari().get(s1)=="agir_tas" && b2.getNesneAdlari().get(s2)=="tas" || b1.getNesneAdlari().get(s1)=="makas" && b2.getNesneAdlari().get(s2)=="usta_makas" || b1.getNesneAdlari().get(s1)=="usta_makas" && b2.getNesneAdlari().get(s2)=="makas" ||b1.getNesneAdlari().get(s1)=="kagit" && b2.getNesneAdlari().get(s2)=="ozel_kagit" || b1.getNesneAdlari().get(s1)=="ozel_kagit" && b2.getNesneAdlari().get(s2)=="kagit")
			{
				System.out.println("Nesneler aynı tür. Birbirlerine zarar veremiyor");
				text=text+ "\n"+"Nesneler aynı tür. Birbirlerine zarar veremiyor";
				 bWriter.write("Nesneler aynı tür. Birbirlerine zarar veremiyor");
					bWriter.write("\n");
					JOptionPane.showMessageDialog(null, text);
					oyun11.tut(j);
					j=oyun11.arttir();
				
			}
			else {
				{
					double etki1=b1.getNesneler().get(s1).etki_hesapla(b2.getNesneAdlari(),s2);
					System.out.println("b1 oyuncusunun b2 oyuncususne veriği etki :  "+etki1);
					text=text+ "\n"+"b1 oyuncusunun b2 oyuncususne veriği etki :  "+etki1;
					 bWriter.write("b1 oyuncusunun b2 oyuncususne veriği etki :  "+etki1);
						bWriter.write("\n");
					double etki2=b2.getNesneler().get(s2).etki_hesapla(b1.getNesneAdlari(),s1);
					System.out.println("b2 oyuncusunun b2 oyuncususne veriği etki :  "+etki2);
					text=text+ "\n"+"b2 oyuncusunun b1 oyuncususne veriği etki :  "+etki2;
					 bWriter.write("b2 oyuncusunun b1 oyuncususne veriği etki :  "+etki2);
						bWriter.write("\n");
					b1.getNesneler().get(s1).durumGuncelle(etki2);
					b2.getNesneler().get(s2).durumGuncelle(etki1);
					System.out.println("Nesnelerin son dayanikliklari\nb1 nesnesi:    "+b1.getNesneler().get(s1).getDayaniklilik()+"\nb2 nesnesi:   "+b2.getNesneler().get(s2).getDayaniklilik());
					text=text+ "\n"+"Nesnelerin son dayanikliklari\nb1 nesnesi:    "+b1.getNesneler().get(s1).getDayaniklilik()+"\nb2 nesnesi:   "+b2.getNesneler().get(s2).getDayaniklilik(); 
					bWriter.write("Nesnelerin son dayanikliklari\nb1 nesnesi:    "+b1.getNesneler().get(s1).getDayaniklilik()+"\nb2 nesnesi:   "+b2.getNesneler().get(s2).getDayaniklilik());
						bWriter.write("\n");
					if(b1.getNesneler().get(s1).getDayaniklilik()<=0)
					{
						System.out.println("B1 in nesnesi oldu");
						text=text+ "\n"+"B1 in nesnesi oldu"; 
						 bWriter.write("B1 in nesnes oldu");
							bWriter.write("\n");
						b1.getNesneler().remove(s1);
						b1.getNesneAdlari().remove(s1);
						b2.getNesneler().get(s2).durumGuncelle();;
						System.out.println("B2 in nesnesinn seviye puani arttirildi");
						text=text+ "\n"+"B2 in nesnesinn seviye puani arttirildi"; 
						
						bWriter.write("B2 in nesnesinn seviye puani arttirildi");
						
						bWriter.write("\n");
						if(b2.getNesneler().get(s2).getSeviye_puani()>=30)
						{
							if(b2.getNesneAdlari().get(s2)=="tas")
							{
								String isim="agir_tas";
								nesne agir_tas=new agir_tas();
								b2.getNesneler().set(s2, agir_tas);
								b2.getNesneAdlari().set(s2, isim);
								System.out.println("Tas nesnesi agir tasa donduruludu");
								text=text+ "\n"+"Tas nesnesi agir tasa donduruludu"; 
								bWriter.write("Tas nesnesi agir tasa donduruludu");
								bWriter.write("\n");
							}
							if(b2.getNesneAdlari().get(s2)=="kagit")
							{
								String isim="ozel_kagit";
								nesne ozel_kagit=new ozel_kagit();
								b2.getNesneler().set(s2, ozel_kagit);
								b2.getNesneAdlari().set(s2, isim);
								System.out.println("Kagit nesnesi ozel kagita donduruludu");
								text=text+ "\n"+"Kagit nesnesi ozel kagita donduruludu"; 
								bWriter.write("Kagit nesnesi ozel kagita donduruludu");
								bWriter.write("\n");
							}
							if(b2.getNesneAdlari().get(s2)=="makas")
							{
								String isim="usta_makas";
								nesne usta_makas=new usta_makas();
								b2.getNesneler().set(s2, usta_makas);
								b2.getNesneAdlari().set(s2, isim);
								System.out.println("Makas nesnesi usta makasa donduruludu");
								text=text+ "\n"+"Makas nesnesi usta makasa donduruludu"; 
								bWriter.write("Makas nesnesi usta makasa donduruludu");
								bWriter.write("\n");
							}
							
						}
						
						
						
					}
					if(b2.getNesneler().get(s2).getDayaniklilik()<=0)
					{
						System.out.println("B2 in nesnesi oldu");
						text=text+ "\n"+"B2 in nesnesi oldu"; 
						bWriter.write("B2 in nesnesi oldu");
						bWriter.write("\n");
						b2.getNesneler().remove(s2);
						b2.getNesneAdlari().remove(s2);
						b1.getNesneler().get(s1).durumGuncelle();
						System.out.println("B1 in nesnesinn seviye puani arttirildi");
						text=text+ "\n"+"B1 in nesnesinn seviye puani arttirildi";
						bWriter.write("B1 in nesnesinn seviye puani arttirildi");
						bWriter.write("\n");
						if(b1.getNesneler().get(s1).getSeviye_puani()>=30)
						{
							if(b1.getNesneAdlari().get(s1)=="tas")
							{
								String isim="agir_tas";
								nesne agir_tas=new agir_tas();
								b1.getNesneler().set(s1, agir_tas);
								b1.getNesneAdlari().set(s1, isim);
								System.out.println("Tas nesnesi agir tasa donduruludu");
								text=text+ "\n"+"Tas nesnesi agir tasa donduruludu";
								bWriter.write("Tas nesnesi agir tasa donduruludu");
								bWriter.write("\n");
							}
							if(b1.getNesneAdlari().get(s1)=="kagit")
							{
								String isim="ozel_kagit";
								nesne ozel_kagit=new ozel_kagit();
								b1.getNesneler().set(s1, ozel_kagit);
								b1.getNesneAdlari().set(s1, isim);
								System.out.println("Kagit nesnesi ozel kagita donduruludu");
								text=text+ "\n"+"Kagit nesnesi ozel kagita donduruludu";
								bWriter.write("Kagit nesnesi ozel kagita donduruludu");
								bWriter.write("\n");
							}
							if(b1.getNesneAdlari().get(s1)=="makas")
							{
								String isim="usta_makas";
								nesne usta_makas=new usta_makas();
								b1.getNesneler().set(s1, usta_makas);
								b1.getNesneAdlari().set(s1, isim);
								System.out.println("Makas nesnesi usta makasa donduruludu");	
								text=text+ "\n"+"Makas nesnesi usta makasa donduruludu";
								bWriter.write("Makas nesnesi usta makasa donduruludu");
								bWriter.write("\n");
							}
							
						}
						
						
						
					}
					if(b2.getNesneler().size()==0)
					{
						String text2="";
						System.out.println("B2 oyuncusunun nesneleri tükendi");
						text2=text2+ "\n"+"B2 oyuncusunun nesneleri tükendi";
						bWriter.write("B2 oyuncusunun nesneleri tükendi");
						bWriter.write("\n");
						System.out.println("B1 oyuncusunun oyunu kazandi");
						text2=text2+ "\n"+"B1 oyuncusunun oyunu kazandi";
						JOptionPane.showMessageDialog(null, text2);
						bWriter.write("B1 oyuncusunun oyunu kazandi");
						bWriter.write("\n");
						sonuc=true;
						break;
						
						
						
					}
					if(b1.getNesneler().size()==0)
					{ 
						String text3="";
						System.out.println("B1 oyuncusunun nesneleri tükendi");
						text3=text3+ "\n"+"B1 oyuncusunun nesneleri tükendi";
						bWriter.write("B1 oyuncusunun nesneleri tükendi");
						bWriter.write("\n");
						System.out.println("B2 oyuncusunun oyunu kazandi");
						text3=text3+ "\n"+"B2 oyuncusunun oyunu kazandi";
						JOptionPane.showMessageDialog(null, text3);
						bWriter.write("B2 oyuncusunun oyunu kazandi");
						bWriter.write("\n");
						sonuc=true;
						break;
						
						
						
					}
					JOptionPane.showMessageDialog(null, text);
					
					oyun11.tut(j);
					j=oyun11.arttir();
				
				}
			}
			
		}
		
		if(!sonuc)
		{
			String text1="";
			System.out.println("Hamle sayisi bitti.Kazanan hesaplaniyor");
			text1=text1+ "\n"+"Hamle sayisi bitti.Kazanan hesaplaniyor";
			bWriter.write("Hamle sayisi bitti.Kazanan hesaplaniyor");
			bWriter.write("\n");
			double sonuc1=0;
			double sonuc2=0;
			for(int a=0;a<b1.getNesneler().size();a++)
			{
				sonuc1=sonuc1+b1.getNesneler().get(a).getDayaniklilik();
			}
			for(int a=0;a<b2.getNesneler().size();a++)
			{
				sonuc2=sonuc2+b2.getNesneler().get(a).getDayaniklilik();
			}
			b1.setSkor(sonuc1);
			b2.setSkor(sonuc2);
			if(b1.getSkor()>b2.getSkor())
			{
				System.out.print("B1");
				text1=text1+ "\n"+"B1";
				b1.SkorGoster();
				bWriter.write("B1");
				bWriter.write("\n");
				System.out.print("B2");
				text1=text1+ "\n"+"B2";
				bWriter.write("B2");
				bWriter.write("\n");
				b2.SkorGoster();
				System.out.println("B1 oyuncusu Kazandi");
				text1=text1+ "\n"+"B1 oyuncusu Kazandi";
				JOptionPane.showMessageDialog(null, text1);
				bWriter.write("B1 oyuncusu Kazandi");
				bWriter.write("\n");
			}
			if(b2.getSkor()>b1.getSkor())
			{
				System.out.print("B1");
				text1=text1+ "\n"+"B1";
				bWriter.write("B1");
				bWriter.write("\n");
				b1.SkorGoster();
				System.out.print("B2");
				text1=text1+ "\n"+"B2";
				bWriter.write("B2");
				bWriter.write("\n");
				b2.SkorGoster();
				
				System.out.println("B2 oyuncusu Kazandi");
				text1=text1+ "\n"+"B2 oyuncusu Kazandi";
				JOptionPane.showMessageDialog(null, text1);
				bWriter.write("B2 oyuncusu Kazandi");
				bWriter.write("\n");
			}
			if(b1.getSkor()==b2.getSkor())
			{
				System.out.print("B1");
				text1=text1+ "\n"+"B1";
				bWriter.write("B1");
				bWriter.write("\n");
				b1.SkorGoster();
				System.out.print("B2");
				text1=text1+ "\n"+"B2";
				bWriter.write("B2");
				bWriter.write("\n");
				b2.SkorGoster();
				
				System.out.println("Oyun berabere bitti");
				text1=text1+ "\n"+"Oyun berabere bitti";
				JOptionPane.showMessageDialog(null, text1);
				bWriter.write("Oyun berabere bitti");
				bWriter.write("\n");
			}
			
				
		}
	
		bWriter.close();
		
	}
	
}
