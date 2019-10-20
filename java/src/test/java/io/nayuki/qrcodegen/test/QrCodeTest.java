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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.nayuki.qrcodegen.QrCode;
import io.nayuki.qrcodegen.QrSegment;
import io.nayuki.qrcodegen.QrCode.Ecc;

class QrCodeTest {

    private static final String[] MODULES_0 = {
        "XXXXXXX  X    XXXXXXX",
        "X     X XX  X X     X",
        "X XXX X     X X XXX X",
        "X XXX X  XX X X XXX X",
        "X XXX X  X    X XXX X",
        "X     X XXXX  X     X",
        "XXXXXXX X X X XXXXXXX",
        "        X   X        ",
        "    XXXX   XX XX   X ",
        " X  XX  XX XXX X  X  ",
        " XXX  XX    XXXXXXXX ",
        "X  X X X X X X  X XX ",
        "X   XXXX  XX         ",
        "        X X  XX   X  ",
        "XXXXXXX X     X  X X ",
        "X     X XXXXXXXX X X ",
        "X XXX X XX XXX XX XXX",
        "X XXX X  XXXX  X X XX",
        "X XXX X  X  X  XXXX  ",
        "X     X    X  X X XX ",
        "XXXXXXX  X X X    XXX"
    };

    private static final String TEXT_0 = "98323";

