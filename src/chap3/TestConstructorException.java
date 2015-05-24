package chap3;

class TestConstructorException{
  private int a ;

  public TestConstructorException(int a) throws Exception {
    this.a = a;
    if(a == 2)
    throw new Exception("exception in constructor");
  }
  
  

  @SuppressWarnings("unused")
  public static void main(String[] args) throws Exception {
    TestConstructorException t = new TestConstructorException(2);
    System.out.println("construct successfully");
  }
}