package heroes;

public class Cavaleiro extends Heroi{

	public Cavaleiro() {
		vida = 300;
		atk = 15;
		def = 30;
	}
	
	public void especial() {
		setAtk(getAtk()*2);
	}
	
	
}
