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
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.nayuki.qrcodegen.BitBuffer;
import io.nayuki.qrcodegen.QrSegment;

class QrSegmentEncodingTest {

    private static final String TEXT_NUMERIC = "83930";

    private static final int BIT_LENGTH_NUMERIC = 17;

    private static final byte[] BITS_NUMERIC = { (byte) 139, (byte) 243, 0 };

    private static final String TEXT_ALPHANUMERIC = "$%*+-./ 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int BIT_LENGTH_ALPHANUMERIC = 242;

    private static final byte[] BITS_ALPHANUMERIC = {
        43, 63,(byte)240, (byte)245, (byte)223, 12, 64, (byte)232,
        (byte)162, (byte)147, (byte)168, 116,(byte)228, (byte)172,  40, 21,
        (byte)170, 67, (byte)243, 58, (byte)211, (byte)175, 81, 76,
        109, 33, 107, (byte)218, (byte)193, (byte)225, 2
    };

    private static final String TEXT_UTF8 = "😐ö€";

    private static final int BIT_LENGTH_UTF8 = 72;

    private static final byte[] BITS_UTF8 = { 15, (byte)249, 25, 9, (byte)195, 109, 71, 65, 53 };

    @Test
    void numericEncoding() {
        QrSegment segment = QrSegment.makeNumeric(TEXT_NUMERIC);
        assertSame(segment.mode, QrSegment.Mode.NUMERIC);
        assertEquals(TEXT_NUMERIC.length(), segment.numChars);

        BitBuffer data = segment.getData();
        assertEquals(BIT_LENGTH_NUMERIC, data.bitLength());

        assertArrayEquals(BITS_NUMERIC, TestHelper.toByteArray(data));
    }

    @Test
    void rejectNonNumeric() {
        assertThrows(IllegalArgumentException.class, () -> QrSegment.makeNumeric("abc"));
    }

    @Test
    void alphanumericEncoding() {
        QrSegment segment = QrSegment.makeAlphanumeric(TEXT_ALPHANUMERIC);
        assertSame(segment.mode, QrSegment.Mode.ALPHANUMERIC);
        assertEquals(TEXT_ALPHANUMERIC.length(), segment.numChars);

        BitBuffer data = segment.getData();
        assertEquals(BIT_LENGTH_ALPHANUMERIC, data.bitLength());

        assertArrayEquals(BITS_ALPHANUMERIC, TestHelper.toByteArray(data));
    }

    @Test
    void rejectNonAlphanumeric() {
        assertThrows(IllegalArgumentException.class, () -> QrSegment.makeAlphanumeric("abc,def"));
    }

    @Test
    void autoNumericEncoding() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_NUMERIC);
        assertEquals(1, segments.size());
        QrSegment segment = segments.get(0);
        assertSame(segment.mode, QrSegment.Mode.NUMERIC);
        assertEquals(TEXT_NUMERIC.length(), segment.numChars);

        BitBuffer data = segment.getData();
        assertEquals(BIT_LENGTH_NUMERIC, data.bitLength());

        assertArrayEquals(BITS_NUMERIC, TestHelper.toByteArray(data));
    }

    @Test
    void autoAlphanumericEncoding() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_ALPHANUMERIC);
        assertEquals(1, segments.size());
        QrSegment segment = segments.get(0);
        assertSame(segment.mode, QrSegment.Mode.ALPHANUMERIC);
        assertEquals(TEXT_ALPHANUMERIC.length(), segment.numChars);

        BitBuffer data = segment.getData();
        assertEquals(BIT_LENGTH_ALPHANUMERIC, data.bitLength());

        assertArrayEquals(BITS_ALPHANUMERIC, TestHelper.toByteArray(data));
    }

    @Test
    void utf8Encoding() {
        List<QrSegment> segments = QrSegment.makeSegments(TEXT_UTF8);
        assertEquals(1, segments.size());
        QrSegment segment = segments.get(0);
        assertSame(segment.mode, QrSegment.Mode.BYTE);
        assertEquals(TEXT_UTF8.getBytes(StandardCharsets.UTF_8).length, segment.numChars);

        BitBuffer data = segment.getData();
        assertEquals(BIT_LENGTH_UTF8, data.bitLength());

        assertArrayEquals(BITS_UTF8, TestHelper.toByteArray(data));
    }

    @Test
    void emptyTest() {
        List<QrSegment> segments = QrSegment.makeSegments("");
        assertEquals(0, segments.size());
    }
}
