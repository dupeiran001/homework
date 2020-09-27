public class p1q1
{
  public static void main(String[] args)
  {
    //init the chained table and add (int)1~9 to it
    node<Integer> chained_table = new node<Integer>(1);
    int[] data_source = {2 , 3 , 4 , 5 , 6 , 7 , 8 , 9};
    for (int data_cpy : data_source )
    {
      chained_table.add(data_cpy);
    }
    
    //show the chained table
    chained_table.show();
    //get a void line
    System.out.println();
    
    //delete an element with data 5
    chained_table.delete(5);
    chained_table.show();

    return;
  }
}

class node<T>
{
  public T data;
  public node<T> next;
  
  public node (T a)
  {
    this.next = this;
    this.data = a;
  }

  public node<T> next()
  {
    if(this!=this.next)
    {
      return this.next;
    }
    else
    {
      System.out.println("Index out of range");
      return this;
    }
  }

  public node<T> add(T a)
  {
    if(this!=this.next)
    {
      return next.add(a);
    }
    else
    {
      node<T> tmp = new node<T>(a);
      this.next = tmp; 
      return this.next;
    }
   } 

  public node<T> delete(T target)
  {
    if(target == this.data)
    {
      return this.next;
    }
    else if(this!=this.next) 
    {
      this.next = this.next.delete(target);
      return this;
    }
    else
    {
      System.out.println("there is no element like that");
      return this; 
    }
  }

  public void show ()
  {
    if(this!=this.next)
    {
      System.out.println(this.data);
      this.next.show();
    }
    else
    {
      return;
    }
    
  }
}
