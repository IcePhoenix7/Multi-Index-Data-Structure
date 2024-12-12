//**************************  SLL.java  *********************************
//           a generic singly linked list class 

import java.util.NoSuchElementException;

public class SLL<T> {

    private class SLLNode<T> {
        private T info;
        private SLLNode<T> next;
        public SLLNode() {
            this(null,null);
        }
        public SLLNode(T el) {
            this(el,null);
        }
        public SLLNode(T el, SLLNode<T> ptr) {
            info = el; next = ptr;
        }
    }

    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
            head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
            head = tail = null;
        else {                  // if more than one node in the list,
            SLLNode<T> tmp;    // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp;        // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                     tmp != null && !tmp.info.equals(el);
                     pred = pred.next, tmp = tmp.next);
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                }
            }
    }

    @Override
    public String toString() {
        if(head == null)
            return "[ ]";
        String str = "[ ";
        SLLNode<T> tmp = head;
        while(tmp != null){
            str += tmp.info + " ";
            tmp = tmp.next;
        }
        return str+"]";
    }

    public boolean contains(T el) {
        if(head == null)// you do not need this my friend \Todo
            return false;
        SLLNode<T> tmp = head;
        while(tmp != null){
            if(tmp.info.equals(el))
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public int size(){
        if(head == null)
            return 0;

        int count = 0;
        SLLNode<T> p = head;
        while(p != null) {
            count++;
            p = p.next;
        }

        return count;
    }

    //  Please write the methods of Task02 here:

    public void insertBefore(int index, T newElem){
        SLLNode<T> newNode = new SLLNode<>(newElem);
        if(isEmpty()){
            throw new IllegalArgumentException("the list is empty");
        }else if(index>=size()) {
            throw new IndexOutOfBoundsException("this index deos not exist");
        }else if (index==0){
            newNode.next = head;
            head = newNode;
        }else {
            SLLNode<T> prePtr = head;//this is the pointer pointing on the node of index 0; before 1
            for(int i=1;i<index;i++) {//first we need to go to the node just before the one of index
                prePtr = prePtr.next;
            }
            newNode.next = prePtr.next;
            prePtr.next = newNode;

        }
    }
    public T delete(int index){

        if(isEmpty()){
            throw new IllegalArgumentException("the list is empty");
        }else if(index>=size()) {
            throw new IndexOutOfBoundsException("this index deos not exist");
        } else {
            SLLNode<T> ptr = new SLLNode<T>();
            ptr = head;

            if (index == 0) {
                T result = head.info;
                ptr = ptr.next;
                head.next = null;
                head = ptr;
                return result;
            }else{
                SLLNode<T> prePtr = head;//this is the pointer pointing on the node of index 0; before 1
                for(int i=1;i<index;i++) {//first we need to go to the node just before the one of index
                    prePtr = prePtr.next;
                }
                T reslut = prePtr.next.info;
                prePtr.next = prePtr.next.next;//if the index was the last it does not matter because it next is null anyways
                return reslut;
            }

        }

    }
    public void insertAfterSecondOccurrence(T e1, T e2) {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty.");
        }

        SLLNode<T> ptr = head;
        int occurs = 0;

        // Traverse the list to find the second occurrence of e2
        while (ptr != null) {
            if (ptr.info.equals(e2)) {
                occurs++;
            }
            if (occurs == 2) {
                // Insert the new element after the second occurrence
                SLLNode<T> newNode = new SLLNode<>(e1, ptr.next);
                ptr.next = newNode;
                return;
            }
            ptr = ptr.next;
        }

        // If we finish the traversal and haven't found the second occurrence
        throw new NoSuchElementException("There is no second occurrence of " + e2);
    }

}
















