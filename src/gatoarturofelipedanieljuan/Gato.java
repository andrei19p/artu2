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
public class Gato {

    public Jugador Jugador1;
    public Jugador Jugador2;
    private char caracterJug1;
    private char caracterJug2;
    private boolean turno=true;
    private char fichaGanadora;
    private int contador=0;

    public Jugador getJugador1() {
        return Jugador1;
    }

    

    public void setJugador1(Jugador Jugador1) {
        this.Jugador1 = Jugador1;
    }

    public Jugador getJugador2() {
        return Jugador2;
    }

    public void setJugador2(Jugador Jugador2) {
        this.Jugador2 = Jugador2;
    }

    public char getCaracterJug1() {
        return caracterJug1;
    }

    public void setCaracterJug1(char caracterJug1) {
        this.caracterJug1 = caracterJug1;
    }

    public char getCaracterJug2() {
        return caracterJug2;
    }

    public int getContador() {
        return contador;
    }

    public void setCaracterJug2(char caracterJug2) {
        this.caracterJug2 = caracterJug2;
    }
public void setTurno(boolean turno) {
        this.turno = turno;
    }
    public Gato() {
         String name=JOptionPane.showInputDialog(null, "Digite Nombre de jugador 1");
          String name2=JOptionPane.showInputDialog(null, "Digite Nombre de jugador");
        Jugador1 = new Jugador();
        Jugador1.setNombreJugador(name);
        Jugador2 = new Jugador();
        Jugador2.setNombreJugador(name2);
        caracterJug1 = 'X';
        caracterJug2 = 'O';
    }

    public Gato(Jugador FirstPlayer, Jugador SecondPlayer, char carjug1, char carjug2) {

        Jugador1 = FirstPlayer;
        Jugador2 = SecondPlayer;
        caracterJug1 = carjug1;
        caracterJug2 = carjug2;
    }

