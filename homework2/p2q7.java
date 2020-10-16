public class p2q7
{
  public static void main(String[] args)
  {
    stack s = new stack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.pop();
    System.out.println(s.top());
  }
}

class stack
{
  private query full;
  private query empty;
  private int count;
  public stack()
  {
    full  = new query();
    empty = new query();
    count = 0;
  }

  public boolean empty()
  {
    return this.count == 0;
  }
  
  public boolean push(int i)
  {
    count++;
    full.push(i);
    return true;
  }

  public boolean pop()
  {
    int num = count;
    if(this.empty())
      return false;
    while(num!=1)
    {
      empty.push(full.top());
      full.pop();
      num--;
    }
    full.pop();
    query tmp = full;
    full = empty;
    empty = tmp;
    count--;
    return true;
  }

  public int top()
  {
    int tmp = 0;
    if(this.empty())
      return 0;
    while(!full.empty())
    {
      empty.push(full.top());
      tmp = full.top();
      full.pop();
    }
    query q = full;
    full = empty;
    empty = q;
    return tmp;
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
