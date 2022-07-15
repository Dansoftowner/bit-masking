package org.btmn;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RGBA {

    private int color; // 00000000 00000000 00000000 00000000

    public int getComponent(Component c) {
        return (color >> c.pos * 8) & 255;
    }

    public void setComponent(Component c, int value) {
        checkComponentValue(value);
        clearComponent(c);
        color |= (value << c.pos * 8);
    }

    public void clearComponent(Component c) {
        color &= ~(255 << c.pos * 8);
    }

    private void checkComponentValue(int value) {
        if (value < 0 || value > 255)
            throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return Arrays.stream(Component.values()).map(it -> "%s:%d".formatted(it, getComponent(it))).collect(Collectors.joining(", "));
    }

    enum Component {
        RED(3), GREEN(2), BLUE(1), ALPHA(0);

        private final int pos;

        Component(int pos) {
            this.pos = pos;
        }
    }
}
