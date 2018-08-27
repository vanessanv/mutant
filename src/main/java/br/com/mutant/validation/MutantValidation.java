package br.com.mutant.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MutantValidation {

	public boolean isMutant(String[] dna) {

		boolean ehMutante = false;
		
		if (validarArrayDna(dna)) { 
			int qtdOcorrenciasDnaMutante = 0;
			int tamArrayDna = dna.length;

			char[][] matrizDna = transformarEmMatriz(dna);

			String aux = "";
			for (int j = 0; j < tamArrayDna; j++) {
				// verifica a linha
				if (sequenciaDnaMutanteEncontrada(dna[j])) {
					qtdOcorrenciasDnaMutante += 1;
					if (qtdOcorrenciasDnaMutante > 1) {
						ehMutante = true;
						break;
					}
				}

				// verifica a coluna
				for (int i = 0; i < tamArrayDna; i++) {
					aux += (String.valueOf(matrizDna[i][j]));
				}
				if (sequenciaDnaMutanteEncontrada(aux)) {
					qtdOcorrenciasDnaMutante += 1;
					if (qtdOcorrenciasDnaMutante > 1) {
						ehMutante = true;
						break;
					}
				}
				aux = "";
			}

			if (ehMutante) {
				return ehMutante;
			}

			ehMutante = validarSequenciaDnaDiagonais(tamArrayDna, matrizDna, qtdOcorrenciasDnaMutante);
		}
		return ehMutante;
	}

	private boolean validarArrayDna(String[] dna) {
		
		boolean valido = true;
		Pattern regexEntrada = Pattern.compile("([B]|[D-F]|[H-S]|[U-Z])");
		
		if (dna.length < 4) {
			return false;
		}
		
		for (int i = 0; i < dna.length - 1; i++) {
			if (dna[i].length() < 4) {
				valido = false;
				break;
			}
			Matcher m = regexEntrada.matcher(dna[i].toUpperCase());
			if (m.find()) {
				valido = false;
				break;
			}
		}
		return valido;
	}

	private boolean validarSequenciaDnaDiagonais(int tamArrayDna, char[][] matrizDna, int qtdOcorrenciasDnaMutante) {

		boolean ehMutante = false;
		String aux = "";

		// leitura Das diagonais esquerda para direita
		int tamLimiteParaLeitura = (tamArrayDna - 4);
		int x = tamLimiteParaLeitura;
		int y = 0;
		// int iteracao = 0;
		boolean leuMetade = false;

		do {

			if (!leuMetade) {
				for (int i = x; i < matrizDna.length; i++) {
					aux += (String.valueOf(matrizDna[i][y++]));
				}
				y = 0;
				x--;
				if (x == -1) {
					leuMetade = true;
					x = 0;
				}
			} else {
				y++;
				for (int i = x; i < (matrizDna.length - y); i++) {
					aux += (String.valueOf(matrizDna[i][y + i]));
				}
			}

			if (sequenciaDnaMutanteEncontrada(aux)) {
				qtdOcorrenciasDnaMutante += 1;
				if (qtdOcorrenciasDnaMutante > 1) {
					ehMutante = true;
					break;
				}
			}
			aux = "";
		} while (y != tamLimiteParaLeitura);

		if (ehMutante) {
			return true;
		}

		x = 0;
		y = 3;
		// iteracao = 0;
		leuMetade = false;

		// leitura Das diagonais direita para esquerda
		do {

			if (!leuMetade) {
				for (int i = x; i <= y; i++) {
					aux += (String.valueOf(matrizDna[i][y - i]));
				}
				y++;
				if (y == tamArrayDna) {
					leuMetade = true;
					y = (tamArrayDna - 1);
				}
			} else {
				x++;
				for (int i = x; i < tamArrayDna; i++) {
					aux += (String.valueOf(matrizDna[i][y--]));
				}
				y = 5;
			}

			if (sequenciaDnaMutanteEncontrada(aux)) {
				qtdOcorrenciasDnaMutante += 1;
				if (qtdOcorrenciasDnaMutante > 1) {
					ehMutante = true;
					break;
				}
			}
			aux = "";
		} while (x != tamLimiteParaLeitura);

		return ehMutante;

	}

	private boolean sequenciaDnaMutanteEncontrada(String sequenciaDna) {
		Pattern regexEntrada = Pattern.compile("([aA]{4})|([tT]{4})|([cC]{4})|([gG]{4})");
		Matcher m = regexEntrada.matcher(sequenciaDna);
		if (m.find()) {
			return true;
		}

		return false;
	}

	private char[][] transformarEmMatriz(String[] dna) {

		char[][] matrizDna = new char[dna.length][dna.length];
		for (int i = 0; i < dna.length; i++) {
			matrizDna[i] = dna[i].toCharArray();
		}

		return matrizDna;
	}
}
