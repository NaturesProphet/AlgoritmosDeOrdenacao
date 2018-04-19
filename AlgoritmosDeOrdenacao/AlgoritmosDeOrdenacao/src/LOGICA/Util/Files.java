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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta classe é uma adaptação da classe original (desenvolvida por mim) que se
 * encontra integralmente disponivel no meu repositorio de utilidades para Java
 * no github, sob licença GPL 3.0, no endereço
 * https://github.com/NaturesProphet/UtilidadesJava   <br>
 * Apenas os métodos pertinentes ao trabalho foram aproveitados aqui.
 *
 * @author Mateus Garcia
 *
 */
public class Files {

    /**
     * Este método SOBREESCREVE todo o conteúdo do arquivo designado e escreve
     * SOMENTE o conteúdo da String informada. Utilize este método com muito
     * cuidado, uma vez que ele apaga o conteúdo anterior do arquivo.
     *
     * @author Mateus Garcia
     * @param path caminho para o arquivo especificado
     * @param content Uma String com o conteúdo que se deseja gravar no arquivo
     * @throws IOException
     *
     */
    public static void setFileContentAsSingleLine(String path, String content)
            throws IOException {
        if (AreYouHere(path)) {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            buffWrite.append(content + "\n");
            buffWrite.close();
        } else {
            throw new FileNotFoundException("O programa buscou por um arquivo "
                    + "que não foi encontrado no local especificado");
        }
    }

    /**
     * Este método faz a leitura completa do arquivo especificado,
     * linha-a-linha, gera um ArrayList de String, contendo todas as linhas do
     * arquivo respeitando suas posições, mantendo o index do ArrayList igual ao
     * numero da linha, começando por 0. Use este método se você quer uma lista
     * com as linhas do arquivo
     *
     * @return Retorna um ArrayList contendo todas as linhas do arquivo
     * @author Mateus Garcia
     * @param path caminho para o arquivo especificado
     * @throws IOException
     * @throws FileNotFoundException
     *
     */
    public static ArrayList<String> getAllLines(String patch)
            throws FileNotFoundException, IOException {
        if (AreYouHere(patch)) {
            ArrayList<String> dados = new ArrayList();
            BufferedReader br = new BufferedReader(new FileReader(patch));
            String linha;
            Scanner scan = new Scanner(br);
            while (scan.hasNextLine()) {
                linha = scan.nextLine();
                dados.add(linha);
            }
            br.close();
            scan.close();
            return dados;
        } else {
            throw new FileNotFoundException("O programa buscou por um arquivo "
                    + "que não foi encontrado no local especificado");
        }
    }

    /**
     * Use este método para verificar se um arquivo existe ou não.
     *
     * @return Retorna um boolean. Se o arquivo existe, retorna TRUE, caso
     * contrário, retorna FALSE.
     * @author Mateus Garcia
     * @param path caminho para o arquivo especificado
     *
     */
    public static boolean AreYouHere(String patch) {
        File file = new File(patch);
        return file.exists();
    }

    /**
     * Este método le um arquivo de texto contendo apenas numeros inteiros
     * separados por espaços e devolve um Array de Inteiros contendo estes
     * numeros na ordem em que se encontram no arquivo
     *
     * @author Mateus Garcia
     * @param patch String contendo o caminho completo para o arquivo
     * @throws Exception caso ocorra um erro ao ler o arquivo ou ao converter
     * Strings em numeros durante o processo
     * @return Array de inteiros int[] contendo os numeros inteiros lidos do
     * arquivo
     *
     */
    public static int[] getIntArray(String patch) throws Exception {

        ArrayList<String> content = getAllLines(patch); //pega o conteudo do arquivo

        ArrayList<Integer> vetor = new ArrayList();
        /* declara a lista que conterá os numeros que serão processados 
        a seguir e posteriormente será armazenada em um array de inteiros 
        e entregue como resultado */

        for (int i = 0; i < content.size(); i++) {
            String linha = content.get(i);
            String num = "";
            boolean lendo = false;
            for (int z = 0; z < linha.length(); z++) {
                if (linha.charAt(z) == ' ') {
                    if (lendo == false) {
                        continue;
                    } else {
                        int n = Integer.parseInt(num);
                        vetor.add(n);
                        num = "";
                        lendo = false;
                    }
                } else {
                    lendo = true;
                    num += linha.charAt(z);
                }
                /* ao fim da varredura, adiciona o ultimo valor válido lido na 
                lista. O fim da varredura implicaria na não inclusão deste numero,
                por isso este if foi adicionado, garantindo a integridade */
                if (z == linha.length() - 1) {
                    int n = Integer.parseInt(num);
                    vetor.add(n);
                }
            }
        }
        int[] Array = new int[vetor.size()];
        for (int i = 0; i < vetor.size(); i++) {
            Array[i] = vetor.get(i);
        }
        return Array;
    }

    /**
     * Método que ADICIONA uma linha no FINAL do arquivo informado. Utilize este
     * método para escrever um conteúdo no final de um arquivo sem alterar o
     * conteúdo anterior.
     *
     * @author Mateus Garcia
     * @param path caminho para o arquivo especificado
     * @param texto String com o conteúdo a ser escrito no final do arquivo.
     * @throws IOException
     * @throws FileNotFoundException caso o arquivo informado não exista
     *
     */
    public static void AddThisLineAtEOF(String path, String texto) throws IOException {
        if (AreYouHere(path)) {
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.newLine();
            bw.close();
        } else {
            throw new FileNotFoundException("O programa buscou por um arquivo "
                    + "que não foi encontrado no local especificado");
        }

    }
}
