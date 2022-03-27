Exception Handling

- Exception are runtime unusual events.
- The term exception is shorthand for the phrase "exceptional event." (Sun Definition)
- An exception is an event, which occurs during the execution of a program, that   disrupts the normal flow of the program's instructions. (Sun Definition)

Example : Disk full, out of memory, divide by zero, arrayindex out of bounds, 

- Exception will immediately crash/abort the program.

Example: Divide by zero

class Test {
 public static void main(String o[]){
	System.out.println("Start of main");
        int i;
	i=Integer.parseInt(o[0]);
	int y=9/i;
	System.out.println(y);
	System.out.println("End of main");
 }
}

Note: Dividing by zero is beyond the power of a processor.

........................................................................

Example 2: Null pointer Exception
         Accessing Object method with object instanciation

class Car{
 private int price;
 public	Car(){price=4000;}
 public	void m()
   {System.out.println("I am car "+price);}
}
class Test {
public static void main(String o[]){
        System.out.println("Start of main");
	Car c=null;
  System.out.println(" i m going to call m() method");
	c.m(); //null pointer exception
	System.out.println("end of main");
}
}
.............................................................................
Reliability issue
- A program with unhandled exceptions are called highly   unreliable program.

- Unethical programmer : who can't manage exceptions.

-  Major Issue in Software Industry
............................................................................

Exception Propagation and Cascade Aborts
............................................................................
Example: Plugins or APIs

*API: Application Programmer Interface; in simple words, readymade functions or classes.

- Two companies: A and B. Company A developed F function and marketed it. Company B wants to use F function in their applications.

// Company A Software
class FClass{
static void f(int i){
	System.out.println("Start of Function F");
	int y=9/i;
	System.out.println(y);
	System.out.println("End of Function F");
}
}

// Company B Software
class F1Class{
static void f1(int n){
	System.out.println("Start of Function F1");
	FClass.f(n);
	System.out.println("End of Function F1");	
}
}

class Test {
public static void main(String o[]){
	System.out.println("Start of main");
	int i;
	i=Integer.parseInt(o[0]);
	F1Class.f1(i);
	System.out.println("end of main");
}
}

- Such types of aborts are known as cascade aborts.
  (see stack diagram on board)
- Cascade Aborts mean abort whole hierarchy from stack.
   
...................................................

How to Handle Exceptions?

Step 1: Diagnose all risky statements from your code.
Step 2: Diagnose all dependant statements whose execution depends on risky statements.
Step 3: Mark risky plus dependant statements into try catch block. (sandbox)

try{
   Risky Statements
          +
   Dependant Statements
}catch(...){action}

Example: Divide By Zero

class Test {
public static void main(String o[]){
	System.out.println("Start of main");
	int i;
	i=Integer.parseInt(o[0]);//risky Stmt
	try{
	 int y=9/i; //risky statement
	 System.out.println(y); //dependant statement
	}catch(Exception e)
         {System.out.println("Divide by zero");}
        System.out.println("end of main");
}
}

Exception class--- it will catch all types of exceptions.

.....................................................
class Test {
public static void main(String o[]){
	System.out.println("Start of main");
	int i;
       try{
	i=Integer.parseInt(o[0]);//risky Stmt
	try{
	 int y=9/i; //risky statement
	 System.out.println(y); //dependant statement
	}catch(Exception e)
         {System.out.println("Divide by zero");}
         

         }catch (Exception e ) 
                   { }


        System.out.println("end of main");
}
}
.............................................................

try with multiple catch
..............................................................
try {

} catch (ExceptionType name) {

} catch (ExceptionType name) {

}
...................................................................

try {
    risk1
    risk2
    risk3
}catch (risk1Exception e) {}
 catch (risk2Exception e) {}
 catch (risk3Exception e) {}
 catch (Exception e) {any other unknown risk}
 finally {default code}
..............................................................


Same Example
..................................................................

