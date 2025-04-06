public class Rozhrania1aDefaultMetody {
    public static void main(String[] args) {
        Box box = new Box();
        box.add(100);
        box.add(200);
        Insertable iBox = new Box();
        iBox.add(300);
        // iBox.remove(); // neda sa zavolat, pretoze v 'Insertable' nie je 'remove()'

        Backpack backpack = new Backpack();
        backpack.add(4);

        System.out.println("---- pole ----");
        Insertable[] array = {box, backpack};
        array[0].add(1);
        array[1].add(2);

        System.out.println("---- default metoda ----");
        box.addAll(10, 20, 30);
        backpack.addAll(11, 22);
    }
}

interface Insertable {
    /* abstract */ void add(int value);

    default void  addAll(int ... values) {
        for (int v: values) {
            add(v);
        }
    }
}

class Box implements Insertable {
    @Override
    public void add(int value) {
        System.out.println("krabica: pridavam " + value);
    }

    public void remove() {
        System.out.println("krabica: vyberam");
    }
}

class Backpack implements Insertable {
    @Override
    public void add(int value) {
        System.out.println("ruksak: pridavam " + value);
    }
}
