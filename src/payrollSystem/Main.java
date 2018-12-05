package payrollSystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;

public class Main
{

	public static void main(String[] args)
	{
		Calendar today = Calendar.getInstance();
		boolean active = true;
		int decision, id=0, syndicateId=0, aux, index; String okay;
		//ArrayList<Syndicate> syndicate = new ArrayList<Syndicate>();
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Scanner input = new Scanner( System.in );
		while(active)
		{
			System.out.printf(
					"Bem-vindo ao Sistema Folha de Pagamentos\n"
					+ "Hoje: %d/%d/%d\n\n" +
					"[1] adicionar um empregado\n" +
					"[2] remover um empregado\n" +
					"[3] lançar um cartao de ponto\n" +
					"[4] lançar um resultado venda\n" +
					"[5] lançar uma taxa de serviço\n" +
					"[6] alterar detalhes de um empregado\n" +
					"[7] rodar a folha de pagamento para hoje\n" +
					"[8] desfazer ou refazer uma opcao\n" +
					"[9] nova agenda de pagamento\n" +
					"[0] terminar o programa\n", today.get(Calendar.DAY_OF_MONTH), today.get(Calendar.MONTH), today.get(Calendar.YEAR));
			System.out.printf("Insira o valor da opção desejada:\n=> ");
			
			decision = input.nextInt(); input.nextLine();
			
			System.out.printf("\n");
			
			switch(decision)
			{
				case 0:
					active = false;
					break;
				
				case 1:	/* adicionar um empregado */
					id++;
					Employee newEmployee = new Employee();
					newEmployee.setId(id);
					newEmployee.setEmployee();
					if(newEmployee.getSyndicate()>1)
					{
						syndicateId++; newEmployee.syndicateId=syndicateId;
					}
					employees.add(newEmployee);
					System.out.printf("\nEmpregado adicionado!\nID: %s. Nome: %s.\n", newEmployee.id, newEmployee.name);
					if(newEmployee.syndicateId>-1)
						System.out.printf("ID de Sindicato: %s\n", newEmployee.syndicateId);
					System.out.printf("\n[1] Continue:\n=> ");
					okay = input.nextLine();
					break;
				
				case 2: /* remover um empregado */
					showEmployee(employees);
					System.out.printf("Digite a ID do empregado:\n=> ");
					aux = input.nextInt(); input.nextLine();
					index = indexEmployee(employees, aux);
					if(index==-1)
					{
						System.out.printf("\nID invalida.\n[1] Continue:\n=> ");
						okay = input.nextLine();
						break;
					}
					employees.remove(index);
					System.out.printf("Empregado removido do sistema.\n[1] Continue:\n=> ");
					input.nextLine();
					break;
				case 3: /* lançar um cartao de ponto */
					showEmployee(employees);
					System.out.printf("Digite a ID do empregado:\n=> ");
					aux = input.nextInt(); input.nextLine();
					index = indexEmployee(employees, aux);
					if(index==-1)
					{
						System.out.printf("\nID invalida.\n[1] Continue:\n=> ");
						okay = input.nextLine();
						break;
					}
					today.add(Calendar.DAY_OF_MONTH, 1);
					employees.get(index).timecard.setTimecard();
					System.out.printf("\nAdicionado!\n[1] Continue:\n=> ");
					okay = input.nextLine();
					break;
				case 4: /* lançar um resultado venda */
					showEmployee(employees);
					System.out.printf("Digite a ID do empregado:\n=> ");
					aux = input.nextInt(); input.nextLine();
					index = indexEmployee(employees, aux);
					if(index==-1)
					{
						System.out.printf("\nID invalida.\n[1] Continue:\n=> ");
						okay = input.nextLine();
						break;
					}
					employees.get(index).setSales();
					break;
				case 5: /* lançar uma taxa de serviço */
					showSyndicate(employees);
					System.out.printf("Digite a ID de Sindicato do empregado:\n=> ");
					aux = input.nextInt(); input.nextLine();
					index = indexSyndicate(employees, aux);
					if(index==-1)
					{
						System.out.printf("\nID de Sindicato invalida.\n[1] Continue:\n=> ");
						okay = input.nextLine();
						break;
					}
					Tax tax = new Tax();
					tax.setTax();
					employees.get(index).taxes.add(tax);
					break;
				case 6: /* alterar detalhes de um empregado */
					showEmployee(employees);
					System.out.printf("Digite a ID do empregado:\n=> ");
					aux = input.nextInt(); input.nextLine();
					index = indexEmployee(employees, aux);
					if(index==-1)
					{
						System.out.printf("\nID invalida.\n[1] Continue:\n=> ");
						okay = input.nextLine();
						break;
					}
					boolean case6b = true;
					while(case6b)
					{
						System.out.printf("\nEmpregado selecionado. Editar:\n"
								+ "[1] Nome\n"
								+ "[2] Endereco\n"
								+ "[3] Tipo\n"
								+ "[4] Salario\n"
								+ "[5] Metodo de Pagamento\n"
								+ "[6] Sindicato (participar/trocar id)\n"
								+ "[7] Taxas do Sindicato\n"
								+ "[8] Voltar\nInsira o valor da opcao desejada:\n=> ");
						int case6 = input.nextInt(); input.nextLine();
						switch(case6)
						{
							case 1:
								employees.get(index).setName();
								break;
							case 2:
								employees.get(index).setAddress();
								break;
							case 3:
								employees.get(index).setType();
								employees.get(index).setSalary();
								break;
							case 4:
								employees.get(index).setSalary();
								break;
							case 5:
								employees.get(index).setPayment();
								break;
							case 6:
								if(employees.get(index).syndicateId>0)
								{
									System.out.printf("Empregado pertece ao Sindicato.\n Remove-lo?\n[1] Sim [2] Nao\n=> ");
									int decisionAux = input.nextInt(); input.nextLine();
									if(decisionAux==1)
									{
										employees.get(index).syndicateId = -1;
										employees.get(index).taxes.clear();
										System.out.printf("Empregado removido do Sindicato e das suas taxas de servico.\n");
										break;
									}
									else
									{
										System.out.printf("Deseja trocar ID de Sindicato?\n[1] Sim [2] Nao");
										decisionAux = input.nextInt(); input.nextLine();
										if(decisionAux==1)
										{
											System.out.printf("Digite um novo ID de numeros:\n=> ");
											decisionAux = input.nextInt(); input.nextLine();
											int a = indexSyndicate(employees, decisionAux);
											if(a==-1)
											{
												employees.get(index).syndicateId = decisionAux;
												System.out.printf("ID adicionado.\n[1] Continue\n=> ");
												input.nextLine();
												break;
											}
											System.out.printf("ID ja em uso.\n[1] Continue\n=> ");
											input.nextLine();
											break;
										}
									}
								}
						
						case 7: /*  */
							for(int i=0; i < employees.get(index).taxes.size(); i++)
								System.out.printf("[%s] Nome: %s. Valor: %s.\n", i, employees.get(index).taxes.get(i).name, employees.get(index).taxes.get(i).taxValue);
							System.out.printf("Digite a opcao:\n=> ");
							int decisionAux = input.nextInt(); input.nextLine();
							for(int i=0; i < employees.get(index).taxes.size(); i++)
								if(decisionAux == i)
									employees.get(index).taxes.get(i).setTax();
							break;
						case 8: /*  */
							case6b = false;
							break;
							
						}
					break;
				}
				case 7: /* rodar a folha de pagamento para hoje */
					System.out.printf("Hoje:\n");
					double subtotal, taxes, less;
					for(int i=0; i < employees.size(); i++)
					{
						subtotal=0; taxes=0; less=0;
						if(employees.get(i).agendaType==1)
						{
							if(employees.get(i).timecard.workedDays >= 7)
							{
								System.out.printf("Folha de pagamento:\n");
								System.out.printf("ID do empregado: %s. Nome: %s.\n", employees.get(i).id, employees.get(i).name);
								if(employees.get(i).syndicateId>0)
									System.out.printf("ID de Sindicato: %s\n", employees.get(i).syndicateId);
								if(employees.get(i).paymentMethod==1)
								{
									System.out.printf("Valor por hora trabalhada: R$ %s\n", employees.get(i).salary);
									System.out.printf("Quantidade de horas trabalhadas: %s\n", employees.get(i).timecard.workedHours);
									subtotal += employees.get(i).timecard.workedHours*employees.get(i).salary;
									System.out.printf("Subtotal 1: R$ %.2f\n", subtotal);
					
								}
								System.out.printf("Total de vendas: R$ %.2f.\n", employees.get(i).sales);
								System.out.printf("\n");
							}
						}
					}
	
					break;
				case 8: /* desfazer ou refazer uma opcao */
			
					break;
				case 9: /* agenda de pagamento */
					showEmployee(employees);
					System.out.printf("Digite a ID do empregado:\n=> ");
					aux = input.nextInt(); input.nextLine();
					index = indexEmployee(employees, aux);
					if(index==-1)
					{
						System.out.printf("\nID invalida.\n[1] Continue:\n=> ");
						okay = input.nextLine();
						break;
					}
					break;
			}
			
		}
		input.close();
	}
	public static void showEmployee(ArrayList<Employee> employees)
	{
		System.out.printf("Empregados:\n\n");
		for(int i=0; i < employees.size(); i++)
		{
			System.out.printf("ID do empregado: %s. Nome: %s.\n", employees.get(i).id, employees.get(i).name);
			if(employees.get(i).syndicateId>0)
				System.out.printf("ID de Sindicato: %s\n", employees.get(i).syndicateId);
			System.out.printf("Dias Trabalhados: %s / Total de vendas: R$ %.2f.\n", employees.get(i).timecard.workedDays, employees.get(i).sales);
			System.out.printf("\n");
		}
	}
	public static int indexEmployee(ArrayList<Employee> employees, int id)
	{
		for(int i=0; i < employees.size(); i++)
			if(employees.get(i).id == id)
				return i;
			
		return -1;
	}
	public static void showSyndicate(ArrayList<Employee> employees)
	{
		System.out.printf("Empregados membros do sindicato:\n\n");
		for(int i=0; i < employees.size(); i++)
		{
			if(employees.get(i).syndicateId>0)
			{
				System.out.printf("ID: %s. Nome: %s.\n", employees.get(i).id, employees.get(i).name);
				System.out.printf("ID de Sindicato: %s\n", employees.get(i).syndicateId);
				System.out.printf("\n");
			}
		}
	}
	public static int indexSyndicate(ArrayList<Employee> employees, int syndicateID)
	{
		for(int i=0; i < employees.size(); i++)
			if(employees.get(i).syndicateId == syndicateID)
				return i;

		return -1;
	}

}
