import java.util.Date;
import java.util.Random;

public class Ordenacao {
    public static void main(String[] args) {
        final int[] tamanhos = {200_000, 400_000, 600_000, 800_000, 1_000_000, 1_200_000, 1_400_000};
        final int numIteracoes = 20;
        final Random random = new Random();

        for (final int tamanho : tamanhos) {
            System.out.println("\nTestando para tamanho: " + tamanho);

            long tempoTotalBubble;
            long tempoTotalInsertion;
            long tempoTotalSelection;

            long comparacoesTotalBubble;
            long comparacoesTotalInsertion;
            long comparacoesTotalSelection;

            long inicio, fim;

            for (int i = 0; i < numIteracoes; i++) {
                final MeuVetor vetor = new MeuVetor(tamanho);
                for (int j = 0; j < tamanho; j++) {
                    vetor.adiciona(random.nextDouble() * tamanho);
                }

                MeuVetor vetorBubble = copiarVetor(vetor);

                // Bubble Sort
                inicio = new Date().getTime();
                comparacoesTotalBubble = vetorBubble.bubbleSort();
                fim = new Date().getTime();
                tempoTotalBubble = (fim - inicio);
                System.out.println("BUBBLE SORT -> Tempo: " + (tempoTotalBubble) + " ms, Comparações: " + (comparacoesTotalBubble));
            }
            System.out.println("\n");
            for (int i = 0; i < numIteracoes; i++) {
                final MeuVetor vetor = new MeuVetor(tamanho);
                for (int j = 0; j < tamanho; j++) {
                    vetor.adiciona(random.nextDouble() * tamanho);
                }
                MeuVetor vetorSelection = copiarVetor(vetor);

                // Selection Sort
                inicio = new Date().getTime();
                comparacoesTotalSelection = vetorSelection.selectionSort();
                fim = new Date().getTime();
                tempoTotalSelection = (fim - inicio);
                System.out.println("SELECTION SORT -> Tempo: " + (tempoTotalSelection) + " ms, Comparações: " + (comparacoesTotalSelection));
            }
            System.out.println("\n");
            for (int i = 0; i < numIteracoes; i++) {
                final MeuVetor vetor = new MeuVetor(tamanho);
                for (int j = 0; j < tamanho; j++) {
                    vetor.adiciona(random.nextDouble() * tamanho);
                }
                MeuVetor vetorInsertion = copiarVetor(vetor);

                // Insertion Sort
                inicio = new Date().getTime();
                comparacoesTotalInsertion = vetorInsertion.insertionSort();
                fim = new Date().getTime();
                tempoTotalInsertion = (fim - inicio);
                System.out.println("INSERTION SORT -> Tempo: " + (tempoTotalInsertion) + " ms, Comparações: " + (comparacoesTotalInsertion));
            }
        }
    }

    private static MeuVetor copiarVetor(final MeuVetor original) {
        final MeuVetor copia = new MeuVetor(original.getUltimaPos() + 1);
        final double[] originalArray = original.getV();
        for (int i = 0; i <= original.getUltimaPos(); i++) {
            copia.adiciona(originalArray[i]);
        }
        return copia;
    }
}
