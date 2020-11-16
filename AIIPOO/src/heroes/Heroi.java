package heroes;

public class Heroi {	
	private int vida;
	private int atk;
	private int def;
	
	public Heroi(int atk,int def, int vida) {
		this.atk = atk;
		this.def = def;
		this.vida = vida;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	
	
}
