package principal;

import java.util.Scanner;
import empregados.Empregado;
import java.util.ArrayList;

public class Main
{

	public static void main(String[] args)
	{
		int comando=1;
		Scanner scanner = new Scanner( System.in );
		ArrayList <Empregado> lista = new ArrayList <Empregado>();
		
		while(comando>0)
		{
			System.out.println(
					"Bem-vindo ao Sistema de Folha de Pagamentos\n\n" +
					"1 para adicionar um empregado\n" +
					"2 para remover um empregado\n" +
					"3 para lançar um cartão de ponto\n" +
					"4 para lançar um resultado venda\n" +
					"5 para lançar uma taxa de serviço\n" +
					"6 para alterar detalhes de um empregado\n" +
					"7 para rodar a folha de pagamento para hoje\n" +
					"8 para desfazer ou refazer uma opção\n" +
					"9 para agenda de pagamento\n" +
					"0 para terminar o programa...\n");
			System.out.printf("Insira o valor da opção desejada: ");
			
			comando = scanner.nextInt();
			
			System.out.printf("\n");
			
			switch(comando)
			{
				case 1:	
					Empregado novoEmpregado = new Empregado();
					novoEmpregado.setName();
					novoEmpregado.setEndereco();
					System.out.printf("%s de %s foi cadastrado como seu empregado!\n\n", novoEmpregado.nome, novoEmpregado.endereco);
					break;
				case 2:
	
					break;
				case 3:
	
					break;
				case 4:
	
					break;
				case 5:
	
					break;
				case 6:
	
					break;
				case 7:
	
					break;
				case 8:
			
					break;
				case 9:
					
					break;
			}
		}
		scanner.close();
	}

}
