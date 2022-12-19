package Lista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainList {
	public static void main(String[] args) {
		Scanner tcl = new Scanner(System.in);
		try {
			List<Funcionario> list = new ArrayList<>();
			System.out.print("Quantos funcionarios vc ira cadastrar? ");
			int qnt = tcl.nextInt();
			tcl.nextLine();
			for (int i = 0; i < qnt; i++) {
				System.out.println("Digite os dados do #" + (i + 1) + " funcionario!");
				System.out.print("Id: ");
				int id = tcl.nextInt();
				tcl.nextLine();
				System.out.print("Nome: ");
				String nome = tcl.nextLine();
				System.out.print("Salário: ");
				double salario = tcl.nextDouble();
				tcl.nextLine();
				list.add(new Funcionario(id, nome, salario));
			}
			for (Funcionario f : list) {
				System.out.println("DADO DO FUNCIONÁRIO");
				System.out.println(f);
				System.out.println("-----------------------");
			}
			System.out.println("Deseja incrementar o salario de algum funcionario(s/n)?");
			char escolha = tcl.next().toUpperCase().charAt(0);
			tcl.nextLine();
			if (escolha == 'S') {
				System.out.println("Digite o ID do funcionario: ");
				int id = tcl.nextInt();
				tcl.nextLine();
				Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
				if (func != null) {
					System.out.println("Qual a porcentagem para o funcionario: ");
					double pct = tcl.nextDouble();
					tcl.nextLine();
					func.aumentarSalario(pct);
				} else {
					System.out.println("ID não encontrado!");
				}
				for (Funcionario f : list) {
					System.out.println("DADOS ATUALIZADOS");
					System.out.println(f);
					System.out.println("-----------------------");
				}
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Por favor digite apenas numeros inteiros!");
		}
		System.out.println("FIM DO PROGRAMA!");
		tcl.close();
	}
}
