

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
}
