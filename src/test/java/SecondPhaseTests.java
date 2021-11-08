import org.junit.jupiter.api.Test;

public class SecondPhaseTests extends ConsoleTest {

    @Test
    public void only2x2ParcelLocker() { //TODO napisz testy do drugiej fazy
        final String data1 = "|S:0 S:X|\n|S:0 S:0|\n\nS\n\n";
        testConsoleOutput("|S:0 S:X|\n|S:0 S:0|\n", data1);
    }
}
