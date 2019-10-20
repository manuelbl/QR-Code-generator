package io.nayuki.qrcodegen.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ShiftJISTable {

    public static void main(String[] arg) {

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("SHIFTJIS.txt"),
                        StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                int hashIndex = line.indexOf('#');
                if (hashIndex >= 0)
                    line = line.substring(0, hashIndex);
                line = line.trim();
                if (line.length() == 0)
                    continue;
                
                processLine(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(String.format("%d entries", numEntries));
        System.out.println(String.format("Shift JIS: %d - %d", shiftJisMin, shiftJisMax));
        System.out.println(String.format("Unicode:   %d - %d", unicodeMin, unicodeMax));
    }

    private static int numEntries;
    private static int shiftJisMin = 999999;
    private static int shiftJisMax = 0;
    private static int unicodeMin = 999999;
    private static int unicodeMax = 0;


    private static void processLine(String line) {
        int split = line.indexOf('\t');
        String shiftJIS = line.substring(2, split);
        String unicode = line.substring(split + 3);
        int shifJisCode = Integer.parseInt(shiftJIS, 16);
        int unicdodeCode = Integer.parseInt(unicode, 16);
        numEntries++;

        shiftJisMin = Math.min(shiftJisMin, shifJisCode);
        shiftJisMax = Math.max(shiftJisMax, shifJisCode);
        unicodeMin = Math.min(unicodeMin, unicdodeCode);
        unicodeMax = Math.max(unicodeMax, unicdodeCode);
    }
}
