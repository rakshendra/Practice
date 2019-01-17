package src.questions;

public class LinkedList {
    public static class Node {
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            next = null;
        }
    }


    private Node head;

    public LinkedList(){
        head = null;
    }

    public Node nthNodeFromLast(int n){
        int l = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            l++;
        }
        if(n > l){
            return null;
        }
        n = l-n;
        temp = head;
        while(n > 0){
            temp = temp.next;
            n--;
        }
        return temp;
    }

    public Node nthNodeFromLastWOLength(int n){
        Node first = head;
        Node second = head;
        int count=0;
        while(count < n && first != null){
            first = first.next;
            count++;
        }
        if(first==null){
            if(count==n){
                return head;
            }
            return null;
        }
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(4);
        ll.head.next.next.next.next = new Node(5);
        ll.head.next.next.next.next.next = new Node(6);

        Node nth = ll.nthNodeFromLastWOLength(7);
        if(nth != null){
            System.out.println(nth.val);
        }else{
            System.out.println("Node doesn't exist");
        }

    }
}
