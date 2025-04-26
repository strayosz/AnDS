public class Stack {
    private char value;
    private Stack prev;
    private Stack last;

    public Stack(){}

    public Stack(char value) {
        this.value = value;
        this.last = this;
    }

    public void add(char value) {
        Stack temp = new Stack(value);
        temp.prev = last;
        this.last = temp;
    }

    public Stack take() {
        return last;
    }

    public void delete() {
        last = last.prev;
    }

    public char getValue() {
        return value;
    }
}