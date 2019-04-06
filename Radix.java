import java.util.Arrays;
public class Radix{
  public static void radixSort(int[]data){
    int maxnum=data[0];
    for(int i=0;i<data.length;i++){
      if(data[i]>maxnum){
        maxnum=data[i];
      }
    }
    boolean dumb=true;
    int count=0;
    while(dumb){
      count++;
      if(maxnum/10==0){
        dumb=false;
      }
      else{
        maxnum=maxnum/10;
      }
    }
  // System.out.println("greatest number of digits: "+ count);
     MyLinkedList[]bucket=new MyLinkedList[10];
     MyLinkedList storage=new MyLinkedList();// stores the data temporaritly as an array
     for(int i=0;i<bucket.length;i++){
       bucket[i]=new MyLinkedList();// creats a bucket
     }
     for(int i=0;i<data.length;i++){
       bucket[data[i]%10].add(data[i]);
     }
     for(int i=0;i<bucket.length;i++){
       if(bucket[i].size()!=0){ // fixed the null and made it size zero
         storage.extend(bucket[i]);
       }
     }
     //System.out.println(storage);// test case
     for(int i=1;i<count;i++){
       MyLinkedList[]bucket2=new MyLinkedList[10];
       for(int j=0;j<bucket2.length;j++){
         bucket2[j]=new MyLinkedList();
       }
      // System.out.println(storage);
       for(int index=0;index<data.length;index++){// checked
         int dummyStore=storage.remove(0);
         int place=dummyStore/(int)(Math.pow(10,i))%10;
         bucket2[place].add(dummyStore);
       }
       for(int gona=0;gona<bucket2.length;gona++){
         if(bucket2[gona].size()!=0){
          storage.extend(bucket2[gona]);
        }
      }
     }
// last part of the code when the linked list is put into the array;
    for(int num=0;num<data.length;num++){
      data[num]=storage.remove(0);
    }
  }
  public static void main(String[]args){
    int[]data={84,32,1,0,55,56,23,11,113,22222};
    MyLinkedList inf=new MyLinkedList();
    MyLinkedList inf2=new MyLinkedList();
  //  inf.add(2);
  radixSort(data);
  System.out.println(Arrays.toString(data));
  }
}
