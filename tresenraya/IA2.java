package tresenraya;

public class IA2 extends IA1 {

    public IA2(){

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
   
    public Movimiento movimientoGanador(int[][] casillas) {
        int[] coordenadas = new int[2];
        Movimiento jugada = new Movimiento();
        jugada.setBlancas(false);
        jugada.setJugador(this);
        if (comprobarColumna(casillas)[0] != -1) {
            coordenadas = comprobarColumna(casillas);
            jugada.setRow(coordenadas[0]);
            jugada.setCol(coordenadas[1]);
            return jugada;

        } else if (comprobarFila(casillas)[0] != -1) {
            coordenadas = comprobarFila(casillas);
            jugada.setRow(coordenadas[0]);
            jugada.setCol(coordenadas[1]);
            return jugada;
        } else if (comprobarDiagonal(casillas)[0] != -1) {
            coordenadas = comprobarDiagonal(casillas);
            jugada.setRow(coordenadas[0]);
            jugada.setCol(coordenadas[1]);
            return jugada;
        } 
        else {
            return null;
        }

    }
    public int[] comprobarFila(int[][] casillas) {
        int[] ficha = new int[3];
        int[] coordenadas = new int[]{-1, -1};

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                ficha[j] = casillas[i][j];
            }
            if (comprobarFicha(ficha) != -1) {
                coordenadas[0] = i;
                coordenadas[1] = comprobarFicha(ficha);
            }
        }
        return coordenadas;
    }
    public int[] comprobarColumna(int[][] casillas) {

        int[] ficha = new int[3];
        int[] coordenadas = new int[]{-1, -1};
        for (int i = 0; i < casillas[0].length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                ficha[j] = casillas[j][i];
            }
            if (comprobarFicha(ficha) != -1) {
                coordenadas[0] = comprobarFicha(ficha);
                coordenadas[1] = i;
            }
        }

        return coordenadas;
    }
    public int[] comprobarDiagonal(int[][] casillas) {
        int[] ficha = new int[3];
        int[] coordenadas = new int[]{-1, -1};

        for (int i = 0; i < casillas.length; i++) {
            ficha[i] = casillas[i][i];
        }
        if (comprobarFicha(ficha) != -1) {
            coordenadas[0] = comprobarFicha(ficha);
            coordenadas[1] = comprobarFicha(ficha);
            return coordenadas;
        }
        for (int i = 2, j = 0; j < casillas.length; i--, j++) {
            ficha[j] = casillas[i][j];
        }

        if (comprobarFicha(ficha) != -1) {
            if (comprobarFicha(ficha) == 1) {
                coordenadas[0] = 1;
                coordenadas[1] = comprobarFicha(ficha);
            } 
            else if (comprobarFicha(ficha) == 0) {
                coordenadas[0] = 2;
                coordenadas[1] = comprobarFicha(ficha);

            } 
            else {
                coordenadas[0] = 0;
                coordenadas[1] = comprobarFicha(ficha);
            }
        }
        return coordenadas;

    }
    public int comprobarFicha(int[] ficha) {
        int contadorIA = 0;

        for (int i = 0; i < ficha.length; i++) {
            if (ficha[i] == -1) {
                contadorIA++;
            }
        }

        if (contadorIA == 2) {
            for (int i = 0; i < ficha.length; i++) {
                if (ficha[i] != -1) {
                    if (ficha[i] == 0) {
                        return i;
                    } 
                    else {
                        return -1;
                    }
                }
            }
        }
        return -1;
    }
}