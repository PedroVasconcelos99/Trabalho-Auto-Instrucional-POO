package heroes;

public class Paladino extends Heroi{
	public Paladino() {
		nome = "Paladino";
		vida = 200;
		atk = 20;
		def = 20;
	}
	
	public String toString() {
		return nome + "\nvida: " + vida + "\natk: " + atk + "\ndef: " + def;
	}
}

