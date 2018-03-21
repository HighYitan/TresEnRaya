package tresenraya ;


public class Ranking {
    private int partidasJugadas;    
    private int ganadasPersona;    
    private int empates;
    private Sesion sesion;
 
    public Ranking(){
        partidasJugadas = 0;
        ganadasPersona = 0;
        empates = 0;
    }
    public int getEmpates(){
        return empates;
    }
    public int getGanadas(){
        return ganadasPersona;
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
        this.ganadasPersona = ganadas;
    }
    public void setPartidasJugadas(int partidasJugadas){
        this.partidasJugadas = partidasJugadas;
    }
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
    public void mostrar() {
        System.out.println("Partidas jugadas: " + partidasJugadas + "  ");
        System.out.println("Partidas ganadas: " + ganadasPersona + "  ");
        System.out.println("Partidas empatadas: " + empates + "  ");
        this.sesion.menuRetorno();   
    }
    public void sumarPartidasJugadas() {
        this.partidasJugadas++;
    }
    public void sumarGanadas() {
        this.ganadasPersona++;
    }
    public void sumarEmpates() {
        this.empates++;
    }
}
