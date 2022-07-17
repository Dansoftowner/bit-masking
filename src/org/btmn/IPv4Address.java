package org.btmn;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IPv4Address {

    private int ip; // 00000000 00000000 00000000 00000000

    public void setOctet(int n, int value) {
        checkN(n);
        checkValue(value);

        int newIp = ip & (~(255 << (3 - n) * 8)); // clear octet
        newIp |= value << (3 - n) * 8;

        ip = newIp;
    }

    public int getOctet(int n) {
        checkN(n);
        return (ip >> (3 - n) * 8) & 255;
    }

    @Override
    public String toString() {
        return IntStream.range(0, 4).map(this::getOctet).mapToObj(String::valueOf).collect(Collectors.joining("."));
    }

    private void checkN(int n) {
        if (n < 0 || n > 3)
            throw new IllegalArgumentException();
    }

    private void checkValue(int value) {
        if (value < 0 || value > 255)
            throw new IllegalArgumentException();
    }
}
