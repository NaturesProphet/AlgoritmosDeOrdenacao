/*
 * Copyright (C) 2018 mgarcia
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package LOGICA;

import static LOGICA.Util.Vetores.imprime;
import javax.swing.JOptionPane;

/**
 * Esta classe contem métodos estáticos para ordenar sequencias numéricas. Os
 * métodos implementam os algoritmos solicitados.
 *
 * @author mgarcia
 */
public class SortBy {

    /**
     * Este método utiliza o algoritmo BubbleSort<br>
     * Utilize este método para ordenar sequências numéricas pequenas na ordem
     * escolhida<br>
     * Complexidade: O(n²)
     *
     * @author Mateus garcia
     * @param nums Array de Inteiros contendo a sequencia numerica a ser
     * ordenada pelo algoritmo Bubble Sort
     * @param ordem String contendo "dec" ou "cre", definindo a ordem
     */
    public static void BubbleSort(int[] nums, String ordem) {
        int aux;
        /*posição de memória para um inteiro que será utilizada para
        armazenar o valor temporário entre uma troca e outra. */
        if (ordem == "cre") {
            for (int z = 0; z < nums.length; z++) {
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] < nums[i - 1]) {
                        //troca as posições dos dois numeros comparados
                        aux = nums[i];
                        nums[i] = nums[i - 1];
                        nums[i - 1] = aux;
                    }
                }
            }
        } else if (ordem == "dec") {
            for (int z = 0; z < nums.length; z++) {
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] > nums[i - 1]) {
                        //troca as posições dos dois numeros comparados
                        aux = nums[i];
                        nums[i] = nums[i - 1];
                        nums[i - 1] = aux;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ordem invalida");
        }
    }

    /**
     * Este método utiliza o algoritmo InsertionSort<br>
     * Utilize este método para ordenar sequências numéricas pequenas em ordem
     * crescente<br>
     * Complexidade: O(n²)
     *
     * @author Mateus garcia
     * @param nums Array de Inteiros contendo a sequencia numerica a ser
     * ordenada
     * @param ordem String contendo "dec" ou "cre", definindo a ordem
     */
    public static void InsertionSort(int[] nums, String ordem) {

        if (ordem == "cre") {
            for (int i = 1; i < nums.length; i++) {
                int aux = nums[i];
                int z = i;

                while ((z > 0) && (nums[z - 1] > aux)) {
                    nums[z] = nums[z - 1];
                    z--;
                }

                nums[z] = aux;
            }

        } else if (ordem == "dec") {
            for (int i = 1; i < nums.length; i++) {
                int aux = nums[i];
                int z = i;

                while ((z > 0) && (nums[z - 1] < aux)) {
                    nums[z] = nums[z - 1];
                    z--;
                }

                nums[z] = aux;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ordem invalida");
        }
    }

    /**
     * Este método utiliza o algoritmo SelectionSort<br>
     * Utilize este método para ordenar sequências numéricas pequenas em ordem
     * crescente<br>
     * Complexidade: O(n²)
     * @author Mateus garcia
     * @param nums Array de Inteiros contendo a sequencia numerica a ser ordenada
     * @param ordem String contendo "dec" ou "cre", definindo a ordem
     */
    public static void SelectionSort(int[] nums, String ordem) {
        if (ordem == "cre") {

            for (int i = 0; i < nums.length; i++) {
                int menorPosicao = i;
                for (int j = (i + 1); j < nums.length; j++) {
                    if (nums[j] < nums[menorPosicao]) {
                        menorPosicao = j;
                    }
                }
                if (nums[i] != nums[menorPosicao]) {
                    int temp = nums[i];
                    nums[i] = nums[menorPosicao];
                    nums[menorPosicao] = temp;
                }
            }

        } else if (ordem == "dec") {
            for (int i = 0; i < nums.length; i++) {
                int maiorPosicao = i;
                for (int j = (i + 1); j < nums.length; j++) {
                    if (nums[j] > nums[maiorPosicao]) {
                        maiorPosicao = j;
                    }
                }
                if (nums[i] != nums[maiorPosicao]) {
                    int temp = nums[i];
                    nums[i] = nums[maiorPosicao];
                    nums[maiorPosicao] = temp;
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ordem invalida");
        }
    }

    public static void main(String[] args) {
        //testes aqui
        int[] x = {9, 6, 2, 8, 7, 1, 0, 3, 4, 5};
        SelectionSort(x, "cre");
        imprime(x);
    }
}
