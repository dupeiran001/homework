public class p2q4
{
  public static void main(String[] args)
  {
    query ood  = new query();
    query even = new query();
    int[] a = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8};
    for(int b : a)
      System.out.println(b);
    for(int tmp = 0; tmp != a.length ; tmp++)
    {
      if(a[tmp] % 2 == 0)
        even.push(a[tmp]);
      else
        ood.push(a[tmp]);
    }
    int tmp;
    for(tmp = 0; !even.empty() ; tmp++)
    {
      a[tmp] = even.top();
      even.pop();
    }
    for( ; !ood.empty() ; tmp++)
    {
      a[tmp] = ood.top();
      ood.pop();
    }
    System.out.println();
    for(int b : a)
      System.out.println(b);

  }
}

class query
{
  private class node
  {
    private node next;
    private int data;
  }

  private node head;
  private node tail;

  public query()
  {
    this.head = null;
    this.tail = null;
  }

  public boolean empty()
  {
    return this.head == null ;
  }

  public boolean push(int i)
  {
    if(this.tail == null)
    {
      this.tail = new node();
      this.tail.data = i;
      this.tail.next = null;
      this.head = this.tail;
      return true;
    }
    else
    {
      node tmp = new node();
      tmp.data = i;
      tmp.next = null;
      this.tail.next = tmp;
      this.tail = tmp;
      return true;
    }
  }

  public int top()
  {
    if(this.empty())
      return 0;
    return this.head.data;
  }

  public boolean pop()
  {
    if(this.empty())
      return false;
    else
    {
      this.head = this.head.next;
      return true;
    }
  }
}
