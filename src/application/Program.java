package application;


import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try { 
			System.out.println("Digite os dados da conta: ");
			System.out.print("Numero: ");
			int num = sc.nextInt();
			System.out.print("Dono: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();
			System.out.print("Limite de saque: ");
			double limite = sc.nextDouble();
			
			Conta conta = new Conta(num, nome, saldo, limite);
			
			System.out.println("Valor de saque: ");
			double saque = sc.nextDouble();
			conta.saque(saque);
			
			
		}
		catch(RuntimeException e) {
			System.out.println("Formato Invalido.");
		}
		catch(DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		sc.close();
	}

}
