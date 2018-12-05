package payrollSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee
{
	int id;
	String name, address;
	int type; /* (1) hourly (2) salaried (3) salaried and commissioned */
	String typeName;
	double salary; /* amount to be paid */
	int paymentMethod=0; /* (1) post office (2) in cash (3) bank deposit */
	String payment;
	float commissionPercentage = 0; /* if he is salaried and commissioned */
	int syndicateId=-1; double syndicateTax=0;
	Timecard timecard = new Timecard();
	double sales=0;
	
	ArrayList<Tax> taxes = new ArrayList<Tax>();
	
	int payday=-1, agendaType; /* day of payment, agenda type (1 per week, 2 per month, 3 bi-weekly)*/
	
	Scanner input = new Scanner( System.in );
	public void setEmployee()
	{
		setName(); setAddress(); setType(); setSalary(); setPayment(); setAgendaType(); setSyndicate();
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
		if(type==1)
			typeName = "Horista";
		else if(type==2)
			typeName = "Assalariado sem comissao";
		typeName = "Assalariado e Comissionado";
	}
	public int getType()
	{
		return type;
	}
	public void setSalary()
	{
		System.out.printf("Digite o valor do salario (mensal/horista) [Ex.: 1280,31]:\n=> R$ ");
		salary = input.nextDouble(); input.nextLine();
		
		if(type==3)
		{
			setCommission();
		}
	}
	public double getSalary()
	{
		return salary;
	}
	public void setCommission()
	{
		System.out.printf("Digite o valor da porcentagem de comissao por vendas:\n[Exemplo: 1,32]\n");
		commissionPercentage = input.nextFloat(); input.nextLine();
	}
	public float getCommission()
	{
		return commissionPercentage;
	}
	public void setSyndicate()
	{
		System.out.printf("Empregado pertence ao sindicato?\n[1] Sim [2] Nao\n=> ");
		syndicateId = input.nextInt(); input.nextLine();
		if(syndicateId!=1)
			syndicateId=-1;
		else
			setSyndicateTax();
	}
	public int getSyndicate()
	{
		return syndicateId;
	}
	public void setSales()
	{
		double aux=0;
		System.out.printf("Digite o valor da venda (ex.: 12,37)\n=> R$ ");
		aux = input.nextDouble(); input.nextLine();
		this.sales += aux;
		System.out.printf("Venda adicionada ao empregado.\n[1] Continue:\n=> ");
		input.nextLine();
	}
	public void setPayment()
	{
		System.out.printf("Metodo de pagamento:\n[1] Cheque pelos correios\n[2] Cheque em maos\n[3] Deposito em conta bancaria\n=> ");
		paymentMethod = input.nextInt(); input.nextLine();
		if(paymentMethod==1)
			payment = "Cheque pelos correios";
		else if(paymentMethod==2)
			payment = "Cheque em maos";
		payment = "Deposito em conta bancaria";
	}
	public void setAgendaType()
	{
		System.out.printf("Agenda de pagamento:\n[1] Semanal\n[2] Mensal\n[3] Bi-semanal\n");
		agendaType = input.nextInt(); input.nextLine();
	}
	public void setSyndicateTax()
	{
		System.out.printf("Digite a taxa basica do Sindicato (Ex.: 123,45):\n=> R$ ");
		syndicateTax = input.nextDouble(); input.nextLine();
	}
	public void setSyndicateId(int sId)
	{
		this.syndicateId = sId;
	}

}
