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
	GuerreiroEsqueleto ge4 = new GuerreiroEsqueleto();
	GuerreiroEsqueleto ge5 = new GuerreiroEsqueleto();
	Orc o1 = new Orc();
	Orc o2 = new Orc();
	Feiticeiro f1 = new Feiticeiro();
	Feiticeiro f2 = new Feiticeiro();
	Boss b1 = new Boss();
	Cavaleiro kg = new Cavaleiro();
	Paladino pl = new Paladino();
	Mago mg = new Mago();
	CalcularDano cd = new CalcularDano();
	GeradorAleatorio ca = new GeradorAleatorio();
	int alvo = ca.alvoAleatorio();
	int andar =0;
	
//	vetores com os inimigos para cada andar
	Inimigos arrAndar[][] = {{ge1,ge2,ge3},{o1,o2,f1},{f2,ge4,ge5},{b1}};
	Heroi arrHerois[] = {kg,pl,mg};
	

	public void menuBatalha() {
		int cooldown = 0;
		do {
			int opcao;
			System.out.println("=============================================================================================");
			System.out.println("Guerreiro esqueleto    Guerreiro esqueleto    Guerreiro esqueleto");
			System.out.println("HP" + arrAndar[andar][0].getVida() + "			HP" +arrAndar[andar][1].getVida() + "			HP" +arrAndar[andar][2].getVida());
			System.out.println("\nTOTAL" + totalVidaInimigos());
			for (int i = 0; i < arrHerois.length; i++) {
				System.out.print("\n" + arrHerois[i].getNome() +"\nHP" + arrHerois[i].getVida());
				
			}
			
			do {
				
				System.out.println("\n1-atacar 2-satus 3-especial");
				opcao = leia.nextInt();
				if (opcao < 0 || opcao > 3) {
					System.out.println("opção invalida");
				}
			} while (opcao < 0 || opcao > 3);
			
			switch (opcao) {
			case 1: {
				batalha();
				break;
			}
			
			case 2: {
				for (int i = 0; i < arrHerois.length; i++) {
					System.out.println(arrHerois[i].toString());
				}
				break;
			}
			case 3: {
				habilidadeEspecial();
				break;
			}
			
			default:
				throw new IllegalArgumentException("valor invalido: " + opcao);
			}
			
		
		} while (totalVidaInimigos() != 0|| totalVidaHerois()== 0);
		if(totalVidaInimigos() == 0) {
			System.out.println("Passou de fase");
			andar++;
		}
		if(totalVidaHerois()== 0) {
			System.out.println("GAME OVER");
		}
		if (andar == 5) {
			System.out.println("PAREBENS");
		}
		
		
	}
	int totalVidaInimigos(){ 
		int total = 0;
		for (int i = 0; i < 3; i++) {
			total += arrAndar[andar][i].getVida();
		}
		return total;
	}
	int totalVidaHerois(){ 
		int total = 0;
		for (int i = 0; i < arrHerois.length; i++) {
			total += arrHerois[i].getVida();
		}
		return total;
	}
	
	
	void habilidadeEspecial() {
		int op;
		do {
				
			System.out.println("escolha o heroi");
			
			  for (int i = 0; i < arrHerois.length; i++) { 
				  //imprimir array de seleção dos herois
				  if (arrHerois[i].getCooldown() == 0) {
					  System.out.println(i+1 + "-" + arrHerois[i].getNome());						
				}
			  }
			 
			op = leia.nextInt();
			if (op<1 || op >3) {
				System.out.println("opção invalida");
			}		
		} while (op<1 || op >3);
		switch (op) {
		case 1: {
			if (kg.getCooldown() == 0) {
				kg.especial();						
			}
			kg.setCooldown(5);
			break;
		}
		case 2: {
			if (pl.getCooldown() == 0) {
				pl.especial(kg,mg);						
			}
			pl.setCooldown(4);
			break;
		}
		case 3: {
			if (mg.getCooldown() == 0) {
				mg.especial(kg,pl);						
			}
			mg.setCooldown(6);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
	}
	
	
	void batalha() {
		int opInimigo;
		int opHeroi;
		//imprime a escolha de inimigos para atacar
		System.out.println("=============================================================================================");
		
		do {
			do {
				
				System.out.println("escolha quem irá atacar");
				for (int i = 0; i < arrHerois.length; i++) {
					if (arrHerois[i].getVida()>0) {
						System.out.println(i+1 + "-" + arrHerois[i].getNome());				
					}
				}
				opHeroi = leia.nextInt();
				
				if (opHeroi < 1 || opHeroi>3) {
					System.out.println("opção invalida");
				}
			} while (opHeroi < 1 || opHeroi>3);
			if (arrHerois[opHeroi-1].getVida()<0) {
				System.out.println("heroi incapacitado");
			}
		} while (arrHerois[opHeroi-1].getVida()<0);
		
		
		
		do {
			System.out.println("escolha um inimigo");
			for (int i = 0; i < arrAndar[andar].length; i++) {
				if (arrAndar[andar][i].getVida()>0) {
					System.out.println(i+1 + "-" + arrAndar[andar][i].getNome());				
				}
			}
				
			opInimigo = leia.nextInt();
			if (arrAndar[andar][opInimigo-1].getVida()<0) {
				System.out.println("inimigo não existe");
			}
		} while (arrAndar[andar][opInimigo-1].getVida()<0);
		
		
		//checa se o ataque do heroi acertou, caso tenha acertado reduz a vida do inimigo;
		if (ca.check() <= 10) {
			System.out.println("errou");
		} else if(ca.check() <=19) {
			System.out.println("DANO TOTAL cavaleiro" + cd.calculoDano(arrHerois[opHeroi-1].getAtk(), arrAndar[andar][opInimigo-1].getDef()));
			arrAndar[andar][0].setVida(arrAndar[andar][opInimigo-1].getVida() - cd.calculoDano(arrHerois[opHeroi-1].getAtk(), arrAndar[andar][opInimigo-1].getDef()));				
		} else if(ca.check() == 20) {
			System.out.println("acerto critico");
			System.out.println("DANO TOTAL cavaleiro" +cd.calculoDano(arrHerois[opHeroi-1].getAtk()*2, arrAndar[andar][opInimigo-1].getDef()));
			arrAndar[andar][0].setVida(arrAndar[andar][opInimigo-1].getVida() - cd.calculoDano(arrHerois[opHeroi-1].getAtk()*2, arrAndar[andar][opInimigo-1].getDef()));
		}
		
//		Impede que a vida dos inimigos fique negativa
		if (arrAndar[andar][opInimigo-1].getVida()<0) {
			arrAndar[andar][opInimigo-1].setVida(0);
		}
		
		//verificar se o inimigo morreu antes de executar uma ação
		for (int i = 0; i < arrAndar[andar].length; i++) {
			if (arrAndar[andar][i].getVida()>0) {
				//verifica se o ataque inimigo acertou
				if (ca.check() <= 10) {
					System.out.println(arrAndar[andar][i].getNome() + (i+1) + " errou");
				} else if(ca.check() <= 19) {
					System.out.println(arrAndar[andar][i].getNome() + (i+1) + " acertou");
					System.out.println("DANO TOTAL inimigo " + cd.calculoDano(arrAndar[andar][i].getAtk(), arrHerois[alvo].getDef()));
					arrHerois[alvo].setVida(arrHerois[alvo].getVida() - cd.calculoDano(arrAndar[andar][i].getAtk(), arrHerois[alvo].getDef()));
				} else if(ca.check() == 20) {
					System.out.println(arrAndar[andar][i].getNome() + (i+1) + " acerto critico ");
					System.out.println("DANO TOTALinimigo " + cd.calculoDano(arrAndar[andar][i].getAtk()*2, arrHerois[alvo].getDef()));
					arrHerois[alvo].setVida(arrHerois[alvo].getVida() - cd.calculoDano(arrAndar[andar][i].getAtk(), arrHerois[alvo].getDef()));
				}
			}
//			Impede que a vida dos herois fique negativa
			if (arrHerois[i].getVida()<0) {
				arrHerois[i].setVida(0);
			}
		}
		//reduz o valor do cooldown de um Heroi que esteja com o cooldown maior que 0
		for (int i = 0; i < arrHerois.length; i++) {
			if (arrHerois[i].getCooldown()>0) {
				arrHerois[i].setCooldown(arrHerois[i].getVida()-1);
			}
		}
		
		
	}
}
