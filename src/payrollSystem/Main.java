package payrollSystem;

import java.util.Scanner;
import java.util.ArrayList;

public class Main
{

	public static void main(String[] args)
	{
		boolean active = true;
		int decision, id=0, aux, index; String okay;
		//ArrayList<Syndicate> syndicate = new ArrayList<Syndicate>();
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Scanner input = new Scanner( System.in );
		while(active)
		{
			System.out.println(
					"Bem-vindo ao Sistema Folha de Pagamentos\n\n" +
					"[1] para adicionar um empregado\n" +
					"[2] para remover um empregado\n" +
					"[3] para lançar um cartão de ponto\n" +
					"[4] para lançar um resultado venda\n" +
					"[5] para lançar uma taxa de serviço\n" +
					"[6] para alterar detalhes de um empregado\n" +
					"[7] para rodar a folha de pagamento para hoje\n" +
					"[8] para desfazer ou refazer uma opção\n" +
					"[9] para agenda de pagamento\n" +
					"[0] para terminar o programa...\n");
			System.out.printf("Insira o valor da opção desejada:\n=> ");
			
			decision = input.nextInt(); input.nextLine();
			
			System.out.printf("\n");
			
			switch(decision)
			{
				case 0:
					active = false;
					break;
				
				case 1:	
					id++;
					Employee newEmployee = new Employee();
					newEmployee.setId(id);
					newEmployee.setEmployee();
					employees.add(newEmployee);
					System.out.printf("\nEmpregado adicionado!\nID: %s\nNome: %s\n\n", newEmployee.id, newEmployee.name);
					System.out.printf("[1] Continue:\n=> ");
					okay = input.nextLine();
					break;
				
				case 2:
					
					break;
				case 3:
					System.out.printf("\nEmpregados:");
					for(int i=0; i < employees.size(); i++)
						System.out.printf("ID: %s\nNome: %s\n\n", employees.get(i).id, employees.get(i).name);
				
					System.out.printf("Digite a ID do empregado:\n=> ");
					aux = input.nextInt(); input.nextLine();
					
					index = -1;
					for(int i=0; i < employees.size(); i++)
					{
						if(employees.get(i).id == aux)
						{
							index = i; break;
						}
					}
					
					if(index==-1)
					{
						System.out.printf("\nID invalida.\n[1] Continue:\n=> ");
						okay = input.nextLine();
						break;
					}
					
					employees.get(index).setTimecard();
					System.out.printf("\nAdicionado!\n[1] Continue:\n=> ");
					okay = input.nextLine();
					break;
				case 4:
	
					break;
				case 5:
	
					break;
				case 6:
					System.out.printf("\nEmpregados:");
					for(int i=0; i < employees.size(); i++)
						System.out.printf("ID: %s\nNome: %s\n\n", employees.get(i).id, employees.get(i).name);
				
					System.out.printf("Digite a ID do empregado:\n=> ");
					aux = input.nextInt(); input.nextLine();
					
					index = -1;
					for(int i=0; i < employees.size(); i++)
					{
						if(employees.get(i).id == aux)
						{
							index = i; break;
						}
					}
					
					if(index==-1)
					{
						System.out.printf("\nID invalida.\n[1] Continue:\n=> ");
						okay = input.nextLine();
						break;
					}
					System.out.printf("\nEmpregado selecionado. Editar:\n"
							+ "[1] Nome\n"
							+ "[2] Endereco\n"
							+ "[3] Tipo\n"
							+ "[4] Salario\n"
							+ "[5] Metodo de Pagamento\n"
							+ "[6] Sindicato\n"
							+ "");
					break;
				case 7:
	
					break;
				case 8:
			
					break;
				case 9:
					
					break;
			}
			
		}
		input.close();
	}

}
