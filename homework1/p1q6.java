public class p1q6
{
  public static void main(String[] args)
  {
    int[] data_src = {-2 , 3 , 4 , -5 , 6 };
    int[] data_src2 = {-2 , 6 , -8};
    node6 data = new node6();
    node6 minus = new node6();
    for(int tmp : data_src)
    {
      data.add(tmp);
    }
    for(int tmp : data_src2)
    {
      minus.add(tmp);
    }
    data.show();
    System.out.println();
    minus.show();
    System.out.println();
    data = data.minus(data , minus);
    data.show();
  }
}

class node6 
{
  public int data;
  public node6 next;

  public node6()
  {
    this.next = null;
  }

  public node6(int input)
  {
    this.data = input;
    this.next = null;
  }

  public void add(int input)
  {
    if(this.next != null)
      this.next.add(input);
    else
      this.next = new node6(input);
  }

  public void show()
  {
    System.out.println(this.next.data);
    if(this.next.next ==null)
      return;
    else
      this.next.show();
  }

  public node6 minus(node6 first , node6 second)
  {
    node6 result = new node6();
    node6 count1 ;
    node6 count2 ;
    boolean isappear = false;
    for(count1 = first.next ; count1.next != null ; count1 = count1.next)
    {
      for(count2 = second.next ; count2.next != null ; count2 = count2.next)
      {
        if(count1.next.data == count2.next.data)
          isappear = true;
      }
      if(!isappear)
        result.add(count1.next.data);
      isappear = false;
    }
    return result;
  }

}
