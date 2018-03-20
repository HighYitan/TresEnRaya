package tresenraya ;

import java.util.*;

public class Partida {
    private boolean turno;
    private Jugador[] jugadores;
    private Sesion sesion;
    private Tablero tablero;
 
    public Partida(Jugador jugador1, Jugador jugador2){
        jugadores = new Jugador[2];
        jugadores[0] = jugador1;
        jugadores[1] = jugador2;
    }
    public boolean isTurno() {
        return turno;
    }
    public Jugador getJugador(int j) {
        return jugadores[j];
    }
    public Jugador[] getJugadores() {
        return jugadores;
    }
    public Sesion getSesion() {
        return sesion;
    }
    public Tablero getTablero() {
        return tablero;
    }
    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    public void crearTablero() {
        Tablero tablero = new Tablero();
        tablero.setPartida(this);
        setTablero(tablero);
    }
    public void jugar() {
        crearTablero();
        boolean ganado = false;
        while (!ganado) {
            if (turno) {
                System.out.println("Turno de " + getJugador(0).getNombre() + "  ");
                Scanner num = new Scanner(System.in);
                System.out.println("Fila: ");
                int row = num.nextInt() - 1;
                System.out.println("Columna: ");
                int col = num.nextInt() - 1;
                System.out.println();
                if (tablero.validarMovimiento(getJugador(0).movimiento(row, col))) {
                    tablero.move(getJugador(0).movimiento(row, col));
                } 
                else {
                    ganado = true;
                    this.sesion.getRanking().upgPartidasJugadas();
                    System.out.println("Humillado.");
                    break;
                }
            } 
            else if (getJugador(1) instanceof IA0) {
                System.out.println("Movimiento de la CPU");
                tablero.move(((IA0) getJugador(1)).movimiento(tablero));
            }
            tablero.mostrar();

            if (tablero.comprobarLleno()) {
                ganado = true;
                if (tablero.comprobarGanador()) {
                    if (turno == true) {
                        this.sesion.getRanking().upgGanadas();
                        this.sesion.getRanking().upgPartidasJugadas();
                        System.out.println("Ha ganado " + getJugador(0).getNombre());
                        break;
                    } else {
                        this.sesion.getRanking().upgPartidasJugadas();
                        System.out.println("Perdiste");
                        break;
                    }
                } else {
                    System.out.println("Hemos empatado, otra vez será");
                    this.sesion.getRanking().upgPartidasJugadas();
                    this.sesion.getRanking().upgEmpates();
                    break;
                }
            }

            if (tablero.comprobarGanador()) {
                if (turno == true) {
                    this.sesion.getRanking().upgGanadas();
                    this.sesion.getRanking().upgPartidasJugadas();
                    System.out.println("Ha ganado " + getJugador(0).getNombre());
                } else {
                    this.sesion.getRanking().upgPartidasJugadas();
                    System.out.println("Humillado.");
                }
                ganado = true;
            }
            turno = !turno;
        }
    }
}
