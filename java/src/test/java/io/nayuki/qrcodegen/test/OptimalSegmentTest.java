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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.nayuki.qrcodegen.QrCode;
import io.nayuki.qrcodegen.QrSegment;
import io.nayuki.qrcodegen.QrSegmentAdvanced;
import io.nayuki.qrcodegen.QrCode.Ecc;

class OptimalSegmentTest {

    private static final String TEXT_1 = "2342342340ABC234234jkl~~";

    private static final String[] MODULES_1 = {
        "XXXXXXX X  X X        XXXXXXX",
        "X     X X  XXXX  XX X X     X",
        "X XXX X X XXXXXX XX   X XXX X",
        "X XXX X  XX  X X X    X XXX X",
        "X XXX X   XXX XXXXX X X XXX X",
        "X     X XX XXX X X X  X     X",
        "XXXXXXX X X X X X X X XXXXXXX",
        "        XX   XXXXXXX         ",
        "  XXX X X X XX X     XXX  XXX",
        "XX X X XXX XX    XX X XX  XXX",
        "  XX XX XXX   XXXX X    X XXX",
        "XX  XX X  XX X   X XXX X XXXX",
        "XXX X XX    XX   XXX XX XX  X",
        "XXX XX X X XX X   XX    X  X ",
        "     XX X  X X  X     X  XXX ",
        "  XXXX XXX X    XXX XX  X XX ",
        "XX XX XX XXXXXXXX  XXX X  XXX",
        "XX   X XX XXXX XXXX  X X X X ",
        "X  X XXXX  XX  XXX  X X X  XX",
        "X  X    X   XX X     X   XXXX",
        "X X XXX X XXXXXXXXX XXXXXX X ",
        "        X  XX  X XXXX   X XX ",
        "XXXXXXX  X   X X  XXX X X  XX",
        "X     X   XX   X XX X   XXXX ",
        "X XXX X X  X X X  X XXXXX XXX",
        "X XXX X XX  XXX  X    X XX X ",
        "X XXX X XXX  XXXXXXX    X XX ",
        "X     X  XX XXXX  X   X  XX  ",
        "XXXXXXX    XX X X XXXXX  X X "
    };

    @Test
    void optimalSegmentCode() {
        List<QrSegment> segments = QrSegmentAdvanced.makeSegmentsOptimally(TEXT_1, Ecc.HIGH, 1, 40);
        QrCode qrCode = QrCode.encodeSegments(segments, Ecc.HIGH);

        assertSame(Ecc.HIGH, qrCode.errorCorrectionLevel);
        assertEquals(29, qrCode.size);
        assertEquals(2, qrCode.mask);
        //TestHelper.printStringArray(TestHelper.toStringArray(qrCode));
        assertArrayEquals(MODULES_1, TestHelper.toStringArray(qrCode));
    }
}
