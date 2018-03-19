package tresenraya ;


public class Ranking {
    
    private int partidasJugadas;    
    private int ganadasHumano;    
    private int empates; 
 
    public Ranking(){
        super();
    }
    
    public void mostrar() {
        // TODO implement me    
    }
    
    public void ganar(Jugador parameter) {
        // TODO implement me    
    }
    
    public void empatar() {
        // TODO implement me    
    }
    public int getPartidasJugadas(){
        return partidasJugadas;
    }
    public int getGanadasHumano(){
        return ganadasHumano;
    }
    public int getEmpates(){
        return empates;
    }
    public void setPartidasJugadas(int partidasJugadas){
        this.partidasJugadas = partidasJugadas;
    }
    public void setGanadasHumano(int ganadasHumano){
        this.ganadasHumano = ganadasHumano;
    }
    public void setEmpates(int empates){
        this.empates = empates;
    }
}
