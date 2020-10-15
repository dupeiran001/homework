public class p2q6
{
  public static void main(String[] args)
  {
    query q = new query();
    q.push(1);
    q.push(2);
    q.push(3);
    System.out.println(q.top());
    q.pop();
    System.out.println(q.top());
  }
}

class query 
{
  private stack stack1;
  private stack stack2;

  public query()
  {
    stack1 = new stack();
    stack2 = new stack();
  }

  public boolean push(int i)
  {
    return stack1.push(i);
  }

  public boolean empty()
  {
    if(stack1.empty()&&stack2.empty())
      return true;
    return false;
  }

  public void reverse()
  {
    if(stack2.empty())
    {
      while(!stack1.empty())
      {
        stack2.push(stack1.top());
        stack1.pop();
      }
    }
  }

  public int top()
  {
    if(stack2.empty())
      this.reverse();
    return this.stack2.top();
  }

  public boolean pop()
  {
    if(this.empty())
      return false;
    else if(stack2.empty())
      this.reverse();
    this.stack2.pop();
    return true;
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
