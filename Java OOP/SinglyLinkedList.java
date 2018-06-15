public class SinglyLinkedList{
  private Node head;

  public SinglyLinkedList(){
    this.head = null;
  }

  public void add(int value){
    if(this.head == null){
      this.head = new Node(value);
    } else {
      Node runner = this.head;
      while(runner.next != null){
        runner = runner.next;
      }
      if(runner.next == null){
        runner.next = new Node(value);
      } 
    }
  }
    
  public void remove(){
    if(this.head == null){
      System.out.println("This SLL is empty.");
    } 
    Node runner = this.head;
    while(runner.next.next != null){
      runner = runner.next;
    }
    runner.next = null;
  }

  public void printValues(){
    // if(this.head == null){
    //   System.out.println("This SLL is empty.");
    // }
    Node runner = this.head;
    while(runner != null){
      System.out.println(runner.value);
      runner = runner.next;
    }
    
  }
  
} 