public class p1q2
{
  public static void main(String args[])
  {

    //init a data array called "dataset"
    int[] data_source = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , -1 , -2 , -3 , -4 , -5};

    //for(int tmp : data_source)
    //{
    //  dataset.add(tmp);
    //}
    
    array dataset = new array(data_source);

    dataset.display();
    System.out.println();

    dataset = dataset.deleteMinus();
    dataset.display();
  }
}

class array
{
  private int string_length;
  private int data_length;
  private int data[];

  public array()
  {
    this.string_length = 10; 
    this.data_length = 0;
    this.data = new int[string_length];
  }

  public array(int[] input)
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

  public array deleteMinus()
  {
    array newdata = new array();
    for(int tmp=0 ; tmp< data_length ; tmp++)
    {
      if(data[tmp] >= 0)
      {
        newdata.add(data[tmp]);
      }
    }
    return newdata;
  }
}
