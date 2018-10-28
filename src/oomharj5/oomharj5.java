package oomharj5;

public class oomharj5 {

	static boolean onko(Tuotettava x, Tuotettava y) {
		if(x == y) {
			return true;
		}
		Tuotettava xYlä;
		try {
			xYlä = x.getYläLuokka();
		}catch(NullPointerException e) {
			return false;
		}
		if(xYlä == y) {
			return true;
		}
		Tuotettava xYläYlä;
		try {
			xYläYlä = xYlä.getYläLuokka();
		}catch(NullPointerException e) {
			return false;
		}
		if(xYläYlä == y) {
			return true;
		}
		return false;
	}
	
	static boolean onko(Tuottaja x, Tuottaja y) {
		if(x == y) {
			return true;
		}
		Tuottaja xYlä;
		try {
			xYlä = x.getYläLuokka();
		}catch(NullPointerException e) {
			return false;
		}
		if(xYlä == y) {
			return true;
		}
		Tuottaja xYläYlä;
		try {
			xYläYlä = xYlä.getYläLuokka();
		}catch(NullPointerException e) {
			return false;
		}
		if(xYläYlä == y) {
			return true;
		}
		return false;
	}
	
	static boolean onko(Kuluttaja x, Kuluttaja y) {
		if(x == y) {
			return true;
		}
		Kuluttaja xYlä;
		try {
			xYlä = x.getYläLuokka();
		}catch(NullPointerException e) {
			return false;
		}
		if(xYlä == y) {
			return true;
		}
		Kuluttaja xYläYlä;
		try {
			xYläYlä = xYlä.getYläLuokka();
		}catch(NullPointerException e) {
			return false;
		}
		if(xYläYlä == y) {
			return true;
		}
		return false;
	}
	
	static boolean sopiiko(Tuotettava x, Kuluttaja y) {
		if(onko(x, y.getTuote())) {
			return true;
		}
		return false;
	}
	
	static boolean tuottaako(Tuottaja x, Tuotettava y) {
		if(onko(x.getTuote(), y)) {
			return true;
		}
		return false;
	}
	
	static boolean pitääkö(Kuluttaja x, Tuottaja y) {
		if(onko(y.getTuote(), x.getTuote())) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(onko(Tuotettava.Humppa, Tuotettava.Musiikki));
		System.out.println(sopiiko(Tuotettava.Humppa, Kuluttaja.HumppaFani));
		System.out.println(sopiiko(Tuotettava.Humppa, Kuluttaja.KaikkiRuokainen));
		System.out.println(sopiiko(Tuotettava.Musiikki, Kuluttaja.HumppaFani));
		System.out.println(tuottaako(Tuottaja.BändiEläkeläinen, Tuotettava.Humppa));
		System.out.println(tuottaako(Tuottaja.BändiEläkeläinen, Tuotettava.Viihde));
		System.out.println(tuottaako(Tuottaja.Viihdetaiteilija, Tuotettava.Humppa));
		System.out.println(pitääkö(Kuluttaja.HumppaFani, Tuottaja.BändiEläkeläinen));
		System.out.println(pitääkö(Kuluttaja.KaikkiRuokainen, Tuottaja.BändiEläkeläinen));
		System.out.println(pitääkö(Kuluttaja.HumppaFani, Tuottaja.Viihdetaiteilija));
	}
}

enum Tuotettava{
	Viihde(null),
	Musiikki(Viihde),
	Humppa(Musiikki);
	
	private final Tuotettava yläLuokka;
	
	Tuotettava(Tuotettava yläLuokka){
		this.yläLuokka = yläLuokka;
	}
	
	public Tuotettava getYläLuokka(){
		return this.yläLuokka;
	}
}

enum Kuluttaja{
	HumppaFani(null, Tuotettava.Humppa),
	MusiikinKuuntelija(HumppaFani, Tuotettava.Musiikki),
	KaikkiRuokainen(MusiikinKuuntelija, Tuotettava.Viihde);
	
	private final Kuluttaja yläLuokka;
	private final Tuotettava tuote;
	
	Kuluttaja(Kuluttaja yläLuokka, Tuotettava tuote){
		this.yläLuokka = yläLuokka;
		this.tuote = tuote;
	}
	
	public Kuluttaja getYläLuokka(){
		return this.yläLuokka;
	}
	
	public Tuotettava getTuote(){
		return this.tuote;
	}
}

enum Tuottaja{
	Viihdetaiteilija(null, Tuotettava.Viihde),
	Muusikko(Viihdetaiteilija, Tuotettava.Musiikki),
	BändiEläkeläinen(Muusikko, Tuotettava.Humppa);
	
	private final Tuottaja yläLuokka;
	private final Tuotettava tuote;
	
	Tuottaja(Tuottaja yläLuokka, Tuotettava tuote){
		this.yläLuokka = yläLuokka;
		this.tuote = tuote;
	}
	
	public Tuottaja getYläLuokka(){
		return this.yläLuokka;
	}
	
	public Tuotettava getTuote(){
		return this.tuote;
	}
}