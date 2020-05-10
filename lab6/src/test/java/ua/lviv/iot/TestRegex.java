package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.RegEx.RegEx;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TestRegex {
    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Test
    public void testIfReturnsAccordingToTemplate() {
        //Епіцентр, м.Львів, вул.Стрийська, час роботи: 10:00 - 21:30
        Assertions.assertEquals("10:00 - 21:30", RegEx.findWorkTime("Епіцентр, м.Львів, вул.Стрийська, час роботи: " +
                "10:00 - 21:30"));
    }

    @Test
    public void checkText() throws IOException {

        String input = "Епіцентр, м.Львів, вул.Стрийська, час роботи: 10:00 - 21:30";
        try (InputStream in = new ByteArrayInputStream(input.getBytes())) {
            System.setIn(in);
            String textToCheck = getInput();
            Assertions.assertEquals("10:00 - 21:30", RegEx.findWorkTime(textToCheck));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
