package empregados;

public class Empregado
{
	public String nome;
	public String endereco;
	public int tipo; /* 1 assalariado 2 horista 3 comissionado */
	public int id;
	public int salario;
	
	java.util.Scanner input = new java.util.Scanner(System.in);
	
	public void setName()
	{
		System.out.printf("Digite o nome do novo empregado\n=> ");
		this.nome = input.nextLine();
		System.out.printf("\n");
	}
	
	public void setEndereco()
	{
		System.out.printf("Digite o endereço do novo empregado\n=> ");
		this.endereco = input.nextLine();
		System.out.printf("\n");
	}
	
	public void setSalario()
	{
		System.out.printf("O novo empregado é:\n[1] Assalariado");
	}
}
