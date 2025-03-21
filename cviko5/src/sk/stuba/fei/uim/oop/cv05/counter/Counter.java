package sk.stuba.fei.uim.oop.cv05.counter;

public class Counter {
    private int value;

    public Counter() {
        this.value = 0; // 'this' mozeme vynechat
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value; // musime pouzit 'this', pretoze 'value' je vstupny paramter metody, 'this.value' je atribut objektu
        // prekresli data na grafe
    }

    public void add() {
        ++ this.value;
    }

    public void reduce() { // decrease decrement
        if (this.value > 0) {
            -- this.value;
        }
    }
}
