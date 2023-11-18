import java.util.Scanner;

public class SPRINT_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite o número de equipes: ");
		int x = teclado.nextInt();
		int equipes[] = new int[x];
		float notas[] = new float[x];
		int pontos[] = new int[x];

		for (int i = 0; i < x; i++) {
			equipes[i] = i + 1 + 10;
			System.out.println("Nota de design da equipe " + (i + 1 + 10) + ": ");
			notas[i] = teclado.nextFloat();
			pontos[i] = 0; 
		}

		for (int i = 0; i < x; i++) {
			for (int j = i + 1; j < x; j++) {
				int equipeA = equipes[i];
				int equipeB = equipes[j];

				double pontuacaoA;
				double pontuacaoB;

				// Valor aleatório
				pontuacaoA = (int) (Math.random() * 10) + 1;
				pontuacaoB = (int) (Math.random() * 10) + 1;

				System.out.println("\nCombate entre Equipe " + equipeA + " e Equipe " + equipeB);
				System.out.println("===== PONTUAÇÃO =====");
				System.out.println("Equipe " + equipeA + ": " + pontuacaoA);
				System.out.println("Equipe " + equipeB + ": " + pontuacaoB);

				if (pontuacaoA > pontuacaoB) {
					System.out.println("Equipe " + equipeA + " venceu!");
					pontos[i] += 2;
				}

				else if (pontuacaoB > pontuacaoA) {
					System.out.println("Equipe " + equipeB + " venceu!");
					pontos[j] += 2;
				}

				else {

					// Caso de empate

					if (notas[i] > notas[j]) {
						System.out.println("\nDESEMPATE");
						System.out.println("Equipe " + equipeA + " venceu (nota de design)");
						pontos[i] += 1;
					}

					else if (notas[j] > notas[i]) {
						System.out.println("\nDESEMPATE");
						System.out.println("Equipe " + equipeB + " venceu (nota de design)");
						pontos[j] += 1;
					}

					else {
						System.out.println("Empate!");
						pontos[i] += 1;
						pontos[j] += 1;
					}
				}
			}
		}

		// Identifica as 3 melhores equipes para a fase final
		int[] melhoresEquipes = new int[3];
		for (int k = 0; k < 3; k++) {
			int melhorEquipe = -1;
			for (int i = 0; i < x; i++) {
				if (melhorEquipe == -1 || pontos[i] > pontos[melhorEquipe]) {
					melhorEquipe = i;
				} else if (pontos[i] == pontos[melhorEquipe]) {

					if (notas[i] > notas[melhorEquipe]) {
						melhorEquipe = i;
					}
				}
			}

			melhoresEquipes[k] = equipes[melhorEquipe];
			pontos[melhorEquipe] = -1;

		}

		// Fase final entre as 3 melhores equipes
		System.out.println("\nFase final entre as 3 melhores equipes:");
		for (int i = 0; i < 3; i++) {
			System.out.println("Equipe " + melhoresEquipes[i]);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 3; j++) {
				int equipeA = melhoresEquipes[i];
				int equipeB = melhoresEquipes[j];
				double pontuacaoA;
				double pontuacaoB;

				// Valor aleatório
				pontuacaoA = (int) (Math.random() * 10) + 1;
				pontuacaoB = (int) (Math.random() * 10) + 1;

				System.out.println("\nCombate na fase final entre Equipe " + equipeA + " e Equipe " + equipeB);
				System.out.println("===== PONTUAÇÃO NA FASE FINAL =====");
				System.out.println("Equipe " + equipeA + ": " + pontuacaoA);
				System.out.println("Equipe " + equipeB + ": " + pontuacaoB);

				// Determina o vencedor da fase final
				if (pontuacaoA > pontuacaoB) {
					System.out.println("Equipe " + equipeA + " venceu");
				}

				else if (pontuacaoB > pontuacaoA) {
					System.out.println("Equipe " + equipeB + " venceu");
				}

				else {

					// Caso de empate na fase final

					if (notas[equipeA - 1] > notas[equipeB - 1]) {
						System.out.println("\nDESEMPATE");
						System.out.println("Equipe " + equipeA + " venceu (nota de design)!");
					}

					else if (notas[equipeB - 1] > notas[equipeA - 1]) {
						System.out.println("\nDESEMPATE");
						System.out.println("Equipe " + equipeB + " venceu (nota de design)!");
					}

					else {
						System.out.println("Empate na fase final!");
					}
				}
			}
		}

		// Determina a equipe vencedora da competição
		int vencedora = -1;
		int pontuacaoMaxima = -1;
		for (int i = 0; i < x; i++) {
			if (pontos[i] > pontuacaoMaxima) {
				vencedora = equipes[i];
				pontuacaoMaxima = pontos[i];
			}
		}
		System.out.println("\n===== EQUIPE VENCEDORA =====");
		System.out.println("Grande vencedora da RoboCup 2023: equipe: "+vencedora);

	}

}
