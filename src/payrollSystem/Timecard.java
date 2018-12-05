package payrollSystem;

import java.util.Scanner;
import java.lang.Math;

public class Timecard
{
	int workedDays=0;
	double workedHours=0, workedExtraHours=0;

	Scanner input = new Scanner( System.in );
	
	public void setTimecard()
	{
		int entryH=0, entryM=0, outH=0, outM=0;
		/*int day=0, month=0, year=0;*/
		double hourAux=0, minuteAux=0;
		
		/*System.out.printf("\nCartão de ponto:\nDigite o dia entre 1 e 31:\n=> ");
		day = input.nextInt(); input.nextLine();
		System.out.printf("Digite o mes entre 1 e 12:\n=> ");
		month = input.nextInt(); input.nextLine();
		System.out.printf("Digite o ano:\n=> ");
		year = input.nextInt(); input.nextLine(); */
		System.out.printf("Digite a hora de entrada entre 0 e 24:\n=> ");
		entryH = input.nextInt(); input.nextLine();
		System.out.printf("Digite os minutos:\n=> ");
		entryM = input.nextInt(); input.nextLine();
		System.out.printf("Digite a hora de saida entre 0 e 24:\n=> ");
		outH = input.nextInt(); input.nextLine();
		System.out.printf("Digite os minutos:\n=> ");
		outM = input.nextInt(); input.nextLine();
		
		workedDays++;
		minuteAux = Math.abs((outM-entryM));			
		hourAux += (outH - entryH) + (minuteAux/60);
		if(hourAux > 8)
		{
			workedHours += 8;
			workedExtraHours += hourAux - 8;
		}
		else
			workedHours += hourAux;
		
		System.out.printf("Horas trabalhadas: %.2f\n", hourAux);
	}
	
}
