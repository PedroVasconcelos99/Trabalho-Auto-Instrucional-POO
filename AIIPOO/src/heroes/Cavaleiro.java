package heroes;

public class Cavaleiro extends Heroi{

	public Cavaleiro() {
		vida = 300;
		atk = 15;
		def = 15;
	}
	
	public void especial() {
		setAtk(getAtk()*2);
	}
	
	
}
