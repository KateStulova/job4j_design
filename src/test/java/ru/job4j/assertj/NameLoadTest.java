package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkArrayIsEmpty() {
        NameLoad nL = new NameLoad();
        String[] temp = new String[0];
        assertThatThrownBy(() -> nL.parse(temp))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("array is empty");
    }

    @Test
    void nameWithoutEqualSign() {
        NameLoad nL = new NameLoad();
        assertThatThrownBy(() -> nL.parse("Kate"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("does not contain the symbol");
    }

    @Test
    void nameStartsWithEqualSign() {
        NameLoad nL = new NameLoad();
        assertThatThrownBy(() -> nL.parse("=Kate"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("does not contain a key");
    }

    @Test
    void nameEndsWithEqualSign() {
        NameLoad nL = new NameLoad();
        assertThatThrownBy(() -> nL.parse("Kate="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining("does not contain a value");
    }
}