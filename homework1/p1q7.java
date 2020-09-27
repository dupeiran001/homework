public class p1q7
{
  public static void main(String[] args)
  {
    int[] data_src1 = { 1 , 4 , 7 , 9};
    int[] data_src2 = { 1 , 3 , 5 , 6 , 7};
    node7 data1 = new node7();
    node7 data2 = new node7();
    for(int tmp : data_src1)
      data1.add(tmp);
    for(int tmp : data_src2)
      data2.add(tmp);
    
    data1.show();
    System.out.println();
    data2.show();
    System.out.println();

    data1 = data1.reverseAnd(data1 , data2);
    data1.show();
  }
}

class node7
{
  public int data;
  public node7 next;

  public node7()
  {
    this.next = null;
  }

  public node7(int input)
  {
    this.data = input;
    this.next = null;
  }

  public void add(int input)
  {
    if(this.next == null)
      this.next = new node7(input);
    else
      this.next.add(input);
  }

  public void addhead(int input , node7 head)
  {
    node7 tmp = new node7(input);
    tmp.next = head.next;
    head.next = tmp;
    return;
  }

  public void show()
  {
    System.out.println(this.next.data);
    if(this.next.next == null)
      return;
    else
      this.next.show();
  }

  public node7 reverseAnd(node7 first , node7 second )
  {
    node7 count1 = first.next;
    node7 count2 = second.next;
    node7 result = new node7();
    for( ; count1!=null && count2 !=null;)
    {
      if(count1.data == count2.data)
      {
        result.addhead(count1.data , result);
        count1 = count1.next;
        count2 = count2.next;
      }
      else if(count1.data < count2.data)
      {
        result.addhead(count1.data , result);
        count1 = count1.next;
      }
      else
      {
        result.addhead(count2.data , result);
        count2 = count2.next;
      }
    }
    if(count1 == null && count2 == null)
    {
      return result;
    }
    else if(count1 == null)
    {
      while(count2!=null)
      {
        result.addhead(count2.data , result);
        count2 = count2.next;
        return result;
      }
    }
    else
    {
      while(count1!=null)
      {
        result.addhead(count1.data , result);
        count1 = count1.next;
        return result;
      }
    }
    return result;
  }

}
