package menus;

import java.util.Scanner;
import enemies.*;
import heroes.*;
import utilities.*;

public class MenuBatalha {
	Scanner leia = new Scanner(System.in);
	GuerreiroEsqueleto ge = new GuerreiroEsqueleto(300, 10, 5);
	Cavaleiro kg = new Cavaleiro(20, 30, 400);
	CalcularDano cd = new CalcularDano();
	
	Inimigos arrInimigos[] = {ge};
	
	
	public void menuBatalha() {
		
		do {
			
			int opcao;
			System.out.println("Guerreiro esqueleto\nHP" + ge.getVida());
			System.out.println("Cavaleiro\nHP" + kg.getVida());
			System.out.println("1-atacar\n2-itens\n3-satus");
			opcao = leia.nextInt();
			
			switch (opcao) {
			case 1: {
				int op;
				System.out.println("escolha um inimigo\n1-" + arrInimigos[0]);
				op = leia.nextInt();
				ge.setVida(arrInimigos[op-1].getVida() - cd.calculoDano(kg.getAtk(), arrInimigos[op-1].getDef()));
				kg.setVida(kg.getVida() - ge.getAtk());
				break;
			}
			
			default:
				throw new IllegalArgumentException("valor invalido: " + opcao);
			}
		
		} while (ge.getVida() != 0);
		
	}
}
