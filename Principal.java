import java.util.Scanner;

public class Principal{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrada para o labirinto (digite um valor de 0 à 4): ");
		int num1 = sc.nextInt();
		System.out.print("Ponto de partida em x: ");
		int num2 = sc.nextInt();
		System.out.print("Ponto de partida em y: ");
		int num3 = sc.nextInt();
		
		Maze labirinto = new Maze(num1);
		Caminho parede = new Parede();
		Caminho livre = new Livre();
		Caminho entrada = new Entrada();
		Caminho saida = new Saida();
		Caminho asterisco = new Asterisco();

		labirinto.soluciona();

		Object[][] objeto = new Object[10][10];
		objeto = labirinto.insere((Livre) livre, (Parede) parede, (Saida) saida, (Entrada) entrada);
		//labirinto.imprime();

		MazeSolver mazeSolver = new MazeSolver(objeto, (Parede) parede, (Entrada) entrada, (Livre) livre, (Saida) saida, (Asterisco) asterisco);
		mazeSolver.mazeRecursive(num2, num3, -1);
		mazeSolver.imprime();	
		//labirinto.imprimeTeste();	
	}
}