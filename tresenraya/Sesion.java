package tresenraya ;

import java.util.*;


public class Sesion {
 
    private ArrayList<Jugador> jugadores;
    private ArrayList<Partida> partidas;
    private Ranking ranking;
 
    public Sesion(){
        partidas = new ArrayList<Partida>();
        jugadores = new ArrayList<Jugador>();
    }
    public static void main(String[] args) {
        iniciar();
    }
    public Ranking getRanking() {
        return ranking;
    }
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }
    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public Jugador crearHumano(String nombre) {
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setSesion(this);
        jugadores.add(jugador);
        return jugador;
    }
    public IA0 crearIA() {
        IA0 ia = new IA0();
        ia.setSesion(this);
        return ia;
    }
    public Partida crearPartida(Jugador jugador1, Jugador jugador2) {
        Partida partida = new Partida(jugador1, jugador2);
        jugador1.setPartida(partida);
        jugador2.setPartida(partida);
        partida.setSesion(this);
        partidas.add(partida);
        partida.setTurno(sorteoTurno());
        return partida;
    }
    public void crearRanking() {
        Ranking ranking = new Ranking();
        this.ranking = ranking;
        ranking.setSesion(this);
    }
    public void empezar() {
        System.out.println();
        Scanner nom = new Scanner(System.in);
        System.out.println("Nombre:");
        Partida partida = crearPartida(crearHumano(nom.next()), crearIA());
        System.out.println();
        partida.jugar();
        System.out.println("FIN...");
        menuVolver();

    }
    public static void iniciar() {
        Sesion sesion = new Sesion();
        sesion.crearRanking();
        sesion.menu();
    }
    public void menu() {
        ventMenu();
        Scanner num = new Scanner(System.in);
        System.out.println();
        System.out.println("Elige una opción:");
        boolean menu = false;
        int val;
        do {
            val = num.nextInt();
            if (val != 1 && val != 2 && val != 3) {
                System.out.println();
                System.out.println("Opción inválida");

            } else {
                menu = true;
                switch (val) {
                    case 1:
                        System.out.println();
                        System.out.println("QUE COMIENCEN LOS JUEGOS");
                        empezar();
                        break;
                    case 2:
                        System.out.println();
                        mostrarRanking();
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Sesión terminada.");
                        break;
                }
            }
        } while (!menu); 
    }
    public void menuVolver() {
        System.out.println();
        System.out.println("1. Volver al menú");
        System.out.println("2. Salir de la sesión");
        Scanner num = new Scanner(System.in);
        System.out.println("Elige una opción:");
        boolean menu = false;
        int val;
        do {
            val = num.nextInt();
            if (val != 1 && val != 2) {
                System.out.println("/!/Introduce un número válido para las opciones/!/");
            } else {
                menu = true;
                switch (val) {
                    case 1:
                        menu();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Sesión terminada.");
                        break;
                }
            }
        } while (!menu);

    }
    //Genera un número entre el 0 y el 1
    public boolean sorteoTurno() {
        return (Math.random() < 0.5);
    }
    public void mostrarRanking() {
        ranking.mostrar();
    }
    public void ventMenu() {
        System.out.println();
        System.out.println("1. Empezar una partida");
        System.out.println("2. Mostrar el Ranking");
        System.out.println("3. Salir de la sesión");
    }
}