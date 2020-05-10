package ua.lviv.iot.RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

    public static String findWorkTime(final String inputSting) throws NullPointerException {
        String workTime = null;
        try {
            String checkedString = checkIfAccordingToTemplateAndReturnCheckedString(inputSting);
            if (checkedString == null) {
                throw new NullPointerException();
            }
            workTime = getWorkTime(checkedString);
            if (workTime == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException);
        }

        return workTime;
    }

    private static String checkIfAccordingToTemplateAndReturnCheckedString(final String inputString) throws NullPointerException {
        String checkedString = null;
        String patternString = "\\p{L}*,\\s\\p{L}{1}.\\p{L}*,\\s\\p{L}{3}.\\p{L}*,\\s\\p{L}{3}\\s\\p{L}*:\\s\\d{2}:\\d{2}\\s-\\s\\d{2}:\\d{2}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputString);
        try {
            if (matcher.find()) {
                checkedString = matcher.group();
            }
            if (checkedString == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException);
        }
        return checkedString;
    }

    private static String getWorkTime(final String inputString) throws NullPointerException {
        String workTime = null;
        String patternString = "\\d{2}:\\d{2}\\s-\\s\\d{2}:\\d{2}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputString);
        try {
            if (matcher.find()) {
                workTime = matcher.group();
            }
            if (workTime == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException);
        }
        return workTime;
    }

}
