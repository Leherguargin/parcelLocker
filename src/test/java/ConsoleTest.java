import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class ConsoleTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    protected final PrintStream originalOut = System.out;
    protected final PrintStream originalErr = System.err;
    protected final InputStream originalIn = System.in;

    @BeforeEach
    private void setStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    private void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    protected void testConsoleOutput(String expected, String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        App.main();
        Assertions.assertEquals(expected, out.toString().replaceAll("\r", ""));
    }

    protected void writeToConsole(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
}
