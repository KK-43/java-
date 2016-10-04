public class Fraction {
  private int numerator;
  private int denominator;
  private static int count=0;
  private static void addCount(){
    count++;
  } 
  Fraction (){
    numerator=1;
    denominator=1;
    addCount();
  }
  Fraction (int n,int d){
    numerator=n;
    denominator=d;
    addCount();
  }
  Fraction(int n){
    numerator=n;
    denominator=1;
    addCount();
  }
  public static void displayCount(){
    System.out.println(count+"");
  }
  public void setNumerator(int n){
    numerator=n;
  }
  
  public void setDenominator(int d){
    denominator=d;
  }
  
  public int getNumerator(){
    return numerator;
  }
  
  public int getDenominator(){
    return denominator;
  }
  public void inverse(){
    int temp=numerator;
    numerator=denominator;
    denominator=temp;
  }
  public void reduce(){
    int n,d,g,temp;
    n=numerator;
    d=denominator;
    while(n%d!=0){
      temp=n%d;
      n=d;
      d=temp; 
    }
    g=d;
    numerator=numerator/g;
    denominator=denominator/g;  
  }
  public Fraction getInverse() {
    Fraction f1 =new Fraction();
    f1.setNumerator(denominator);
    f1.setDenominator(numerator);
    return f1;
  }
  public void print() {
    System.out.println(numerator+"/"+denominator);
  }
  
  public boolean checkProper(){
    if(numerator>denominator)
      return false;
    else 
      return true; 
  }
  public Fraction multiply(Fraction f1){
    Fraction f2=new Fraction(numerator*f1.getNumerator(),denominator*f1.getDenominator());
    return f2;
  }

  public Fraction add(Fraction f1){
    int n,d,g,d1,d2,temp,n1,n2;
    d1=denominator;
    d2=f1.getDenominator();
    while(d1%d2!=0){
      temp=d1%d2;
      d1=d2;
      d2=temp; 
    }
    d=(f1.getDenominator()*denominator)/d2;
    n1=(numerator*d)/denominator;
    n2=(f1.getNumerator()*d)/f1.getDenominator();
    n=n1+n2;
    Fraction f2=new Fraction(n,d);
    f2.reduce();
    return f2;
  }

  public Fraction subtract(Fraction f1){
    int n,d,g,d1,d2,temp,n1,n2;
    d1=denominator;
    d2=f1.getDenominator();
    while(d1%d2!=0){
      temp=d1%d2;
      d1=d2;
      d2=temp; 
    }
    d=(f1.getDenominator()*denominator)/d2;
    n1=(numerator*d)/denominator;
    n2=(f1.getNumerator()*d)/f1.getDenominator();
    n=n1-n2;
    Fraction f2=new Fraction(n,d);
    f2.reduce();
    return f2;
  }

  public Fraction divide(Fraction f1){
    Fraction f2=new Fraction(numerator*f1.getDenominator(),denominator*f1.getNumerator());
    return f2;
  }

  public Fraction scalarMultiply(int n){
    Fraction frac=new Fraction(n*getNumerator(),getDenominator());
    frac.reduce();
    return frac;
  }

  public double toDouble()
  {  double a=((float)numerator/denominator);
     return a;
  }
  
}


 
