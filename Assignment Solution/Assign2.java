public class Assign2 {
    public static void main(String[] args) {
        DynArray arr = new DynArray();
        try {
            arr.append(10);
            arr.append(20);
        } catch (ArrayException e) {

            e.printStackTrace();
        }
    }
}

class ArrayException extends Exception {
    public static final String ARRAY_OVERFLOW = "Array Overflow";
    public static final String INVALID_INDEX = "Invalid Index";
    public static final String ARRAY_UNDERFLOW = "Empty Array";

    public ArrayException(String msg) {
        super(msg);
    }
}

class DynArray {
    private int lastIndex;
    private int[] ptr;

    public DynArray() {
        ptr = new int[1];
        lastIndex = -1;
    }

    public DynArray(int size) {
        ptr = new int[size];
        lastIndex = -1;
    }

    public void doubleArray() {
        int[] temp = new int[ptr.length * 2];
        for (int i = 0; i <= lastIndex; i++) {
            temp[i] = ptr[i];
        }
        ptr = temp;
    }

    public void halfArray() {
        int[] temp = new int[ptr.length / 2];
        for (int i = 0; i <= lastIndex; i++) {
            temp[i] = ptr[i];
        }
        ptr = temp;
    }

    public void append(int data) throws ArrayException {
        if (isFull())
            doubleArray();
        lastIndex += 1;
        ptr[lastIndex] = data;
    }

    public void insert(int index, int data) throws ArrayException {
        if (index < 0 || index > lastIndex + 1)
            throw new ArrayException(ArrayException.INVALID_INDEX);
        if (isFull())
            doubleArray();
        for (int i = lastIndex; i >= index; i--) {
            ptr[i + 1] = ptr[i];
        }
        ptr[index] = data;
        lastIndex++;
    }

    public void edit(int index, int newData) throws ArrayException {
        if (index < 0 || index > lastIndex)
            throw new ArrayException(ArrayException.INVALID_INDEX);
        ptr[index] = newData;
    }

    public void delete(int index) throws ArrayException {
        if (isEmpty())
            throw new ArrayException(ArrayException.ARRAY_UNDERFLOW);
        if (index < 0 || index > lastIndex)
            throw new ArrayException(ArrayException.INVALID_INDEX);
        for (int i = index; i < lastIndex; i++) {
            ptr[i] = ptr[i + 1];
        }
        lastIndex--;
        if (ptr.length > 1 && (ptr.length / 2 == lastIndex + 1))
            halfArray();
    }

    public int countElements() {
        return lastIndex + 1;
    }

    public boolean isEmpty() {
        return lastIndex == -1;
    }

    public boolean isFull() {
        return lastIndex + 1 == ptr.length;
    }

    public int getAt(int index) throws ArrayException {
        if (isEmpty())
            throw new ArrayException(ArrayException.ARRAY_UNDERFLOW);
        if (index < 0 || index > lastIndex)
            throw new ArrayException(ArrayException.INVALID_INDEX);
        return ptr[index];
    }

    public int getCapacity() {
        return ptr.length;
    }
}