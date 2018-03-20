package tresenraya ;

import java.util.*;

public class Jugador {
    private Partida partida;
    private Sesion sesion;
    private String nombre; 
 
    public Jugador(){
        
    }
    public Partida getPartida() {
        return partida;
    }
    public Sesion getSesion() {
        return sesion;
    }
    public String getNombre(){
        return nombre;
    }
    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public Movimiento movimiento(int row, int col) {
        Movimiento jugada = new Movimiento();
        jugada.setRow(row);
        jugada.setCol(col);
        jugada.setJugador(this);
        if (this.getPartida().getJugador(0) == this) {
            jugada.setBlancas(true);
        } 
        else {
            jugada.setBlancas(false);
        }
        return jugada;
    }
}
