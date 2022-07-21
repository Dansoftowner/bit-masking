package org.btmn;

public class Calculator {

    public boolean isEven(int number) {
        return (number & 1) == 0;
    }

    public boolean isPowerOf2(int number) {
        return (number & (number - 1)) == 0;
    }

    public int countIdenticalBits(int numOne, int numTwo) {
        // 1010, 0101
        // 1000, 0101
        int c = 0;
        while (!(numOne == 0 || numTwo == 0)) {
            if (((numOne & 1) == 1) && ((numTwo & 1) == 1))
                c++;
            numOne >>= 1;
            numTwo >>= 1;
        }
        return c;
    }

    public int bitCount(int number) {
        int c = 0;
        while (number > 0) {
            c += (number & 1);
            number >>= 1;
        }
        return c;
    }

}
