import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static ArrayList<Integer> pozgracza1 = new ArrayList<Integer>();
    static ArrayList<Integer> pozgracza2 = new ArrayList<Integer>();

    public static void main(String[] args) {

        char [][] Plansha = {{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '}};

        rysPlansha(Plansha);

        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Gracz 1! Jaka kratka? od 1 do 9: ");
            int poz1 = scanner.nextInt();
            while(pozgracza1.contains(poz1)||pozgracza2.contains(poz1)){
                System.out.println("Pozycja zajęta! wybierz ponownie!");
                poz1 = scanner.nextInt();
            }

            rysPoz(Plansha, poz1, "gracz1");
            rysPlansha(Plansha);

            String Wynik = ktoWygral();
            if(Wynik.length()>0){
                System.out.println();
                System.out.println(Wynik);
                break;
            }


            System.out.println("Gracz 2! Jaka kratka? od 1 do 9: ");
            int poz2 = scanner.nextInt();
            while(pozgracza1.contains(poz2)||pozgracza2.contains(poz2)){
                System.out.println("Pozycja zajęta! wybierz ponownie!");
                poz2 = scanner.nextInt();
            }

            rysPoz(Plansha, poz2, "gracz2");
            rysPlansha(Plansha);

            Wynik = ktoWygral();
            if(Wynik.length()>0){
                System.out.println();
                System.out.println(Wynik);
                break;
            }

        }

    }

    public static void rysPoz(char[][] Plansha, int poz, String gracz){

        char XO = ' ';

        if(gracz.equals("gracz1")) {
            XO = 'X';
            pozgracza1.add(poz);
        }
        else if(gracz.equals("gracz2")) {
            XO = 'O';
            pozgracza2.add(poz);
        }

        switch (poz) {
            case 1:
                Plansha [0][0] = XO;
                break;
            case 2:
                Plansha [0][2] = XO;
                break;
            case 3:
                Plansha [0][4] = XO;
                break;
            case 4:
                Plansha [2][0] = XO;
                break;
            case 5:
                Plansha [2][2] = XO;
                break;
            case 6:
                Plansha [2][4] = XO;
                break;
            case 7:
                Plansha [4][0] = XO;
                break;
            case 8:
                Plansha [4][2] = XO;
                break;
            case 9:
                Plansha [4][4] = XO;
                break;
            default:
                break;
        }
    }

    public static void rysPlansha(char[][] Plansha) {
        for(char[] linia : Plansha) {
            for(char jaja : linia) {
                System.out.print (jaja);
            }
            System.out.println ();
        }
    }

    public static String ktoWygral() {

        List gorLinia = Arrays.asList(1,2,3);
        List srLinia = Arrays.asList(4,5,6);
        List dolLinia = Arrays.asList(7,8,9);
        List lewKol = Arrays.asList(1,4,7);
        List srKol = Arrays.asList(2,5,8);
        List prKol = Arrays.asList(3,6,9);
        List przLp = Arrays.asList(1,5,9);
        List przPl = Arrays.asList(3,5,7);

        List<List> wygryw = new ArrayList<List>();
        wygryw.add(gorLinia);
        wygryw.add(srLinia);
        wygryw.add(dolLinia);
        wygryw.add(lewKol);
        wygryw.add(srKol);
        wygryw.add(prKol);
        wygryw.add(przLp);
        wygryw.add(przPl);

        for(List l: wygryw) {
            if(pozgracza1.containsAll(l)) {
                return"Gracz 1 wygrał!";
            }
            else if(pozgracza2.containsAll(l)) {
                return"Gracz 2 Wygrał!";
            }
            else if (pozgracza1.size()  + pozgracza2.size() == 9) {
                return "Remis";
            }

        }

        return"";

    }
}
