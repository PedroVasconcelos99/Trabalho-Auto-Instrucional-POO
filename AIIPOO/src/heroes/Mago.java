package heroes;

public class Mago extends Heroi {
	public Mago() {
		nome = "Mago";
		atk = 30;
		def = 10;
		vida = 150;
	}
	
	
	public void especial(Cavaleiro cavaleiro, Paladino paladino) {
		cavaleiro.setDef(cavaleiro.getDef() + 20);
		paladino.setDef(paladino.getDef() + 20);
		def = def + 20;
	}
	
	public String toString() {
		return nome + "\nvida: " + vida + "\natk: " + atk + "\ndef: " + def;
	}
}
