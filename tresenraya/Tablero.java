package tresenraya ;


public class Tablero {
    private int[][] casillas;
    private Partida partida;
 
    public Tablero(){
        casillas = new int[3][3];
    }
    public int getCasilla(int row, int col) {
        return casillas[row][col];
    }
    public int[][] getCasillas() {
        return casillas;
    }
    public Partida getPartida() {
        return partida;
    }
    public void setCasillas(int casillas[][]){
        this.casillas = casillas;
    }
    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    
    public boolean comprobarColumnas() {

        int[] ficha = new int[3];

        for (int i = 0; i < casillas[0].length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                ficha[j] = casillas[j][i];
            }
            if (comprobarFicha(ficha)) {
                return true;
            }
        }
        return false;
    }
    public boolean comprobarDiagonal() {
        int[] ficha = new int[3];

        for (int i = 0; i < casillas.length; i++) {
            ficha[i] = casillas[i][i];
        }
        if (comprobarFicha(ficha)) {
            return true;
        }

        for (int i = 2, j = 0; j < casillas.length; i--, j++) {
            ficha[j] = casillas[i][j];
        }
        return comprobarFicha(ficha);
    }
    public boolean comprobarFicha(int[] ficha) {
        for (int i = 1; i < ficha.length; i++) {
            if (ficha[i - 1] != ficha[i] || ficha[i - 1] == 0) {
                return false;
            }
        }
        return true;
    }
    public boolean comprobarFilas() {

        int[] ficha = new int[3];

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                ficha[j] = casillas[i][j];
            }
            if (comprobarFicha(ficha)) {
                return true;
            }
        }
        return false;
    }
    public boolean comprobarGanador() {
        return (comprobarFilas() || comprobarColumnas() || comprobarDiagonal());
    }
    public boolean comprobarLleno() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public int impresionFicha(boolean ficha) {
        if (ficha) {
            return 1;
        } else {
            return -1;
        }
    }
    public void mover(Movimiento mov) {
        if (validarMovimiento(mov)) {
            casillas[mov.getRow()][mov.getCol()] = impresionFicha(mov.getBlancas());
        }
    }
    public void mostrarTablero() {
        System.out.println(" ___________");
        for (int i = 0; i < casillas.length; i++) {
            System.out.print("|");
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] == 0) {
                    System.out.print(" ~ |");
                } 
                else if (casillas[i][j] == 1) {
                    System.out.print(" O |");
                } 
                else if (casillas[i][j] == -1) {
                    System.out.print(" X |");
                }
                //else{
                   // comprobarPeso(casillas[i]);
                // }
            }
            System.out.println();
        }
        System.out.println(" ¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println();
    }
    public boolean validarCasillaVacia(int row, int col) {
        if (getCasilla(row, col) == 0) {
            return true;
        } 
        else {
            System.out.println("Esta casilla está ocupada amigo");
            return false;
        }
    }
    public boolean validarMovimiento(Movimiento movimiento) {
        int row = movimiento.getRow();
        int col = movimiento.getCol();
        if (col < 3 && col >= 0) {
            if (row < 3 && row >= 0) {
                return (validarCasillaVacia(row, col));
            }
        }
        System.out.println("Movimiento inválido");
        return false;
    }
}