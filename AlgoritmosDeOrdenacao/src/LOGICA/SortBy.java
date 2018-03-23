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

/**
 * Esta classe contem métodos estáticos para ordenar sequencias numéricas os
 * métodos implementam os algoritmos solicitados.
 *
 * @author mgarcia
 */
public class SortBy {

    /**
     * Este método utiliza o algoritmo BubbleSort<br>
     * Utilize este método para ordenar sequências numéricas pequenas em ordem
     * crescente
     *
     * @author Mateus garcia
     * @param nums Array de Inteiros contendo a sequencia numerica a ser
     * ordenada pelo algoritmo Bubble Sort
     */
    public static void BubbleSort(int[] nums) {
        int aux;
        /*posição de memória para um inteiro que será utilizada para
        armazenar o valor temporário entre uma troca e outra. */
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
    }

    /**
     * Este método utiliza o algoritmo InsertionSort<br>
     * Utilize este método para ordenar sequências numéricas pequenas em ordem
     * crescente
     *
     * @author Mateus garcia
     * @param nums Array de Inteiros contendo a sequencia numerica a ser
     * ordenada pelo algoritmo Insertion Sort
     */
    public static void InsertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            int aux = nums[i];
            int z = i;

            while ((z > 0) && (nums[z - 1] > aux)) {
                nums[z] = nums[z - 1];
                z--;
            }
            nums[z] = aux;

        }

    }
    
    
    
    
    public static void main(String[] args) {
        //testes aqui
        int[] x = {23, 44, 11, 22, 0, 7, 55, 99, 88, 123, 400, 2, 0, 15, 8};
        InsertionSort(x);
        imprime(x);
    }

}