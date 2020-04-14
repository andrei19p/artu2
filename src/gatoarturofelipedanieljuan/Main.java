/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatoarturofelipedanieljuan;

import javax.swing.JOptionPane;

/**
 *
 * @author artqu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char matriz[][] = new char[3][3];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                matriz[i][j]=' ';
            }
        }
        Gato cat = new Gato();
        while(!cat.ganarColumna(matriz)&&!cat.ganarDiagonal(matriz)&&!cat.ganarHilera(matriz)&&cat.getContador()!=9){
            cat.turnoJugador(matriz);
        }
    cat.ganador();
    }

}
