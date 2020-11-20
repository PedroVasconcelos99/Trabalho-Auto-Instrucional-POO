package heroes;

public class Mago extends Heroi {
	public Mago() {
		nome = "Mago";
		atk = 30;
		def = 10;
		vida = 100;
	}
	
	public String toString() {
		return nome + "\nvida: " + vida + "\natk: " + atk + "\ndef: " + def;
	}
}
