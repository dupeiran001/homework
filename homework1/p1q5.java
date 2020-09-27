public class p1q5
{
  public static void main(String[] args)
  {
    int[] data_src = {1 , -2 , 3 , 4 , -5 , 6 , 7 , -8};
    element data = new element();
    for(int tmp : data_src)
    {
      data.add(tmp);
    }
    data = data.movMinus(data);
    data.show();
  }
}

class element
{
  public int data;
  public element next;

  public element()
  {
    this.next = null;
  }

  public element(int input)
  {
    this.data = input;
    this.next = null;
  }

  public void add(int input)
  {
    if(this.next != null)
      this.next.add(input);
    else
      this.next = new element(input);
  }

  public void show()
  {
    System.out.println(this.next.data);
    if(this.next.next ==null)
      return;
    else
      this.next.show();
  }
  
  public element getend()
  {
    if(this.next == null)
      return this;
    else 
      return this.next.getend();
  }

  public element movMinus(element input)
  {
    element pos = new element();
    element neg = new element();
    element count = input.next;
    while(true)
    {
      if(count == null)
      {
        neg.getend().next = pos.next;
        return neg;
      }
      else 
      {
        if(count.data >= 0)
          pos.add(count.data);
        else
          neg.add(count.data);
        count = count.next;
      }
    }
  }

}
