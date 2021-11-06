import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String... args) {
        String paczkomat = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextLine()) {
                return;
            }
            String line = scanner.nextLine();
            if (line.equals("")) {
//                System.out.println(paczkomat);
                break;
            } else {
                if (!paczkomat.equals("")) {
                    paczkomat += '\n';
                }
                paczkomat += line;
            }
        }
        paczkomat = paczkomat
                .replaceAll("L:L", "L:X")
                .replaceAll("M:M", "M:X")
                .replaceAll("S:S", "S:X");
        //S - wyświetla paczkomat (nie ma tego w dokumentacji XD)
        while (true) {
            if (!scanner.hasNextLine()) {
                return;
            }
            String commands = scanner.nextLine();
            String[] com = commands.split(";");
            if (commands.equals("")) {
                System.out.println(paczkomat);
                break;
            }
            if (commands.equals("S")) {
                System.out.println(paczkomat);
            } else {
                for (String c : com) {
                    paczkomat = wlozPaczke(c, paczkomat);
                }
                System.out.println(paczkomat);
            }
        }
    }

    private static String wlozPaczke(String com, String paczkomat) {
        String comm = com.split("@")[0];
        String name = "@" + com.split("@")[1];
        switch (comm) {
            case "B":
                //brak break; => to samo co dla BS się wykona :)
            case "BS":
                if (paczkomat.contains("S:O" + name)) {
                    paczkomat = paczkomat.replaceFirst("S:O" + name, "S:X" + name);
                } else if (paczkomat.contains("M:O")) {
                    paczkomat = paczkomat.replaceFirst("M:O" + name, "M:S" + name);
                } else if (paczkomat.contains("L:O")) {
                    paczkomat = paczkomat.replaceFirst("L:O" + name, "L:S" + name);
                }
                break;
            case "BM":
                if (paczkomat.contains("M:O" + name)) {
                    paczkomat = paczkomat.replaceFirst("M:O" + name, "M:X" + name);
                } else if (paczkomat.contains("L:O")) {
                    paczkomat = paczkomat.replaceFirst("L:O" + name, "L:M" + name);
                }
                break;
            case "BL":
                if (paczkomat.contains("L:O" + name)) {
                    paczkomat = paczkomat.replaceFirst("L:O", "L:X");
                }
                break;
        }
        return paczkomat;
    }

}
