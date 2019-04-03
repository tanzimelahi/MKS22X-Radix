public class Node{
  private Integer data;
  private Node next,prev;

    public Node(Integer data,Node next,Node prev){
      this.data=data;
      this.next=next;
      this.prev=prev;

    }

  public Node next() {
    return next;
  }
  public Node prev(){
    return  prev;
  }
  public void setNext(Node other){
    next=other;
  }
  public void setPrev(Node other){
    prev=other;
  }
  public Integer getData(){
    return this.data;
  }
  public Integer setData(Integer i){
   Integer result=data;
    this.data=i;
    return result;
  }
  public String toString(){
    return ""+data;
  }

 }
