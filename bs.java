
import java.util.Scanner;

class bs {

    static char polje[][] = new char[10][10]; // NUJNO STATIC, DA LAHKO KLICEMO V DRUGIH METODAH!!!!//
    static int dolzina = polje.length;
    // 0 1 2 3 4 5 6 7 8 9 (0-9)
    static int steviloLadjic = 18;
    static String abcd = "ABCDEFGHIJ";
    static int steviloPoiskusov = 0;
    static char starEmoji = '\u2B50';

    // metode:

    static void generirajPolje() {

        for (int i = 0; i < dolzina; i++) {
            for (int j = 0; j < dolzina; j++) {
                polje[i][j] = 'O';
            }
        }

    }

    static void izpisPolja() {

        for (int i = 0; i < dolzina; i++) {
            for (int j = 0; j < dolzina; j++) {
                System.out.print(polje[i][j]);
            }
            System.out.println();

        }

    }

    static void generirajLadjice() {
        int i = 0;
        while (i <= 18) { // generira 18 ladjic na radome poljih//
            polje[(int) Math.floor(Math.random() * 10)][(int) Math.floor(Math.random() * 10)] = 'x';
            i++;
        }
    }

    static void ugibaj() {
        

        // Vnos podatkov
        Scanner scanner = new Scanner(System.in);
        System.out.println("Izberite polje in stevilo na katerem mislite, da se nahaja ladjica (A 5): ");
        String s = scanner.nextLine();
        char row = s.charAt(0); // A
        char column = s.charAt(2); // 5
        int r = 0;

        int c = Integer.parseInt(String.valueOf(column)) - 1; // pretvori char v int ce je mozno '1' = 1

        for (int i = 0; i < abcd.length(); i++) { // iz Stringa ABCDEFGHIJ vcame index ki je ustrezen s igralnim poljem
            if (abcd.charAt(i) == row)
                r = i;
        }

        // testni izpois poolji
        System.out.print(r);
        System.out.print(" ");
        System.out.print(c);
        System.out.println(" ");

        // preverimo ali je igralec zadelo ladjico
        while (steviloLadjic != 0) {
            if (polje[c][r] == 'x') {
                System.out.println("Zadetek");
                steviloLadjic--;
                System.out.println("Preostalo je se: " + steviloLadjic);
            }

            else
                System.out.println("Na tem polju ni ladjice");

            steviloPoiskusov++;
            System.out.println("To je bil vas " + steviloPoiskusov + ". poiskusi");

            ugibaj();
        }
        System.out.println("Cestitam zmagali ste igor potaplanje ladjic");
        System.out.println("Igro ste zakljucili s " + steviloPoiskusov + " poiskusi");

        if (steviloPoiskusov >= 50)
            System.out.println("Zasluzite si: " + 3 * (starEmoji));
        else if (steviloPoiskusov >= 100)
            System.out.println("Zasluzite si: " + 2 * (starEmoji));
        else
            System.out.println("Zasluzite si " + 1 * (starEmoji));

        // pregeld:

        /*
         * polje[c][r] = '@';
         * 
         * for (int i = 0; i < dolzina; i++) {
         * for (int j = 0; j < dolzina; j++) {
         * System.out.print(polje[i][j]);
         * }
         * System.out.println();
         * }
         */

        scanner.close();
        System.out.println("Igro ste zakljucili s " + steviloPoiskusov + " poiskusi");
    }

    public static void main(String[] args) {

        System.out.println("Zasluzite si " + starEmoji + starEmoji + starEmoji);


        generirajPolje();
        generirajLadjice();
        izpisPolja();
        ugibaj();

    }

}