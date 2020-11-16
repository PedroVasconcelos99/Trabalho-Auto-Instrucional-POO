package menus;

import java.util.Scanner;

public class MenuPrincipal {

	Scanner leia = new Scanner(System.in);
	MenuBatalha mb = new MenuBatalha();
	public void menuPrincipal() {
		int opcao;
		System.out.println("1-começar\n2-sair");
		opcao = leia.nextInt();
		
		if (opcao == 1) {
			System.out.println("1° Andar");
			mb.menuBatalha();
		} 
	}
}
