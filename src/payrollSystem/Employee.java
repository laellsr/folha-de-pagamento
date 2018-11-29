package payrollSystem;

import java.util.Scanner;

public class Employee
{
	int id;
	String name, address;
	int type; /* (1) hourly (2) salaried (3) salaried and commissioned */
	int salary; /* amount to be paid */
	float commissionPercentage = 0; /* if he is salaried */
	int syndicate=0;
	int timeCard=0;
	
	Scanner input = new Scanner( System.in );
	public void setEmployee()
	{
		setName(); setAddress(); setType(); setSalary(); setSyndicate();
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return id;
	}
	public void setName()
	{
		System.out.printf("Digite o nome do empregado:\n=> ");
		name = input.nextLine();
	}
	public String getName()
	{
		return name;
	}
	public void setAddress()
	{
		System.out.printf("Digite o endereco do empregado:\n=> ");
		address = input.nextLine();
	}
	public String getAddress()
	{
		return address;
	}
	public void setType()
	{
		System.out.printf("Digite o tipo de salario:\n"
				+ "[1] Horista\n[2] Assalariado\n[3] Assalariado e Comissionado\n=> ");
		type = input.nextInt(); input.nextLine();
	}
	public int getType()
	{
		return type;
	}
	public void setSalary()
	{
		System.out.printf("Digite o valor do salario:\n");
		salary = input.nextInt(); input.nextLine();
		
		if(type==3)
		{
			setCommission();
		}
	}
	public int getSalary()
	{
		return salary;
	}
	public void setCommission()
	{
		System.out.printf("Digite o valor da porcentagem de comissão por vendas:\n[Exemplo: 1,32]\n");
		commissionPercentage = input.nextFloat(); input.nextLine();
	}
	public float getCommission()
	{
		return commissionPercentage;
	}
	public void setSyndicate()
	{
		System.out.printf("Empregado pertence ao sindicato?\n[1] Sim [2] Nao\n=> ");
		syndicate = input.nextInt(); input.nextLine();
		if(syndicate!=1)
			syndicate = 0;
	}
	public int getSyndicate()
	{
		return syndicate;
	}
	public void setTimecard()
	{
		System.out.printf("Entrada dos cartões de ponto:\n=> ");
		timeCard = input.nextInt(); input.nextLine();
	}
	public int getTimecard()
	{
		return timeCard;
	}
}
