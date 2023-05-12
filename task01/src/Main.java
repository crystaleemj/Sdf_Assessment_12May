import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

    // 1. string array to store user input
    // 2. check if index 0 or index 2 of input is "$last", 
    // if input 0 and 2 is $last, int last = expression[0] / [2]
    // 3. after every operation last = result

        // create welcome message
        System.out.println("Welcome.");

        // create scanner for user input
        Scanner scan = new Scanner(System.in);

        // create string var to store user input
        String input = "";

        // create double var to store number input/result
        double n1 = 0;
        double n2 = 0;
        double result = 0;
        double $last = 0;

        // create while loop to keep prompting user unless user exit
        while (!input.equals("exit")){
            System.out.print("> ");
            input = scan.nextLine();

            String [] s = input.split(" ");
            String operator = s[1];

            // check if any of the number inputs are '$last'
            if (s[0].equals("$last")) {
                n1 = $last;
            } else {
                n1 = Double.parseDouble(s[0]);
            }
    
            if (s[2].equals("$last")) {
                n2 = $last;
            } else {
                n2 = Double.parseDouble(s[2]);
            }
    
            // check if operator is + - *  or /, then calculate accordingly
            if(operator.equals("+")){
                result = n1 + n2;
                System.out.println(result);
            }
            if(operator.equals("-")){
                result = n1 - n2;
                System.out.println(result);
            }
            if(operator.equals("*")){
                result = n1 * n2;
                System.out.println(result);
            }
            if(operator.equals("/")){
                result = n1 / n2;
                System.out.println(result);
            } 

            // set $last as result var, to use within the loop 
            // if '$last' is called upon
            $last = result;
            
            // if user command 'exit', close the program
        } System.exit(0);

        // close scanner 
        scan.close();

    } 
}
