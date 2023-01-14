
package Sacola;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Sacola {


    public static void main(String[] args) {
    // Import com os métodos de Pilha, fila e fila de Prioridade. Pensei em implementar eles, todos mas ia dar trabalho demais. Implementei a pillha só e aí descobri que dava pra importar
    Stack<Integer> Pilha = new Stack<>();  
    Queue<Integer> Fila = new LinkedList<>();
    PriorityQueue<Integer> FilaPrioridade = new PriorityQueue<>();
    int numOperacoes;
    int op;
    int elemento;
     //Começa tudo como verdadeiro e eu vou validando depois. No final é só fazer a verificação lógica.
    boolean podeSerFilaPrioridade = true; 
    boolean podeSerPilha = true;
    boolean PodeSerFila = true;
    
    
    Scanner entrada = new Scanner(System.in); // Para receber as entradas. Pode receber NextInt, nextLine e nextFloat.
    System.out.print("Quantas operações deseja fazer?  ");
    numOperacoes = entrada.nextInt();
    for (int i = 0; i < numOperacoes; i++) {
        System.out.println("Opções: \n1-INSERIR \n2-R=REMOVER ");
        System.out.print("Sua opção:  ");
        op = entrada.nextInt();
        
        while (op <1 || op > 2){
            System.out.println("Opção inválida. Digite 1 ou 2:  ");
            op = entrada.nextInt();
            
        }

        if (op == 1) {
            System.out.print("Insira um elemento na sacola:  ");
            elemento = entrada.nextInt();
            while(elemento < 0 || elemento > 100){
                System.out.println("O número tem que ser positivo e menor que 100.");
                System.out.print("Digite novamente:  ");
                elemento  = entrada.nextInt();
            }
            if (podeSerPilha) Pilha.push(elemento);
            if (PodeSerFila) Fila.add(elemento);
            if (podeSerFilaPrioridade) FilaPrioridade.add(elemento);
        } else {
            if(Pilha.empty()){
                System.out.println("A sacola está vazia, não há nada para remover. Gastou uma operação."); 
            } else{
            System.out.print("Remova um elemento na sacola:  ");
            elemento = entrada.nextInt();
            
            
            if (Pilha.peek() != elemento) //Peek(espiar) olha o elemento mais recente da lista sem removê-lo
                podeSerPilha = false;
            else
                Pilha.pop();

            if (Fila.peek() != elemento)
                PodeSerFila = false;
            else
                Fila.poll(); 

            if (FilaPrioridade.peek() != elemento)
                podeSerFilaPrioridade = false;
            else
                FilaPrioridade.poll(); // Remove o maior elemento
            }
        }
    }
    if (podeSerPilha && !PodeSerFila && !podeSerFilaPrioridade)
        System.out.println("\nÉ definitivamente uma pilha.");
    else if (!podeSerPilha && PodeSerFila && !podeSerFilaPrioridade)
        System.out.println("\nÉ definitivamente uma fila.");
    else if (!podeSerPilha && !PodeSerFila && podeSerFilaPrioridade)
        System.out.println("\nÉ definitivamente uma fila de priporidade.");
    else if (!podeSerPilha && !PodeSerFila && !podeSerFilaPrioridade)
        System.out.println("\nÉ impossível. Não pode ser uma pilha, uma fila ou uma fila de prioridade.");
    else{
        System.out.println("Não dá pra ter certeza. "); // Quando caia em outro caso sem ser esses de cima ficava em branco. 
    }

    System.out.println("\nFim do programa.");


        
} 
    }
    


