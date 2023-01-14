/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sacola;

/**
 *
 * @author Takeshi
 */
public class Pilha {
    String pilha[];
    int topo;


    //Inicializando a pilha
    Pilha(int tamanho) {
        pilha = new String[tamanho];
        topo = 0;
    }

    boolean isFull() {
        if (pilha.length == topo)
            return true;
        return false;
        //return pilha.lenght == topo (dá pra fazer em uma linha só também)
    }

    boolean push(String valor) {
        if (isFull()) {
            return false;
        }
        pilha[topo] = valor;
        //o valor é o que estou passando por parâmetro na função
        topo++; //topo = topo+1
        return true;

    }


    //  Metodo para remover. Mas para isso é preciso verificar se está vazia para não dar erro.
    boolean isEmpty() {
        return topo == 0;
    }


    String pop() {
        if (isEmpty()) {
            return null; //System.out.println("Não é possível remover. Pilha vazia"); // Poderia retornar null também.
        }
        String aux = pilha[topo];
        topo--;
        return aux;
    }

    int tamanho() {
        return topo;
    }
     //método para espiar o que tá no topo
    String peek() {
        System.out.println(pilha[topo]);
        return pilha[topo];
    }
    //metodo para imprimir a pilha
    void print() {
        for (int i = 0; i < topo; i++) {
            System.out.println("|" + pilha[i] + "|");
        }
    }
}
