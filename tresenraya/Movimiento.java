package tresenraya ;


public class Movimiento {
    
    private Jugador jugador;    
    private boolean blancas;    
    private int row;    
    private int col; 
 
    public Movimiento(){
        super();
    }
    public Jugador getJugador(){
        return jugador;
    }
    public boolean getBlancas(){
        return blancas;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }
    public void setBlancas(boolean blancas){
        this.blancas = blancas;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }
}
