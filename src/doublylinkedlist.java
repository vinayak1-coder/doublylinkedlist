public class doublylinkedlist {
    class Node{
        int element;
        Node next;
        Node prev;
        public Node(int e,Node n, Node p){
            element = e;
            next = n;
            prev = p;
        }

    }
    private Node head;
    private Node tail;
    private int size;
    public doublylinkedlist(){
        head = null;
        tail = null;
        size  = 0;
    }
    public int lenght(){
        return size;
    }
    public boolean isempty(){
        return size==0;
    }
    // add in last
    public void addlast(int e){
        Node newest = new Node (e,null,null);
        if(isempty()){
            head=newest;
            tail = newest;
        }
        else{
            tail.next=newest;
            newest.prev=tail;
            tail=newest;
        }
        size=size+1;

    }
    // add in first
    public void addfir(int e){
        Node newest = new Node(e,null,null);
        if(isempty()){
            head= newest;
            tail=newest;
        }
        else{
            newest.next=head;
            head.prev=newest;
            head = newest;
        }
        size=size+1;
    }
    //add at any position
    public void addany(int e,int pos){
        if(pos<=0 || pos>=size)
            System.out.println("invalid pos");
        Node newest = new Node(e,null,null);
        Node p=head;
        int i=1;
        while(i<pos-1){
            p=p.next;
            i=i+1;
        }
        newest.next=p.next;
        p.next.prev=newest;
        p.next=newest;
        newest.prev=p;
        size=size+1;

    }
    // remove first
    public int removefir(){
        if(isempty())
            System.out.println("invalid");
        int e = head.element;
        head=head.next;
        size=size-1;
        if(isempty())
            tail=null;
        else
            head.prev=null;
        return e;

    }
    //remove last
    public int removeLast() {
        if(isempty()) {
            System.out.println(" List is Empty");
            return -1;
        }
        int e = tail.element;
        tail = tail.prev;
        tail.next = null;
        size = size - 1;
        return e;
    }
    //remove any
    public int removeAny(int position) {
        if(position <= 0 || position >= size-1) {
            System.out.println("Invalid Position");
            return -1;
        }
        Node p = head;
        int i = 1;
        while(i < position-1) {
            p = p.next;
            i = i + 1;
        }
        int e = p.next.element;
        p.next = p.next.next;
        p.next.prev=p;
        size = size - 1;
        return e;
    }
    // fot display
    public void display(){
        Node p=head;
        while(p!=null){
            System.out.print(p.element+" ");
            p=p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        doublylinkedlist l = new doublylinkedlist();
        l.addlast(3);
        l.addlast(4);
        l.addlast(5);
        l.display();
        System.out.println("size "+l.lenght());
        l.addfir(1);
        l.addfir(2);
        l.display();
        System.out.println("size "+l.lenght());
        l.addany(5,3);
        l.display();
        System.out.println("size"+l.lenght());
    }
}



