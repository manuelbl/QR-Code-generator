/* 
 * QR Code generator library (Java)
 * 
 * Copyright (c) Project Nayuki. (MIT License)
 * https://www.nayuki.io/page/qr-code-generator-library
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * - The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 * - The Software is provided "as is", without warranty of any kind, express or
 *   implied, including but not limited to the warranties of merchantability,
 *   fitness for a particular purpose and noninfringement. In no event shall the
 *   authors or copyright holders be liable for any claim, damages or other
 *   liability, whether in an action of contract, tort or otherwise, arising from,
 *   out of or in connection with the Software or the use or other dealings in the
 *   Software.
 */

package io.nayuki.qrcodegen.test;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import io.nayuki.qrcodegen.QrCode;
import io.nayuki.qrcodegen.QrSegment;
import io.nayuki.qrcodegen.QrCode.Ecc;

public class TestCaseGenerator {

    private static final TestCaseData[] TEST_CASES = {
        new TestCaseData("98323", GenerationApi.ENCODE_TEXT, Ecc.MEDIUM),
        new TestCaseData("The quick brown fox jumps", GenerationApi.ENCODE_TEXT, Ecc.QUARTILE),
        new TestCaseData("kVtnmdZMDB wbhQ4Y0L0D 6dxWYgeDO7 6XEq8JBGFD dbA5ruetw0 zIevtZZkJL UnEcrObNuS COOscwe4PD PL2lKGcbqk uXnmfUX00E l4FsUfvkiU" +
            " O8bje4GTce  C85HiEHDha EoObmX7Hef VEipzaCPV7 XpBy5cgYRZ VzlrmMTRSW f0U7Dt0x5j Mb5uk2JcA6 MFov2hnHQR",
            GenerationApi.ENCODE_TEXT, Ecc.MEDIUM),
        new TestCaseData("😀 € éñ 💩", GenerationApi.ENCODE_BINARY, Ecc.LOW),
        new TestCaseData("ABCD22340", GenerationApi.ENCODE_SEGMENTS, Ecc.HIGH, 10, 40, 4, false),
        new TestCaseData("314159265358979323846264338327950288419716939937510", GenerationApi.ENCODE_TEXT, Ecc.MEDIUM),
        new TestCaseData("DOLLAR-AMOUNT:$39.87 PERCENTAGE:100.00% OPERATIONS:+-*/", GenerationApi.ENCODE_TEXT, Ecc.HIGH),
        new TestCaseData("こんにちwa、世界！ αβγδ", GenerationApi.ENCODE_TEXT, Ecc.QUARTILE),
        new TestCaseData("Alice was beginning to get very tired of sitting by her sister on the bank, "
        + "and of having nothing to do: once or twice she had peeped into the book her sister was reading, "
        + "but it had no pictures or conversations in it, 'and what is the use of a book,' thought Alice "
        + "'without pictures or conversations?' So she was considering in her own mind (as well as she could, "
        + "for the hot day made her feel very sleepy and stupid), whether the pleasure of making a "
        + "daisy-chain would be worth the trouble of getting up and picking the daisies, when suddenly "
        + "a White Rabbit with pink eyes ran close by her.", GenerationApi.ENCODE_TEXT, QrCode.Ecc.HIGH),
        new TestCaseData("https://www.nayuki.io/", GenerationApi.ENCODE_SEGMENTS, Ecc.HIGH, 1, 40, -1, true),
        new TestCaseData("https://www.nayuki.io/", GenerationApi.ENCODE_SEGMENTS, Ecc.HIGH, 1, 40, 3, true),
        new TestCaseData("維基百科（Wikipedia，聆聽i/ˌwɪkᵻˈpiːdi.ə/）是一個自由內容、公開編輯且多語言的網路百科全書協作計畫",
            GenerationApi.ENCODE_SEGMENTS, Ecc.MEDIUM, 1, 40, 0, true),
        new TestCaseData("維基百科（Wikipedia，聆聽i/ˌwɪkᵻˈpiːdi.ə/）是一個自由內容、公開編輯且多語言的網路百科全書協作計畫",
            GenerationApi.ENCODE_SEGMENTS, Ecc.MEDIUM, 1, 40, 1, true),
        new TestCaseData("維基百科（Wikipedia，聆聽i/ˌwɪkᵻˈpiːdi.ə/）是一個自由內容、公開編輯且多語言的網路百科全書協作計畫",
            GenerationApi.ENCODE_SEGMENTS, Ecc.MEDIUM, 1, 40, 5, true),
        new TestCaseData("維基百科（Wikipedia，聆聽i/ˌwɪkᵻˈpiːdi.ə/）是一個自由內容、公開編輯且多語言的網路百科全書協作計畫",
            GenerationApi.ENCODE_SEGMENTS, Ecc.MEDIUM, 1, 40, 7, true)
    };

