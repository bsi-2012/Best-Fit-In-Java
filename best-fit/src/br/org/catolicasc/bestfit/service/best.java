package br.org.catolicasc.bestfit.service;

import java.io.IOException;
import java.util.Scanner;

public class best {
	public static void main(String args[]) throws IOException {

		int p, m;
		Scanner in = new Scanner(System.in);

		System.out.println("Nº processos:");
		p = in.nextInt();
		System.out.println("Nº blocos de memória:");
		m = in.nextInt();

		int tamProcessos[] = new int[p];
		int segMemoria[] = new int[m];

		int i;

		for (i = 0; i < p; i++) {
			System.out.println("Tamanho do processo " + (i+1));
			tamProcessos[i] = in.nextInt();
		}

		for (i = 0; i < m; i++) {
			System.out.println("Entre o tamanho do segmento de memória "
					+ (i + 1));
			segMemoria[i] = in.nextInt();
		}

		int j;

		for (i = 0; i < m; i++) {
			for (j = i + 1; j < m; j++) {
				if (segMemoria[i] > segMemoria[j]) {
					int t = segMemoria[i];
					segMemoria[i] = segMemoria[j];
					segMemoria[j] = t;
				}
			}
		}

		for (i = 0; i < p; i++) {
			for (j = 0; j < m; j++) {
				if (segMemoria[j] >= tamProcessos[i]) {
					segMemoria[j] -= tamProcessos[i];
					System.out.println("Processo " + (i + 1)
							+ " alocado no espaço de memória " + (j + 1));
					System.out.println("Espaço restante após a alocação "
							+ segMemoria[j]);
					System.out.println();
					break;
				}

			}
			if (j == m) {
				System.out.println("Não há mais memória para o processo " + i);
				break;
			}
		}
	}

}
