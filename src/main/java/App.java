import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String... args) {
        String paczkomat = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if(scanner.hasNextLine()){
                return;
            }
            String line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println(paczkomat);
                break;
            } else {
                if (!paczkomat.equals("")) {
                    paczkomat += '\n';
                }
                paczkomat += line;
            }
        }
        //S - wyświetla paczkomat (nie ma tego w dokumentacji XD)
        while (true) {
            if(!scanner.hasNextLine()) {
                return;
            }
            String command = scanner.nextLine();
            String[] split = command.split(";");
            if (command.equals("")) {
                System.out.println(paczkomat);
                break;
            }
            if (command.equals("S")) {
                System.out.println(paczkomat);
            } else {
                for (String c : split) {
                    int index = paczkomat.indexOf("O");
                    if (index == -1) {
                        //dodaj nowy rząd?
                    } else {
                        paczkomat = paczkomat.replaceFirst("O", "X");
                    }
                }
                System.out.println(paczkomat);
            }
        }
    }

}
