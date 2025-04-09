package genericketypy;

public class Queue <ELEMENT>{
    private ELEMENT[] data;
    private int first;
    private int count;

    public Queue(int capacity){
        data = (ELEMENT[]) new Object[capacity];
        first = 0;
        count = 0;
    }

    public void add(ELEMENT element){
        if(count == data.length) {
            throw new FullQueueException();
        }
    }
}
