
package Sacola;
/**
 *
 * @author Takeshi
 */

import java.util.Arrays;
import Sacola.Fila;
import Sacola.Pilha;
import java.util.Collections;
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
    PriorityQueue<Integer> FilaPrioridade = new PriorityQueue<>(Collections.reverseOrder()); // É necessário Usar o reverseorder pois
    //por padrão, a classe PriorityQueue em Java remove o menor número. 
    int elemento;
    //Cores
    String azul = "\u001B[34m";
    String vermelho = "\u001B[31m";
    String amarelo = "\u001B[43m";
    String reset = "\u001B[m";
     //Começa tudo como verdadeiro e eu vou validando depois. No final é só fazer a verificação lógica.
    boolean eUmaPilha = true;
    boolean PodeSerFila = true;
    boolean eUmaFilaPrioridade = true;
    boolean impossivel = true;
    
    
    Scanner entrada = new Scanner(System.in); // Para receber as entradas. Pode receber NextInt, nextLine e nextFloat.
    System.out.print("Quantas operacoes deseja fazer?  ");
    int numOperacoes = entrada.nextInt();
    for (int i = 0; i < numOperacoes; i++) {
        System.out.println(amarelo + "Opcoes:     ");
        System.out.println(amarelo+ "1-INSERIR    ");
        System.out.println(amarelo+ "2-REMOVER" + reset);
        System.out.print(">>>Sua opcao:  ");
        int op = entrada.nextInt();
        
        while (op <1 || op > 2){
            System.out.println(vermelho+ "Opcao invalida. Digite 1 ou 2:  " + reset);
            op = entrada.nextInt();
            
        }

        if (op == 1) {
            System.out.print("Insira um elemento na sacola:  ");
            elemento = entrada.nextInt();
            while(elemento < 0 || elemento > 100){
                System.out.println(vermelho + "O numero tem que ser positivo e menor que 100." + reset);
                System.out.print("Digite novamente:  ");
                elemento  = entrada.nextInt();
            }
            if (eUmaPilha) Pilha.push(elemento);
            if (PodeSerFila) Fila.add(elemento);
            if (eUmaFilaPrioridade) FilaPrioridade.add(elemento);
            //Printar a sacola    
                System.out.println(azul + "CONTEUDO DA SACOLA" + reset);
                for (int k: Fila){
                    System.out.print(" | "+ azul + k + reset +" | ");
                }
                System.out.println(" ");
                
        } else {
            if(Pilha.empty()){
                System.out.println(vermelho + "A sacola está vazia, nao ha nada para remover. Gastou uma operacao." + reset); 
            } else{
            System.out.print("Remova um elemento na sacola:  ");
            elemento = entrada.nextInt();
  
            if (Pilha.peek() != elemento) //Peek(espiar) olha o elemento mais recente da lista sem removê-lo
                eUmaPilha = false;
            else
                Pilha.pop();

            if (Fila.peek() != elemento)
                PodeSerFila = false;
            else
                Fila.remove(); 

            if (FilaPrioridade.peek() != elemento)
                eUmaFilaPrioridade = false;
            else
                FilaPrioridade.poll(); // Remove o maior elemento
            }
            //Printar a sacola Fila
                System.out.println(azul + "CONTEUDO DA FILA" + reset);
                for (int k: Fila){
                    System.out.print(" | "+ azul + k + reset +" | ");
                }
                //System.out.println("fila peek = "+ Fila.peek()); era um teste de mesa pra saber onde eu estava errando.
                System.out.println(" ");
            
                
                //Printar a sacola Fila Prioridade 
                System.out.println(azul + "CONTEUDO DA fila prioridade" + reset);
                for (int k: FilaPrioridade){
                    System.out.print(" | "+ azul + k + reset +" | ");
                }
               // System.out.println("Fila de prioridade peek = " + FilaPrioridade.peek());
                System.out.println(" ");
                
                  //Printar a sacola pilha    
                System.out.println(azul + "CONTEUDO DA PILHA" + reset);
                for (int k: Pilha){
                    System.out.print(" | "+ azul + k + reset +" | ");
                }
                //System.out.println("Pilha peek = " + Pilha.peek());
                System.out.println(" ");
        }
    } 
    if (eUmaPilha == true && PodeSerFila == false && eUmaFilaPrioridade == false)
        System.out.println("\nÉ definitivamente uma pilha.");
    
    else if (eUmaPilha == false && PodeSerFila == true && eUmaFilaPrioridade == false)
        System.out.println("\nÉ definitivamente uma fila.");
    
    else if (eUmaPilha == false && PodeSerFila == false && eUmaFilaPrioridade == true)
        System.out.println("\nÉ definitivamente uma fila de priporidade.");
    
    else if (eUmaPilha == false && PodeSerFila == false && eUmaFilaPrioridade == false)
        System.out.println("\nÉ impossível. Não pode ser uma pilha, uma fila ou uma fila de prioridade.");
    
    else{
        System.out.println("Nao da pra ter certeza. "); // Se for mais de um ao mesmo tempo ele fica incerto. Decidi colocar esse campo mesmo
        //você tendo tirado porque quando eu rodava ficava em branco. 
    }

    System.out.println("\nFim do programa.");
    

        
} 
    }


