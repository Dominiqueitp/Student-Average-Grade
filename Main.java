package tTT;

/*  I hereby acknowledge that the work handed in is my own original work. If I
    have quoted from any other source this information has been correctly referenced.
    I also declare that I have read the Namibia University of Science and Technology
   Policies on Academic Honesty and Integrity as indicated in my course outline and
    the NUST general information and regulations - Yearbook 2018.

   */

import java.util.*;

public class Main {

    static ArrayList<Integer> playerpos = new ArrayList<Integer>(  );
    static ArrayList<Integer> cpupos = new ArrayList<Integer>(  );

    public static void main(String[] args) {
        // write your code here
        char[][] boardgame = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printBoardgame(boardgame);



        while(true){
            Scanner aEK = new Scanner(System.in);

        System.out.println("Enter your placement (1-9):");
        int playbiish = aEK.nextInt( );
        while(playerpos.contains( playbiish ) || cpupos.contains( playbiish )){
            System.out.println("Position Taken!! Enter a correct position");
            playbiish = aEK.nextInt();
        }

        placepiece( boardgame, playbiish, "player" );

            String result = checkWinner();
            if (result.length() > 0){
                System.out.println(result);
                break;
            }

        Random kaE = new Random();
        int cpubiish = kaE.nextInt(9) + 1;
        while(playerpos.contains( cpubiish ) || cpupos.contains( cpubiish )){
            cpubiish = kaE.nextInt( 9 ) + 1;
        }


        placepiece( boardgame, cpubiish, "cpu" );

        printBoardgame( boardgame );
        
         result = checkWinner();
        if (result.length() > 0){
            System.out.println(result);
            break;
        }
            System.out.println(result);
        
        }

    }

    private static String checkWinner() {
        return null;
    }


    public static void printBoardgame(char[][] boardgame){
        for(char[] row: boardgame){
            for (char k : row){
                System.out.println(k);
            }
            System.out.println();
        }
    }
    public static void placepiece(char[][] boardgame, int biish, String user ){

        char sym = ' ';

        if (user.equals( "player" )){
            sym = 'X';
            playerpos.add( biish );
        }else if (user.equals( "cpu" )){
            sym = 'O';
            cpupos.add( biish );
        }

        switch(biish){
            case 1:
                boardgame[0][0] = sym;
                break;
            case 2:
                boardgame[0][2] = sym;
                break;
            case 3:
                boardgame[0][4] = sym;
                break;
            case 4:
                boardgame[2][0] = sym;
                break;
            case 5:
                boardgame[2][2] = sym;
                break;
            case 6:
                boardgame[2][4] = sym;
                break;
            case 7:
                boardgame[4][0] = sym;
                break;
            case 8:
                boardgame[4][2] = sym;
                break;
            case 9:
                boardgame[4][4] = sym;
                break;
            default:
                break;

        }

    }
    public static String winneriis(){

        List topr = Arrays.asList(1, 2, 3);
        List midr = Arrays.asList(4, 5, 6);
        List botr = Arrays.asList(7, 8, 9);
        List lftc = Arrays.asList(1, 4, 7);
        List midc = Arrays.asList(2, 5, 8);
        List rytc = Arrays.asList(3, 6, 9);
        List cr1 = Arrays.asList(1, 5, 9);
        List cr2 = Arrays.asList(7, 5, 3);

        List<List> winC = new ArrayList<List>(  );
        winC.add( topr );
        winC.add( midr );
        winC.add( botr );
        winC.add( lftc );
        winC.add( midc );
        winC.add( rytc );
        winC.add( cr1 );
        winC.add( cr2 );

        for (List f : winC){
            if (playerpos.containsAll( f )){
                return "Congratulations you won!!";
            }else if (cpupos.contains( f )) {
                return "Ooops! CPU wins! Sorry :( ";
            }else if (playerpos.size() + cpupos.size() == 9){
                return "CAT!";
            }
        }


        return "";
    }
}
