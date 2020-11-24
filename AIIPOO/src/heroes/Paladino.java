package heroes;

public class Paladino extends Heroi{
	public Paladino() {
		nome = "Paladino";
		vida = 200;
		atk = 20;
		def = 20;
	}
	
	public void especial(Cavaleiro cavaleiro, Mago mago) {
		cavaleiro.setVida(cavaleiro.getVida()+50);
		mago.setVida(mago.getVida()+50);
		vida = vida + 50;
	}
	
	public String toString() {
		return nome + "\nvida: " + vida + "\natk: " + atk + "\ndef: " + def;
	}
}

