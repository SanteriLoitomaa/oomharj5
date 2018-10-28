package oomharj55;

public class Main {

	public static void main(String[] args) {
		System.out.println(new Humppa() instanceof Musiikki);
		System.out.println(new Humppa().käykö(new HumppaFani()));
	}

}

abstract class Tuotettava{
	<X extends Tuotettava> X tunnista() {
		if(this instanceof Humppa) {
			return (X) new Humppa();
		}
		if(this instanceof Musiikki) {
			return (X) new Musiikki();
		}
		if(this instanceof Viihde) {
			return (X) new Viihde();
		}
		return null;
	}
}

class Humppa extends Musiikki{
	<X extends Tuottaja> boolean sopiiko(X x) {
		if(x.tuota() instanceof Humppa) {
			return true;
		}
		return false;
	}
	
	<X extends Kuluttaja> boolean käykö(X x) {
		if(x.kuluta() instanceof Humppa) {
			return true;
		}
		return false;
	}
}

class Musiikki extends Viihde{
	<X extends Tuottaja> boolean sopiiko(X x) {
		if(x.tuota() instanceof Musiikki) {
			return true;
		}
		return false;
	}
	
	<X extends Kuluttaja> boolean käykö(X x) {
		if(x.kuluta() instanceof Musiikki) {
			return true;
		}
		return false;
	}
}

class Viihde extends Tuotettava{
	<X extends Tuottaja> boolean sopiiko(X x) {
		if(x.tuota() instanceof Viihde) {
			return true;
		}
		return false;
	}
	
	<X extends Kuluttaja> boolean käykö(X x) {
		if(x.kuluta() instanceof Viihde) {
			return true;
		}
		return false;
	}
}

abstract class Tuottaja{
	<X extends Tuotettava> X tuota() {
		if(this instanceof Eläkeläinen) {
			return (X) new Humppa();
		}
		if(this instanceof Muusikko) {
			return (X) new Musiikki();
		}
		if(this instanceof Viihdetaiteilija) {
			return (X) new Viihde();
		}
		return null;
	}
}

class Eläkeläinen extends Muusikko{
	
}

class Muusikko extends Viihdetaiteilija{
	
}

class Viihdetaiteilija extends Tuottaja{
	
}

class Kuluttaja{
	<X extends Tuotettava> X kuluta() {
		if(this instanceof KaikkiRuokainen) {
			return (X) new Viihde();
		}
		if(this instanceof MusiikinKuuntelija) {
			return (X) new Musiikki();
		}
		if(this instanceof HumppaFani) {
			return (X) new Humppa();
		}
		return null;
	}
}

class HumppaFani extends Kuluttaja{
	
}

class MusiikinKuuntelija extends HumppaFani{
	
}

class KaikkiRuokainen extends MusiikinKuuntelija{
	
}
