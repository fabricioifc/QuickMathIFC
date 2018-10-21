/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quick.math.calculos.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author aluno
 */
public class Util {
    
    private List<Integer> listaNumerosErrados = null;

    private int getNumeroMaximoPorNivel(int nivel, char operacao) {
        // Para multiplicação
        if (Character.valueOf('*').equals(operacao)) {
            switch (nivel) {
                case 0:
                    return 10;
                case 1:
                    return 12;
                case 2:
                    return 15;
                default:
                    return 10;
            }

        } else {
            //Outras Operações
            switch (nivel) {
                case 0:
                    return 20;
                case 1:
                    return 30;
                case 2:
                    return 40;
                default:
                    return 20;

            }
        }
    }

    public Integer gerarNumeroAleatorio(int nivel, char operacao) {
        return 1 + (int) (Math.random() * getNumeroMaximoPorNivel(nivel, operacao));
    }

    public Integer gerarNumeroErrado(Integer numeroCorreto) {
        Integer numeroErrado = null;
        Integer numeroMinimo = numeroCorreto > 10 ? numeroCorreto - 10 : numeroCorreto / 2;
        Integer numeroMaximo = numeroCorreto + 10;
        
        if (listaNumerosErrados == null) {
            listaNumerosErrados = new ArrayList<Integer>();
        }
        
        while (numeroErrado == null || numeroErrado.equals(numeroCorreto) || verificarNumeroJaUtilizado(numeroErrado)) {
            numeroErrado = new Random().nextInt(numeroMaximo - numeroMinimo) + numeroMinimo;
        }
        listaNumerosErrados.add(numeroErrado); //Adicionar o número errado na lista
        return numeroErrado;
    }
    
    private boolean verificarNumeroJaUtilizado(int numeroErrado) {
        for (Integer numero : listaNumerosErrados) {
            if (numeroErrado == numero) {
                return true;
            }
        }
        return false;
    }
    
    public void limparLista() {
        listaNumerosErrados = null;
    }
}
