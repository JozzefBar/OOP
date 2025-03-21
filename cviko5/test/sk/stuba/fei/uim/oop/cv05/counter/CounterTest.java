package sk.stuba.fei.uim.oop.cv05.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    private Counter counter;

    @BeforeEach
    void createCounter() {
        counter = new Counter();
        System.out.println("createCounter");
    }

    @Test
    void initValue() {
        // Counter counter = new Counter();
        Assertions.assertEquals(0, counter.getValue());
    }

    @Test
    void add() {
        // Counter counter = new Counter();
        counter.add();
        counter.add();
        counter.add();
        assertEquals(3, counter.getValue());
    }

    @Test
    void reduceOne() {
        // Counter counter = new Counter();
        counter.add();
        counter.add();
        counter.add();
        counter.reduce();
        assertEquals(2, counter.getValue());
    }

    @Test
    void reduceBelowZero() {
       //  Counter counter = new Counter();
        counter.reduce();
        assertEquals(0, counter.getValue());
    }
}
