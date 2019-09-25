
public class Formelsammlung {
	public static void main(String[] args) {
		int n = 6 ;
		String[]Menustruktur = new String [n]; 
		Menustruktur[0] = "Hallo";
		Menustruktur[1] = "Fakultät";
		Menustruktur[2] = "Größter gemeinsamer Teiler";
		Menustruktur[3] = "Kleinstes gemeinsames Vielfaches";
		Menustruktur[4] = "Array Sortieren";
		Menustruktur[5] = "Beenden";
		Boolean weiter = true;
		while(weiter) {
			System.out.println("=== Formelsammlung Menü ===");
			for(int i = 0; i < n; i++) {
				if(i<(n-1)) {
					System.out.println("[" + (i+1) + "] " + Menustruktur[i]);
				}else {
					System.out.println("[0] " + Menustruktur[i]);
				}
			}
			System.out.println("Ihre Auswahl: ");
			int Entscheidung = Eingabe.intEinlesen();
			if(Entscheidung == 0) {
				weiter = false;
			}
			else if(Entscheidung == 1) {
				System.out.print("Geben Sie Ihren Name ein: ");
				String name = Eingabe.stringEinlesen();
				System.out.println(Hallo(name));
			}
			else if(Entscheidung == 2) {
				System.out.println("Geben Sie eine Zahl ein: ");
				int zahl = Eingabe.intEinlesen();
				System.out.println(falkutaetRekursiv(zahl));
			}
			else if(Entscheidung == 3) {
				int a , b;
				System.out.println("Geben Sie die erste Zahl: ");
				a = Eingabe.intEinlesen();
				System.out.println("Geben Sie die zweite Zahl: ");
				b = Eingabe.intEinlesen();
				System.out.println(ggT(a,b));
				
			}
			else if(Entscheidung == 4) {
				int c , d;
				System.out.println("Geben Sie die erste Zahl: ");
				c = Eingabe.intEinlesen();
				System.out.println("Geben Sie die zweite Zahl: ");
				d = Eingabe.intEinlesen();
				System.out.println(kgV(c,d));
			}
			else if(Entscheidung == 5) {
				System.out.println("Geben sie die Laenge des Arrays: ");
				int Laenge = Eingabe.intEinlesen();
				int[] array = new int[Laenge];
				for(int l = 0; l < array.length; l++) {
					System.out.print("Geben Sie " + (l+1) + "ste Zahl ein: ");
					array[l] = Eingabe.intEinlesen();
				}
				System.out.print("Originales Array: ");
				Ausgabe.arrayAusgeben(array);
				sort(array);
				System.out.println("Jetzt wird das Array sortiert!");
				System.out.print("Sortiertes Array: ");
				 Ausgabe.arrayAusgeben(array);
				}
				
			else {
				System.out.println("Falsche Eingabe! Die Eingabe muss 0 bis 5 sein! Probieren Sie noch mal!");
			}
			
		}
		
		
	}
	
	public static void sort(int[] Sort) {
		int x = 0, a = 0, b = 0;
		while(x < Sort.length) {
			for(int y = 0; y < Sort.length; y++) {
				if((x < y) && (Sort[x] >= Sort[y])) {
					a = Sort[x];
					b = Sort [y];
					Sort[y] = a;
					Sort[x] = b;
				}else {
					Sort[x] = Sort[x];
				}
			}
			x++;
		}
	}
	public static String Hallo(String name) {
		return "Hallo, "+ name;
	}
	
	public static int falkutaetRekursiv(int n) {
		int Falkutaet = 1 , produkt = 1;
		if(n == 0) {
			Falkutaet = 1;
		} else if(n < 0) {
			System.out.println("ungueltige Zahl!");
		} else {
			for(int i = 1; i <= n;i++) {
				produkt = produkt * i;
				Falkutaet = produkt;
			}
		}
		return Falkutaet;
	}
	
	public static int ggT(int a, int b) {
		int ggT = 1 ;
		int[]Ta = new int[a] ;
		int[]Tb = new int[b];
		for(int i = 1; i <= a; i++) {
			if(a % i == 0) {
				Ta[i-1] = i;
			}
		}	
		for(int j = 1; j <= b; j++) {
			if(b % j == 0) {
				Tb[j-1] = j;
				}
		}
		int x = 0;
		while(x < a) {
			for(int y=0; y < b; y++) {
				if((Ta[x] == Tb[y]) && (Ta[x] != 0)) {
					ggT = Ta[y];
				}
			}
			x++;
		}
		return ggT;
			
		}
	public static int kgV(int a, int b) {
		int kgV = a * b / (ggT(a,b));
		return kgV;
	}
}
