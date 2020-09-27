public class p1q8
{
  public static void main(String[] args)
  {
    int[] data_src1 = { 2 , 5 , 6 , 7 , 9};
    int[] data_src2 = {4 , 6 , 8 , 9 };
    dnode data1 = new dnode();
    dnode data2 = new dnode();
    for(int tmp : data_src1)
    {
      data1.add(tmp , data1);
    }
    for(int tmp : data_src2)
    {
      data2.add(tmp , data2);
    }
    data1.show();
    System.out.println();
    data2.show();
    System.out.println();

    int result = data1.findsmall(data1 , data2 , 3);
    System.out.println(result);
  }
}

class dnode
{
  public int data;
  public dnode last;
  public dnode next;
  
  public dnode()
  {
    this.next = null;
    this.last = null;
  }

  public dnode(int input , dnode ptr)
  {
    this.data = input;
    this.next = null;
    this.last = ptr;
  }

  public void add(int input , dnode ptr)
  {
    if(this.next != null)
      this.next.add(input , this);
    else
      this.next = new dnode(input , this);
  }

  public void show()
  {
    System.out.println(this.next.data);
    if(this.next.next != null)
      this.next.show();
    else
      return;
  }

  public int findsmall(dnode first , dnode second , int count)
  {
    dnode count1 = first.next;
    dnode count2 = second.next;
    int num =0;
    int result = 0;
    for( ; num != count && count1!=null && count2!=null ; num++)
    {
      if(count1.data == count2.data)
      {
        result  = count1.data;
        count1 = count1.next;
        count2 = count2.next;
      }
      else if(count1.data > count2.data)
      {
        result = count2.data;
        count2 = count2.next;
      }
      else
      {
        result = count1.data;
        count1 = count1.next;
      }
    }
    if(num == count)
      return result; 
    else if(count1 == null)
    {
      for( count2 = count2.next; num!=count && count2!=null ; num++ )
      {
        result = count2.data;
        count2 = count2.next;
      }
    }
    else
    {
      for(count1 = count1.next ; num!=count && count1 != null ; num++)
      {
        result = count2.data;
        count1 = count1.next;
      }
    }
    return result;
  }

}
