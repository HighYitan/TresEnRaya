package tresenraya;

public class IA2 extends IA1 {
    int peso[][];
    public IA2(){
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
    public Movimiento comprovarHoritzontals(String fitxa){
        Movimiento m=null;
        int fila=0;
        boolean buida;
        int columna=0;
        int contadorPlenes;
        for(int fil=0 ; fil<3 ; fil++){
            buida=false;
            contadorPlenes=0;
            for(int col=0 ; col<3 ; col++){
                
            if(this.tablero.validarCasillaVacia(fil, col) == 0){
             fila=fil;
             columna=col;
             buida=true;
            }
            if(this.taulellIA.validarCasellaBuida(fil, col).equals(fitxa)){
             contadorPlenes++;   
            }
            }
            if(contadorPlenes==2 && buida){
             m=new Moviment();
             m.setCol(columna);
             m.setFil(fila);
            }
            
        }
       
        
        return m;
        
    }
}