    public void turnoJugador(char[][] matriz) {
       
        imprimirGato(matriz);
            int fila = (Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la fila"))) - 1;
        int columna = (Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la columna"))) - 1;
        if(turno==true){
        registrarJugada(matriz, fila, columna, 'X');
        this.setTurno(false);
        }
        else{
        registrarJugada(matriz, fila, columna, 'O');
        this.setTurno(true);
        }
        contador+=1;
    }

    public boolean casillaVacia(char[][] matriz, int fil, int column) {
        boolean comprobacion = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[fil][column] == ' ' || matriz[fil][column]=='|') {
                    comprobacion = true;
                } else {
                    comprobacion = false;
                }

            }
        }
        return comprobacion;
    }

    public void registrarJugada(char[][] matriz, int fil, int column, char marca) {
        while (casillaVacia(matriz, fil, column) == false) {
            fil = Integer.parseInt(JOptionPane.showInputDialog("Error, jugada invalida, la casilla esta ocupada;" + "\n" + "Digite de nuevo la fila"));
            column = Integer.parseInt(JOptionPane.showInputDialog("Digite de nuevo la columna"));
        }
        matriz[fil][column] = marca;
    }

    public boolean ganarHilera(char[][] matriz) {

        boolean Ganador = false;

        if (matriz[0][0] == caracterJug1 && matriz[0][1] == caracterJug1 && matriz[0][2] == caracterJug1) {
            Ganador = true;
            this.fichaGanadora=caracterJug1;
        } else if (matriz[1][0] == caracterJug1 && matriz[1][1] == caracterJug1 && matriz[1][2] == caracterJug1) {
           Ganador = true;
           this.fichaGanadora=caracterJug1;
        } else if (matriz[2][0] == caracterJug1 && matriz[2][1] == caracterJug1 && matriz[2][2] == caracterJug1) {
           Ganador = true;
           this.fichaGanadora=caracterJug1;
        }
        else
            if (matriz[0][0] == caracterJug2 && matriz[0][1] == caracterJug2 && matriz[0][2] == caracterJug2) {
            Ganador = true;
            this.fichaGanadora=caracterJug2;
        } else if (matriz[1][0] == caracterJug2 && matriz[1][1] == caracterJug2 && matriz[1][2] == caracterJug2) {
           Ganador = true;
           this.fichaGanadora=caracterJug2;
        } else if (matriz[2][0] == caracterJug2 && matriz[2][1] == caracterJug2 && matriz[2][2] == caracterJug2) {

           Ganador = true;
           this.fichaGanadora=caracterJug2;
        }
        return Ganador;
    }

    public boolean ganarColumna(char[][] matriz) {

        boolean Ganador = false;

        if (matriz[0][0] == caracterJug1 && matriz[1][0] == caracterJug1 && matriz[2][0] == caracterJug1) {
            Ganador = true;
            this.fichaGanadora=caracterJug1;
        } else if (matriz[0][1] == caracterJug1 && matriz[1][1] == caracterJug1 && matriz[2][1] == caracterJug1) {
            Ganador = true;
            this.fichaGanadora=caracterJug1;
        } else if (matriz[0][2] == caracterJug1 && matriz[1][2] == caracterJug1 && matriz[2][2] == caracterJug1) {

           Ganador = true;
           this.fichaGanadora=caracterJug1;
        }
        else
             if (matriz[0][0] == caracterJug2 && matriz[1][0] == caracterJug2 && matriz[2][0] == caracterJug2) {
            Ganador = true;
            this.fichaGanadora=caracterJug2;
        } else if (matriz[0][1] == caracterJug2 && matriz[1][1] == caracterJug2 && matriz[2][1] == caracterJug2) {
            Ganador = true;
            this.fichaGanadora=caracterJug2;
        } else if (matriz[0][2] == caracterJug2 && matriz[1][2] == caracterJug2 && matriz[2][2] == caracterJug2) {

           Ganador = true;
           this.fichaGanadora=caracterJug2;
        }
        return Ganador;
    }

    public boolean ganarDiagonal(char[][] matriz) {

        boolean Ganador = false;

        if (matriz[0][0] == caracterJug1 && matriz[1][1] == caracterJug1 && matriz[2][2] == caracterJug1) {
           Ganador = true;
           this.fichaGanadora=caracterJug1;
        } else if (matriz[0][2] == caracterJug1 && matriz[1][1] == caracterJug1 && matriz[2][0] == caracterJug1) {
           Ganador = true;
           this.fichaGanadora=caracterJug1;
        }
        else
            if (matriz[0][0] == caracterJug2 && matriz[1][1] == caracterJug2 && matriz[2][2] == caracterJug2) {
           Ganador = true;
           this.fichaGanadora=caracterJug2;
        } else if (matriz[0][2] == caracterJug2 && matriz[1][1] == caracterJug2 && matriz[2][0] == caracterJug2) {
           Ganador = true;
           this.fichaGanadora=caracterJug2;
        }
        return Ganador;
    }

    public void imprimirGato(char[][] matriz) {
        String impresion = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                impresion += "" + matriz[i][j] + "\t";
                if (j != matriz[i].length - 1) {
                    impresion += "  |  ";
                } else {
                    impresion += "\n";
                }
           }
        }
        JOptionPane.showMessageDialog(null,
                impresion,
                "Matriz",
                JOptionPane.INFORMATION_MESSAGE);
         
    }
void ganador(){
    if(this.fichaGanadora==this.caracterJug1){
        JOptionPane.showMessageDialog(null, "El jugador 1: "+this.Jugador1.getNombreJugador()+" gano");
    }
    else if(this.fichaGanadora==this.caracterJug2){
        JOptionPane.showMessageDialog(null, "El jugador 2: " +this.Jugador2.getNombreJugador()+ " gano");
    }
    else{
        JOptionPane.showMessageDialog(null, "Quedaron empates");
    }
}
}
