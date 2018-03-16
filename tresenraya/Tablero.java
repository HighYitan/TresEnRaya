package tresenraya ;


public class Tablero {
    
    private final int row_tablero = 2;
    private final int col_tablero = 2;
    private int[][] casillas; 
 
    public Tablero(){
        casillas = new int[row_tablero][col_tablero];
    }
    
    public void mostrar() {
        for (int i = 0; i < row_tablero; i++){
            for(int j = 1; j < col_tablero; j++){
                System.out.print("_|");
            }
            System.out.print("_");
            System.out.println();
        }
        
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (matr == listaVehiculos.get(i).getMatricula()) {
                return listaVehiculos.get(i);
            }
        }
    }
    
    public void validarMovimiento(movimiento parameter) {
        // TODO implement me    
    }
    
    public void mover(movimiento parameter) {
        // TODO implement me    
    }
    
    public boolean comprobarGanador() {
        // TODO implement me 
        return false;    
    }
    
    public void comprobarLleno() {
        // TODO implement me    
    }
    
    public int getCasilla(int row_tablero, int col_tablero) {
        return casillas[row_tablero][col_tablero];
    }
    public int getRowTablero(){
        return row_tablero;
    }
    public int getColTablero(){
        return col_tablero;
    }
    public boolean validarCasillaVacia(int parameter, int parameter2) {
        // TODO implement me 
        return false;    
    }
}