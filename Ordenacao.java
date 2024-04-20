import java.util.Date;
import java.util.Random;

public class Ordenacao {
    public static void main(String[] args) {
        final int[] tamanhos = {200_000, 400_000, 600_000, 800_000, 1_000_000, 1_200_000, 1_400_000};
        final int numIteracoes = 20;
        final Random random = new Random();

        for (final int tamanho : tamanhos) {
            System.out.println("\nTestando para tamanho: " + tamanho);

            long tempoTotalBubble = 0;
            long tempoTotalInsertion = 0;
            long tempoTotalSelection = 0;
            long tempoTotalMerge = 0;
            long tempoTotalQuick = 0;
            long tempoTotalHeap = 0;

            long comparacoesTotalBubble = 0;
            long comparacoesTotalInsertion = 0;
            long comparacoesTotalSelection = 0;
            long comparacoesTotalMerge = 0;
            long comparacoesTotalQuick = 0;
            long comparacoesTotalHeap = 0;

            for (int i = 0; i < numIteracoes; i++) {
                final MeuVetor vetor = new MeuVetor(tamanho);
                for (int j = 0; j < tamanho; j++) {
                    vetor.adiciona(random.nextDouble() * tamanho);
                }

                MeuVetor vetorBubble = copiarVetor(vetor);
                MeuVetor vetorInsertion = copiarVetor(vetor);
                MeuVetor vetorSelection = copiarVetor(vetor);
                MeuVetor vetorMerge = copiarVetor(vetor);
                MeuVetor vetorQuick = copiarVetor(vetor);
                MeuVetor vetorHeap = copiarVetor(vetor);

                // Bubble Sort
                long inicio = new Date().getTime();
                comparacoesTotalBubble += vetorBubble.bubbleSort();
                long fim = new Date().getTime();
                tempoTotalBubble += (fim - inicio);

                // Insertion Sort
                inicio = new Date().getTime();
                comparacoesTotalInsertion += vetorInsertion.insertionSort();
                fim = new Date().getTime();
                tempoTotalInsertion += (fim - inicio);

                // Selection Sort
                inicio = new Date().getTime();
                comparacoesTotalSelection += vetorSelection.selectionSort();
                fim = new Date().getTime();
                tempoTotalSelection += (fim - inicio);

                // Merge Sort
                inicio = new Date().getTime();
                comparacoesTotalMerge += vetorMerge.mergeSort();
                fim = new Date().getTime();
                tempoTotalMerge += (fim - inicio);

                // Quick Sort
                inicio = new Date().getTime();
                comparacoesTotalQuick += vetorQuick.quickSort();
                fim = new Date().getTime();
                tempoTotalQuick += (fim - inicio);

                // Heap Sort
                inicio = new Date().getTime();
                comparacoesTotalHeap += vetorHeap.heapSort();
                fim = new Date().getTime();
                tempoTotalHeap += (fim - inicio);
                // tempoTotalHeapMs += (fim - inicio) / numIteracoes;
                // tempoTotalHeapMin += ((fim - inicio) / numIteracoes) / 60000;
                // tempoTotalHeapHr += ((fim - inicio) / numIteracoes) / 3600000;
            }

            System.out.println("BUBBLE SORT -> Tempo médio: " + (tempoTotalBubble / numIteracoes) + " ms, Comparações médias: " + (comparacoesTotalBubble / numIteracoes));
            System.out.println("INSERTION SORT -> Tempo médio: " + (tempoTotalInsertion / numIteracoes) + " ms, Comparações médias: " + (comparacoesTotalInsertion / numIteracoes));
            System.out.println("SELECTION SORT -> Tempo médio: " + (tempoTotalSelection / numIteracoes) + " ms, Comparações médias: " + (comparacoesTotalSelection / numIteracoes));
            System.out.println("MERGE SORT -> Tempo médio: " + (tempoTotalMerge / numIteracoes) + " ms, Comparações Médias: " + (comparacoesTotalMerge / numIteracoes));
            System.out.println("QUICK SORT -> Tempo médio: " + (tempoTotalQuick / numIteracoes) + " ms, Comparações médias: " + (comparacoesTotalQuick / numIteracoes));
            System.out.println("HEAP SORT -> Tempo médio: " + (tempoTotalHeap / numIteracoes) + " ms, Comparações médias: " + (comparacoesTotalHeap / numIteracoes));
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
