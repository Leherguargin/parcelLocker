import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

class FirstPhaseTests extends ConsoleTest {

    //Todo testy wyjątków scannera (brak sprawdzenia hasNextLine)

    private void testConsoleOutput(String expected, String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        App.main();
        Assertions.assertEquals(expected, super.out.toString().replaceAll("\r", ""));
    }

    @Test
    public void onlyParcelLocker() {
        //2x2
        final String data1 = "|S:0 S:X|\n|S:0 S:0|\n\nS\n\n";
        testConsoleOutput("|S:0 S:X|\n|S:0 S:0|\n", data1);
        //4x4
        final String data2 = "|S:0 S:X S:X S:0|\n|S:0 S:0 S:X S:0|\n|S:0 S:X S:X S:0|\n|S:0 S:0 S:X S:0|\n\nS\n\n";
        testConsoleOutput("|S:0 S:X S:X S:0|\n|S:0 S:0 S:X S:0|\n|S:0 S:X S:X S:0|\n|S:0 S:0 S:X S:0|\n", data2);
        //4x1
        final String data3 = "|S:0|\n|S:X|\n|S:0|\n|S:0|\n\nS\n\n";
        testConsoleOutput("|S:0|\n|S:X|\n|S:0|\n|S:0|\n", data3);

        //TODO testy wyjątków kiedy dajemy paczkomat który nie jest prostokątem
    }


    @Test
    public void addingOneParcel() {
        final String data = "|S:0 S:X|\n|S:0 S:0|\n\nB\n\n";
        final String expected = "|S:X S:X|\n|S:0 S:0|\n";
        testConsoleOutput(expected, data);

        //TODO testy wyjątków dla nieznanej komendy oraz komend bez średnika pomiędzy lub z średnikiem takze na koniec
    }

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
