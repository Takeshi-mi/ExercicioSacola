
package DesempenhoSorts;

/**
 *
 * @author Takeshi
 */


// Classe com os métodos vistos em sala de aula
//(Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort, Shell Sort)
 
public class Metodos {
    // Shell Sort 
    public static void simpleShellSort(int[] v) {
        int h=v.length/2;
        while (h>0) {
            for (int i = 0; i < v.length-1; i++) {
                if (v[i] > v[i + 1]) {
                    int aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                }
            }
            h = h/2;
        }
    }
    
    // Bubble Sort
    public static int[] bubbleSort(int[] vetor) {
        for (int i=1; i<vetor.length; i++) {
            for (int j=0; j<vetor.length-i; j++) {
                if (vetor[j]>vetor[j+1]) {
                    int bubble = vetor[j+1];
                    vetor[j+1] = vetor[j];
                    vetor[j] = bubble;
                }
            }
        }
        return vetor;
    }
    
    // Insert Sort
    public static int[] insertionSort(int[] vetor) {
        for (int i=0; i< vetor.length-1; i++) {
            int key = vetor[i+1];
            for (int j=i; j>=0; j--) {
                if (vetor[j] > key) {
                    vetor[j+1] = vetor[j];
                    if (j==0) {
                        vetor[j] = key;
                    }
                }else {
                    vetor[j+1] = key;
                    break;
                }
            }
        }
        return vetor;
    }
    
    // Selection Sort
      public static int[] selectionSort(int[] vetor) {
        for (int i=0; i<vetor.length-1; i++) {
            int e = vetor[i];
            int menor=i+1;
            for (int j=i+2; j<vetor.length; j++) {
                if (vetor[j]<vetor[menor]) {
                    menor = j;
                }
            }
            if (vetor[menor] < e) {
                vetor[i] = vetor[menor];
                vetor[menor] = e;
            }
        }
        return vetor;
    }
    
        // MergeSort
        // Para o mergeSort funcionar tem que ter esse método intercalar. É um tipo de função recursiva
      
        public static void intercalar(int[] v, int[] aux, int start, int mid, int end) {
        for(int k=start; k <= end; k++) {
            aux[k] = v[k];
        }
        int i = start;
        int j = mid + 1;
        for (int k=start; k <= end; k++) {
            if (i > mid) {
                v[k] = aux[j++];
            } else if (j > end) {
                v[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                v[k] = aux[i++];
            } else {
                v[k] = aux[j++];
            }
        }
    }
        
        //Merge Sort 
    public static void mergeSort(int[] v, int[] aux, int start, int end) {
        if (start < end) {
            int mid = (start+end) / 2;
            mergeSort(v, aux, start, mid);
            mergeSort(v, aux, mid+1, end);
            intercalar(v, aux, start, mid, end);
        }
    }
        // Override (sobrepor. Duas funções com o mesmo nome, mas com quantidade de parâmetros diferentes. Naoki estava me explicando que
        // é um jeito mais eficiente de chamar a função sem passar um monte de parâmetros. 
        public static void mergeSort(int[] v) {
        int[] aux = new int[v.length];
        mergeSort(v, aux, 0, v.length-1);
    }
        
    // QuickSort
    public static void quickSort(int[] v, int start, int end) {
        int i, j, pivot, aux;
        i = start;
        j = end;
        pivot = v[(start+end)/2];
        while(i<j) {
            while(v[i]<pivot) {
                i++;
            }
            while(v[j]>pivot) {
                j--;
            }
            if(i<=j){
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
                i++;
                j--;
            }
        }
        if(j>start) {
            quickSort(v, start, j);
        }
        if(i<end) {
            quickSort(v, i, end);
        }
    }
    // Função reduzida para chamar quickSort sem passar aquele tanto de parâmetros. Também usa Override
    public static void quickSort(int[] v) {
        quickSort(v, 0, v.length-1);
    }
    
    
}