    @Test
    void testCode0() {
        QrCode qrCode = QrCode.encodeText(TEXT_0, Ecc.MEDIUM);
        assertSame(Ecc.HIGH, qrCode.errorCorrectionLevel);
        assertEquals(21, qrCode.size);
        assertEquals(4, qrCode.mask);
        assertArrayEquals(MODULES_0, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_1 = {
        "XXXXXXX X X XXX     X XXXXXXX",
        "X     X   X XXXX    X X     X",
        "X XXX X XXX      XX   X XXX X",
        "X XXX X X  XX XX  XX  X XXX X",
        "X XXX X   X  X X X    X XXX X",
        "X     X XX   XX  XXXX X     X",
        "XXXXXXX X X X X X X X XXXXXXX",
        "        X X X  X             ",
        " X X XXXX   XXXX X   XXX XX X",
        " XXX   XXXXXXXXX X XXXX   XXX",
        "  XX  X XXX  XXX XX XX XX  X ",
        "XX   X   XXXX  X       X  XX ",
        "X   X XX X XXXX XX XXXXX X XX",
        " X X    X   X   XX X X    XX ",
        "X X XXX   X   X XXX XX  X  XX",
        "X X    XX XXX X XXX    X   XX",
        "XX   XX X  X XX   X XX X X X ",
        "  XXX    XXXX XXXXXXX XX X   ",
        "X   XXX     X XXXX        XXX",
        "  XXXX   X  XX   XXX  XXX   X",
        "X  X  X   X X XXX   XXXXX X  ",
        "        XX X XX   XXX   X  XX",
        "XXXXXXX X    X   X  X X X XX ",
        "X     X XX   X  XX  X   XXXX ",
        "X XXX X   XXXXXX    XXXXX   X",
        "X XXX X XXXX X XXX XX X X   X",
        "X XXX X   XX            X   X",
        "X     X X  X XXX XX XX X   X ",
        "XXXXXXX  X   XX  X  X   XX X "
    };

    private static final String TEXT_1 = "The quick brown fox jumps";

    @Test
    void testCode1() {
        QrCode qrCode = QrCode.encodeText(TEXT_1, Ecc.QUARTILE);
        assertSame(Ecc.QUARTILE, qrCode.errorCorrectionLevel);
        assertEquals(29, qrCode.size);
        assertEquals(7, qrCode.mask);
        //TestHelper.printStringArray(TestHelper.toStringArray(qrCode));
        assertArrayEquals(MODULES_1, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_2 = {
        "XXXXXXX XXXXX X  XX  X    X    XXX    X XXX  X  X  XX XXXXXXX",
        "X     X    XX  XXXXX XX XXXX     X  XX  XXX XXX  X XX X     X",
        "X XXX X  X  X   XXXXX  XX  XX   XXX X   XX XXX  X XXX X XXX X",
        "X XXX X XX X  X   X  X XXX   X XX XX X  X    XX  XX X X XXX X",
        "X XXX X X   X XX X  XX X X XXXXXX  X XXXX X  X    XX  X XXX X",
        "X     X XXXX   XXX  XX XX X X   XX  X XX XX  X XXXX   X     X",
        "XXXXXXX X X X X X X X X X X X X X X X X X X X X X X X XXXXXXX",
        "        X  X XXXXX  XXX  XXXX   X XXXX XXX    XXX   X        ",
        "X   X XXX XXX XXXXX       X XXXXX XXX  X  X X   XX   XXXXX  X",
        "XXXX      X X            X    X XX X  X   XX X  XXXX XXXX X  ",
        " X XX X  X X  X  X  XXXX X XXX X  X   XXX X   X X X X X  XX  ",
        "X  XXX X XX      X XXX   X  X     X X  X  X XXX XX XXXX X XX ",
        "XX X XXX  XXXXXXX XX  XXX X   XXXX  X  X X XX   XXX X X X X  ",
        "X X    X XXXX     X X   XX     XX   X XX XXXXX XX XX  X XX   ",
        "  X   XX  XX X  XXXX  XXX XXXX X   X   X XXX  XX X XX XXX X  ",
        "X XX     X  XXXX  X     X   X  X X X X XXXX   XX XXXX     X  ",
        "XX  X X   XXX X XX      XXXXX X X  X XXXX X   XXXXXXXXX X XXX",
        "X      X XXXXX  XX XXX  X   XXX X     X XXXX X   XXX XX   X  ",
        "X XXX XX XXX X XX  XXX   XXX   X    X X  XXXXX  XXXX XX      ",
        "XX  X  X       XX     XXX XXXX   XX  XX  XX XXX     XX    XX ",
        "  XXX X X X X X  X  X  XX    X XXXXXXXXX XX X  XX    XX XX X ",
        "X X    X X    X XXX XXX XXXX  XXXX  X X XXX  X  X XX  XX X X ",
        "   XX X  X   XXX    XXXXXX XX  X  X  XX X    XXX X XX XX  X  ",
        " XX X  XXXX X  XX X X  XX    X     X XXXX X  XXXXXX X  X  X  ",
        "XX    XXXX X  XXX    XX X X XXXX  XXXX X    XX XX     X XXXXX",
        " X XX    XXXXXXXXXXX XXX X XX X XXX X    X XXX XX XX XX XXX X",
        "XXXXX X      X X XXX X XX    XX  XXX    XX    X  XX X  X X   ",
        "X   X  X    X X  X X  X XXXXX  X X  XX X   XXX X     XX X X X",
        " X XXXXXX     X  XXX  X   X XXXXX  XX X     XX XXXX XXXXX XXX",
        "  XXX   X   XXX  XX XX XXX  X   XX X  XXXXX       XXX   XX XX",
        "XXXXX X X  X X XX XX X   XX X X XXXX   XXXX    XXXX X X X X  ",
        "  X X   X  XX X X     X XXXXX   X XXXXX XX    X   XXX   X X  ",
        "   XXXXXX XX XXXXX     XX X XXXXX   X  X    XX XXX  XXXXX XXX",
        "X X  X  X XX  X X   X  XXXXX  XXXX X  XXXXXXXX  X XX   XX XX ",
        "    X XXXXX X XXXXX   X  X X  XXX X     XX   X XXX  X        ",
        "X  XXX  X XXX X XXXXX X XX XXX    X     XX X X XXX  XX   XXXX",
        " XX X XX X X XXXXXXX XX   X   XX X  X      XXXXXXXX X XX XX X",
        "XX X   X XX  X  X X     XX  XX  XX XX XX XX XX  X X X X XX XX",
        " X XX X X XXXXX  XXX XX X  XX    XXX  XXXXX  X XX  X X  XX  X",
        "XX  X    XX    XXXXX   XXX X X X  X     XX  XXXXX     XXX XX ",
        "    XXXX   X  XX XXX  XXXXXX XX XXXXXX X    X X XXX X  X XX X",
        "XXXX X    XX XXX  X XXX X X X  X   XX X  XX XX X  X XXX XX X ",
        " XXXXXX     XXX X XX  X    XX   XX  X XXX  X     X XX   XXXX ",
        "  XXXX     XXX   XX  XXX  X   X  XXXX    X  XXX  X X  X X XXX",
        "  XX XXXX   X X  X X XX X X XXXXXX  X X  XXXX XXXX  XXX XXX X",
        "XX  XX  XXX    XX   XXXXXXX   X X   XXXX  X X  X XX X   XXXX ",
        " XX  XXX X XXXX X  X   X   X  XXX XX X  X  X XXX XX XX    XX ",
        "  XX X X XXX  XXXX   X X  XXXXX   XXXX  X   XXXX X X XX   XX ",
        "XXX   XX X  XX XXXX       X XX  XX XXXXX  X X  XX       X X  ",
        "XX XX    X XX XXXX X X XX  XX XXXX X  XX XX XX X  X     XX X ",
        "  XXXXXX X X     XXXX  XXXXXX      X    X XX XXXX XX    XX   ",
        "XXX X  XXX X  XX  XX  XX XXX  XXXXX XXX X XXX  XX X  X X XXX ",
        "XXXX  XXX    XXX  X   X   X XXXXX   X  X   XX XXXX  XXXXX X X",
        "        XXXX XXXX X XXXXXX  X   XX X  X  XXXXX    X X   X  X ",
        "XXXXXXX X   X XXX X X X   X X X XXX XXXX  XXXXXX  XXX X XX   ",
        "X     X  XX XX   XXXXX X  X X   XX X X XXXX  X XXX XX   X X  ",
        "X XXX X X   X  XX  X  XX XX XXXXX  X  XXX    X XXX  XXXXX  XX",
        "X XXX X   X X XX     XX XX   XXX X   XX XXXX X    X      X  X",
        "X XXX X     X  X  X XX   XXX X XXX  X X  XXXX XX XX X    XXX ",
        "X     X   X XXX X   XXXX  XX X  XXXX XXX XXXXX  XX XX  XX XX ",
        "XXXXXXX X    X  X    X  X  X    X  XX X    XXX  XX      X XXX"
    };

    private static final String TEXT_2 = "kVtnmdZMDB wbhQ4Y0L0D 6dxWYgeDO7 6XEq8JBGFD dbA5ruetw0 zIevtZZkJL UnEcrObNuS COOscwe4PD PL2lKGcbqk uXnmfUX00E l4FsUfvkiU O8bje4GTce  C85HiEHDha EoObmX7Hef VEipzaCPV7 XpBy5cgYRZ VzlrmMTRSW f0U7Dt0x5j Mb5uk2JcA6 MFov2hnHQR";

    @Test
    void testCode2() {
        QrCode qrCode = QrCode.encodeText(TEXT_2, Ecc.MEDIUM);
        assertSame(Ecc.MEDIUM, qrCode.errorCorrectionLevel);
        assertEquals(61, qrCode.size);
        assertEquals(4, qrCode.mask);
        assertArrayEquals(MODULES_2, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_3 = {
        "XXXXXXX X  X XXXX XXXXXXX",
        "X     X   X X   X X     X",
        "X XXX X X X X XXX X XXX X",
        "X XXX X X X XX XX X XXX X",
        "X XXX X  X  X X   X XXX X",
        "X     X X  XX   X X     X",
        "XXXXXXX X X X X X XXXXXXX",
        "        X  X X           ",
        " X X XXXX  XX XX XXX XX X",
        "XXX X   XX   X X X  XXX  ",
        " X X  XXXX  XXXX  XXX    ",
        " X  X    XX XX X XXXXXXXX",
        "   XXXXX X XX X       XX ",
        " X  XX X   X XX  XX  XX  ",
        "X XX XX XXX  X XXX    XX ",
        " X X X XX XXX XX    XX X ",
        "XX  X X X  XXXX XXXXX X X",
        "        XX  XX XX   XX XX",
        "XXXXXXX XXX  X XX X X XX ",
        "X     X X XX XXXX   X  XX",
        "X XXX X  XXXX X XXXXX  XX",
        "X XXX X X XX XX   XXXX   ",
        "X XXX X    XXX    XX  X X",
        "X     X X  X  X X  X XX  ",
        "XXXXXXX  X   X   X  X XXX"
    };

    private static final String TEXT_3 = "😀 € éñ 💩";

    @Test
    void testCode3() {
        QrCode qrCode = QrCode.encodeBinary(TEXT_3.getBytes(StandardCharsets.UTF_8), Ecc.LOW);
        assertSame(Ecc.QUARTILE, qrCode.errorCorrectionLevel);
        assertEquals(25, qrCode.size);
        assertEquals(7, qrCode.mask);
        assertArrayEquals(MODULES_3, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_4 = {
        "XXXXXXX    XX  X X   XXX   XX    XXX XXX X X  XX  XXXXXXX",
        "X     X XXX X   XXX  X X  XX    XXX   X   X  X X  X     X",
        "X XXX X  XX XX XX XX X XXX XXXX  X  XXXXXX X XXX  X XXX X",
        "X XXX X   XX   X  X    XX X    XX X X X      X X  X XXX X",
        "X XXX X    XXX   X X  XX XXXXXX XX X    X X X  X  X XXX X",
        "X     X X XX XXX X XX X  XX   XX     XXXXXXXXXX   X     X",
        "XXXXXXX X X X X X X X X X X X X X X X X X X X X X XXXXXXX",
        "        X X X X   X X     X   X XXXX XX X X  XXX         ",
        "    XXXX  XXX XX  XXXXX   XXXXXX   XXX       X  X XX   X ",
        "   X    X       X  X XX    XXX     X   X X X   X    XX  X",
        "XXXXXXXXXXX XXXX   X  X X XX X X  XXX  XXX XX XXX    XX  ",
        "X X  X X X   X      XX XXX XX    X XX  XXX    X X  XX XX ",
        "    X X  X  XXX XX XXXXXXXXXXX X      XXXXX   XXX X X XXX",
        "  XX   XX  XXX  X  X  XX  XXX   XXXX XX X XX    XXX   XXX",
        " XX X XX    X  X  X  X  X XX XXX   XXX     XXXX  X  X  XX",
        " X   X   XX X XXXXX XXXXX        XXX XX X XX XXX XXXXX  X",
        "X XXX XXXX XXX  X  XXXXXX XX       XXX     XXX  XX XXXX  ",
        "  X     X X   X XX X  XX    X X    X   X X  X  X    XX  X",
        " XX X XXXXX X  X   X X  X XXX XXX XXX  XXX    XXX    XX  ",
        " XX  X X X    XXX   XXXXXX X     X XX  XXX      X  XX XX ",
        "X    XX  X  XX X X XXXXXXXXX          XXXXX   XXX XXX XXX",
        "XXXX X XX  XX XX   X  X   X   X  XXX XX X XX XX XXX XX X ",
        " XX XXXX    XXX   X  XXX  XX  XXX  XXX     XXXX  X   XX  ",
        "     X   XX X XX XX X  X     XXXXXXX XX XX X XXX XX X XX ",
        "XXXXXXXXXX X X X     X  X XX XX    XXX   XXXXX  XX    XXX",
        " XX XX  X XXXX   X XX XX  X XX     X   X  X X  X   X XX X",
        " XX XXXXXXX    XX   XX X  XXXXX X XXX  XX     XXXXXXX X  ",
        " XX X   XX X XXXX  X XXXXXX   X X  X    X X     X   XX X ",
        "X   X X XX XXXXX X X XXXX X X XX   X  X       XXX X XX XX",
        "XXXXX   X   X  X    X X  XX   XX     XXX X X XXXX   XX  X",
        " XX XXXXXXX X    XX X  X XXXXXXX X XXX XXX XXXX XXXXXXX  ",
        "       XXX  X XX XXX  XX  XXX XXX  X XXXXX X XXX   XX XX ",
        "XXX   XX   XXXXX X X XX XX  XXX     XX XXXXXXX   XX   XXX",
        " X  X  XX   X       XXXX   X  X     X   X X X   X XXX XXX",
        " XXX XXX XX X  XXXX XX X X XX X XX  X         XX   X   XX",
        " X  XX  XX  XXXXXXXX XXXX XX XX X  X    X X    XXX   X  X",
        "X   X X    XXXXX X X XXXXXXXX XX  X X X       XXXXXX XX  ",
        "XXX XX X   X   X      X    X  XX XX XXXX X X XXX  X  X  X",
        " XX   XX  XX     X  X  X XXX XXX X  XX XXX XXXX     XXX  ",
        "X      XXX XX XX  XXX XX   XX  XXX  X  XXX X   XXX XX XX ",
        " X    X    X XXX X X XXXX X  XX  XXXX XXXXXXX XXX X   XXX",
        " XX X  X   X   X X   XX X XXX X  X   XX X X XXXX  XXX XXX",
        " XX  XXX XXX   XXXX  X  X  X  X XX X X       XX XXXX   XX",
        "X   XX XX X  XX XXXXXXX  XX  XX  X  XXX X XX XXX     X  X",
        " X XX XX  XXXXX XX X XX X  XX X X   XX     XX    XXX XX  ",
        " X XXX X  XX     XX   XXX X   XXX   X  X X  X   X X  X  X",
        "X X  XXX XXX    XX  XXX    X XXX X XX  XXX   XXX    XXX  ",
        "XXXXX    XXXXX   XXXXX      X  XXX  XXXXXX     XXX XX XX ",
        "      X XXXX    XX X X  XXXXXXXX XXXXX XXXX   XXXXXXX XXX",
        "        XX X  X       XXX X   X  X      X XX XX X   X XXX",
        "XXXXXXX XXXX    XXX  XX   X X XXXX X       XXXX X X X  XX",
        "X     X X X  X   XXXXX   XX   XXXX  X X X XX XX X   XX  X",
        "X XXX X X XXX  X X X X XXXXXXXXX    X X    XXX XXXXXXXX  ",
        "X XXX X   XX  XXXXX   X   XXXXX     XX X X  X  XX  X  XXX",
        "X XXX X  XXX X X X  XX XXXXXXX XXX XX  XXX    XX  XXX    ",
        "X     X  XXXXX X XXXXX X  XX  X XX  X  XX X      XX XX  X",
        "XXXXXXX  XX X X XX  X   XX X    XXXXXX XX     X XXXX XXXX"
    };

    private static final String TEXT_4 = "ABCD22340";

    @Test
    void testCode4() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_4);
        QrCode qrCode = QrCode.encodeSegments(segments, Ecc.HIGH, 10, 40, 4, false);
        assertSame(Ecc.HIGH, qrCode.errorCorrectionLevel);
        assertEquals(57, qrCode.size);
        assertEquals(4, qrCode.mask);
        assertArrayEquals(MODULES_4, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_5 = {
        "XXXXXXX X     X   XXXXXXX",
        "X     X X X XXX X X     X",
        "X XXX X   X   XXX X XXX X",
        "X XXX X XX XXX  X X XXX X",
        "X XXX X  X  XXXX  X XXX X",
        "X     X  X  X   X X     X",
        "XXXXXXX X X X X X XXXXXXX",
        "        X  XXX X         ",
        "X XX XXX X X  XX  X  X XX",
        "    XX  X XXXX X  XX  XX ",
        "XXX  XX  XX XXX  X   X   ",
        "X   X  X     X  X X X X X",
        " X XX XX X X  X   X  X  X",
        " X  X   XXXX X  X  XX XXX",
        " XXXX X X X X X XX  XXX X",
        "X  X   XXXX XXX XXXXX  X ",
        "  XX  XXXXXX X  XXXXXX X ",
        "        X X XX XX   X  X ",
        "XXXXXXX XXXXX   X X X  X ",
        "X     X XXX X X X   X XX ",
        "X XXX X  X XXX XXXXXXX XX",
        "X XXX X XX  XX  X X   X X",
        "X XXX X XX XXX XXXX XX X ",
        "X     X  X     XXX    XX ",
        "XXXXXXX X   X XX XXX  X X"
    };

    private static final String TEXT_5 = "314159265358979323846264338327950288419716939937510";

    @Test
    void testCode5() {
        QrCode qrCode = QrCode.encodeText(TEXT_5, Ecc.MEDIUM);
        assertSame(Ecc.MEDIUM, qrCode.errorCorrectionLevel);
        assertEquals(25, qrCode.size);
        assertEquals(3, qrCode.mask);
        assertArrayEquals(MODULES_5, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_6 = {
        "XXXXXXX    X   XX   XX XXXXXX XXXXXXX",
        "X     X XX  XX  XXX X XXX  X  X     X",
        "X XXX X X XXX      X XXXXX  X X XXX X",
        "X XXX X X XXX X    X   X  XX  X XXX X",
        "X XXX X X  XX      XXX X    X X XXX X",
        "X     X X XXX XXXXXXX XX XXX  X     X",
        "XXXXXXX X X X X X X X X X X X XXXXXXX",
        "          X X X X   X    X XX        ",
        "  X  XXXX   XXXXX XX  X  X X X XXXXX ",
        " XX    XX  X   XX XX    XX    X      ",
        "  XXXXX XXXX X     X XX X XX  X  X XX",
        "  X      XXXXX XXX XX   XXX  XXX X X ",
        "X XX XXXXXXX  XX XX   X   XX  XXX  XX",
        "XXX X  X   X  XX  XXX     X XXX  X X ",
        " XX X XX X  XXXXXXX X  XXX XXX XXX XX",
        "XX  XX  X X X  XXX   X  X X XXXX    X",
        "X X XXXXXX X XXXXXX  X  XXXXX X X XXX",
        "  X    XXX X X  XXX    X   X X  X X X",
        " X XX XX X X XXX      X   XXXXX    X ",
        "X X XX        X   X X      X   XXXXXX",
        " XXXXXXXXX X   XXX X  X X X  XX    X ",
        "XX X X   X X XXXX   X X    XXXXX     ",
        "XXX   XXXX  X  X   XX XXXXX  X XXX  X",
        "XXX XX XXXX  XXX XXXX X X XX XXXXXXX ",
        "XXX X X    X  XXXX   XXX XX XXX X XXX",
        "    XX XXX  XXX  X    X   X X  XXXXX ",
        "XX XX X  XXX X X      XX X  XX  X   X",
        "  XX   XXXX     X  XX X   XXXX  XXXX ",
        "XXXXXXX X XXX XX X    XXXXX XXXXXXXX ",
        "        X  X X XXX XXXXX  XXX   XX   ",
        "XXXXXXX X  XX  X  XXX X    XX X X   X",
        "X     X X X XX   X      X X X   X XXX",
        "X XXX X  X X  X XXX   X XX  XXXXXXX X",
        "X XXX X  XX X XXX  X  X X   XXXX   X ",
        "X XXX X XXX   X X X     X   X   XX XX",
        "X     X    XXXX X XX   XX X  X   XX X",
        "XXXXXXX   XXX XX  XXXX     X XXXX XXX"
    };

    private static final String TEXT_6 = "DOLLAR-AMOUNT:$39.87 PERCENTAGE:100.00% OPERATIONS:+-*/";

    @Test
    void testCode6() {
        QrCode qrCode = QrCode.encodeText(TEXT_6, Ecc.HIGH);
        assertSame(Ecc.HIGH, qrCode.errorCorrectionLevel);
        assertEquals(37, qrCode.size);
        assertEquals(1, qrCode.mask);
        assertArrayEquals(MODULES_6, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_7 = {
        "XXXXXXX  X    X  X XXXX   XXXXXXX",
        "X     X X    X  X X       X     X",
        "X XXX X  XX X  X    XX X  X XXX X",
        "X XXX X X XX  XXX X X X X X XXX X",
        "X XXX X X  XXXXXXX   XXX  X XXX X",
        "X     X   XXXX XXX X  X X X     X",
        "XXXXXXX X X X X X X X X X XXXXXXX",
        "        X   X  XXX   XXX         ",
        " X XXXX XXX  X XX X    X XX XX X ",
        "     X  X XX  X  XXX XXX  X   X X",
        "X XXXXX XXXX XXX   XX XX  X X X  ",
        "X X X  X X  XX    XXXXXXX X XX   ",
        " XXX  XX XX  X XXX X X XX     X  ",
        "X  XX  X X X   XXXXXX   XXX X XXX",
        "X  X XX  XX XXXX  XXX X XX X XXXX",
        "XXXX   X   X XXX  X XX   XXX  XX ",
        "  X  XX X  X  X XXX  X XX  XXX  X",
        "XX X    XX  X X X     X X XX XXXX",
        "      XXX  X        XXX        X ",
        "XXX     XX    XXXXXXX X XX   X   ",
        "   X  XXX   X   XX   XX  XXXX   X",
        "XXX X  X XXXXX         XXX X  X  ",
        "X     XX XXX XXXX  XXX  X    XXX ",
        "X X    XXX  X      XXXX  XX X  XX",
        "XXX X X X X X    XX  XX XXXXXXXXX",
        "        X X   XX XX XX  X   X XX ",
        "XXXXXXX  X  XXX X       X X XX  X",
        "X     X XX  X   XX   XX X   X   X",
        "X XXX X XX X XX XXX  XX XXXXXXXX ",
        "X XXX X X XXX X   X   X  XXXX   X",
        "X XXX X       XXXX X XXXXX X X XX",
        "X     X XXX  X X XXXXXX XXX X  XX",
        "XXXXXXX  X  X X X XX   X  XXXX   "
    };

    private static final String TEXT_7 = "こんにちwa、世界！ αβγδ";

    @Test
    void testCode7() {
        QrCode qrCode = QrCode.encodeText(TEXT_7, Ecc.QUARTILE);
        assertSame(Ecc.QUARTILE, qrCode.errorCorrectionLevel);
        assertEquals(33, qrCode.size);
        assertEquals(6, qrCode.mask);
        //TestHelper.printStringArray(TestHelper.toStringArray(qrCode));
        assertArrayEquals(MODULES_7, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_8 = {
        "XXXXXXX X X XX X  XXX X XX X X X X  X   XXXX X  X XX   X  XX XXXXXX  XX  X     XXX  X XX  X    XX    XXX XX X XX  XXXXXXX",
        "X     X X   XXX   X    XX X   X  XXXX X  XXXX   XX XX  X  X X  XXXX  XX  XX  XX      X XXXX XX     XXXXXX    XX X X     X",
        "X XXX X XXX X      X XX X         X  XXXXX X   XXXXX    X XX X X X  XXXX  XX      XXX X      XX X X  X X XX X  XX X XXX X",
        "X XXX X   XX       XX  X   XXX  X X   XXX X   XXX   X X X X   XXXXXXX  XXXXXXXX XX X   X  XXXXX       XX XXX XXXX X XXX X",
        "X XXX X   X XXX    XXXX XXX XXXXX XXX X X XXXX X XX X XXXXXXXX        X XX X  XXXX XXXXXXX    XX   X  XX   XX  X  X XXX X",
        "X     X XX XX  XX X      XXXX   X   X XX  X X  X  X    XX   XX  X XXX  XX     XXX   X   X X XX   X  XXX XX   XXX  X     X",
        "XXXXXXX X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X XXXXXXX",
        "        X      XXX       X  X   X X    X XX X  XXX  X XXX   XX X X XX X    X   X  XXX   X  X XXXX X  X   XXXXXXXX        ",
        "  XXX X X XX  X  XX  XX X X XXXXXX   X  X  XXX  X    X  XXXXX    X XX X  X X  X    XXXXXXXXX X  XXX   XX   XXXX  XXX  XXX",
        "  XXXX     XXX  XXXXX   XX      X  X  X XX X  X   XX XXX  XXXXXX XX  XX  X  X     XXX  XXXX XXXXX X  XXX X   XX X X XX   ",
        "XX X XXX X   X XX     XXX   X XX XXX  X XXX XX    X   X X       X XX   XX X  XXXX    X XXXX X  X   XXXX X    X    XX   XX",
        " X XXX XXXXX   X X   XXX X  XX X XX XXXX XX  XX   XX XX XXX X X XXX XX XX XXX  X XX XXX    X  XXX X  X X XXXX XXXXXXX   X",
        "X   XXXXXX  X   XXX XX X  XX  XXXXXXX  XXXXXXX XXXXX X X X X XX  XX X XXXX  XX X X    X   X XX  X XX  X  X  XXX    XXXX  ",
        "XX XXX  XX   XXXX X XXXXX   XX  XXX  XXX   XX XX     X X XX XX XXXX   XX XXXX   XX XXX XX X     XX X XX XX X XX XX  XX X ",
        "XX   XXXX  X X XX XXXXX XXX X    XXX XXXXX  X XXX XXXXX X  XXXXXX      X  XX X  X  XXX XXXX X  X X XX X X       X      XX",
        "X   XX XXX   X     XX  XX X   XXXXXXX X  XX  X XX X  XXXX  XX X X   XX  XXXXX XX XX  XX       XXXXXX   X XX X XXXXXXX  XX",
        "X X  XX X XXX X XXXXXX X  X XXXX X  XXX XX  X  XX X XXX    X XX  X  X XX XXX XXX X       XXX   X     XX X   XX     X XXXX",
        "  X       XX XXX  XXXXXXXXXX X    X   XXXX XXXXX XXX XX X XX XX X  XXX X X     X  XXXXXX XXX  XX  X  XXXXX   X  X XXX  X ",
        "XX XXXX X     XXXX X XXX XX   X X    X XX   XXXX  XXXX XXX  XXX  X   X  XXXX   XXX  XX XXXX X    X XXXX X  XXX     X X XX",
        "     X  XXX X   XXXXX     XXXX XX X XXXXX  X  XX  XXXXX X  XXXX    XX  XX XX  XX  X XXX      XXXX X    X XXXXXXXX X      ",
        "  XX  XX XXXX XXX XX X X  X X   X  X X XX XX X  X X   XXXX  XXXXX    X  X XX XXX  X  XX  X XX   XXXX  X X   X        XX X",
        "X X XX X XX   X  XX X X X XXXXX XXX X  X  XX XX  X XX X XX X      XXX X X    X  X XXX       XXX X     XXX X X   X X X    ",
        "    X X X  XX X   X XX   XX X   X   X X   X X XX X X  XXXX X  XX   XX X  X    X X   X  XXXX XX   X XXXX X    X  X XX XXXX",
        "X  X     XX XX   XXX XXXXXX XXXXX XXXXXXX      X X        X     XX X  XXXXX X X  XXXX X    X XXXX X  X X XX X X XXX XX XX",
        "X    XX  XXXXX XX  XX XX   XXXX  XXXXX  XXX  XXX XX   XX  X X XX X XX XX   X XX  X   XXX     X XX  XX    X  X      XXXXX ",
        "XX X   X XX  X X XX  X   X XXX X XX X XX    XXXX XX  XX X     X   X X    XX    X XXXX XX  XX X  XXX  XX XX X XX   X  X   ",
        "  X  XXXX XXXXX XX XX X  XXXX XXX    XX XXX       X  X X X XXX X  XXXXX XXX X   XX  XX XXXX X    X XXXXXX          X X XX",
        "    XX    XX   XXXXXXX   X  XX  X      XXXXX  XX   X  X X  XXXXXX  XX X  XXX  XX XXXX X       XXXXX    X XXXX X XXX      ",
        "  X XXXXX   X   XXXX X X X  XXXXX  XX XXX X X XXX  X  XXXXXXXXX XX X X XX X  XXXX   XXXXX X  X     X X X XXX    XXXXX XXX",
        "   XX   X X      XXXXX X  XXX   XX X X  XXX     XX XX X X   X X XXXXX   XXX XX XX  XX   X XX    XXXX   X  X    XX   XX   ",
        " X XX X X    X  X XX XXXX X X X X  XXXX  X X  X  X X X  X X XXXX  XX X XXX XX  XX  XX X XXXXX  X X  XXX XX X X  X X X X X",
        "XXX X   X XX XX X   X  XX X X   X  X XX     X   X  X    X   XXX   X  XXXXX XXXXX XX X   X  X XXXX X    X XXXXXXXX   X   X",
        " X XXXXXXX   XXX XX XX X  XXXXXXXXX XX   XX  X  X   XXX XXXXXXX  XXX X X XXX  X X X XXXXX X X XXX    XX  X  XX XXXXXXXXX ",
        "X XX   X XXXXXXX XX X XXXXX  X X      X  XXXX X X X XXXX XXXXX XX  X  X XXXXXX   X  XXXX X XXXXXX    X   X XXX  X     XX ",
        "X XX  XX X  X   XXX XX  XX XXXX  XX XX X      XXX  X   XX X X  XX XX     X  X X XX XX XX XX X    X XXXX         XXX XX XX",
        " XXXX  XXXXX XXXXXXXXX    X      X  X XXXX     X  X  XX   XX      XXXXX X    X X XXX X XXX   XXXXXX    X  XXX XXXX     X ",
        "XX  X XXXX X XXXX  XX XXX    X  XX   XXXXX X X   XXX X X   X X   X   X XX  XXXX  XX   X  XXXXXX X  X     X  X  X XX X XX ",
        "X XXXX X X  X XXX X    X X X   XX  XXXXXX X   X   X    XX X   X  X XXXXX   X X  X  XX  X XXXXXX X  X  X  X   XXX   XXX   ",
        "XXX   X  XX  XX X X XX     XXXXXXX   X  X  XXXXX X XXXXX  X     X X  X  XXXX  X XX      X X XX   X XXXX X    X  X X XX XX",
        "XX         X XXXX X  X XX XX X XXX    XX    X XX XXXXX X X X     X XXXX XXXX XXX XXX X  X  X XXXX XX     XXXX XXX XX   X ",
        "X X   XX X XXX X XX  X   X   XXX    XXXXXXX X XXXXXX  XX  XX  XX XX  X X XXXXX X      X   X XX      X XX X X X  XXXXX X X",
        "XX XXX     XX  X X X X  X XX X  X  XX  XXXX X XXX  XXXXXXX XX  XX  XXXX  XX X XXXXXX   X   XX XXX   X X  X XX      X X   ",
        "XX X XXX  X      X     X   X  XXXXX X XX  XX X X XX X X     XX  XX  XX  X X   X X  XX  X XX X  X    XXX X       X X X   X",
        " X XXX XX  X  X X X  X   X   X   X    X XX    X  X X X  XXXXXX XX    XX  XXXXX X XXX X XX  X XXXX X      XX X XXX      X ",
        "XX XXXXXXX X  XXX  X X X  X  XX XX    XX XXXXX  XXX   XXX   XX X XX  XX X X  XX  X  XXXX  XXX XX   X  X  X X   XXXXX XXXX",
        "X  X X   XXX X XX XX X  X XXXX  X X  X  X  XXX    X  XXXXX X   XXX X  X X XX   X  X X     X  XXX   X X X  XXX  XX   XX   ",
        " X    X  X XX XX  XXXX XXXXXXX  XXXX  XX X  XX    X XXX X  XXX X XXXX  X X XXXXXX   XXXXX X X    X XXXX XX   X  X   XXX X",
        " XX  X     XX X X  X X      XXXX XXXX   XXX XX  XXXX XXX   XXX XX X X    XX  XXX  XX X XX  X  XXX XX   X XXXX XX XXX     ",
        "X X XXXXX  XX XX XX  X   XX   XXXXX  X     X  XX  X  XXXX XX  XXXXX  X        X  X  XXX  XX  X X  X  XX  X  XXXX XXX    X",
        "X XXXX X  X XXXXX X    X XX XXXX X    XXXX    X  X XXXXXX XX XX  XX   XX   X   X X   XX XXXX X  X    XX    X  XX    X X  ",
        "   XX X  X  XXX  XX XXXX   X  X  XXX XX X XXX       X X     XXX XXXX   X XXXX XXX       X X X    X XX XXX    X    X XXXXX",
        "XXXX    XX  XX XXX   X X XX   X  XX  XX  XX X   X XX XXXXX  XX  XX   X  X  XXXXX  XX    X  X  XXX X    X  X X XXX XX    X",
        " X    XX    X XXX X      XX XX XX XX XXXX XXXX XXXX XX X XXX XXXX    XXX XXX X X X  X X   X  XX X    XXXXX XX   XXX  XXXX",
        "XX     XXX  XX   X    X        X  XX   X   X X   XX      XXX X   X X XXXX XX  XX X       X  X      XX XXXX     X X   XX  ",
        " X    XXXXXX X   X     X  XXX         XX   X  XXX X  XX  XXX XXX X  X X X  XXX  X   X    XX X    X  XXX X    X  X X X  XX",
        " XX XX      XXX  X XX XXX X X  X XXXX X XXXX    XX XXXX X X  X  XXXXXXX XXX XXXX XXX X XXX X XXXX X    X XXXXXXXX XX X  X",
        "X  XXXXXX  XX X    XXXXX X  XXXXXXXX   XX   XXXX X    XXXXXXX     X   XX         X  XXXXX X   XXX X  XX     XX  XXXXXXX  ",
        "    X   XX  XXX XX  X  X  X X   XXX   X  X   X XX XXXXXXX   X X XX  XXX XX  XX    X X   X    XX  X XX X XX X    X   X X  ",
        "   XX X X XXX  X X X XXXXXXXX X X   XX  XXXXXXX XXXXX  XX X XXXXXXX  XX  X X X  X  XX X XXX X      XX X XX   X  X X XXXXX",
        "   XX   X X   X XX   X    X X   XXX XX XX  X   X      X X   X   X XXX  XX XX XXX XXXX   X    XXXX X    X XXXX XXX   X  X ",
        "   XXXXXXXX X XXXXXX   XX   XXXXXX XXX  XX XX  X XX   XXXXXXXXX  XX X XXXXXX      X XXXXXXXXX XX  XX    XX  XX  XXXXXXX X",
        "X    X  XXXXX XXXXXX  XX XX X X   XXXXXX  X X XX  XXXXX X XX  XXX XXX XX    X X   X   XX XXX  XXX  XX X  X  XX X XX  X   ",
        "   X  X X  XX X XXX X   XXXXXX  X X X  XXXX XX X X     XX   XXX      X X X X    X  XXX X XX X  X X XXXX X    X XX    X XX",
        "XXXXX   XX  XXX    X   X X  X X X  X X  X X  XX  XXX XXXXXXXXX  XXXX  X X  X XXX  XXXX   X X XXXX XX   X  XXXXX XXX X    ",
        "XX XX XX XX  X X  X XXX       XXX  X        X  X   XX XX     X X X   X    XXX    X XXX XX X XXXXXX  XXX     X  XXXX  XXX ",
        "XX   X   X XXX XXX XXXX   X XXXXX XX   X XXX  XXXX  XXXX XX  X X X   XX  XXX X XXX X XXX  XXX   XX   XX  XXXXXX  XX    X ",
        "    X XXXXX XX  XX X X  XXXXXX  XX  XX   XX XX  X XX X X      X   X XX  XX XX   X  XX  X XX X  X X XX X X  X X X    XX XX",
        "XXX XX XX X XXX X   XXX XXXX XX XXX XXX XXXX X    X   XXXXXX   X   X X   XXXXX X XXXX   X  X  XXXXX    X XXXX XX X  XX XX",
        "  XXX X  XX  XX X XXX  X    XXX XXXX XXX    X XXX X   X XXX     X   XX     XXXX   XXX  XX XXXX  XX XX XX X  X  XXX X XX X",
        " X  X    XX X XXXX   X  X XX  X  X X X X  X  XXX XX     X    X X     XXXXX X X   XXX  X   X  X XX   XXXX  X XXX  XXX XXX ",
        " XX X XXXX XXXXXXX X X    X   XX X XX XX X  XXX        X XXXXX    XXX XXX XX   XX  XXX X XXXX    X  XXX X      X X  X  XX",
        " X      XX  X  XXX     X XXXX   XX   X X XXXX   X    XX   X  XXXXX  X XXX XXX XX XXXXX     X  XXX X  X X XXXX X   X X   X",
        "   X  X  XX   X X XX  X    X  X X XXX  X    X  XX     X  X X XXXXXX  X     XXX  XX XX  XXXX   XXXX X  XX XXXX  XXX X XXXX",
        "XX X X XXX X    X X XXX   XX   X X X  XXXXXX   X  X X   X  X X   XXXXX  XX X X XX     X   X   X       X X  X X   XXXX XX ",
        "    X XX XX   X    X X X XXX XXXXX   XXX  X  X XX    X  X  X XXXXX X  X X XXXXX X  XXX X  XXX      XXXX X           X XXX",
        "X X        XXX XX  X XX XX    X XXX X XXX X  XXXXXX   X        XXXXXXX X  XXXXX  XX  XX X  X XXXX X      XXXX XXX X X  XX",
        "   XXXX  X     X  X X        XX XXX      XXX   X     XX  XXXX  X X  X    X   XXXX   X   X XX X X   X  XXXXX  X XXX    XXX",
        " X X X XXXXXXX XX   XXX XX   XXX X  XXXX  XXX X X XXX X XXX  XXX  X  X XXXX XX XXX    X  X X  XX  X XX XX   X    XXX X   ",
        "     XXX X  XX   X  XXX XX  X  X  X    X   X    XX    XXXXXX XXXXXX  X X XX X  XX  XXX X XX X    X XXXX X  X X     X X  X",
        "XX XXX X X   X   X X X X  X     XXXX XXX X X   X  X X  XX  X XXXX   X  XX     XX XX XXXX     XX X X    X XXXX XX XX X    ",
        "XXXXX X X   XXX X  XXX  XXX     X XX  XXXXX   X X X  XXXXXX XXX   XXX XXX   XX XXX XXX XX  XX  X X X XX  X  X  XX XX  X X",
        "XX  X  XX    X XX  X   XXXXX  X   X  XXXX  XXXXX  X  XXXXXXXX X   XXXXXXX   XX XXXX  XX  XX     XXXX  X X X XXX  XX  X   ",
        "   X XX  XX X       XXXXX  X X    XXX XXXX  XXX   XX XX     X      X    X  X XXXX  XX  X XX X       X X X  X X X     X  X",
        " XX XX XX    XXX  XX X X X X XX  XX     XX XXX XXX X XXXX   X X X  XXX XXX XXX X XX XXXXXX    XXX X    X XXXX XX X  X  XX",
        "X   XXXXXXX   X XXX X   X   XXXXX   X X X XX X  X X XXXXXXXXXXXX  X  X X X  XXXX X XXXXXX  X    X   X    XX  XX XXXXXXXXX",
        "X XXX   X X  X XXXX    XX  XX   XXX XX XX  XXX  XX    X X   X     X X X XX XXXX X X X   XX  XX  X  X  X XX X    X   XX   ",
        "   XX X XX XXXXX   X  XXXX XX X X XX X X   X   X  X X   X X X X    XXXXXXXXXXX  XX  X X X X X    X XXXX X    X  X X XX  X",
        "X   X   X  XX XX   X  XX  X X   X   X X   X XX XX XX  XXX   XX   XXX   XX XXX  X XXXX   X  X XXXXXX    X XX X XXX   X   X",
        "X XXXXXXX  XX     XX  X X X XXXXX XX  XXX X   X XXXX XXXXXXXXXXX X  XXX   XXXXX  X XXXXXX X  X X X  XXX  XX XXX XXXXX XXX",
        " X XXX X    X   XX XXX     X X   XX XXX    XX   XX X  X X XXX       X XXX    XXX XX    XX X     XX   XX  X XX XX         ",
        " XXX  XXXXX  XX   X XXXX X  XX X  XX XX   X X    XXXX   X  X XXX X  XXXX X XX  XXX  X X  XXX     X  XXX X  X X    XX X XX",
        "X X    XXXXXX  X XX  XX XX X XX  XXXXXXX     X X X      X X  XX XX   XXX    XXXX XX XXXX   X  XXX X    X XXXX X X   XX  X",
        " X X XXX    X XXX XXX  XXXXXX X XX XXX XXX   XXXXXX X XX X    X XX XXX   X XXX X   XX XX X    X XX X  XX    X XX  X XXX X",
        "  X     X  XX XX X     XX X     X   X XXXXXX  X X X XX  XXX  XX XXXXX    XX X XX  X  X XXX   XX X  X XXX     X X XXX     ",
        "XXX  XX X X   XX X  X  X X    XX XX  XX XX  XXX X XX X    X  XXXX  X XX  XXXXX  X    XX  XXXXX   X XXXXXX    X XXXXX   XX",
        "XXX XX XX XXX    X XX     XX XX XX  XXXX XXXXXXXXXX XX X  X  XX XX XX  X  XX   X XX X   X  X XXXX XX   X XX XXX XX      X",
        "  X XXX  X X  X X   X   X X   X   X X X XX  XXX         XX  X XXXX    XX     XXX   X XX XXX  X  XXXXX X   X    XX XXX X  ",
        "     X XXXX   XXX  X  X  XX X XXX X  XX XXX XX XX    XXXX   X XX X XXX  XX XXX       X  XXX    XX XX     X XX XXX  X     ",
        "XXX  XX XX XX   XXXX X      XX X XXX   X  X X X  X XXXX XX   XXXX   X XX XXX XX X  X  X   X X    X XX X XX   X X  XXXX XX",
        " X XXX XX  XX X  X          XXXX X  X  XX X X  XX X  XXX  X XXXX    X  XX   X XX  X XX     X  X X X    X XXXXXX X  XX    ",
        "XX   XXXXXXX XX X  XXXXXXX      X  XXXXX X  XXX    X  X   XX X XXX  X  XX  XX XXX  X X   X    X    X   XX   X  XXXX XXXX ",
        "X   X       XX XXXXX       X   XX  X X XXXXXXXX   XXXXX  X XX X XXX XXXXXXX X    X   X XXX  X X X  X XX        X  XX     ",
        "XXX X X      X X XX  X XXX      XXX X X XX X  XXX X X  X   XX  X   XX    XX X XXX    XXX  XXX    X XXXXXX  X X   XX  X  X",
        "  XXX   XX XXXX X XX XXX  X X XXX   X   X XX   X XXXXXXX   XX X  XX   X  X X   X XXXXX X   X  XXX XX   X XXXXXX X    X   ",
        "XX   XXXXX XX XX  X X XX X  X X X   XX XX    XX X   XXX X  XX XX  X X X XXX XXXXX  XXXXX   X   XXX    XXXX   X XX X XXX X",
        "  X  X XX   X X XXXX   XX XXXX   X XX X  XX  X   X X  XX   X  XX  XXX X X  X  X     XX XXXXX X   XX   XXXX X  X X XX     ",
        "XXX   XX X  XX  XXX  X XX X   X XX  X X     X   XXX XX  XXXXX     XX XX  X  X XXX  X  XX XX XX X X XXXXXX      XXXXXX  XX",
        "X XXXX   XXXXXX XX X  XX  X X  X X  X  X XXXXXXXX X XXXX XXX X  X XXXX XX    XXX  X XX X X X XXXX XX   X XX X X XX X X XX",
        "X   X X  X XXX X XX    XX X X  XX    XXX   XX X   XXX    XX XXX  XX XXXXX  X X  XX XX   XXXX    X  X  X   XX   X    XXX  ",
        "X   X  X  X X X    X   XXX   X  X  XXXX X X      X X   XX X  XX XXXX XXXXXXXXX      X  XXX X    X     X   X X  X XXX  XX ",
        "XX X XXXXXX     XXX X  X XX XXXXXXX X XX XX          X  XXX X    XX  X   XXXX XXX  XX X   X X  X X XXXX X    X X XXX  XXX",
        "X XXXX   XX  XX  X  XX XX  X    XXXX      X  XX   X XX X X  XX    XXX   XX    XX XX    X   X XX X XX   X  X XXX     X    ",
        " XXX  X  X    X     X XXX  XXXXXX   X X XXXXX XXXX    XXXXXXXX    XX XX  X  XX X   XXXXXX X XX X XX X XXX   XX XXXXXX X X",
        "        X  XXXX XXXXXXXX XXXX   XXXXXXXXXXX    XXX X XX X   XXX X XXX  XX XX XXX X XX   X X    X XX  XXX   XX  XX   XXX  ",
        "XXXXXXX   XX XX  XXX   X X  X X XX  XX  XX    X X XXX  XX X X   X   X XX  XXXXX X   X X XXXXX    X XXXXXXX   X  X X XX XX",
        "X     X  X X     X   X    XXX   XX X  X  X X  X XXX    XX   X X     X  X X XX  X XX X   XX X XXXX XX   X XX XXX X   X  XX",
        "X XXX X XX X  X  XX X X X  XXXXXX    X XX X     XX   XX XXXXXXXX  X X   X           XXXXXXXX   XX          X X  XXXXXXX  ",
        "X XXX X XX X  XX XX XX  X  X   XXX X  XX    X  XXX XX X X XX  XX  XX XXXX XX X  X   XX XX   XX    X  XX  X  XX XX XX X  X",
        "X XXX X XXXXXXX XXXXXX   X   XXX X X X XXX XXXXX X    XXXXXX X XXXXXX   X     X XX X X XXXX X       XXX X    X    XX X  X",
        "X     X  XX X XXX  X X XX  X  X XXX XXX X X XXX XXXXXX X    X X X  X XX X X   XX XXXXXXX     XXXX X    X XXXXXX  XX     X",
        "XXXXXXX       X X  X   X  X   X  XX  XXXX  X   X  X XX  X    X   X   X   XXXXX X X  X  X X X       XX XX XXX XXXXX   XXXX"
    };

    private static final String TEXT_8 = "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, 'and what is the use of a book,' thought Alice 'without pictures or conversations?' So she was considering in her own mind (as well as she could, for the hot day made her feel very sleepy and stupid), whether the pleasure of making a daisy-chain would be worth the trouble of getting up and picking the daisies, when suddenly a White Rabbit with pink eyes ran close by her.";

    @Test
    void testCode8() {
        QrCode qrCode = QrCode.encodeText(TEXT_8, Ecc.HIGH);
        assertSame(Ecc.HIGH, qrCode.errorCorrectionLevel);
        assertEquals(121, qrCode.size);
        assertEquals(2, qrCode.mask);
        assertArrayEquals(MODULES_8, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_9 = {
        "XXXXXXX  X  XXX X XX  XXXXXXX",
        "X     X XXXXX XXXX  X X     X",
        "X XXX X    XX XX XXXX X XXX X",
        "X XXX X  X  X XX   XX X XXX X",
        "X XXX X   XXX  X  X   X XXX X",
        "X     X X X     X XX  X     X",
        "XXXXXXX X X X X X X X XXXXXXX",
        "        X X X XXXXXXX        ",
        "    XXXX  X X X   XXX XX   X ",
        "X XXX  X X XX  X X XX X XXXXX",
        "XX  XXXX X XX   X   XX   X  X",
        " X   X  X  X X X X XXX XXX XX",
        " X XX X XX XX X   X    X    X",
        " XXXXX   X  XXXX XX   X X X X",
        "   XX XX  XXXXXX    X   X   X",
        "XX     X  X  X     XXX X X X ",
        " XXX XX XX    XX X XXX     XX",
        "XXX XX  XX XX    XX X XXXX  X",
        "  X XXXX     X      X   XX  X",
        "  XXXX  X  X XX XX XX  XXX X ",
        "XXX XXXX  XXX  XX   XXXXX  X ",
        "        X  X  XX    X   X X X",
        "XXXXXXX XXX XX   X XX X X   X",
        "X     X XXXX X  X  XX   XX X ",
        "X XXX X XX     XXXXXXXXXX  XX",
        "X XXX X  X  XX   XX    X  XX ",
        "X XXX X  X XX   XXXXXX   X XX",
        "X     X    X   X XX XX X X XX",
        "XXXXXXX  X  XXX  X  XX  XX X "
    };

    private static final String TEXT_9 = "https://www.nayuki.io/";

    @Test
    void testCode9() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_9);
        QrCode qrCode = QrCode.encodeSegments(segments, Ecc.HIGH, 1, 40, -1, true);
        assertSame(Ecc.HIGH, qrCode.errorCorrectionLevel);
        assertEquals(29, qrCode.size);
        assertEquals(4, qrCode.mask);
        //TestHelper.printStringArray(TestHelper.toStringArray(qrCode));
        assertArrayEquals(MODULES_9, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_10 = {
        "XXXXXXX     X  XX X X XXXXXXX",
        "X     X  XX  XXXX XXX X     X",
        "X XXX X  X  XXX   X X X XXX X",
        "X XXX X  XXX  XXXXXXX X XXX X",
        "X XXX X X X  X X X X  X XXX X",
        "X     X     X X    XX X     X",
        "XXXXXXX X X X X X X X XXXXXXX",
        "        XX  X    XXX         ",
        "  XX  XXX       X  X XX X    ",
        "XX  X   X  XXXX  X   XX X   X",
        "XXXX XXXX XXX XX      X  XXX ",
        "   X   XXX          X   X   X",
        "  X X XX   XXX X  XXXX X XXXX",
        "X XXX  X X X  XX   X  XX XX X",
        " X  XXX  XX X X  X XXX XXX XX",
        " X  XX X   XXX  XXXXXXX XX XX",
        "X XX  XXXX XXXXX  X XX XXX XX",
        " X   X   XXX  X XX     X XX  ",
        "X X   XX  XXXX  XXX X XX X   ",
        "     X   XXX X X X X XXXXXX X",
        " X   XXXX  X  XX  X XXXXX XXX",
        "        XX X X     XX   XX XX",
        "XXXXXXX X   XXXXXX XX X X XX ",
        "X     X   X    XXX  X   X    ",
        "X XXX X      XX XXX XXXXXXX X",
        "X XXX X XX X       X    XXXX ",
        "X XXX X X   XX XX X X  X    X",
        "X     X   X X  XX   XXX XX X ",
        "XXXXXXX  X X  X   XXXX X   X "
    };

    private static final String TEXT_10 = "https://www.nayuki.io/";

    @Test
    void testCode10() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_10);
        QrCode qrCode = QrCode.encodeSegments(segments, Ecc.HIGH, 1, 40, 3, true);
        assertSame(Ecc.HIGH, qrCode.errorCorrectionLevel);
        assertEquals(29, qrCode.size);
        assertEquals(3, qrCode.mask);
        assertArrayEquals(MODULES_10, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_11 = {
        "XXXXXXX    X XX     X  XX XXX   X  XXX  X XXXXXXX",
        "X     X X XXX XX XXXX XX   X X XX   X XXX X     X",
        "X XXX X    X X  XX X XXXX  XXXXXXXX  X XX X XXX X",
        "X XXX X  X XXX XXXX   XX X XXX XX XXXX X  X XXX X",
        "X XXX X X  XXX XX   XXXXXXX  XX XXXX X    X XXX X",
        "X     X   XXXXX X    XX   XXXXXXXXX  XX   X     X",
        "XXXXXXX X X X X X X X X X X X X X X X X X XXXXXXX",
        "            XXXXX XX  X   XXX  XXXXX XX          ",
        "X X X X   XX  XX      XXXXXX   X XXX XX     X  X ",
        "   XXX X XX XX  XXX X    XXX XX  XXXX XXXXX X  XX",
        "XXXX XX X  XX  X X   X  X X XXX  XXX  XXX  XXX   ",
        " X XX  X XX   XX XXX XXXX  XX  XXXX   X  XXX  X  ",
        "X    XXX   X   X X  XXXX XXX  XXX XXX X          ",
        "    XX   XX X       X XX XXX  X   XX  XXX X X X X",
        "  X X XX X XX  XX       X XX   XX      XX   XX   ",
        "X    X    XXXXXX XX X XX  XX XXXX  X XX  XX X X X",
        "XXXXXXXXXXXXXX  X XX  X    X  X   X   X  X     XX",
        "X X X   X XXXX  XXXXX XX  XXX XX  X   X   X    XX",
        "XXX X XXXXX X X XX   XX    X       XX   X XXX    ",
        " X X X XXX   X  XXX    X  XXXXX XXX X  X X  XXX X",
        "XX XX X      X               XX  XX  X    X    XX",
        " X XXX  X  XX  X XX XXXX  XX   X    XXX XXX XXXXX",
        "  X XXXXXX XX  XX XXXXXXXXX    XX  XXXX XXXXX    ",
        "XXXXX   X X  XX XX X XX   XX XXX XXXXXX X   X    ",
        "XXX X X X XX XXXX   XXX X X   X  XX XX XX X X  XX",
        "  XXX   X   XXX X XXX X   XX XXX X   XX X   X  X ",
        "XXX XXXXX  XX XX XXX XXXXXX    X     XX XXXXXXXX ",
        "X  X X   X    XX  XXX  XXX X   XXXXX XXX X  XXX X",
        " XXXX XX  X XX   X XXXX X X  XXXX X  XXX XX    XX",
        "    X  XXXX  XXXX  X    X  X XXX XXX XXXX X X  XX",
        "X XXX X X XXX XXXX XX X    X    XX X XX X    X X ",
        " XXXXX  XX  XX  XXXX X  XX X   XX  XX  X    XXXX ",
        "   XXXX  XXXX X X  X  X X X XX X  XX   X XX  XXX ",
        "XX X X    X  X   X XXXXXXX  XXXX XXX XXXX X X X X",
        " X    XXX X XX X XXX  X X    XXX X   XX    XXXX  ",
        "  X XX XX  XX    XX   XXXX XXX XXXXXXX  X  XX XX ",
        " X  X X X  XX XX   X  X    X XXX X X XX X  X     ",
        "  X X  X    X XXX  XXXX XX XX X X   X XX  XXXXXX ",
        " X   XXXXXX X     X XXXX       X       X   XXX   ",
        " XXX   X XX    X     X XXXX X X X XXXX   X X  X  ",
        "XXX   XXX X X  XXX  XXXXXXX  X   X XX XXXXXXX  XX",
        "        X X  X   XX X X   XX  X X XX    X   X X X",
        "XXXXXXX  X XX XXXXXX XX X XXX  X   XX   X X X  XX",
        "X     X  XX  X XX   X X   X X   X X X  XX   XXXX ",
        "X XXX X XX X X XX   X XXXXX   XXX X    XXXXXXX X ",
        "X XXX X  X XX XX X  X  XXX  XXX  XX XXXXXX   XXX ",
        "X XXX X XXX XX XX    XXX XXX XX    X  XX XX  XX  ",
        "X     X   XXXXX  XX XX XXX XX     X XXX   X  XXX ",
        "XXXXXXX X X   X  X   X XXXX  XX  XX  X  X  XXX XX"
    };

    private static final String TEXT_11 = "維基百科（Wikipedia，聆聽i/ˌwɪkᵻˈpiːdi.ə/）是一個自由內容、公開編輯且多語言的網路百科全書協作計畫";

    @Test
    void testCode11() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_11);
        QrCode qrCode = QrCode.encodeSegments(segments, Ecc.MEDIUM, 1, 40, 0, true);
        assertSame(Ecc.MEDIUM, qrCode.errorCorrectionLevel);
        assertEquals(49, qrCode.size);
        assertEquals(0, qrCode.mask);
        assertArrayEquals(MODULES_11, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_12 = {
        "XXXXXXX XX    XX X XXX  XXX XX XXX  X   X XXXXXXX",
        "X     X  XX XXX   X XXX  X      XX XXXXXX X     X",
        "X XXX X XX     XX     X XX  X X X XX   XX X XXX X",
        "X XXX X     X   X XX XX     X   XXX X  X  X XXX X",
        "X XXX X  X  X   XX XX XXXXXX  XXX X       X XXX X",
        "X     X XXX X XXXX X  X   X X X X XX  X   X     X",
        "XXXXXXX X X X X X X X X X X X X X X X X X XXXXXXX",
        "         X XX X XXX  XX   X XX  X X   XX         ",
        "X X   XX XX  XX  X X XXXXXX  X    X   XX   X  X X",
        " X  X     XXX  XX XXXX X  X   XX  X XXX X XXXX  X",
        "X X   XXXX  XX     X   XXXXXX XX  X  XX XX  X  X ",
        "    XX    XX XX   X   X XX  XX  X XX XXX  X  XXX ",
        "XX X  X  X   X     XX X   X  XX XXX XXXX X X X X ",
        " X XX  X  XXXX X X XXXX   X  XXX XX  XX XXXXXXXXX",
        " XXXXXX     XX  XX X X XXXX  X  XX X X  XX XX  X ",
        "XX X   X XX X X   XXXXX  XX   X XX    XX  XXXXXXX",
        "X X X X X X X  XXXX  XXX X   XXX XXX XXX   X X  X",
        "XXXXXX XXXX X  XX X XXX  XX XXX  XXX XXX XXX X  X",
        "X XXXXX X XXXXXXX  X  XX X   X X X  XX XXXX XX X ",
        "        X  X   XX XX X   XX X XXX XXXX     XX XXX",
        "X   XXXX X X   X X X X X X X  XX  XX   X XXX X  X",
        "    X  XXX  XX    XXX X  XX  X   X XX XXX XXX X X",
        " XXXXXXXX   XX  XXX X XXXXXX X  XX  X XXXXXXXX X ",
        "X X X   XXXX  XXX     X   X   X   X X XXX   XX X ",
        "X XXX X XXX   X XX XX X X XX XXX  XXX   X X XX  X",
        " XX X   XX XX XXXXX XXX   X   X    X  XXX   XX   ",
        "X XXXXXXXX  XXX   X   XXXXXX X   X X  XXXXXXX X  ",
        "XX     X   X XX  XX XX  X    X  X X   X    XX XXX",
        "  X XXX  XXXX  X    X XXXXXX  X XXXX  X   XX X  X",
        " X XXX  X XX  X XX   X XXX    X   X   X XXXXXX  X",
        "XXX XXXXXXX XXX X   XXXX X   X XX     XXXX X     ",
        "  X X  XX  XX  XX X    XX    X  XX  XX   X XX X  ",
        " X  X XX  X XXXXXX   XXXXXXXX    XX  X    XX  X  ",
        "X      X XXX   X    X X X  XX X   X   X XXXXXXXXX",
        "   X XX XXXXX     X  XXXXX X  X    X  XX X  X XX ",
        " XXXX   XX  XX X  XX XX X   X   X X X  XXX  XXX  ",
        "   XXXXXXX  XXX  X   XXX X    X       XXXX   X X ",
        " XXXXX   X XXXX XX  X XXX   XXXXXX XXXX  XX X X  ",
        " X   XX X XXXX X XXXX X  X X X   X X X   X  X  X ",
        " XXX      XX X   X X    X XXXXXXXXX X  X     XXX ",
        "XXX   X XXXXXX  X  XX XXXXXX   X    XXX XXXXXX  X",
        "        XXXX   X  XXXXX   X  XXXXXX  X XX   XXXXX",
        "XXXXXXX X   XXX X X   X X X XX   X  XX XX X XX  X",
        "X     X   XX    XX XXXX   XXXX XXXXXXX  X   X X  ",
        "X XXX X         XX XXXXXXXXX XX XXXX X  XXXXX    ",
        "X XXX X     XXX    XXX  X  XX XX  XXX X X  X  X  ",
        "X XXX X X XXX   XX X  X   X   XX X   XX   XX  XX ",
        "X     X  XX X XX  XXX   X   XX X XXXX XX XXX  X  ",
        "XXXXXXX XXXX XXX   X    X XX  XX  XX   XXX  X   X"
    };

    private static final String TEXT_12 = "維基百科（Wikipedia，聆聽i/ˌwɪkᵻˈpiːdi.ə/）是一個自由內容、公開編輯且多語言的網路百科全書協作計畫";

    @Test
    void testCode12() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_12);
        QrCode qrCode = QrCode.encodeSegments(segments, Ecc.MEDIUM, 1, 40, 1, true);
        assertSame(Ecc.MEDIUM, qrCode.errorCorrectionLevel);
        assertEquals(49, qrCode.size);
        assertEquals(1, qrCode.mask);
        assertArrayEquals(MODULES_12, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_13 = {
        "XXXXXXX  X    XX X XXX  XXX XX XXX  X   X XXXXXXX",
        "X     X XXX  XX     XXX XX    X XX X XXXX X     X",
        "X XXX X XXXX XXX X XX  XX X  XXX     X XX X XXX X",
        "X XXX X X X   X    XXX  X X   X  X     X  X XXX X",
        "X XXX X  XXXXXX       XXXXXXXXX    X X    X XXX X",
        "X     X  XX   XXXXXX  X   X X   X XXX X   X     X",
        "XXXXXXX X X X X X X X X X X X X X X X X X XXXXXXX",
        "        XX X  X XX   XX   X XXX X X X XX         ",
        "X     X XX X    X   XXXXXXX X  XX  X X XXXX  XXX ",
        "XXX     X  X  XX   X XXXX   X  XX    X     X XX  ",
        "XX  XXX  XXXX X XX  X X X  X XX X  X       X  X  ",
        "X   XX    XXXXX       X  X  XXX X XXXXXX     XXXX",
        "XX X  X  X   X     XX X   X  XX XXX XXXX X X X X ",
        "XX XX  X  XX X X XXXXXX X X  X X XX XXX XX XXXXX ",
        "   X  XXX XXX X     XXX X   X  X XX   X       X  ",
        " XXXX  XXX      X  X X  XX  X    XX X  XX  X X X ",
        "XX   XXX   XXXXX  XXXX    X X X XX     XXX  XXXXX",
        " XXXXX XXXX    XX   XXX XXX XX   XXXXXXX X X X   ",
        "X XXXXX X XXXXXXX  X  XX X   X X X  XX XXXX XX X ",
        "X       X  XX  XX  X X  XXX X  XX XX X    XXX XX ",
        "XXX   X XXX  XXXX   XXX   XXXXX X    XXXX X XXXXX",
        "X X    X XX  XX X  X    XX  XXX XXXX   X   X     ",
        "   XXXXXX XXX X   XX  XXXXXXX  X XXXXX XXXXXXXX  ",
        "  X X   XXXXX XXX X   X   X       X   XXX   XX XX",
        "X XXX X XXX   X XX XX X X XX XXX  XXX   X X XX  X",
        "XXX X   XX X  XXXX  XXX   X        XX XXX   XX  X",
        "XX XXXXXXXXXX   XXXXX XXXXXXX  XXXX  X XXXXXX  X ",
        " XX X  XX XXXX  XX   XX   X XXX     X   X XX   X ",
        " X    XXXX  XXXXXX X    X  XXXXX X   X  XXX XXXXX",
        "XX XXX  X XXX X XXX  X X X        X X X XX XXX   ",
        "XXX XXXXXXX XXX X   XXXX X   X XX     XXXX X     ",
        "X X X  XX  X   XX      X     XX XX   X   XXXX X X",
        "  X  XX X  XX  X   XXX  X  X X XXX X  X XXX X  X ",
        "  X X  XXX XX XXX X       XX    X   X    X X X X ",
        " XXXX XX X  XXX XXXXXX  X XXXXXXX X  X XX  X     ",
        "XXXXX   XX   X X   X XX     X X X X    XXXX XXX X",
        "   XXXXXXX  XXX  X   XXX X    X       XXXX   X X ",
        "XXXXXX   X X XX XXX X XX    XX XXX X XX  X  X X X",
        " X   XXX    X XXX X    X  XXX  XXXX   X X  X  X  ",
        " XXX    X  XXXX XXXXX X    X X X X    XXX X XX XX",
        "XXX   XX X  X X  X    XXXXXXXX  X XXX   XXXXXXXXX",
        "        XXXXX  X   XXXX   X  X XXXX XX XX   XXXX ",
        "XXXXXXX     XXX X X   X X X XX   X  XX XX X XX  X",
        "X     X   XXX   XXXXXXX   XXXXXXXXXX X  X   X X X",
        "X XXX X   XX XX      XXXXXXXX XX X    X XXXXX XX ",
        "X XXX X   X  X  X XX XX   XX   XX  X      XXX   X",
        "X XXX X     XXX     X  X X  XXX XXXX    XXX X    ",
        "X     X  XX   XX   XX       XXXX XXX  XX X X  X X",
        "XXXXXXX XXXX XXX   X    X XX  XX  XX   XXX  X   X"
    };

    private static final String TEXT_13 = "維基百科（Wikipedia，聆聽i/ˌwɪkᵻˈpiːdi.ə/）是一個自由內容、公開編輯且多語言的網路百科全書協作計畫";

    @Test
    void testCode13() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_13);
        QrCode qrCode = QrCode.encodeSegments(segments, Ecc.MEDIUM, 1, 40, 5, true);
        assertSame(Ecc.MEDIUM, qrCode.errorCorrectionLevel);
        assertEquals(49, qrCode.size);
        assertEquals(5, qrCode.mask);
        assertArrayEquals(MODULES_13, TestHelper.toStringArray(qrCode));
    }

    private static final String[] MODULES_14 = {
        "XXXXXXX    X XX     X  XX XXX   X  XXX  X XXXXXXX",
        "X     X    XXXXXXXX X  X X XXX  X X XXXXX X     X",
        "X XXX X      XX X  XXXX X XXX XX XXX X XX X XXX X",
        "X XXX X  X XXX XXXX   XX X XXX XX XXXX X  X XXX X",
        "X XXX X   XXX  X   XXXXXXXX XXXXXX X      X XXX X",
        "X     X X X XX  XX  XXX   XXX XX XXX XX   X     X",
        "XXXXXXX X X X X X X X X X X X X X X X X X XXXXXXX",
        "          X X XX  X   X   XX    XX X  X X        ",
        "X  X XX X X    X X  X XXXXXX X XXXX  X   X X     ",
        "   XXX X XX XX  XXX X    XXX XX  XXXX XXXXX X  XX",
        "X XXXXXXX XXXX XXX X XX XXX  XXX X X XXX    XXX  ",
        " XXXXX XXXXX   X  XXXXX X XXXX X XXX      XXX XX ",
        "X    XXX   X   X X  XXXX XXX  XXX XXX X          ",
        " X   X X X  XX  X  XX  X  XXX XX   X XXX  XXX   X",
        "    XXXXXX  X XXXX  X  XX  X X X   X  XXXX   X X ",
        "X    X    XXXXXX XX X XX  XX XXXX  X XX  XX X X X",
        "X XX XX XX XX     X      X XX XX     XX XX X  XXX",
        "X   XX    X XXX X XX  X    XXXXXX XX     XX X   X",
        "XXX X XXXXX X X XX   XX    X       XX   X XXX    ",
        "   XXX  XXX      XXX  XX XXX XXXXX  XX XXX XXX  X",
        "XXXXXXX X  X XX  X  X  X  X   X XXXX XX  XX X   X",
        " X XXX  X  XX  X XX XXXX  XX   X    XXX XXX XXXXX",
        " XX XXXXXXXXXX X  X XXXXXXX X   X XXX X XXXXX X  ",
        "XX XX   X XX X  X  XXXX   XX  XXXXX XX  X   X  X ",
        "XXX X X X XX XXXX   XXX X X   X  XX XX XX X X  XX",
        " XXXX   X X X X   X X X   XXXXX  XX   X X   X XX ",
        "XX  XXXXX   X  X  XXXXXXXXX  X XX  X X  XXXXXXX  ",
        "X  X X   X    XX  XXX  XXX X   XXXXX XXX X  XXX X",
        "  XX  X     X   XX  XX  XXX XXX X     XXXXXX  XXX",
        "  X XX X XXX X XXX XX  XX XX  XXXXX  X XXXX     X",
        "X XXX X X XXX XXXX XX X    X    XX X XX X    X X ",
        "  XX X XXXX X    XX  XX X  XX   X XXXX XX  XXX X ",
        "  XXX X XXX X   XX XX XXX   X  XX X   XX  X XXX  ",
        "XX X X    X  X   X XXXXXXX  XXXX XXX XXXX X X X X",
        "    X X X   X  XXXX     XX  XXX  XX   X X   XX   ",
        "    X  X    X X   X X X XXXXX  X XX XXX XX X  X  ",
        " X  X X X  XX XX   X  X    X XXX X X XX X  X     ",
        " XX       X XXXX    XX  X  X  XXX X XXXXX X XX X ",
        " X   XXX XXXX X  XX  XX   X  X XX  X  XX X X X X ",
        " XXX   X XX    X     X XXXX X X X XXXX   X X  X  ",
        "XXX   X X   XX X X XXXXXXXX XX X XXXXXXXXXXXX XXX",
        "        X XX XX   X   X   XX XX   X   X X   X XXX",
        "XXXXXXX  X XX XXXXXX XX X XXX  X   XX   X X X  XX",
        "X     X XX     X   XX X   X    XX   XX XX   XX X ",
        "X XXX X  X   XXXXX    XXXXX  XXX  XX  XXXXXXXX   ",
        "X XXX X XX XX XX X  X  XXX  XXX  XX XXXXXX   XXX ",
        "X XXX X  X  X  X   X X X  XXXXXX  XX XXXXXXX X   ",
        "X     X   X XX    X  X  XXXXXX  X XXXX   XX XXX  ",
        "XXXXXXX X X   X  X   X XXXX  XX  XX  X  X  XXX XX"
    };

    private static final String TEXT_14 = "維基百科（Wikipedia，聆聽i/ˌwɪkᵻˈpiːdi.ə/）是一個自由內容、公開編輯且多語言的網路百科全書協作計畫";

    @Test
    void testCode14() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_14);
        QrCode qrCode = QrCode.encodeSegments(segments, Ecc.MEDIUM, 1, 40, 7, true);
        assertSame(Ecc.MEDIUM, qrCode.errorCorrectionLevel);
        assertEquals(49, qrCode.size);
        assertEquals(7, qrCode.mask);
        assertArrayEquals(MODULES_14, TestHelper.toStringArray(qrCode));
    }

}
