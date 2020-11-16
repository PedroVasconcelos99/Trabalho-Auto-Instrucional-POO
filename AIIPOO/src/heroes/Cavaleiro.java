package heroes;

public class Cavaleiro extends Heroi{

	public Cavaleiro(int atk, int def, int vida) {
		super(atk, def, vida);
		this.atk = atk;
		this.def = def;
		this.vida = vida;
	}
	
	public void ataques() {
		normal(); 
	}
	
	public void normal() {
		
	}
}
