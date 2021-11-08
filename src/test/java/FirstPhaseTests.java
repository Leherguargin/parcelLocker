import org.junit.jupiter.api.Test;

class FirstPhaseTests extends ConsoleTest {

    @Test
    public void scannerExceptions() {//TODO testy wyjątków scannera (brak sprawdzenia hasNextLine)
        writeToConsole("ciekawy napis bez entera");
    }

    @Test
    public void only2x2ParcelLocker() {
        final String data1 = "|S:0 S:X|\n|S:0 S:0|\n\nS\n\n";
        testConsoleOutput("|S:0 S:X|\n|S:0 S:0|\n", data1);
    }

    @Test
    public void only4x4ParcelLocker() {
        final String data2 = "|S:0 S:X S:X S:0|\n|S:0 S:0 S:X S:0|\n|S:0 S:X S:X S:0|\n|S:0 S:0 S:X S:0|\n\nS\n\n";
        testConsoleOutput("|S:0 S:X S:X S:0|\n|S:0 S:0 S:X S:0|\n|S:0 S:X S:X S:0|\n|S:0 S:0 S:X S:0|\n", data2);
    }

    @Test
    public void only4x1ParcelLocker() {
        final String data3 = "|S:0|\n|S:X|\n|S:0|\n|S:0|\n\nS\n\n";
        testConsoleOutput("|S:0|\n|S:X|\n|S:0|\n|S:0|\n", data3);
    }

    //TODO testy wyjątków kiedy dajemy paczkomat który nie jest prostokątem

    @Test
    public void addingOneParcel() {
        final String data = "|S:0 S:X|\n|S:0 S:0|\n\nB\n\n";
        final String expected = "|S:X S:X|\n|S:0 S:0|\n";
        testConsoleOutput(expected, data);
    }

    //TODO testy wyjątków dla nieznanej komendy oraz komend bez średnika pomiędzy lub z średnikiem takze na koniec

    @Test
    public void addingMoreParcelsWithoutOverFlow() {
        final String data = "|S:0 S:X|\n|S:0 S:0|\n\nB;B\n\n";
        final String expected = "|S:X S:X|\n|S:0 S:0|\n";
        testConsoleOutput(expected, data);

        final String data2 = "|S:0 S:X|\n|S:0 S:0|\n\nB;B;B;B;B\n\n";
        final String expected2 = "|S:X S:X|\n|S:X S:X|\n";
        testConsoleOutput(expected2, data2);
    }

}
