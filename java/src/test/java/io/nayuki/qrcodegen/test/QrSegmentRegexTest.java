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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.nayuki.qrcodegen.QrSegment;

class QrSegmentRegexTest {

    @Test
    void isNumeric() {
        assertTrue(QrSegment.NUMERIC_REGEX.matcher("1234").matches());
    }

    @Test
    void emptyIsNumeric() {
        assertTrue(QrSegment.NUMERIC_REGEX.matcher("").matches());
    }

    @Test
    void textIsNotNumeric() {
        assertFalse(QrSegment.NUMERIC_REGEX.matcher("123a").matches());
    }

    @Test
    void whitespaceIsNotNumeric() {
        assertFalse(QrSegment.NUMERIC_REGEX.matcher("123\n345").matches());
    }

    @Test
    void validAlphanumeric() {
        assertTrue(QrSegment.ALPHANUMERIC_REGEX.matcher("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./").matches());
    }

    @Test
    void emptyIsAlphanumeric() {
        assertTrue(QrSegment.ALPHANUMERIC_REGEX.matcher("").matches());
    }

    @Test
    void invalidAlphanumeric() {
        assertFalse(QrSegment.ALPHANUMERIC_REGEX.matcher(",").matches());
        assertFalse(QrSegment.ALPHANUMERIC_REGEX.matcher("^").matches());
        assertFalse(QrSegment.ALPHANUMERIC_REGEX.matcher("(").matches());
        assertFalse(QrSegment.ALPHANUMERIC_REGEX.matcher("a").matches());
    }
}