package menus;

import java.util.Scanner;

public class MenuPrincipal {

	Scanner leia = new Scanner(System.in);
	MenuBatalha mb = new MenuBatalha();
	public void menuPrincipal() {
		int opcao;
		boolean valido;
		
		do {
			try {
				System.out.println("1-come�ar\n2-sair");
				do {
					opcao = leia.nextInt();
					
					if (opcao == 1) {
						mb.menuBatalha();
					} else if(opcao == 2) {
						System.out.println("Jogo encerrado");
						System.exit(0);
					}
					if (opcao <1 || opcao>2) {
						System.out.println("op��o invalida");
					}
				} while (opcao < 1 || opcao>2);
				valido = true;
			} catch (Exception e) {
				System.out.println("MENU op��o inv�lida utilize apenas numeros");
				valido = false;
			}
			leia.next();
		} while (!valido);
	}
}
