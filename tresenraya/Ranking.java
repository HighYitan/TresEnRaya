package tresenraya ;


public class Ranking {
    private int partidasJugadas;    
    private int ganadas;    
    private int empates;
    private Sesion sesion;
 
    public Ranking(){
        partidasJugadas = 0;
        ganadas = 0;
        empates = 0;
    }
    public int getEmpates(){
        return empates;
    }
    public int getGanadas(){
        return ganadas;
    }
    public int getPartidasJugadas(){
        return partidasJugadas;
    }
    public Sesion getSesion() {
        return sesion;
    }
    public void setEmpates(int empates){
        this.empates = empates;
    }
    public void setGanadas(int ganadas){
        this.ganadas = ganadas;
    }
    public void setPartidasJugadas(int partidasJugadas){
        this.partidasJugadas = partidasJugadas;
    }
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
    public void mostrar() {
        System.out.println("Partidas jugadas: " + partidasJugadas + "  ");
        System.out.println("Partidas ganadas: " + ganadas + "  ");
        System.out.println("Partidas empatadas: " + empates + "  ");
        this.sesion.menuVolver();   
    }
    public void upgPartidasJugadas() {
        this.partidasJugadas++;
    }
    public void upgGanadas() {
        this.ganadas++;
    }
    public void upgEmpates() {
        this.empates++;
    }
}
