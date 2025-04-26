package genericketypy;

public class Queue <ELEMENT> {
    private ELEMENT[] data;
    private int first;
    private int count;

    public Queue(int capacity) {
        data = (ELEMENT[]) new Object[capacity];
        first = 0;
        count = 0;
    }

    public void add(ELEMENT element) throws FullQueueException {
        if (count == data.length) {
            throw new FullQueueException();
        }
        data[(first + count) % data.length] = element;
        ++ count;
    }

    public ELEMENT remove() throws EmptyQueueException {
        if (count == 0) {
            throw new EmptyQueueException();
        }
        ELEMENT result = data[first];
        first = (first + 1) % data.length;
        -- count;
        return result;
    }
}
