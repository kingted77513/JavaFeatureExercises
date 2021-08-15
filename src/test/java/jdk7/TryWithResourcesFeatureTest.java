package jdk7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TryWithResourcesFeatureTest {

    @Test
    void closeResourceUsingBeforeJDK() throws IOException {
        final String path = "build.gradle";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            br.readLine();
            throw new IOException("Test");
        } catch (final IOException e) {
        } finally {
            if (br != null) br.close();
        }

        Assertions.assertThrows(IOException.class, br::readLine);
    }

    @Test
    void closeResourceUsingJDK7() throws IOException {
        final String path = "build.gradle";
        final BufferedReader brForTest;
        try (final BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            brForTest = br;
        }
        Assertions.assertThrows(IOException.class, brForTest::readLine);
    }

}
