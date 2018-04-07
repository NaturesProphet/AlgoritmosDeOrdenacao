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

import static LOGICA.SortBy.BubbleSort;
import LOGICA.Util.Files;
import static LOGICA.DAO.TestesDAO.AddRegistro;
import static LOGICA.SortBy.InsertionSort;
import static LOGICA.SortBy.MergeSort;
import static LOGICA.SortBy.QuickSort;
import static LOGICA.SortBy.SelectionSort;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mgarcia
 */
public class Script extends Thread {

    /**
     * Método para verificar se os arquivos apontados existem. Usarei este
     * método para verificar a integridade existencial dos arquivos antes de
     * iniciar os testes.
     *
     * @author Mateus Garcia
     * @param array vetor de strings com patchs para arquivos
     * @return boolean true se estiver tudo OK. false senão.
     */
    public boolean FileCheck(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!Files.AreYouHere(array[i])) {
                System.out.println("Arquivo não encontrado:\n" + array[i]);
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado:\n" + array[i]);
                return false;
            }
        }
        return true;
    }

    /**
     * Esta Thread executa os testes e registra os resultados no banco de dados
     *
     * @author Mateus Garcia
     */
    public void run() {
        /*
        ################## INICIO: apontando os arquivos #####################
        Criarei vetores de Strings, nesses vetores, cada posição armazena
        uma string contendo o patch para cada arquivo isolado. cada bateria de 
        testes acessa 11 arquivos diferentes, a quantidade de elementos no 
        arquivo apontado por cada indice é a seguinte:
        
        indice [0] -  100.000 
        indice [1] -  160.000
        indice [2] -  220.000
        indice [3] -  280.000
        indice [4] -  340.000
        indice [5] -  400.000
        indice [6] -  460.000
        indice [7] -  520.000
        indice [8] -  580.000
        indice [9] -  640.000
        indice [10] - 700.000
        
        ######################################################################
         */
        //construindo o vetor para os Aleatorios distintos
        String[] AleatoriosDistintos = new String[11];
        AleatoriosDistintos[0] = "Test-inputs/aleatorios/distintos/ale-dist-100.txt";
        AleatoriosDistintos[1] = "Test-inputs/aleatorios/distintos/ale-dist-160.txt";
        AleatoriosDistintos[2] = "Test-inputs/aleatorios/distintos/ale-dist-220.txt";
        AleatoriosDistintos[3] = "Test-inputs/aleatorios/distintos/ale-dist-280.txt";
        AleatoriosDistintos[4] = "Test-inputs/aleatorios/distintos/ale-dist-340.txt";
        AleatoriosDistintos[5] = "Test-inputs/aleatorios/distintos/ale-dist-400.txt";
        AleatoriosDistintos[6] = "Test-inputs/aleatorios/distintos/ale-dist-460.txt";
        AleatoriosDistintos[7] = "Test-inputs/aleatorios/distintos/ale-dist-520.txt";
        AleatoriosDistintos[8] = "Test-inputs/aleatorios/distintos/ale-dist-580.txt";
        AleatoriosDistintos[9] = "Test-inputs/aleatorios/distintos/ale-dist-640.txt";
        AleatoriosDistintos[10] = "Test-inputs/aleatorios/distintos/ale-dist-700.txt";

        //construindo o vetor para os Crescentes distintos
        String[] CrescentesDistintos = new String[11];
        CrescentesDistintos[0] = "Test-inputs/crescentes/distintos/cre-dist-100.txt";
        CrescentesDistintos[1] = "Test-inputs/crescentes/distintos/cre-dist-160.txt";
        CrescentesDistintos[2] = "Test-inputs/crescentes/distintos/cre-dist-220.txt";
        CrescentesDistintos[3] = "Test-inputs/crescentes/distintos/cre-dist-280.txt";
        CrescentesDistintos[4] = "Test-inputs/crescentes/distintos/cre-dist-340.txt";
        CrescentesDistintos[5] = "Test-inputs/crescentes/distintos/cre-dist-400.txt";
        CrescentesDistintos[6] = "Test-inputs/crescentes/distintos/cre-dist-460.txt";
        CrescentesDistintos[7] = "Test-inputs/crescentes/distintos/cre-dist-520.txt";
        CrescentesDistintos[8] = "Test-inputs/crescentes/distintos/cre-dist-580.txt";
        CrescentesDistintos[9] = "Test-inputs/crescentes/distintos/cre-dist-640.txt";
        CrescentesDistintos[10] = "Test-inputs/crescentes/distintos/cre-dist-700.txt";

        //construindo o vetor para os Decrescentes distintos
        String[] DecrescentesDistintos = new String[11];
        DecrescentesDistintos[0] = "Test-inputs/decrescentes/distintos/dec-dist-100.txt";
        DecrescentesDistintos[1] = "Test-inputs/decrescentes/distintos/dec-dist-160.txt";
        DecrescentesDistintos[2] = "Test-inputs/decrescentes/distintos/dec-dist-220.txt";
        DecrescentesDistintos[3] = "Test-inputs/decrescentes/distintos/dec-dist-280.txt";
        DecrescentesDistintos[4] = "Test-inputs/decrescentes/distintos/dec-dist-340.txt";
        DecrescentesDistintos[5] = "Test-inputs/decrescentes/distintos/dec-dist-400.txt";
        DecrescentesDistintos[6] = "Test-inputs/decrescentes/distintos/dec-dist-460.txt";
        DecrescentesDistintos[7] = "Test-inputs/decrescentes/distintos/dec-dist-520.txt";
        DecrescentesDistintos[8] = "Test-inputs/decrescentes/distintos/dec-dist-580.txt";
        DecrescentesDistintos[9] = "Test-inputs/decrescentes/distintos/dec-dist-640.txt";
        DecrescentesDistintos[10] = "Test-inputs/decrescentes/distintos/dec-dist-700.txt";

        //testando a integridade existencial dos arquivos antes de proseguir
        boolean valid = true;
        valid = FileCheck(AleatoriosDistintos);
        if (valid) {
            valid = FileCheck(CrescentesDistintos);
        }
        if (valid) {
            valid = FileCheck(DecrescentesDistintos);
        }
        if (!valid) {
            System.out.println("a verificação de existência "
                    + "dos arquivos falhou. cheque a pasta Test-inputs");

            JOptionPane.showMessageDialog(null, "a verificação de existência "
                    + "dos arquivos falhou. cheque a pasta Test-inputs");
            System.exit(1);
        }

        //pergunta ao usuario quantas execuções devem ser feitas pra cada teste
        int NumExec = 0;
        while (NumExec <= 0) {
            String NumExecStr = JOptionPane.showInputDialog(null, "Quantas execuções "
                    + "você quer fazer para para cada teste?");
            try {
                NumExec = Integer.parseInt(NumExecStr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "resposta invalida. informe um numero inteiro");
            }
        }

        /*
        ######################## PARTE 1 ########################
        ################ TESTES DO BUBBLE SORT ##################
        #########################################################
         */
        //aleatorios distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(AleatoriosDistintos[i]);
                    long start = System.currentTimeMillis();
                    BubbleSort(array, 0);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "ale", "dist", elapsed, "BubbleSort");
                    System.out.println("Registro de BubbleSort aleatorio"
                            + elementos(i) + " adicionado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //crescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(CrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    BubbleSort(array, 0);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "BubbleSort");
                    System.out.println("Registro de BubbleSort crescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //decrescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(DecrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    BubbleSort(array, 0);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "BubbleSort");
                    System.out.println("Registro de BubbleSort decrescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        /*
        ######################## PARTE 2 ########################
        ############### TESTES DO INSERTION SORT ################
        #########################################################
         */
        //aleatorios distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(AleatoriosDistintos[i]);
                    long start = System.currentTimeMillis();
                    InsertionSort(array, 0);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "ale", "dist", elapsed, "InsertionSort");
                    System.out.println("Registro de InsertionSort aleatorio"
                            + elementos(i) + " adicionado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //crescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(CrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    InsertionSort(array, 0);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "InsertionSort");
                    System.out.println("Registro de InsertionSort crescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //decrescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(DecrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    InsertionSort(array, 0);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "InsertionSort");
                    System.out.println("Registro de InsertionSort decrescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        /*
        ######################## PARTE 3 ########################
        ############### TESTES DO SELECTION SORT ################
        #########################################################
         */
        //aleatorios distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(AleatoriosDistintos[i]);
                    long start = System.currentTimeMillis();
                    SelectionSort(array, 0);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "ale", "dist", elapsed, "SelectionSort");
                    System.out.println("Registro de SelectionSort aleatorio"
                            + elementos(i) + " adicionado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //crescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(CrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    SelectionSort(array, 0);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "SelectionSort");
                    System.out.println("Registro de SelectionSort crescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //decrescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(DecrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    SelectionSort(array, 0);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "SelectionSort");
                    System.out.println("Registro de SelectionSort decrescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        /*
        ######################## PARTE 4 ########################
        ################# TESTES DO MERGE SORT ##################
        #########################################################
         */
        //aleatorios distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(AleatoriosDistintos[i]);
                    long start = System.currentTimeMillis();
                    MergeSort(array, 0, array.length);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "ale", "dist", elapsed, "MergeSort");
                    System.out.println("Registro de MergeSort aleatorio"
                            + elementos(i) + " adicionado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //crescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(CrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    MergeSort(array, 0, array.length);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "MergeSort");
                    System.out.println("Registro de MergeSort crescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //decrescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(DecrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    MergeSort(array, 0, array.length);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "MergeSort");
                    System.out.println("Registro de MergeSort decrescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        
        /*
        ######################## PARTE 5 ########################
        ################# TESTES DO QUICK SORT ##################
        #########################################################
         */
        //aleatorios distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(AleatoriosDistintos[i]);
                    long start = System.currentTimeMillis();
                    QuickSort(array, 0, array.length);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "ale", "dist", elapsed, "QuickSort");
                    System.out.println("Registro de QuickSort aleatorio"
                            + elementos(i) + " adicionado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //crescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(CrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    QuickSort(array, 0, array.length);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "QuickSort");
                    System.out.println("Registro de QuickSort crescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //decrescentes distintos
        for (int i = 0; i < 11; i++) { //executa testes com os 11 arquivos
            for (int z = 0; z < NumExec; z++) {//executa NumExec testes em cada arquivo
                try {
                    int[] array = Files.getIntArray(DecrescentesDistintos[i]);
                    long start = System.currentTimeMillis();
                    QuickSort(array, 0, array.length);
                    long elapsed = System.currentTimeMillis() - start;
                    AddRegistro(elementos(i), "cre", "dist", elapsed, "QuickSort");
                    System.out.println("Registro de QuickSort decrescente "
                            + elementos(i) + " adicionado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo" + ex);
                    Logger.getLogger(Script.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        
        
        
        
        
        
        
        
        
        
        
        

    }

    /**
     * Este método informa ao laço de repetição que o invoca, a quantidade de
     * elementos presentes na posição i, conforme descrito nos comentarios
     * iniciais desta classe
     *
     * @author Mateus Garcia
     * @param i posição do vetor de patchs
     * @return inteiro dos elementos presentes no arquivo especificado
     */
    public static int elementos(int i) {
        switch (i) {
            case 0:
                return 100000;
            case 1:
                return 160000;
            case 2:
                return 220000;
            case 3:
                return 280000;
            case 4:
                return 340000;
            case 5:
                return 400000;
            case 6:
                return 460000;
            case 7:
                return 520000;
            case 8:
                return 580000;
            case 9:
                return 640000;
            case 10:
                return 700000;
        }
        //se nao der return ate aqui, entao ta errado....
        JOptionPane.showMessageDialog(null, "erro ao executar elementos()");
        return 0;
    }

    //testes aqui
    public static void main(String[] args) {
        new Script().run();
    }
}
