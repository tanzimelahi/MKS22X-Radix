public class MyLinkedList{
    private Node start;
    private Node end;
    private int length;
    public MyLinkedList(){
      length=0;
      start=new Node(null,null,null);
      end=new Node(null,null,null);
    }
    public void clear(){
      length=0;
      start=new Node(null,null,null);
      end=new Node(null,null,null);
    }

  private Node getn(int n){   //remember to turn this private
	  if(n==0) {
		  return start;
	  }
	  if(n<0 || n>length) {
		  throw new IndexOutOfBoundsException("index is out ofbounds");
	  }
	  Node current=this.start;
	  for(int i=0;i<length;i++) {
		  if(i==n) {
			  return current;
		  }
		  else {
			  current=current.next();
		  }

	  }
	  return end;
  }
  public boolean addFront(Integer i){
    if(length==0){
      start=new Node(i,null,null);
      end=start;
      length++;
      return true;
    }
    else{
      Node node=new Node(i,start,null);
      this.start=node;
      length++;
      return true;
    }
  }
  public boolean add(Integer i) {// this is what i need to use

	  if(length==0 ) {
		 start=new Node(i,null,null);
		 end=start;// end and start are the same
		  length++;
		  return true;
	  }
	  else {
	  Node node=new Node(i,null,this.end);
	  end.setNext(node); // change
	  end=node;
	  length++;
	  return true;
	  }
  }
  public int size() {
	  return this.length;
  }
  public String toString() {
    if(length==0){
      return "[null]";
    }
	  String result="[";
	  Node current=this.start;
	  for(int i=0;i<this.length-1;i++) {
		  result+=current.toString()+",";
		  //System.out.println(result);
		  current=current.next();
	  }
	  result+=current.toString()+"]";
	  return result;
  }
  public Integer get(int Index) {
	  return this.getn(Index).getData();
  }
  public Integer set(int Index,Integer value) {
	  if(Index<0|| Index>this.length) {
		  throw new IndexOutOfBoundsException();
	  }
	  Integer answer=this.getn(Index).getData();
	  this.getn(Index).setData(value);
	  return answer;

  }
  public boolean contains(Integer value) {
	  Node start=this.start;
	  for(int i=0;i<this.length;i++) {
		  if(start.getData()==value) {
			  return true;
		  }
		  start=start.next();
	  }
	  return false;
  }
  public int indexOf(Integer value) {
	  Node start=this.start;
	  for(int i=0;i<this.length;i++) {
		  if(start.getData().equals(value)) {
			  return i;
		  }
		  start=start.next();
	  }
	  return -1;
  }
  public void add(int index,Integer value) {
	  if(index<0|| index>this.length) {
		  throw new IndexOutOfBoundsException("index out ofbounds,dood");
	  }
	  if(index==0) {
		  Node current=new Node(value,start,null);
		 start.setPrev(current);

		  start=current;
		  //length++;
	  }
	  else if(index==length) {
		  this.add(value);
	  }

	  else {


			  Node next=this.getn(index);
			  Node prev=next.prev();
			  Node current=new Node(value,next,prev);
			  prev.setNext(current);
			  next.setPrev(current);
			  length++;



	  }
  }
  public Integer remove(int index) {// this is what I want to use
	  if(index<0 ||index>=this.length) {
		  throw new IndexOutOfBoundsException();
	  }
    if(index==0 && this.length==1){
      Integer answer=start.getData();
      start=null;
      end=null;
      length--;
      return answer;
    }
	  if(index==0) {
		  Integer answer=start.getData();
		  start=start.next();
		  start.setPrev(null);
		  length--;
		  return answer;
	  }
	  else if(index==length-1) {

		  Integer answer=end.getData();
		  this.end=end.prev();// change this baendck
		  this.end.setNext(null);
		  length--;
		  return answer;
	  }
	  else {
		      Integer answer=this.getn(index).getData();
			  Node prev=this.getn(index-1);
			  Node next=this.getn(index+1);
			  prev.setNext(next);
			  next.setPrev(prev);
			  length--;
			  return answer;

	  }
  }
  public boolean remove(Integer value) {
    System.out.println("wrong");
	  for(int i=0;i<this.length;i++) {
		  if(this.getn(i).getData().equals(value)) {
			  this.remove(i);
			  length--;
			  return true;
		  }
	  }return false;
  }
  public void extend (MyLinkedList other){
    if(this.length==0){
      this.start=other.start;
  	  this.length=this.length+other.length;
  	  this.end=other.end;
    }
    else{
	  other.start.setPrev(this.end);
	  this.end.setNext(other.start);
	  this.length=this.length+other.length;
	  this.end=other.end;
  }
  }
  public static void main(String[]args){
    MyLinkedList[] ary=new MyLinkedList[10];
    ary[0]=new MyLinkedList();
    ary[0].add(2);
    ary[0].addFront(1);


  }
}
