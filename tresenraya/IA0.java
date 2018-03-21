package tresenraya;

public class IA0 extends Jugador {
 
    public IA0(){
        
    }
    public Movimiento movimiento(Tablero tablero) {
        int[][] casillas = tablero.getCasillas();
        Movimiento jugada = new Movimiento();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (tablero.getCasilla(i, j) == 0) {
                    jugada.setRow(i);
                    jugada.setCol(j);
                    jugada.setJugador(this);
                    jugada.setBlancas(false);
                    return jugada;
                }
            }
        }
        return null;
    }
}
