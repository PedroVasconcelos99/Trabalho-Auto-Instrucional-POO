package menus;

import java.util.Scanner;
import enemies.*;
import heroes.*;
import utilities.*;

public class MenuBatalha {
	Scanner leia = new Scanner(System.in);
	GuerreiroEsqueleto ge = new GuerreiroEsqueleto(300, 10, 5);
	public void menuBatalha() {
		
		do {
			
			int opcao;
			System.out.println("HP" + ge.getVida());
			System.out.println("1-atacar\n2-itens\n3-satus");
			opcao = leia.nextInt();
			
			switch (opcao) {
			case 1: {
				ge.setVida(ge.getVida() - 10);
				break;
			}
			
			default:
				throw new IllegalArgumentException("valor invalido: " + opcao);
			}
		
		} while (ge.getVida() != 0);
		
		
		
	}
}
