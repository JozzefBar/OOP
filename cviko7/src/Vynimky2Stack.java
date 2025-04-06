public class Vynimky2Stack {
    public static void main(String[] args) {
        try {
            Stack stack = new Stack(3);
//            Stack stack2 = new Stack(-1);
            stack.push('a');
            stack.push('b');
            stack.push('c');
//            stack.push('d');
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        }
//        catch (StackCapacityException exception) {
//            System.err.println(exception);
//        }
//        catch (StackFullException exception) {
//            System.err.println(exception);
//        }
        catch (StackEmptyException exception) {
            System.err.println(exception);
        }
        catch (StackException exception) {
            System.err.println(exception);
        }
    }
}

class Stack {
    private char[] data;
    private int counter;

    public Stack(int capacity) throws StackCapacityException {
        if (capacity < 0) {
            throw new StackCapacityException(capacity);
        }
        data = new char[capacity];
        counter = 0;
    }

    public void push(char value) throws StackFullException {
        if (counter >= data.length) {
            throw new StackFullException(value);
        }
        data[counter] = value;
        ++ counter;
    }

    public char pop() throws StackEmptyException {
        if (counter == 0) {
            throw new StackEmptyException();
        }
        -- counter;
        return data[counter];
    }
}

abstract class StackException extends Exception{
    public StackException(String message) {
        super(message);
    }
}

class StackCapacityException extends StackException {
    public StackCapacityException(int capacity) {
        super("mala kapacita (" + capacity + ")");
    }
}

class StackFullException extends StackException {
    public StackFullException(char value) {
        super("zasobnik je plny (" + value + ")");
    }
}

class StackEmptyException extends StackException {
    public StackEmptyException() {
        super("pokus o vyber z prazdneho zasobnika");
    }
}
