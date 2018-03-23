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
    public Jugador crearPersona(String nombre) {
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setSesion(this);
        jugadores.add(jugador);
        return jugador;
    }
    public IA0 crearIA0() {
        IA0 ia0 = new IA0();
        ia0.setSesion(this);
        return ia0;
    }
    public IA1 crearIA1() {
        IA1 ia1 = new IA1();
        ia1.setSesion(this);
        return ia1;
    }
    public Partida crearPartida(Jugador jugador1, Jugador jugador2) {
        Partida partida = new Partida(jugador1, jugador2);
        jugador1.setPartida(partida);
        jugador2.setPartida(partida);
        partida.setSesion(this);
        partidas.add(partida);
        partida.setTurno(TurnoSorteado());
        return partida;
    }
    public void crearRanking() {
        Ranking ranking = new Ranking();
        this.ranking = ranking;
        ranking.setSesion(this);
    }
    public void empezarPartida() {
        System.out.println();
        System.out.println("1. Luchar contra IA0");
        System.out.println("2. Luchar contra IA1");
        Scanner num = new Scanner(System.in);
        System.out.println("Elige una opción:");
        boolean menu = false;
        int val;
        do {
            val = num.nextInt();
            if (val != 1 && val != 2) {
                System.out.println("Opción inválida");
            } else {
                menu = true;
                switch (val) {
                    case 1:
                        System.out.println();
                        Scanner nombre = new Scanner(System.in);
                        System.out.println("Nombre:");
                        Partida partida = crearPartida(crearPersona(nombre.next()), crearIA0());
                        System.out.println();
                        partida.jugar();
                        System.out.println("FIN...");
                        menuRetorno();
                        break;
                    case 2:
                        System.out.println();
                        Scanner nombre2 = new Scanner(System.in);
                        System.out.println("Nombre:");
                        partida = crearPartida(crearPersona(nombre2.next()), crearIA1());
                        System.out.println();
                        partida.jugar();
                        System.out.println("FIN...");
                        menuRetorno();
                        break;
                }
            }
        } while (!menu);
    }
    public static void iniciar() {
        Sesion sesion = new Sesion();
        sesion.crearRanking();
        sesion.menu();
    }
    public void menu() {
        presentacionMenu();
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
                        empezarPartida();
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
    public void menuRetorno() {
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
                System.out.println("Opción inválida");
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
    public boolean TurnoSorteado() {
        return (Math.random() < 0.5);
    }
    public void mostrarRanking() {
        ranking.mostrar();
    }
    public void presentacionMenu() {
        System.out.println();
        System.out.println("1. Empezar una partida");
        System.out.println("2. Mostrar el Ranking");
        System.out.println("3. Salir de la sesión");
    }
}