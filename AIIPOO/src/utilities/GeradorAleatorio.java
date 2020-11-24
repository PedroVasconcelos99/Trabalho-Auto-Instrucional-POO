package utilities;

public class GeradorAleatorio {
	//classe que verifica se o ataque acertou errou ou foi um critico
	public int check() {
		return (int) (Math.random() * (20 - 1 + 1) + 1);
		
	}
	
	public int alvoAleatorio() {
		return (int) (Math.random() * (2 - 1 + 1) + 1);
	}
}
