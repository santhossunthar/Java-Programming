import java.util.*;

public class SimpleCalculator {

    static short opIn;
    static long[] num1, num2;
    static char option, nxt;
    static String str;
    static Scanner sc;

    public static void main(String[] arg){

        try {
            menu();
            userInput();      
            numIn();
            operation(opIn);
            
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }

    public static void operation(short opI){
        switch(opI){
            case 1:
            System.out.println("Answer: " + addition(num1));
            validation();
            break;

            case 2:
            System.out.println("Answer: " + substraction(num2));
            validation();
            break;

            case 3:
            System.out.println("Answer: " + multiplication(num1));  
            validation();
            break;

            case 4:
            System.out.println("Answer: " + divition(num2));
            validation();
            break;

            default:
            System.out.println("Something went wrong here!");
            break;
        }
    }

    public static void menu() {
        System.out.println("Which operation should do? Select anything!");
        System.out.println();
        System.out.println("(1) Addition");
        System.out.println("(2) Substraction");
        System.out.println("(3) Multiplication");
        System.out.println("(4) Divition");
        System.out.println("(-1) Exit");
        System.out.println();
    }

    public static void userInput() {
        sc = new Scanner(System.in);

        do{
            try {
                System.out.print("Enter here: ");
                opIn = sc.nextShort();

                if(opIn == -1) {
                    System.exit(0);    
        
                } else if( opIn >=5 || opIn <= 0){ 
                    System.out.println("Invalid input provided! Try again!");
                    System.out.println();
        
                    menu();
                    userInput();
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input provided! Try again!");
                System.out.println();
            }
            sc.nextLine();

        }while(true);            
    }

    public static void validation(){
        System.out.println();

            nxt = nxtOp();
            
            if(nxt == 'y' || nxt == 'Y'){
                menu();
                userInput();
                numIn();
                operation(opIn);

            } else if(nxt == 'n' || nxt == 'N'){
                System.exit(0);

            } else {
                System.out.println("Invalid input provided! Try again!");
                validation();

            }
    }

    public static char nxtOp(){

        System.out.print("Do you need to do the operation again? yes(y) no(n): ");      

        str = sc.next();

        if(str.length() == 1){
            option = str.charAt(0);       

        } else {
            System.out.println("Invalid input provided! Try again!");
            System.out.println();
            nxtOp();                  
        }

        return option;      
    }

    public static void numIn() {
       do {
            try {
                System.out.println();

                
                num2 = new long[2];

                if(opIn == 1 || opIn == 3){

                    System.out.print("How many numbers should be added? ");
                    int num = sc.nextInt();

                    num1 = new long[num];

                    for(int i=0; i < num1.length; i++){

                        int count = i + 1;
                        System.out.print("Enter the Number " + count + ": ");
                        num1[i] = sc.nextLong();
                        
                    }

                } else {
                    
                    for(int i=0; i < 2; i++){

                        String[] label = {"First", "Second"};

                        System.out.print("Enter the "+ label[i] +" Number: ");
                        num2[i] = sc.nextLong();
                    }
                }

                break;              

            } catch (InputMismatchException e) {
                System.out.println("Something goes wrong with your input! Try again!");               
            }
           sc.nextLine();

        } while(true);        
    }

    public static long addition(long[] n){
        long answer = 0;
        for(int i = 0; i < n.length; i++){
            answer += n[i];
        }
        System.out.println();

        return answer;
    }

    public static long substraction(long[] n){
        long answer = n[0] - n[1];

        System.out.println();

        return answer;
    }

    public static long multiplication(long[] n){
        long answer = 1;
        for(int i = 0; i < n.length; i++){
            answer = answer * n[i];        
        }
        System.out.println();

        return answer;
    }

    public static long divition(long[] n){
        long answer = n[0] / n[1];

        System.out.println();
        
        return answer;
    }
}