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
package LOGICA.Util;

/**
 * Classe que oferece métodos estáticos para auxiliar na manipulação e/ou
 * exibição de vetores numéricos
 *
 * @author mgarcia
 */
public class Vetores {

    /**
     * Método que converte um vetor de inteiros em uma String para exibição
     * simples de seu conteúdo
     *
     * @author Mateus Garcia
     * @param Vetor Array de Inteiros a ser exibido na tela.
     */
    public static String ToString(int[] Vetor) {
        StringBuilder array = new StringBuilder();
        for (int i = 0; i < Vetor.length; i++) {
            array.append(Vetor[i]).append(", ");
        }
        //remove os espaços e a virgula do final
        array.delete(array.length() - 2, array.length() - 1);
        array.deleteCharAt(array.length() - 1);
        return array.toString();
    }

    public static void imprime(int[] vetor) {
        System.out.println(ToString(vetor));
    }

}
