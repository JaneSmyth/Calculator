//JANE SMYTH
//C00208290

package CalculatorProject;
//ERROR HANDLING
//should be called MyException
public class Exception extends ArithmeticException 
{
   public Exception()
   {
      super( "Attempted to Divide by Zero" );
   }

   public Exception( String message )
   {
      super( message );
   }
  
}
