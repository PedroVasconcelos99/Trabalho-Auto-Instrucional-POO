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
			System.out.println("Guerreiro esqueleto   Guerreiro esqueleto   Guerreiro esqueleto");
			System.out.println("HP" + arrAndar[andar][0].getVida() + "			HP" +arrAndar[andar][1].getVida() + "			HP" +arrAndar[andar][2].getVida());
//			System.out.println("Guerreiro esqueleto \nHP" + arrAndar[andar][1].getVida());
			System.out.println("\nCavaleiro\nHP" + kg.getVida());
			System.out.println("\n1-atacar 2-itens 3-satus");
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
		System.out.println("=============================================================================================");
		System.out.println("escolha um inimigo\n1-" + arrAndar[andar][0].getNome()+"\n2-" + arrAndar[andar][0].getNome());
		op = leia.nextInt();
		//checa se o ataque do heroi acertou, caso tenha acertado reduz a vida do inimigo;
		if (ca.check() ==1) {
			System.out.println("errou");
		} else if(ca.check()==2) {
			System.out.println("DANO TOTAL cavaleiro" + cd.calculoDano(kg.getAtk(), arrAndar[andar][op-1].getDef()));
			arrAndar[andar][0].setVida(arrAndar[andar][op-1].getVida() - cd.calculoDano(kg.getAtk(), arrAndar[andar][op-1].getDef()));				
		} else if(ca.check() == 3) {
			System.out.println("acerto critico");
			System.out.println("DANO TOTAL cavaleiro" +cd.calculoDano(kg.getAtk()*2, arrAndar[andar][op-1].getDef()));
			arrAndar[andar][0].setVida(arrAndar[andar][op-1].getVida() - cd.calculoDano(kg.getAtk()*2, arrAndar[andar][op-1].getDef()));
		}
		
		//verificar se o inimigo morreu antes de executar uma ação
		for (int i = 0; i < 3; i++) {
			if (arrAndar[andar][i].getVida()>0) {
				//verifica se o ataque inimigo acertou
				if (ca.check() == 1) {
					System.out.println(arrAndar[andar][i].getNome() + (i+1) + " errou");
				} else if(ca.check()==2) {
					System.out.println(arrAndar[andar][i].getNome() + (i+1) + " acertou");
					System.out.println("DANO TOTAL inimigo " + cd.calculoDano(arrAndar[andar][i].getAtk(), kg.getDef()));
					kg.setVida(kg.getVida() - cd.calculoDano(arrAndar[andar][i].getAtk(), kg.getDef()));
				} else if(ca.check()==3) {
					System.out.println(arrAndar[andar][i].getNome() + (i+1) + " acerto critico ");
					System.out.println("DANO TOTALinimigo " + cd.calculoDano(arrAndar[andar][i].getAtk()*2, kg.getDef()));
					kg.setVida(kg.getVida() - cd.calculoDano(arrAndar[andar][i].getAtk(), kg.getDef()));
				}
			} else {
				arrAndar[andar][i] = null;
			}
			
		}
	}
}
