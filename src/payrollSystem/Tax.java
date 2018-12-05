package payrollSystem;

import java.util.Scanner;

public class Tax
{
	String name;
	double taxValue=0;
	
	Scanner input = new Scanner( System.in );
	
	public void setTax()
	{
		System.out.printf("Digite o nome do servico:\n=> ");
		name = input.nextLine();
		System.out.printf("Digite o valor da taxa:\n=> ");
		taxValue = input.nextDouble();
		System.out.printf("Taxa adicionada.\n[1] Continue\n=> ");
		input.nextLine();
	}
}
