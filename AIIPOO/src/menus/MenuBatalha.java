package menus;

import java.util.Scanner;
import enemies.*;
import heroes.*;
import utilities.*;

public class MenuBatalha {
	Scanner leia = new Scanner(System.in);
	GuerreiroEsqueleto ge = new GuerreiroEsqueleto();
	Cavaleiro kg = new Cavaleiro();
	CalcularDano cd = new CalcularDano();
	ChecarAcerto ca = new ChecarAcerto();
	
	Inimigos arrInimigos[] = {ge,ge};
	
	
	public void menuBatalha() {
		
		
		do {
			batalha();
		} while (ge.getVida() != 0|| kg.getVida() == 0);
		
	}
	
	
	void batalha() {
		int opcao;
		System.out.println("Guerreiro esqueleto\nHP" + arrInimigos[0].getVida());
		System.out.println("Guerreiro esqueleto\nHP" + arrInimigos[1].getVida());
		System.out.println("Cavaleiro\nHP" + kg.getVida());
		System.out.println("1-atacar\n2-itens\n3-satus");
		opcao = leia.nextInt();
		
		switch (opcao) {
		case 1: {
			int op;
			System.out.println("escolha um inimigo\n1-" + arrInimigos[0].getNome()+"\n2-" + arrInimigos[1].getNome());
			op = leia.nextInt();
			if (ca.check() ==1) {
				System.out.println("errou");
			} else if(ca.check()==2) {
				ge.setVida(arrInimigos[op-1].getVida() - cd.calculoDano(kg.getAtk(), arrInimigos[op-1].getDef()));				
			} else {
				ge.setVida(arrInimigos[op-1].getVida() - cd.calculoDano(kg.getAtk()*2, arrInimigos[op-1].getDef()));
			}
			kg.setVida(kg.getVida() - ge.getAtk());
			break;
		}
		
		default:
			throw new IllegalArgumentException("valor invalido: " + opcao);
		}
	
	
	}
}
