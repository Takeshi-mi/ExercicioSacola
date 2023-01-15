/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sacola;

/**
 *
 * @author Takeshi
 */
public class Fila {
    String[] queue;
    int end;

    Fila(int size) {
        queue = new String[size];
        end = -1; // Zero é a primeira posição, -1 é vazio
    }
    boolean isEmpty() {
        return end ==-1;
    }
    boolean isFull() {
        return end ==queue.length-1;
    }

    void add(String element) {
        if (!isFull()) {
            end += 1;
            queue[end] = element;
        }
    }
    String remove() {
        if (!isEmpty()) {
            String removed = queue[0];
            for (int i=0; i<queue.length-1; i++) {
                queue[i] = queue[i+1];
            }
            queue[end] = null;
            end -= 1;
            return removed;
        }
        return null;
    }
}
