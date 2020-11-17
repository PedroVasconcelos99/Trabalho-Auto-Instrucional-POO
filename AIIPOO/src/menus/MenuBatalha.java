package menus;

import java.util.Scanner;
import enemies.*;
import heroes.*;
import utilities.*;

public class MenuBatalha {
	//inicializando as classes
	Scanner leia = new Scanner(System.in);
	GuerreiroEsqueleto ge1 = new GuerreiroEsqueleto();
	GuerreiroEsqueleto ge2 = new GuerreiroEsqueleto();
	GuerreiroEsqueleto ge3 = new GuerreiroEsqueleto();
	Cavaleiro kg = new Cavaleiro();
	CalcularDano cd = new CalcularDano();
	ChecarAcerto ca = new ChecarAcerto();
	
	int andar =0;
	
//	vetores com os inimigos para cada andar
//	Inimigos arrInimigos[] = {ge1,ge2,ge3};
	Inimigos arrAndar[][] = {{ge1,ge2,ge3}};
	

	public void menuBatalha() {
		do {

			int opcao;
			System.out.println("Guerreiro esqueleto\nHP" + arrAndar[andar][0].getVida());
			System.out.println("Guerreiro esqueleto \nHP" + arrAndar[andar][1].getVida());
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
		
		
		
		} while (arrAndar[andar][0].getVida() != 0|| kg.getVida() == 0);
		
	}
	
	
	void batalha() {
		int op;
		System.out.println("escolha um inimigo\n1-" + arrAndar[andar][0].getNome()+"\n2-" + arrAndar[andar][0].getNome());
		op = leia.nextInt();
		//checa se o ataque do heroi acertou, caso tenha acertado reduz a vida do inimigo;
		if (ca.check() ==1) {
			System.out.println("errou");
		} else if(ca.check()==2) {
			arrAndar[andar][0].setVida(arrAndar[andar][op-1].getVida() - cd.calculoDano(kg.getAtk(), arrAndar[andar][op-1].getDef()));				
		} else {
			System.out.println("acerto critico");
			arrAndar[andar][0].setVida(arrAndar[andar][op-1].getVida() - cd.calculoDano(kg.getAtk()*2, arrAndar[andar][op-1].getDef()));
		}
		
		//verificar se o inimigo morreu antes de executar uma ação
		if (arrAndar[andar][0].getVida()>0) {
		//verifica se o ataque inimigo acertou
			if (ca.check() ==1) {
				System.out.println(arrAndar[andar][0].getNome() + "errou");
			} else if(ca.check()==2) {
				kg.setVida(kg.getVida() - cd.calculoDano(arrAndar[andar][0].getAtk(), kg.getDef()));
			} else {
				System.out.println("acerto critico inimigo");
				kg.setVida(kg.getVida() - cd.calculoDano(arrAndar[andar][0].getAtk(), kg.getDef()));
			}
		}
	}
}
