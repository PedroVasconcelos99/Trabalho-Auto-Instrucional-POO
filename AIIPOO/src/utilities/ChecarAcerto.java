package utilities;

public class ChecarAcerto {
	public int check() {
		int resultado = (int) (Math.random() * (20 - 1 + 1) + 1);
		if (resultado <=10) {
			return 1;
		} else if (resultado <=19) {
			return 2;
		} else {
			return 3;
		}
	}
}
