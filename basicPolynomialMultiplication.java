import java.text.DecimalFormat;
import java.util.Random;


/**
 * Rohan D. Shah 
 * IDE: NetBeans 7.4
 * Programming language = JAVA
 * Solution of polynomial multiplication basic school algorithm.
 * 
 * --------------------------------------------------------------------------------------------------------------
 * Description:
 * --------------------------------------------------------------------------------------------------------------
 * This program implements polynomial multiplication the school way. This algorithm is the most inefficient as it takes maximum
 * time and and does more amount of multiplication. The degree of the polynomial is n-1 where n is the number of coefficients. 
 * To calculate the execution time, I have used profiling tool in the IDE. It starts and stops the stop watch
 * at defined points. I have defined the start point at 65 and end point at 104.
 * 
 * -------------------------------------------------------------------------------------------------------------
 * Multiplication mechanism:
 * -------------------------------------------------------------------------------------------------------------
 * The nested for loops are used to iterate through coefficients of both the polynomial and multiplies and adds them. So, one 
 * coefficient of first polynomial is multiplied by all the coefficients of the other polynomial. The index of the array 
 * represents the power of the unknown variable 'x' in the polynomial.
 * 
 * The coefficients are randomly assigned and the values are between -1 and 1 inclusive limited to 5 decimal places.
 * @author Rohan D. Shah
 */
public class basicPolynomialMultiplication 
{

    /**
     * @param args the command line arguments
     */
    // order of the polynomials
    static int order = 3;
    
    // storing first polynomial, no of coefficients = order+1 hence size = order + 1
    static double[] p = new double[order+1];
    
    // storing second polynomial, no of coefficients = order+1 hence size = order + 1
    static double[] q = new double[order+1];
    
    // storing the product of the polynomials
    // the order of the product will always be 2*order, hence size will be 2*order+1
    static double[] pq = new double[(2*order)+1];
    
    // function that prints the polynomials
    static void printPoly(double []a, int length)
    {
        for(int z=0 ; z<length ; z++)
        {
            System.out.print(a[z]);
            if(z>0)
            System.out.print(" X^"+z);
            System.out.println();
        }
    }
    
    public static void main(String[] args) 
    {
        double forDistribution;        
        //assign sizes and values randomly
        Random randomGenerator = new Random();
        
         //format to 5 decimal place
        DecimalFormat oneDigit = new DecimalFormat("#.#####");
        // Fill in size and values of items with random numbers between -1 and 1 inclusive
        for(int i=0 ; i<=order ; i++)
        {   
            // the nextdouble method gives values from 0 to 1 but we want to have values from -1 to 1
            // hence we multiply by 2 and then subtract 1 from it to get values between that range
            forDistribution = randomGenerator.nextDouble() * 2 - 1;
            p[i] = Double.valueOf(oneDigit.format(forDistribution));
           

            forDistribution = randomGenerator.nextDouble() * 2 - 1;            
            q[i] = Double.valueOf(oneDigit.format(forDistribution));
        }
        System.out.println("------------------------------------");
        System.out.println("The first polynomial=");
        System.out.println("------------------------------------");
        printPoly(p, p.length);
        
        System.out.println("------------------------------------");
         System.out.println("The second polynomial=");
         System.out.println("------------------------------------");
        printPoly(q, q.length);
        System.out.println("------------------------------------");
        // multiply coefficients of p to all the coefficient of q and store in pq
        for(int i=0 ; i<(order+1) ; i++)
        {
            for(int j=0 ; j<(order+1) ; j++)
            {
                pq[i+j] += Double.valueOf(oneDigit.format(p[i]*q[j]));
            }
        }
        
        // printing the product
        System.out.println("The multiplication product");
        System.out.println("------------------------------------");
        printPoly(pq, pq.length);
       
    }
    
}