class Test {
public static void main(String o[]){
	System.out.println("Start of main");
	int i;
       try{       
	i=Integer.parseInt(o[0]);//risk1 Stmt

	 int y=9/i; //risk2 statement
	 System.out.println(y); //dependant statement
        }catch (ArrayIndexOutofBoundsException e1)
            {System.out.println("Array Index out of Bounds");}
        catch (ArithmeticException e2)
           {System.out.println("/ by zero);}
        catch (Exception e3)
          {System.out.println("Any Other Exception");}
        finally  {//common code 
                 }
       
        System.out.println("end of main");
}
}
.....................................................
Ethical Programming

- Ethical programmer handles exceptions using two techniques:

Method 1. Handle all exceptions by try catch block.
Method 2. Inform others about the exceptions without handling exceptions.
        
...............................................................................
Example: Method 1 
// Company A Software
class FClass{
static void f(int i){
	System.out.println("Start of Function F");
	try{
		int y=9/i;
		System.out.println(y);
	}catch(Exception e)
         {System.out.println("Divide by Zero");}
     System.out.println("End of Function F");
}
}

// Company B Software
class F1Class{
static void f1(int n){
	System.out.println("Start of Function F1");
	FClass.f(n);
	System.out.println("End of Function F1");	
}
}
class Test {
public static void main(String o[]){
	System.out.println("Start of main");
	int i;
	i=Integer.parseInt(o[0]);
	F1Class.f1(i);
	System.out.println("end of main");
}
}
.................................................................................
Example : Method 2
A method that specifies that it can throw the exception. The method must provide a throws clause that lists the exception, as described in Specifying the Exceptions Thrown by a Method.
................................................................................
class FClass{
static void f(int i) throws Exception{
	System.out.println("Start of Function F");
	
		int y=9/i;
		System.out.println(y);
	
     System.out.println("End of Function F");
}
}

// Company B Software
class F1Class{
static void f1(int n) throws Exception{
	System.out.println("Start of Function F1");
         
            FClass.f(n);
        
	System.out.println("End of Function F1");	
}
}
class Test {
public static void main(String o[]) throws Exception{
	System.out.println("Start of main");
	int i;
	i=Integer.parseInt(o[0]);
	F1Class.f1(i);
	System.out.println("end of main");
}
}


.................................................
Muti throw 
................................................
// Company A Software
class FClass{
static void f(int i) throws Exception{
	System.out.println("Start of Function F");
	      try{
		int y=9/i;
		System.out.println(y);
	       }catch (Exception e ) 
  {System.out.println("F function Handle Exception");
   System.out.println(e);
     e.printStackTrace();
                 throw e; }
     System.out.println("End of Function F");
}
}

// Company B Software
class F1Class{
static void f1(int n) throws Exception{
	System.out.println("Start of Function F1");
          try {
            FClass.f(n);
            }catch (Exception e ) 
  {System.out.println("F1 function Handle Exception");
                 throw e; } 
	System.out.println("End of Function F1");	
}
}
class Test {
public static void main(String o[]) throws Exception{
	System.out.println("Start of main");
	int i;
	i=Integer.parseInt(o[0]);
       try {
	F1Class.f1(i);
        }catch (Exception e ) 
  {System.out.println("main function Handle Exception");
                 throw e; }
	System.out.println("end of main");
}
}
.............................................................


Types of Exceptions

1. System Exceptions

2. Business Exceptions (User-defined Exceptions)

System Exception Examples: Divide by zero, disk full, null pointer exception, out of memory.
.........................................................
Business Exception Example(s): 
ATM withdrawal ( when requested amount > current balance )

.................................................

class BankException extends Exception{
private String  msg;
public	BankException(){}
public BankException(String n){msg=n;}
public void setMsg(String n){msg=n;}
public String getMsg(){return msg;}
}

class Account{
private int balance;
public	Account(){}
public	Account(int b){balance=b;}
public	void deposit(int b){balance=balance+b;}
public	boolean withdraw(int amt)throws BankException {
		if(amt<=balance){
			balance=balance-amt;
			return true;
		}
		else{
         BankException b=new BankException("Out of Balance");
         throw  b;
		}
	}
}
class Test{
public static void main(String o[]){
	int i;
	i=Integer.parseInt(o[0]);
	Account obj=new Account(5000);
try{
	if(obj.withdraw(i))
	     System.out.println("Successfully withdrawn.");	
}catch(BankException ob)
            {System.out.println(ob.getMsg());}
	System.out.println("End of Main");
}
}

............................................................................
Kinds of Exceptions by java
............................................................................
Java Support three  Kinds of Exceptions
	1) Checked Exceptions
	2) error
	3) runtime

1) Checked Exceptions 
	- Checked exceptions are subject to the Catch or Specify Requirement

2) error 
These are exceptional conditions that are external to the application, and that the application usually cannot anticipate or recover from.
Errors are not subject to the Catch or Specify Requirement. Errors are those exceptions indicated by Error and its subclasses. 

3) runtime
 These are exceptional conditions that are internal to the application, and that the application usually cannot anticipate or recover from. 
e.g. NullPointerException
Runtime exceptions are not subject to the Catch or Specify Requirement. Runtime exceptions are those indicated by RuntimeException and its subclasses.

Errors and runtime exceptions are collectively known as unchecked exceptions.
.......................................................................................

The finally Block
................................................................................
The finally block always executes when the try block exits.

Example
class Test {
public static void main (String args[]) {
int i=0;
String greetings [] = {"HELLO WORLD!!", "No, I mean it!","Hello world!"};
  while (i < 4){
           try {
                 System.out.println (greetings[i]);
               } catch (ArrayIndexOutOfBoundsException e)
                   {System.out.println("Re-stting Index Value");
                      i = -1;
                   } finally {System.out.println("This is always printed");}

                i++;
               }
              }
}
.....................................................................................

Java Exception Class Hierarchy

                                  Throwable
             Exception 					Error

 
RunTimeException    IOException


ArithmethicException
NullPointerException

(See Java Tutorial)  and Java Docs
......................................................................


























