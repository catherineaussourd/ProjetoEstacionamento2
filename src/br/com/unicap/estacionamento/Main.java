package br.com.unicap.estacionamento;

import br.com.unicap.estacionamento.Estacionamento;
import br.com.unicap.estacionamento.Registro;
import br.com.unicap.estacionamento.TipoVeiculo;

import java.util.Scanner;

public class Main {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		Estacionamento estacionamento = new Estacionamento();
		int resposta;
		boolean L = false;

		do {
			try {
				System.out.println("< E S T A C I O N A M E N T O >\n" + "Digite - 0 (Para acessar vagas disponiveis)\n"
						+ "Digite - 1 (Para registrar-se)\n" + "Digite - 2 (Para a saída de um veículo)\n" + "Digite - 3 (Para sair do Menu)\n");
				System.out.print("Resposta: ");
				resposta = in.next().charAt(0);
				System.out.println("\n");

				// Buffer cls
				in.nextLine();

				switch (resposta) {
					case '0':
						acessarVagasDisponiveis(estacionamento);
						break;
					case '1':
						cadastrarAluno(estacionamento);
						L = true;
						break;
					case '2':
						saidaVeiculo(estacionamento);
						break;
					case '3':
					default:
						break;
				}
			} catch (InvalidDataException e){
				System.out.println(e.getMessage());
				L = true;
			}
		} while (L);

	}

	private static void acessarVagasDisponiveis(Estacionamento estacionamento) {

		int matricula;

		int senha;

		Registro reg;

		System.out.print("Informe sua Matricula: ");
		matricula = in.nextInt();

		System.out.print("Informe sua Senha: ");
		senha = in.nextInt();

		reg = estacionamento.acessarRegistro(matricula, senha);

		if (reg == null) {
			System.out.println("Aluno não registrado");
		} else if (reg.getaTipo() != null) {
			boolean v0;
			v0 = estacionamento.verificarVaga(reg);
			if (!v0) {
				System.out.println("Não há vagas Especiais disponíveis");
			} else {
				System.out.println("Pode estacionar! ");
			}
		} else {
			System.out.println("Senha incorreta");
		}
	}

	private static void cadastrarAluno(Estacionamento estacionamento) throws InvalidDataException {

		String nome;
		int idade;
		boolean especial;
		int ehEspecial;
		String marcaAutomovel;
		String placaAutomovel;
		boolean isMoto;
		int moto;
		int matricula;
		int senha;

		System.out.print("Informe seu Nome: ");
		nome = in.nextLine();

		System.out.print("Informe sua Idade: ");
		idade = in.nextInt();

		// Buffer cls
		in.nextLine();

		System.out.print("Informe sua Matricula: ");
		matricula = in.nextInt();

		// Buffer cls
		in.nextLine();

		System.out.print("Informe sua Senha: ");
		senha = in.nextInt();

		// Buffer cls
		in.nextLine();

		System.out.print("Você é um aluno especial? (0 - Sim) / (1 - Não) ");
		ehEspecial = in.nextInt();

		// Buffer cls
		in.nextLine();

		if (ehEspecial == 0) {
			especial = true;
		} else {
			especial = false;
		}

		System.out.print("Informe a Marca do Automovel: ");
		marcaAutomovel = in.next();

		System.out.print("Informe a Placa do Automovel: ");
		placaAutomovel = in.next();

		System.out.print("Seu automovel é uma moto? (0 - Sim) / (1 - Não) ");
		moto = in.nextInt();

		if (moto == 0) {
			isMoto = true;
		} else {
			isMoto = false;
		}

		Registro R = new Registro(nome, idade, matricula, senha, especial, marcaAutomovel, placaAutomovel, isMoto);
		estacionamento.registrar(R);
	}
	private static void saidaVeiculo(Estacionamento estacionamento){

	}
}
