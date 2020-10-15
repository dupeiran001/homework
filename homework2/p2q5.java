public class p2q5
{
  public static void main(String[] args)
  {
    cycleque a = new cycleque(1);
    a.push(2);
    a.push(3);
    a.push(4);
    a.push(5);
    a.push(6);
    a.push(7);
    a.push(8);
    a.push(9);
    a.push(10);
    System.out.println(a.top());
  }
}

class cycleque
{
  private int MaxSize;
  private boolean tag;
  private int front;
  private int rear;
  private int[] data; 

  public cycleque(int i)
  {
    this.MaxSize = 10;
    tag = false;
    front = 0;
    rear = 0;
    data = new int[MaxSize];
    data[0] = i;
  }

  public boolean empty()
  {
    return front == rear && !tag;
  }

  public boolean full()
  {
    return (front+1) % MaxSize == rear && tag;
  }

  private void doublecapsity()
  {
    int[] a = new int[2*MaxSize];
    int tmp;
    for(tmp = 0; front != rear ; tmp++ , rear=(rear++)%MaxSize)
      a[tmp] = data[rear];
    this.rear = 0;
    this.front = tmp-1;
    MaxSize *= 2;
    this.data = a;
    this.tag = false;
  }

  public boolean push(int i)
  {
    if(this.full())
      this.doublecapsity();
    this.front = (this.front+1) % MaxSize ;
    data[this.front] = i;
    if(this.rear == this.front)
      tag = true;
    return true;
  }

  public boolean pop()
  {
    if(this.empty())
      return false;
    this.data[this.rear] = 0;
    this.rear = (this.rear+1) % MaxSize;
    if(this.rear == this.front)
      tag = false;
    return true;
  }

  public int top()
  {
    if(this.empty())
      return 0;
    return this.data[rear];
  }
}

