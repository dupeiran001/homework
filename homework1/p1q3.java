public class p1q3
{
  public static void main(String args[])
  {

    //init a data array called "dataset"
    int[] data_source = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 };

    arraylist dataset = new arraylist(data_source);

    dataset.display();
    System.out.println();

    dataset = dataset.execlude(3, 6);
    dataset.display();
  }
}

class arraylist
{
  private int string_length;
  private int data_length;
  private int data[];

  public arraylist()
  {
    this.string_length = 10; 
    this.data_length = 0;
    this.data = new int[string_length];
  }

  public arraylist(int[] input)
  {
    this.string_length = 10; 
    this.data_length = 0;
    this.data = new int[string_length];
    for(int tmp : input)
    {
      this.add(tmp);
    }
  }

  public void doubleCapcity()
  {
    this.string_length *= 2;
    int[] newdata = new int[this.string_length];
    for(int tmp=0 ; tmp < this.data_length ; tmp++)
    {
      newdata[tmp] = this.data[tmp];
    }
    this.data = newdata;
  }

  public void add(int input)
  {
    if(this.data_length == this.string_length)
    {
      this.doubleCapcity();
    }
    else
    {
      this.data[data_length] = input;
      data_length ++;
    }
  }

  public void display(int input)
  {
      System.out.println(data[input]);
  }

  public void display()
  {
    for(int tmp =0 ; tmp<data_length ; tmp++)
    {
      System.out.println(data[tmp]);
    }
  }
  
  public arraylist execlude(int from , int end)
  {
    arraylist newdata = new arraylist(); 
    for(int tmp = 0; tmp<this.data_length ; tmp++)
    {
      if(this.data[tmp] < from || this.data[tmp] > end)
      {
        newdata.add(this.data[tmp]);   
      }
    }
    return newdata;
  }
}
