package heroes;

public class Cavaleiro extends Heroi{

	public Cavaleiro() {
		nome = "Cavaleiro";
		vida = 300;
		atk = 15;
		def = 15;
		cooldown = 0;
	}
	
	public void especial() {
		setAtk(getAtk()*2);							
	}
	
	public String toString() {
		return nome + "\nvida: " + vida + "\natk: " + atk + "\ndef: " + def;
	}
	
	
}
