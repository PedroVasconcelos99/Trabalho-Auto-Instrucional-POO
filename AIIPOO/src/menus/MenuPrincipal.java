package menus;

import java.util.Scanner;

public class MenuPrincipal {

	Scanner leia = new Scanner(System.in);
	MenuBatalha mb = new MenuBatalha();
	public void menuPrincipal() {
		int opcao;
		System.out.println("1-começar\n2-sair");
		opcao = leia.nextInt();
		
		do {
	
			if (opcao == 1) {
				mb.menuBatalha();
			} else if(opcao == 2) {
				System.out.println("Jogo encerrado");
				System.exit(0);
			}
			if (opcao <1 || opcao>2) {
				System.out.println("opção invalida");
			}
		} while (opcao <1 || opcao>2);		
	}
}
