public class ArrayList<T> implements List<T>
{
    protected T[] a;
    protected int size;

    public ArrayList() //makes new array list and sets size at 0
    {
        a = (T[]) new Object[10];
        size = 0;
    }
    public void add(T item) //adds item to end of arraylist
    {
        if(size == a.length) //if size is full grow array
        {
            grow_array();
        }
        a[size++] = item;
    }
    public void add(int pos, T item) //adds item at given position
    {
        if(size == a.length) //if the size is full then grow the array
        {
            grow_array();
        }
        for(int i = size - 1; i > pos; i--) // shifts the items of the array to the right to make space for new item
        {
            a[i+1] = a[i];
        }
        a[pos] = item;
        size++;
    }
    public T get(int pos) // returns item at index
    {
        return a[pos];
    }
    public T remove(int pos) //returns item after removing it from arraylist
    {

        T temp = a[pos]; // item we want to delete
        for(int i = pos; i < size-1; i++)//shifts all items left after deleting array
        {
            a[i] = a[i+1];
        }
        --size;
        return temp;
    }
    public int size() //returns size
    {
        return size;
    }
    private void grow_array() //doubles size of array
    {
        T[] newA = (T[]) new Object[a.length*2];
        System.arraycopy(a, 0, newA, 0, a.length);
        a = newA;
    }
}