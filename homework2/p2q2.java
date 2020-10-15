public class p2q2
{
  public static void main(String[] args)
  {
     char[] st = {'a','b','c','d','e','@','e','d','c','b','a'};
    seqstack a = new seqstack();
    int tmp;
    for(tmp = 0 ; st[tmp] != '@' ; tmp++)
      a.push(st[tmp]);
    tmp++;
    for( ; st[tmp] == a.top() && tmp < st.length-1 ; tmp++)
      a.pop();
    if(a.top()==st[tmp])
    {
      a.pop();
        if(a.empty())
          System.out.println("true");
    }
    else
      System.out.println(tmp);
  }
}

class seqstack
{
  private int datalength;
  private int stringlength;

  private char[] data;

  public seqstack()
  {
    this.datalength = 0;
    this.stringlength = 10;
    this.data = new char[this.stringlength]; 
  }

  private void doublecapsity()
  {
    char[] tmp = new char[2*this.stringlength];
    for(int i =0 ; i < datalength ; i++)
      tmp[i] = this.data[i];
    this.data = tmp;
  }

  public void push(char i)
  {
    if(this.full())
      this.doublecapsity();
    data[this.datalength] = i;
    this.datalength ++;
  }

  public char top()
  {
    if(this.empty())
      return 0;
    return data[datalength-1];
  }

  public boolean pop()
  {
    if(this.empty())
      return false;
    data[datalength-1] = 0;
    datalength--;
    return true;
  }

  public boolean empty()
  {
    return datalength == 0;
  }

  private boolean full()
  {
    return datalength == stringlength;
  }
}


