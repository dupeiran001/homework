public class p1q4
{
  public static void main(String args[])
  {

    //init a data array called "dataset"
    int[] data_source1 = {1 , 2 , 3 , 4 , 5 };
    int[] data_source2 = {5 , 6 , 7 , 8 , 9 };

    arraylist4 dataset1 = new arraylist4(data_source1);
    arraylist4 dataset2 = new arraylist4(data_source2);

    dataset1.display();
    System.out.println();
    dataset2.display();
    System.out.println();
    System.out.println();

    arraylist4 result = new arraylist4();
    result = result.and(dataset1 , dataset2);
    result.display();
  }
}

class arraylist4
{
  private int string_length;
  private int data_length;
  private int data[];

  public arraylist4()
  {
    this.string_length = 10; 
    this.data_length = 0;
    this.data = new int[string_length];
  }

  public arraylist4(int[] input)
  {
    this.string_length = 10; 
    this.data_length = 0;
    this.data = new int[string_length];
    for(int tmp : input)
    {
      this.add(tmp);
    }
  }

  public arraylist4(arraylist4 input)
  {
    for(int tmp=0 ; tmp <input.data_length ; tmp++)
    {
      this.add(input.data[tmp]);
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
  
  public arraylist4 and(arraylist4 s1 , arraylist4 s2)
  {
    int count1=0;
    int count2=0;
    arraylist4 newdata = new arraylist4();

    for(count1=count2=0 ; count1 < s1.data_length && count2 < s2.data_length ; )
    {
      //do until one of the ptr reatch the end
      if(s1.data[count1] == s2.data[count2])
      {
        newdata.add(s1.data[count1]);
        count1 ++;
        count2 ++;
      }
      else if(s1.data[count1] < s2.data[count2])
      {
        newdata.add(s1.data[count1]);
        count1 ++;
      }
      else 
      {
        newdata.add(s2.data[count2]);
        count2++;
      }
    }
    if(count1 == s1.data_length && count2 == s2.data_length)
      ;
    else if(count1 == s1.data_length)
    {
      for( ; count2 <s2.data_length ; count2++)
      {
        newdata.add(s2.data[count2]);
      }
    }
    else
    {
      for( ; count1 < s1.data_length ; count1 ++)
      {
        newdata.add(s1.data[count1]);
      }
    }
    return newdata;
  }

}