    public static void main(String[] args) {
        
        try (PrintStream stream = new PrintStream("QrCodeTest.java")) {
            for (int i = 0; i < TEST_CASES.length; i++) {
                generateJavaTestCase(stream, TEST_CASES[i], i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        try (PrintStream stream = new PrintStream("QrCodeTest.cs")) {
            for (int i = 0; i < TEST_CASES.length; i++) {
                generateCSharpTestCase(stream, TEST_CASES[i], i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateJavaTestCase(PrintStream stream, TestCaseData caseData, int testCaseNum) {
        QrCode qrCode = generateQrCode(caseData);

        String textName = String.format("TEXT_%d", testCaseNum);
        String expectedResultName = String.format("MODULES_%d", testCaseNum);
        String testCaseName = String.format("testCode%d", testCaseNum);

        printJavaStringArray(stream, expectedResultName, TestHelper.toStringArray(qrCode));

        stream.print("    private static final String ");
        stream.print(textName);
        stream.print(" = \"");
        stream.print(escapeString(caseData.text));
        stream.println("\";");
        stream.println();

        stream.println("    @Test");
        stream.println("    void " + testCaseName + "() {");

        if (caseData.api == GenerationApi.ENCODE_TEXT) {
            stream.print("        QrCode qrCode = QrCode.encodeText(");
            stream.print(textName);
            stream.print(", Ecc.");
            stream.print(caseData.errorCorrectionLevel.name());
            stream.println(");");
        } else if (caseData.api == GenerationApi.ENCODE_BINARY) {
            stream.print("        QrCode qrCode = QrCode.encodeBinary(");
            stream.print(textName);
            stream.print(".getBytes(StandardCharsets.UTF_8), Ecc.");
            stream.print(caseData.errorCorrectionLevel.name());
            stream.println(");");
        } else {
            stream.print("        List<QrSegment> segments = QrSegment.makeSegments(");
            stream.print(textName);
            stream.println(");");
            stream.print("        QrCode qrCode = QrCode.encodeSegments(segments, Ecc.");
            stream.print(caseData.errorCorrectionLevel.name());
            stream.print(", ");
            stream.print(caseData.minVersion);
            stream.print(", ");
            stream.print(caseData.maxVersion);
            stream.print(", ");
            stream.print(caseData.mask);
            stream.print(", ");
            stream.print(caseData.boostEcl ? "true" : "false");
            stream.println(");");
        }

        stream.print("        assertSame(Ecc.");
        stream.print(qrCode.errorCorrectionLevel.name());
        stream.println(", qrCode.errorCorrectionLevel);");
        stream.print("        assertEquals(");
        stream.print(qrCode.size);
        stream.println(", qrCode.size);");
        stream.print("        assertEquals(");
        stream.print(qrCode.mask);
        stream.println(", qrCode.mask);");
        stream.print("        assertArrayEquals(");
        stream.print(expectedResultName);
        stream.println(", TestHelper.toStringArray(qrCode));");
        stream.println("    }");
        stream.println();
    }

    public static void generateCSharpTestCase(PrintStream stream, TestCaseData caseData, int testCaseNum) {
        QrCode qrCode = generateQrCode(caseData);

        String textName = String.format("Text%d", testCaseNum);
        String expectedResultName = String.format("Modules%d", testCaseNum);
        String testCaseName = String.format("TestCode%d", testCaseNum);

        printCSharpStringArray(stream, expectedResultName, TestHelper.toStringArray(qrCode));

        stream.print("        private const string ");
        stream.print(textName);
        stream.print(" = \"");
        stream.print(escapeString(caseData.text));
        stream.println("\";");
        stream.println();

        stream.println("        [Fact]");
        stream.println("        private void " + testCaseName + "()");
        stream.println("        {");

        if (caseData.api == GenerationApi.ENCODE_TEXT) {
            stream.print("            var qrCode = EncodeText(");
            stream.print(textName);
            stream.print(", Ecc.");
            stream.print(getCSharpErrorCorrectionLevel(caseData.errorCorrectionLevel));
            stream.println(");");
        } else if (caseData.api == GenerationApi.ENCODE_BINARY) {
            stream.print("            var qrCode = EncodeBinary(Encoding.UTF8.GetBytes(");
            stream.print(textName);
            stream.print("), Ecc.");
            stream.print(getCSharpErrorCorrectionLevel(caseData.errorCorrectionLevel));
            stream.println(");");
        } else {
            stream.print("            var segments = QrSegment.MakeSegments(");
            stream.print(textName);
            stream.println(");");
            stream.print("            var qrCode = EncodeSegments(segments, Ecc.");
            stream.print(getCSharpErrorCorrectionLevel(caseData.errorCorrectionLevel));
            stream.print(", ");
            stream.print(caseData.minVersion);
            stream.print(", ");
            stream.print(caseData.maxVersion);
            stream.print(", ");
            stream.print(caseData.mask);
            stream.print(", ");
            stream.print(caseData.boostEcl ? "true" : "false");
            stream.println(");");
        }

        stream.print("            Assert.Same(Ecc.");
        stream.print(getCSharpErrorCorrectionLevel(qrCode.errorCorrectionLevel));
        stream.println(", qrCode.ErrorCorrectionLevel);");
        stream.print("            Assert.Equal(");
        stream.print(qrCode.size);
        stream.println(", qrCode.Size);");
        stream.print("            Assert.Equal(");
        stream.print(qrCode.mask);
        stream.println(", qrCode.Mask);");
        stream.print("            Assert.Equal(");
        stream.print(expectedResultName);
        stream.println(", TestHelper.ToStringArray(qrCode));");
        stream.println("        }");
        stream.println();
    }

    private static QrCode generateQrCode(TestCaseData caseData) {

        QrCode qrCode;
        switch (caseData.api) {
            case ENCODE_TEXT:
                qrCode = QrCode.encodeText(caseData.text, caseData.errorCorrectionLevel);
                break;
            case ENCODE_BINARY:
                qrCode = QrCode.encodeBinary(caseData.text.getBytes(StandardCharsets.UTF_8),
                    caseData.errorCorrectionLevel);
                break;
            case ENCODE_SEGMENTS:
                qrCode = QrCode.encodeSegments(QrSegment.makeSegments(caseData.text),
                    caseData.errorCorrectionLevel, caseData.minVersion, caseData.maxVersion,
                    caseData.mask, caseData.boostEcl);
                break;
            default:
                throw new IllegalArgumentException("invalid test case api");
        }

        return qrCode;
    }

    static void printJavaStringArray(PrintStream s, String name, String[] array) {
        s.println("    private static final String[] " + name  + " = {");
        for (int i = 0; i < array.length; i++) {
            s.print("        \"");
            s.print(escapeString(array[i]));
            s.print("\"");
            if (i != array.length - 1)
                s.print(",");
            s.println();
        }
        s.println("    };");
        s.println();
    }

    private static void printCSharpStringArray(PrintStream s, String name, String[] array) {
        s.println("        private static readonly string[] " + name  + " = {");
        for (int i = 0; i < array.length; i++) {
            s.print("            \"");
            s.print(escapeString(array[i]));
            s.print("\"");
            if (i != array.length - 1)
                s.print(",");
            s.println();
        }
        s.println("        };");
        s.println();
    }

    private static String getCSharpErrorCorrectionLevel(Ecc ecc) {
        String javaName = ecc.name();
        return javaName.substring(0, 1) + javaName.substring(1).toLowerCase();
    }


    private static String escapeString(String text) {
        int length = text.length();
        int lastCopiedPosition = 0;
        StringBuilder result = null;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch == '"' || ch == '\\' || ch == '\t' || ch == '\n' || ch == '\r') {
                if (result == null)
                    result = new StringBuilder(length + 10);
                if (i > lastCopiedPosition)
                    result.append(text, lastCopiedPosition, i);
                String entity;
                switch (ch) {
                    case '"':
                        entity = "\\\"";
                        break;
                    case '\\':
                        entity = "\\\\";
                        break;
                    case '\t':
                        entity = "\\t";
                        break;
                    case '\n':
                        entity = "\\n";
                        break;
                    default:
                        entity = "\\r";
                }
                result.append(entity);
                lastCopiedPosition = i + 1;
            }
        }

        if (result == null)
            return text;
        if (length > lastCopiedPosition)
            result.append(text, lastCopiedPosition, length);
        return result.toString();
    }



    public enum GenerationApi {
        ENCODE_TEXT,
        ENCODE_BINARY,
        ENCODE_SEGMENTS
    }

    public static class TestCaseData {
        public String text;
        public GenerationApi api;
        public Ecc errorCorrectionLevel;
        public int minVersion;
        public int maxVersion;
        public int mask;
        public boolean boostEcl;

        public TestCaseData() { }

        public TestCaseData(String text, GenerationApi api, Ecc errorCorrectionLevel) {
            this.text = text;
            this.api = api;
            this.errorCorrectionLevel = errorCorrectionLevel;
        }

        public TestCaseData(String text, GenerationApi api, Ecc errorCorrectionLevel,
            int minVersion, int maxVersion, int mask, boolean boostEcl) {
            this.text = text;
            this.api = api;
            this.errorCorrectionLevel = errorCorrectionLevel;
            this.minVersion = minVersion;
            this.maxVersion = maxVersion;
            this.mask = mask;
            this.boostEcl = boostEcl;
        }
    }
}