import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static String[][] arreglo = new String[3][3];
    public static void main(String[] args) {
        CerosyCruces();

    }
    public static void ImprimirArreglo(String[][] a)
    {

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[0].length; j++) {
                System.out.print("\t");
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
    public static void AsignarValores (String[][] a){
        int contador = 1;

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[0].length; j++) {
                String conta = ""+contador;
                a[i][j] = conta;
                contador++;
            }

        }
    }

    public static void CerosyCruces(){
        AsignarValores(arreglo);
        System.out.println("Bienvenido al juego de tres en raya introduzcan sus nombres");

        do {
            boolean ciclo = false;
            String pl1,pl2;
            System.out.print("Nombre del jugador 1: ");
            pl1 = scn.nextLine();
            System.out.println(pl1);
            System.out.print("Nombre del jugador 2: ");
            pl2 = scn.nextLine();
            System.out.println(pl2);

            for (int i = 0; 3 >= i; i++) {

                System.out.println("Este movimiento es de " + pl1 + " a continuacion elige un numero disponible para colocar tu X");
                ImprimirArreglo(arreglo);
                int mov = scn.nextInt();
                scn.nextLine();
                mov = MovValido(mov);
                mov = MovOcupado(mov);

                Movimientospl1(mov);
                System.out.println();

                if (i >= 2){
                    ciclo = Tresenraya(pl1,pl2);
                }
                if (ciclo){
                    break;
                }

                System.out.println("Este movimiento es de " + pl2 + " a continuacion elige un numero disponible para colocar tu 0");
                ImprimirArreglo(arreglo);
                mov = scn.nextInt();
                scn.nextLine();
                mov = MovValido(mov);
                mov = MovOcupado(mov);
                Movimientospl2(mov);

                if (i >= 2){
                    ciclo = Tresenraya(pl1,pl2);
                }
                if (ciclo){
                    break;
                }
                if (i == 3){
                    System.out.println("Empate");
                }
            }

            System.out.println("Desean seguir jugando? (S/N)");
            String res = scn.nextLine();
            if (res.equals("S")){
                AsignarValores(arreglo);
            }else {
                break;
            }
        }while (true);



    }

    public static void Movimientospl1(int a){
        switch (a){
            case 1:
                arreglo[0][0] = "X";
                break;
            case 2:
                arreglo[0][1] = "X";
                break;
            case 3:
                arreglo[0][2] = "X";
                break;
            case 4:
                arreglo[1][0] = "X";
                break;
            case 5:
                arreglo[1][1] = "X";
                break;
            case 6:
                arreglo[1][2] = "X";
                break;
            case 7:
                arreglo[2][0] = "X";
                break;
            case 8:
                arreglo[2][1] = "X";
                break;
            case 9:
                arreglo[2][2] = "X";
                break;

        }
    }
    public static void Movimientospl2(int a){
        switch (a){
            case 1:
                arreglo[0][0] = "0";
                break;
            case 2:
                arreglo[0][1] = "0";
                break;
            case 3:
                arreglo[0][2] = "0";
                break;
            case 4:
                arreglo[1][0] = "0";
                break;
            case 5:
                arreglo[1][1] = "0";
                break;
            case 6:
                arreglo[1][2] = "0";
                break;
            case 7:
                arreglo[2][0] = "0";
                break;
            case 8:
                arreglo[2][1] = "0";
                break;
            case 9:
                arreglo[2][2] = "0";
                break;

        }
    }

    public static int MovOcupado(int a){
        int m = 0,n = 0;

        do {
            switch (a){
                case 1:
                    m = 0;
                    n = 0;

                    break;
                case 2:
                    m = 0;
                    n = 1;

                    break;
                case 3:
                    m = 0;
                    n = 2;

                    break;
                case 4:
                    m = 1;
                    n = 0;

                    break;
                case 5:
                    m = 1;
                    n = 1;

                    break;
                case 6:
                    m = 1;
                    n = 2;

                    break;
                case 7:
                    m = 2;
                    n = 0;

                    break;
                case 8:
                    m = 2;
                    n = 1;

                    break;
                case 9:
                    m = 2;
                    n = 2;

                    break;

            }
            if (arreglo[m][n].equals("X") || arreglo[m][n].equals("0")){
                System.out.println("Esta posicion ya esta ocupada elige otra entre el 1 y el 9 porfavor");
                a = scn.nextInt();

            }else {
                break;
            }
        }while (true);
        return a;
    }

    public static int MovValido(int a){

        do {
            if (a >= 1 && a <= 9){
                break;
            }else {
                System.out.println("No introdujiste un numero valido porfavor vuelve a ingresar uno entre el 1 y el 9");
                a = scn.nextInt();
            }
        }while (true);
        return a;
    }

    public static boolean Tresenraya(String a, String b){
        //Player1
        //Posibilidades horizontales
        if (arreglo[0][0].equals("X") && arreglo[0][1].equals("X") && arreglo[0][2].equals("X")){
            System.out.println("Felicidades ganaste " + a + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[1][0].equals("X") && arreglo[1][1].equals("X") && arreglo[1][2].equals("X")){
            System.out.println("Felicidades ganaste " + a + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[2][0].equals("X") && arreglo[2][1].equals("X") && arreglo[2][2].equals("X")){
            System.out.println("Felicidades ganaste " + a + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }

        //Posibilidades verticales
        if (arreglo[0][0].equals("X") && arreglo[1][0].equals("X") && arreglo[2][0].equals("X")){
            System.out.println("Felicidades ganaste " + a + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[0][1].equals("X") && arreglo[1][1].equals("X") && arreglo[2][1].equals("X")){
            System.out.println("Felicidades ganaste " + a + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[0][2].equals("X") && arreglo[1][2].equals("X") && arreglo[2][2].equals("X")){
            System.out.println("Felicidades ganaste " + a + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }

        //Posibilidades cruzadas
        if (arreglo[0][0].equals("X") && arreglo[1][1].equals("X") && arreglo[2][2].equals("X")){
            System.out.println("Felicidades ganaste " + a + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[0][2].equals("X") && arreglo[1][1].equals("X") && arreglo[2][0].equals("X")){
            System.out.println("Felicidades ganaste " + a + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }




        //Player2
        //Posibilidades horizontales
        if (arreglo[0][0].equals("0") && arreglo[0][1].equals("0") && arreglo[0][2].equals("0")){
            System.out.println("Felicidades ganaste " + b + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[1][0].equals("0") && arreglo[1][1].equals("0") && arreglo[1][2].equals("0")){
            System.out.println("Felicidades ganaste " + b + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[2][0].equals("0") && arreglo[2][1].equals("0") && arreglo[2][2].equals("0")){
            System.out.println("Felicidades ganaste " + b + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }

        //Posibilidades verticales
        if (arreglo[0][0].equals("0") && arreglo[1][0].equals("0") && arreglo[2][0].equals("0")){
            System.out.println("Felicidades ganaste " + b + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[0][1].equals("0") && arreglo[1][1].equals("0") && arreglo[2][1].equals("0")){
            System.out.println("Felicidades ganaste " + b + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[0][2].equals("0") && arreglo[1][2].equals("0") && arreglo[2][2].equals("0")){
            System.out.println("Felicidades ganaste " + b + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }

        //Posibilidades cruzadas
        if (arreglo[0][0].equals("0") && arreglo[1][1].equals("0") && arreglo[2][2].equals("0")){
            System.out.println("Felicidades ganaste " + b + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        if (arreglo[0][2].equals("0") && arreglo[1][1].equals("0") && arreglo[2][0].equals("0")){
            System.out.println("Felicidades ganaste " + b + "!!!");
            ImprimirArreglo(arreglo);
            return true;
        }
        return false;
    }
}