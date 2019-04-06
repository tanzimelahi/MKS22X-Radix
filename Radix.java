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
   //System.out.println("greatest number of digits: "+ count);
    int divisor=10;
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
     System.out.println(storage);// test case
     for(int i=1;i<count;i++){
        MyLinkedList[]bucket2=new MyLinkedList[10];
        for(int l=0;l<10;l++){
          bucket2[l]=new MyLinkedList();
        }
       for(int index=0;index<data.length;index++){
          int info=storage.remove(0);
          int algorithm=info;
          for(int tired=0;tired<count+1;tired++){
            algorithm=algorithm/10;
          }
          algorithm=algorithm%10;
          //System.out.println("count: "+i+" info: "+info+ "here's the digitCurrent: "+ algorithm);
          bucket2[algorithm].add(info);
       }
       storage.clear();
       for(int j=0;j<bucket2.length;j++){
         if(bucket2[j].size()>0){
           storage.extend(bucket2[j]);
         }
      }
    }
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
//  System.out.println(Arrays.toString(data));
  }
}
