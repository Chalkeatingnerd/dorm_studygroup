import java.nio.channels.OverlappingFileLockException;

public class IntQueue {
    private int max;
    private int ptr;
    private int[] queue;
    private int front;
    private int rear;

    public class EmptyIntQueueException extends RuntimeException {

    }

    public class OverflowIntQueueException extends RuntimeException {

    }

    public IntQueue(int capacity) {
        ptr  = front = rear = 0;
        max = capacity;

        try{
            queue = new int[max];
        }catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueue(int x) throws OverflowIntQueueException {
        if (ptr >= max)
            throw new OverflowIntQueueException();
        queue[rear++] = x;
        ptr++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public int dequeue() throws EmptyIntQueueException {
        if (ptr < 1)
            throw new EmptyIntQueueException();
        int x = queue[front++];
        ptr--;
        if (front == max)
            front =0;
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (ptr < 1)
            throw new EmptyIntQueueException();
        return queue[front];
    }

    public int indexOf(int x) {
        for (int i=0; i < ptr ; i++) {
            int searchNum = (i + front) % max;
            if (queue[searchNum] == x)
                return searchNum;
        }
        return -1; //search failed
    }

    public void clear() {
        ptr = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <1;
    }

    public boolean isFull() {
        return ptr > max;
    }

    public void dump() {
        if (ptr < 1)
            System.out.println("queue is empty");
        else{
            for (int i = 0; i< ptr; i++)
                System.out.println(queue[(i + front) % max]);
        }
    }

}
