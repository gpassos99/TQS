import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ITqsStack<T> {

    private int limit = -1;

    private ArrayList<T> stack;

    public ITqsStack() {
        this.stack = new ArrayList<>();
    }

    public ITqsStack(int limit) {
        this.limit = limit;
        this.stack = new ArrayList<>();
    }

    public boolean IsEmpty() {
        return this.stack.size() == 0;
    }

    public int size() {
        return this.stack.size();
    }

    public void push(T value) {
        if(this.limit > 0){
            if (this.stack.size() < limit)
                this.stack.add(value);
            else
                throw new IllegalStateException();
        }
        else {
            this.stack.add(value);
        }

    }

    public T pop() {
        if(this.stack.size() == 0) {
            throw new NoSuchElementException();
        }
        else {
            return this.stack.remove(this.stack.size()-1);
        }
    }

    public T peek() {
        if(this.stack.size() == 0) {
            throw new NoSuchElementException();
        }
        else {
            return this.stack.get(this.stack.size()-1);
        }
    }
}