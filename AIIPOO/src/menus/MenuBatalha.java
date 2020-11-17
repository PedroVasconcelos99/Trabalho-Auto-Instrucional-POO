package menus;

import java.util.Scanner;
import enemies.*;
import heroes.*;
import utilities.*;

public class MenuBatalha {
	//inicializando as classes
	Scanner leia = new Scanner(System.in);
	GuerreiroEsqueleto ge = new GuerreiroEsqueleto();
	Cavaleiro kg = new Cavaleiro();
	CalcularDano cd = new CalcularDano();
	ChecarAcerto ca = new ChecarAcerto();
	
//	vetores com os inimigos para cada andar
	Inimigos arrInimigos[] = {ge,ge};
	

	public void menuBatalha() {
		do {

			int opcao;
			System.out.println("Guerreiro esqueleto\nHP" + arrInimigos[0].getVida());
			System.out.println("Guerreiro esqueleto \nHP" + arrInimigos[1].getVida());
			System.out.println("Cavaleiro\nHP" + kg.getVida());
			System.out.println("1-atacar 2-itens 3-satus");
			opcao = leia.nextInt();
			
			switch (opcao) {
			case 1: {
				batalha();
				break;
			}
			
			default:
				throw new IllegalArgumentException("valor invalido: " + opcao);
			}
		
		
		
		} while (ge.getVida() != 0|| kg.getVida() == 0);
		
	}
	
	
	void batalha() {
		int op;
		System.out.println("escolha um inimigo\n1-" + arrInimigos[0].getNome()+"\n2-" + arrInimigos[1].getNome());
		op = leia.nextInt();
		//checa se o ataque do heroi acertou, caso tenha acertado reduz a vida do inimigo;
		if (ca.check() ==1) {
			System.out.println("errou");
		} else if(ca.check()==2) {
			ge.setVida(arrInimigos[op-1].getVida() - cd.calculoDano(kg.getAtk(), arrInimigos[op-1].getDef()));				
		} else {
			System.out.println("acerto critico");
			ge.setVida(arrInimigos[op-1].getVida() - cd.calculoDano(kg.getAtk()*2, arrInimigos[op-1].getDef()));
		}
		
		//verificar se o inimigo morreu antes de executar uma ação
		if (ge.getVida()>0) {
		//verifica se o ataque inimigo acertou
			if (ca.check() ==1) {
				System.out.println(arrInimigos[1].getNome() + "errou");
			} else if(ca.check()==2) {
				kg.setVida(cd.calculoDano(ge.getAtk(), kg.getDef()));
			} else {
				System.out.println("acerto critico");
				kg.setVida(cd.calculoDano(ge.getAtk(), kg.getDef()));
			}
		}
	}
}
