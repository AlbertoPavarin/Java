public class List<E>{
    public ListNode<E> head;
    public ListNode<E> tail;
    public List()
    {
        this.head = new ListNode<E>(null, null, null);
        this.tail = new ListNode<E>(null, null, head);
        this.head.setNext(tail);
    }

    public void addFirst(E el)
    {
        this.head.setElement(el);
        ListNode<E> newHead = new ListNode<E>(null, this.head, null); 
        this.head.setPrevious(newHead);
        // this.tail.setPrevious(this.head);
        System.out.println(this.tail.getPrevious().getElement());
        this.head = newHead;
    }   

    public void addLast(E el)
    {
        this.tail.setElement(el);
        ListNode<E> newTail = new ListNode<E>(null, null , this.tail);
        this.tail.setNext(newTail);
        this.tail = newTail;
    } 

    public E removeFirst()
    {
        ListNode<E> firstNode = this.getFirst();
        
        this.head = firstNode;
        this.head.setPrevious(null);
        this.head.setElement(null);
        return firstNode.getElement();
    }

    public E removeLast()
    {
        ListNode<E> lastNode = this.tail.getPrevious();
        this.tail = lastNode;
        this.tail.setElement(null);
        this.tail.setNext(null);
        return lastNode.getElement();
    }

    public ListNode<E> getFirst()
    {
        return this.head.getNext();
    }

    public ListNode<E> getLast()
    {
        return this.tail.getPrevious();
    }

    public String toString()
    {
        String str = "[ ";
        
        ListNode<E> tmpNode = this.head;
        
        while ((tmpNode = tmpNode.getNext()) != this.tail)
        {
            str += "" + tmpNode.getElement() + " ";
        }

        return str + "]";
    }

    public class ListNode<E>{
        public E element;
        public ListNode<E> next;
        public ListNode<E> previous;

        public ListNode(E el, ListNode<E> next, ListNode<E> previous)
        {
            this.element = el;
            this.next = next;
        }

        public E getElement()
        {
            return this.element;
        }

        public ListNode<E> getNext()
        {
            return this.next;
        }

        public ListNode<E> getPrevious()
        {
            return this.previous;
        }

        public void setElement(E element)
        {
            this.element = element;
        }

        public void setNext(ListNode<E> next)
        {
            this.next = next;
        }

        public void setPrevious(ListNode<E> prev)
        {
            this.previous = prev;
        }
    }
}