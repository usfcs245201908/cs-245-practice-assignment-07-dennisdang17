public class LinkedList<T> implements List<T>
{
    Node<T> head; //instance data head and size
    int size;
    class Node<T> //class Node that we use
    {
        private T data;
        private Node<T> next;
        
        public Node(T item) //constructor for the node.
        {
            data = item;
            next = null;
        }
        public T getData() //returns the data
        {
            return data;
        }
        public void setData(T item) //sets data to item
        {
            data = item;
        }
        public int getSize() //returns size
        {
            return size;
        }
        public Node<T> getNext() //returns the next of the node
        {
            return next;
        }
        public void setNext(Node<T> n) //sets the next of the node
        {
            next = n;
        }
    }
    public LinkedList() //constructor for linked list. setting the head at null and size at 0
    {
        head = null;;
        size = 0;
    }
    public void add(T item) //adds an item at the end of the list
    {
        Node<T> n = new Node<T>(item); //item to add
        if (head == null) //adds item to the head if list is empty
        {
            head = n;
        }
        else
        {
            Node<T> prev = head; //makes prev node
            while(prev.getNext() != null) //traverses the whole list until you reach the end
            {
                prev = prev.getNext();
            }
            prev.setNext(n); //make the next node n
        }
        ++size;
    }
    public void add(int pos, T item) //adds item at a position
    {
        Node<T> n = new Node<T>(item); //node to add
        if (pos == 0) //if pos at head then just set the next to head and then set the node as head
        {
            n.setNext(head);
            head = n;
        }
        else
        {
            Node<T> prev = head; //make prev
            for (int i=0; i < pos-1; i++) //traverse list until you reach the locaiton you wish to insert the item at 
            {
                prev = prev.getNext();
            }
            n.setNext(prev.getNext()); //sets the current nodes next as the prev nodes next so that it takes the spot of the node.
            prev.setNext(n); //sets the prev next to the new node ahead of it
        }
        ++size;
    }
    public T get(int pos) //returns the node
    {
        if (pos == 0) //returns head if at head
        {
            return head.getData();
        }
        else
        {
            Node<T> prev = head; 
            for (int i=0; i < pos-1; i++) //traverse list to find the node before given node
            {
                prev = prev.getNext();
            }
            return prev.getNext().getData(); //return the next item of the node before the given node
        }
    }
    public T remove(int pos) //removes item from linked list and then returns the item
    {
        if (pos == 0) //if at head then return head and set the next item as head
        {
            Node<T> n = head;
            head = head.getNext();
            -- size;
            return n.getData();
        }
        else
        {
            Node<T> prev = head; 
            for (int i=0; i < pos-1; i++) //traverse list to item before wanted item
            {
                prev = prev.getNext();
            }
            Node<T> n = prev.getNext(); //set the next as the next items next
            prev.setNext(n.getNext());
            --size;
            return n.getData(); //return the node
        }

    }
    public int size() //returns size
    {
        return size;
    }
}