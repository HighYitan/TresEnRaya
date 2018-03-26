package tresenraya;

public class IA1 extends IA0 {
    int peso[][];
    public IA1(){
        peso = new int[][]{{3,2,3}, {2,4,2}, {3,2,3}}; 
    }
    @Override
    public Movimiento movimiento(Tablero tablero) {
        int[][] casillas = tablero.getCasillas();
        Movimiento jugada = new Movimiento();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                
                if (peso[i][j] == buscarPeso(tablero)) {
                    
                    if(tablero.getCasilla(i, j) == 0){
                        jugada.setRow(i);
                        jugada.setCol(j);
                        jugada.setJugador(this);
                        jugada.setBlancas(false);
                        return jugada;
                    }
                }
            }
        }
        return null;
    }
    public int buscarPeso(Tablero tablero) {
        peso = new int[][]{{3,2,3}, {2,4,2}, {3,2,3}};    
        int[][] casillas = tablero.getCasillas();
        int pesoMinimo;
        pesoMinimo = peso[0][1];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (peso[i][j] >= pesoMinimo && tablero.getCasilla(i, j) == 0) {
                    pesoMinimo = peso[i][j];   
                }
            }
        }
       return pesoMinimo;
    }
}