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

import java.io.PrintStream;

import io.nayuki.qrcodegen.BitBuffer;
import io.nayuki.qrcodegen.QrCode;

public class TestHelper {

    public static byte[] toByteArray(BitBuffer buffer) {
        int len = buffer.bitLength();
        byte[] result = new byte[(len + 7) / 8];

        byte mask = 1;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (buffer.getBit(i) != 0)
                result[index] |= mask;
            mask <<= 1;
            if (mask == 0) {
                mask = 1;
                index++;
            }
        }

        return result;
    }

    public static void printByteArray(byte[] array) {
        PrintStream s = System.out;

        s.println("byte[] array = {");
        
        int len = array.length;
        for (int i = 0; i < len; i += 8) {

            s.print("    ");
            for (int j = i; j < Math.min(i + 8, len); j++) {
                s.print("0x");
                s.print(Integer.toHexString(array[j] & 0xff));
                if (j != len - 1)
                    s.print(", ");
            }
            s.println();
        }

        s.println("};");
    }

    public static String[] toStringArray(QrCode qrCode) {
        int size = qrCode.size;
        String[] result = new String[size];

        for (int y = 0; y < size; y++) {
            char[] row = new char[size];
            for (int x = 0; x < size; x++)
                row[x] = qrCode.getModule(x, y) ? 'X' : ' ';
            result[y] = new String(row);
        }

        return result;
    }

}