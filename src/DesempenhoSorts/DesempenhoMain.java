// QUESTÃO 2
package DesempenhoSorts;
/**
 *
 * @author Takeshi
 */

import DesempenhoSorts.Metodos.*; // Importei todos os métodos presentes nessa classe
import java.util.Arrays;



interface Funcoes {  
    void func(int[] array);
}
/* Interface é um recurso de programação que me permite usar métodos como se fosse uma variável. Estou usando isso para passar como parâmetro na função OrdenarEMedirTempo
* A sintaxe para utilizar é  Classe :: Metodo.  No meu caso Metodos :: bubbleSort
*/


public class DesempenhoMain {
    public static void main(String[] args) {
        int[] sizes = {10, 1000, 10000, 100000, 1000000};
        for (int size : sizes) {
            int[] array = ArrayAleatorio(size);
            System.out.println(String.format("\u001B[32mTamanho do vetor:   | %,d |", size)); // %,d formata o número para decimal, deixando mais legível. 1.000.000
            System.out.println("\u001B[32m| Metodos |       | Tempo de execucao |" );
            System.out.println("Bubble Sort:         " + OrdenarEMedirTempo(array, Metodos::bubbleSort));
            System.out.println("Insertion Sort:      " + OrdenarEMedirTempo(array, Metodos::insertionSort));
            System.out.println("Selection Sort:      " + OrdenarEMedirTempo(array, Metodos::selectionSort));
            System.out.println("Merge Sort:          " + OrdenarEMedirTempo(array, Metodos::mergeSort));
            System.out.println("Quick Sort:          " + OrdenarEMedirTempo(array, Metodos::quickSort));
            System.out.println("Shell Sort:          " + OrdenarEMedirTempo(array, Metodos::simpleShellSort));
            System.out.println();
        }
    }

    // Gera um vetor de inteiros aleatórios com o tamanho especificado
    private static int[] ArrayAleatorio(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }

    // Este método mede o tempo de execução de um algoritmo de ordenação. Pra usar ele passei 
    private static long OrdenarEMedirTempo(int[] array, Funcoes funcoes) {
        int[] copy = Arrays.copyOf(array, array.length);
        long inicio = System.currentTimeMillis();  //Long é tipo um int, mas guarda números maiores. (Às vezes eu comento pra mim mesmo entender, Professora)
        funcoes.func(copy);
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }
    
    /** O método Arrays.copyOf(array, array.length) cria uma cópia do array original e armazena na variável "copy". Isso é importante para que a 
      * ordenação do array original não seja afetada pelo teste de tempo de execução. Desta forma, é possível medir o tempo de execução do algoritmo 
      * de ordenação sem afetar o array original.
    */
}
