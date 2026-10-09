import java.util.Scanner;

public class Gato {
    static char[][] tablero = new char[3][3];
    static int turnoJugador = 0; // 0 para 'X', 1 para 'O'
    static char[] simbolos = {'X', 'O'};

    public static void main(String[] args) {
        inicializarTablero();
        while (true) {
            imprimirTablero();
            if (realizarMovimiento()) {
                if (verificarGanador()) {
                    imprimirTablero();
                    System.out.println("¡Jugador " + simbolos[turnoJugador] + " es el ganador!");
                    break;
                }
                if (esTableroLleno()) {
                    imprimirTablero();
                    System.out.println("¡Empate!");
                    break;
                }
                turnoJugador = (turnoJugador + 1) % 2; // Cambia de jugador
            }
        }
    }

    public static void inicializarTablero() {
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public static void imprimirTablero() {
        System.out.println(tablero[0][0] + "|" + tablero[0][1] + "|" + tablero[0][2]);
        System.out.println("-----");
        System.out.println(tablero[1][0] + "|" + tablero[1][1] + "|" + tablero[1][2]);
        System.out.println("-----");
        System.out.println(tablero[2][0] + "|" + tablero[2][1] + "|" + tablero[2][2]);
    }

    public static boolean realizarMovimiento() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Jugador " + simbolos[turnoJugador] + ", ingresa tu movimiento (1-9): ");
        int movimiento = leer.nextInt() - 1;
        int fila = movimiento / 3;
        int columna = movimiento % 3;

        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = simbolos[turnoJugador];
            return true;
        } else {
            System.out.println("Movimiento inválido.");
            return false;
        }
    }

    public static boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == simbolos[turnoJugador] && tablero[i][1] == simbolos[turnoJugador] && tablero[i][2] == simbolos[turnoJugador]) {
                return true; // Verifica filas
            }
            if (tablero[0][i] == simbolos[turnoJugador] && tablero[1][i] == simbolos[turnoJugador] && tablero[2][i] == simbolos[turnoJugador]) {
                return true; // Verifica columnas
            }
        }
        if (tablero[0][0] == simbolos[turnoJugador] && tablero[1][1] == simbolos[turnoJugador] && tablero[2][2] == simbolos[turnoJugador]) {
            return true; // Verifica diagonal
        }
        if (tablero[0][2] == simbolos[turnoJugador] && tablero[1][1] == simbolos[turnoJugador] && tablero[2][0] == simbolos[turnoJugador]) {
            return true; // Verifica diagonal inversa
        }
        return false;
    }

    public static boolean esTableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false; // Hay al menos una celda vacía
                }
            }
        }
        return true; // No hay celdas vacías
    }
}