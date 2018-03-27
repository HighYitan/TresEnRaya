package tresenraya;

public class IA4 extends IA3 {

    public IA4() {
    
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
    public void pesoRecalculado(Movimiento fichaje) {
        int x = fichaje.getRow();
        int y = fichaje.getCol();
        boolean casillaEsquina1 = false;
        boolean casillaEsquina2 = false;
        if (y == 0 && x != 1) {
            for (int i = 1, j = 1; i < peso.length; i++, j--) {
                if (x == 0) {
                    peso[i][0]--;
                    if (!casillaEsquina1) {
                        for (int z = 1; z < peso.length; z++) {
                            peso[z][z]--;
                        }
                        casillaEsquina1 = true;
                    }
                } 
                else if (x == 2) {
                    peso[j][0]--;
                    if (!casillaEsquina2) {
                        for (int z = 1, k = 1; z < peso.length; z++, k--) {
                            peso[z][k]--;
                        }
                        casillaEsquina2 = true;
                    }
                }
                peso[x][i]--;
            }
        }
        else if (y == 2 && x != 1) {
            for (int i = 1, j = 1; i < peso.length; i++, j--) {
                if (x == 0) {
                    peso[i][0]--;
                    if (!casillaEsquina2) {
                        for (int z = 1, k = 1; z < peso.length; z++, k--) {
                            peso[k][z]--;
                        }
                        casillaEsquina2 = true;
                    }
                    peso[j][i]--;
                } 
                else if (x == 2) {
                    peso[j][0]--;
                    if (!casillaEsquina1) {
                        for (int z = 1; z > 0; z--) {
                            peso[z][z]--;
                        }
                        casillaEsquina1 = true;
                    }
                }
                peso[x][j]--;
            }
        }
        boolean casillaCruz1 = false;
        boolean casillaCruz2 = false;
        if (y == 1 && x != 1) {
            peso[x][0]--;
            peso[x][2]--;

            if (casillaCruz1 == false) {
                for (int i = 1, j = 1; i < peso.length; i++, j--) {
                    if (x == 0) {
                        peso[i][y]--;
                    } else if (x == 2) {
                        peso[j][y]--;
                    }
                }
                casillaCruz1 = true;
            }
        } 
        else if (y != 1 && x == 1) {
            peso[0][y]--;
            peso[2][y]--;

            if (casillaCruz2 == false) {
                for (int i = 1, j = 1; i < peso.length; i++, j--) {
                    if (y == 0) {
                        peso[x][i]--;
                    } else if (y == 2) {
                        peso[x][j]--;
                    }
                }
                casillaCruz2 = true;
            }
        }
    }
}