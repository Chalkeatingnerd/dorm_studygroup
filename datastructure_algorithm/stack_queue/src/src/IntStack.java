public class IntStack {
    private int max;
    private int ptr; //the number of data
    private int[] stk;

    //when stack is empty
    public class EmptyIntStackException extends RuntimeException {

    }

    //when stack is full
    public class OverflowStackException extends RuntimeException {

    }

    public IntStack (int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        }catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int x) throws OverflowStackException {
        if (ptr >= max)
            throw new OverflowStackException();
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <1 )
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    public int peek() throws EmptyIntStackException {
        if (ptr <1)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    public int indexOf(int x) {
        for (int i = 0 ; i < ptr - 1; i++)
            if (stk[i] ==x )
                return i;
            return -1;
    }

    public void clear() {
        ptr =0;
    }
    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr < 1;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    //print out every data of the stack
    public void dump() {
        if (ptr < 1)
            System.out.println("Stack is empty");
        else {
            for (int i=0; i<ptr; i++) {
                System.out.println(stk[i]);
            }
        }
    }
}
