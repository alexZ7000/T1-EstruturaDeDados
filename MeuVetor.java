

public class MeuVetor {
    private double[] v;
    private int ultimaPos;

    public MeuVetor (int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }

    public int getUltimaPos (){
        return ultimaPos;
    }
    public double[] getV () {
        return v;
    }

    public boolean estaCheio () {
        return ultimaPos == v.length - 1;
    }
    public boolean estaVazio() {
        return ultimaPos == -1;
    }
    private void redimensiona (int novaCapacidade) {
        double[] temp = new double[novaCapacidade];
        if (ultimaPos + 1 >= 0) System.arraycopy(v, 0, temp, 0, ultimaPos + 1);
        v = temp;
    }
    public void adiciona (double e){
        if (estaCheio()) redimensiona(v.length*2);
        v[++ultimaPos] = e;
    }

    @Override
    public String toString () {
        StringBuilder s = new StringBuilder();
        if (estaVazio()) {
            s.append("esta vazio");
        }
        else {
            for (int i=0; i<=ultimaPos; i++) {
                s.append(String.format("%.0f ", v[i]));
            }
        }
        return s + "\n";
    }
    public long bubbleSort () {
        long cont = 0;
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < v.length - i; j++) {
                cont++;
                if (v[j] > v[j+1]) {
                    final double aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
        return cont;
    }

    public long insertionSort() {
        long cont = 0;
        for (int i = 1; i <= ultimaPos; i++) {
            final double chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
                cont++;
            }
            v[j + 1] = chave;
        }
        return cont;
    }

    // Selection Sort
    public long selectionSort() {
        long cont = 0;
        for (int i = 0; i < ultimaPos; i++) {
            int minIdx = i;
            for (int j = i + 1; j <= ultimaPos; j++) {
                cont++;
                if (v[j] < v[minIdx]) {
                    minIdx = j;
                }
            }
            final double temp = v[minIdx];
            v[minIdx] = v[i];
            v[i] = temp;
        }
        return cont;
    }

    public long mergeSort() {
        return mergeSortHelper(0, ultimaPos);
    }

    private long mergeSortHelper(final int inicio, final int fim) {
        if (inicio < fim) {
            final int meio = (inicio + fim) / 2;
            // comparações à esquerda e comparações à direita respectivamente
            return mergeSortHelper(inicio, meio) + mergeSortHelper(meio + 1, fim) + merge(inicio, meio, fim);
        }
        return 0;
    }

    private long merge(final int inicio, final int meio, final int fim) {
        final int n1 = meio - inicio + 1;
        final int n2 = fim - meio;

        final double[] L = new double[n1];
        final double[] R = new double[n2];

        System.arraycopy(v, inicio, L, 0, n1);
        System.arraycopy(v, meio + 1, R, 0, n2);

        int i = 0, j = 0, k = inicio;
        long comparacoes = 0;
        while (i < n1 && j < n2) {
            comparacoes++;
            if (L[i] <= R[j]) {
                v[k++] = L[i++];
            } else {
                v[k++] = R[j++];
            }
        }

        while (i < n1) {
            v[k++] = L[i++];
        }
        while (j < n2) {
            v[k++] = R[j++];
        }

        return comparacoes;
    }

    public long heapSort() {
        long comparacoes = 0;
        for (int i = ultimaPos / 2; i >= 0; i--) {
            comparacoes += heapify(ultimaPos, i);
        }
        for (int i = ultimaPos; i > 0; i--) {
            final double temp = v[0];
            v[0] = v[i];
            v[i] = temp;
            comparacoes += heapify(i - 1, 0);
        }
        return comparacoes;
    }

    private long heapify(int n, int i) {
        long comparacoes = 0;
        int largest = i;
        final int left = 2 * i + 1;
        final int right = 2 * i + 2;

        if (left <= n && v[left] > v[largest]) {
            largest = left;
        }
        if (right <= n && v[right] > v[largest]) {
            largest = right;
        }

        if (largest != i) {
            final double temp = v[i];
            v[i] = v[largest];
            v[largest] = temp;
            comparacoes++;
            comparacoes += heapify(n, largest);
        }

        return comparacoes;
    }

    public long quickSort() {
        return quickSortHelper(0, ultimaPos);
    }

    private long quickSortHelper(int inicio, int fim) {
        long comparacoes = 0;
        if (inicio < fim) {
            final double pivot = v[fim];
            int i = inicio - 1;
            for (int j = inicio; j < fim; j++) {
                if (v[j] < pivot) {
                    i++;
                    double temp = v[i];
                    v[i] = v[j];
                    v[j] = temp;
                    comparacoes++;
                }
            }
            final double temp = v[i + 1];
            v[i + 1] = v[fim];
            v[fim] = temp;
            return comparacoes + (fim - inicio) + quickSortHelper(inicio, i) + quickSortHelper(i + 2, fim);
        }
        return comparacoes;
    }
}
