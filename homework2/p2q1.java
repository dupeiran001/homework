public class p2q1
{
  public static void main(String[] args)
  {
    int[] result = {2 , 1 , 3 , 4 , 5 , 6};
    int[] input  = {1 , 2 , 3 , 4 , 5 , 6};

    for(int tmp = 0 ; tmp != input.length ; tmp++ )
      System.out.print(input[tmp] + " ");
    System.out.println();
    for(int tmp = 0 ; tmp != result.length ; tmp++ )
      System.out.print(result[tmp] + " ");
    System.out.println();
    stack st = new stack();
    st.push(input[0]);
    int tmp;
    int rtmp = 0;
    for(tmp = 0 ; rtmp < result.length-1 && tmp < input.length-1 ; )
    {
      if(st.top() == result[rtmp])
      {
        st.pop();
        rtmp++;
      }
      else
      {
        tmp++;
        st.push(input[tmp]);
      }
    }
    if(st.empty())
      System.out.println("true");
    else
      System.out.println("false");

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
