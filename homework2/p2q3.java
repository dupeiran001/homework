public class p2q3
{
  public static void main(String[] args)
  {
    int[] source = {1 , 2 , 3 , 4 , 5 , 6};
    for(int i = 0; i != source.length ; i++ )
      System.out.println(source[i]);
    stack a = new stack();
    for(int tmp = 0; tmp != source.length ; tmp++)
      a.push(source[tmp]);
    for(int b = 0 ; !a.empty() ; b++ )
    {
      source[b] = a.top();
      a.pop();
    }

    for(int i = 0; i != source.length ; i++ )
      System.out.println(source[i]);

  }
}

class stack
{
  private class node
  {
    private int data;
    private node next;
  }

  private node head;
  
  public stack()
  {
    this.head = null;
  }

  public boolean push(int i)
  {
    if(head == null)
    {
      this.head = new node();
      this.head.data = i;
      this.head.next = null;
    }
    else
    {
      node tmp = new node();
      tmp.data = i;
      tmp.next = this.head;
      this.head = tmp;
    }
    return true;
  }

  public boolean empty()
  {
    return this.head == null;
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
    this.head = this.head.next;
    return true;
  }
}


