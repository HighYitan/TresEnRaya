package tresenraya;

public class IA1 extends IA0 {
    private int peso[][];
    public IA1(){
        peso = new int[][]{{3,2,3}, {2,4,2}, {3,2,3},};
    }
    @Override
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
                //else {
                //    System.out.println();
                //    System.out.println("Error de la CPU al mover, mal programado amigo");
                //}
            }
        }
        return null;
    }
    public void asignarPeso(int [][] peso){
        
    }
}
