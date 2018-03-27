package tresenraya;

public class IA3 extends IA2 {

    public IA3(){

    }      
    @Override
    public Movimiento movimiento(Tablero tablero) {
        int[][] casillas = tablero.getCasillas();
        Movimiento jugada = new Movimiento();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (movimientoGanador(tablero.getCasillas()) != null) {
                    return movimientoGanador(tablero.getCasillas());
                }
                else if (evitarPerder(tablero.getCasillas()) != null) {
                    return evitarPerder(tablero.getCasillas());
                }
                else {
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
        }
        return null;
    }
    public Movimiento evitarPerder(int[][] casillas) {
        int[] coordenadas = new int[2];
        Movimiento mov = new Movimiento();
        mov.setBlancas(false);
        mov.setJugador(this);
        if (evitarPerderColumna(casillas)[0] != -1) {
            coordenadas = evitarPerderColumna(casillas);
            mov.setRow(coordenadas[0]);
            mov.setCol(coordenadas[1]);
            return mov;
        } 
        else if (evitarPerderFila(casillas)[0] != -1) {
            coordenadas = evitarPerderFila(casillas);
            mov.setRow(coordenadas[0]);
            mov.setCol(coordenadas[1]);
            return mov;
        } 
        else if (evitarPerderDiagonal(casillas)[0] != -1) {
            coordenadas = evitarPerderDiagonal(casillas);
            mov.setRow(coordenadas[0]);
            mov.setCol(coordenadas[1]);
            return mov;
        } 
        else {
            return null;
        }
    }
    public int[] evitarPerderFila(int[][] casillas) {
        int[] ficha = new int[3];
        int[] coordenadas = new int[]{-1, -1};
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                ficha[j] = casillas[i][j];
            }
            if (comprobarFichaPerdedora(ficha) != -1) {
                coordenadas[0] = i;
                coordenadas[1] = comprobarFichaPerdedora(ficha);
            }
        }
        return coordenadas;
    }
    public int[] evitarPerderColumna(int[][] casillas) {
        int[] ficha = new int[3];
        int[] coordenadas = new int[]{-1, -1};
        for (int i = 0; i < casillas[0].length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                ficha[j] = casillas[j][i];
            }
            if (comprobarFichaPerdedora(ficha) != -1) {
                coordenadas[0] = comprobarFichaPerdedora(ficha);
                coordenadas[1] = i;
            }
        }
        return coordenadas;
    }
    public int[] evitarPerderDiagonal(int[][] casillas) {
        int[] ficha = new int[3];
        int[] coordenadas = new int[]{-1, -1};

        for (int i = 0; i < casillas.length; i++) {
            ficha[i] = casillas[i][i];
        }
        if (comprobarFichaPerdedora(ficha) != -1) {
            coordenadas[0] = comprobarFichaPerdedora(ficha);
            coordenadas[1] = comprobarFichaPerdedora(ficha);
            return coordenadas;
        }
        for (int i = 2, j = 0; j < casillas.length; i--, j++) {
            ficha[j] = casillas[i][j];
        }
        if (comprobarFichaPerdedora(ficha) != -1) {
            if (comprobarFichaPerdedora(ficha) == 1) {
                coordenadas[0] = 1;
                coordenadas[1] = comprobarFichaPerdedora(ficha);
            } else if (comprobarFichaPerdedora(ficha) == 0) {
                coordenadas[0] = 2;
                coordenadas[1] = comprobarFichaPerdedora(ficha);

            } else {
                coordenadas[0] = 0;
                coordenadas[1] = comprobarFichaPerdedora(ficha);
            }
        }
        return coordenadas;
    }
    public int comprobarFichaPerdedora(int[] ficha) {
        int contadorIA = 0;

        for (int i = 0; i < ficha.length; i++) {
            if (ficha[i] == 1) {
                contadorIA++;
            }
        }

        if (contadorIA == 2) {
            for (int i = 0; i < ficha.length; i++) {
                if (ficha[i] != 1) {
                    if (ficha[i] == 0) {
                        return i;
                    } else {
                        return -1;
                    }
                }
            }
        }

        return -1;
    }
}