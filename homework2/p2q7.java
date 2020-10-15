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
