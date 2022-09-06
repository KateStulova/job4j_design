package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(10, 0);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void has4Vertices() {
        Box box = new Box(8, 12);
        assertThat(box.getNumberOfVertices()).isEqualTo(8);
    }

    @Test
    void hasNoVertices() {
        Box box = new Box(0, 12);
        assertThat(box.getNumberOfVertices()).isEqualTo(0);
    }

    @Test
    void doExist() {
        Box box = new Box(8, 12);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void doesntExist() {
        Box box = new Box(16, 0);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void findSquareOfCube() {
        Box box = new Box(8, 12);
        assertThat(box.getArea()).isEqualTo(864);
    }

    @Test
    void findNoSquare() {
        Box box = new Box(2, 1);
        assertThat(box.getArea()).isEqualTo(0);
    }
}