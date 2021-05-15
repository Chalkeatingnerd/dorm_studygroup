import java.sql.SQLOutput;
import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("1)push, 2)pop, 3)peek, 4)dump, etc)exit");
            int selectNum = scan.nextInt();

            if(!(selectNum == 1 || selectNum == 2 || selectNum == 3 || selectNum == 4))
                break;

            int x;
            switch (selectNum) {
                case 1:
                    System.out.print("input data : ");
                    x = scan.nextInt();
                    System.out.println();
                    try{
                        s.push(x);
                    }catch (IntStack.OverflowStackException e){
                        System.out.println("stack is full");
                    }
                        break;
                case 2:
                    try{
                        System.out.println("output data is... : " + s.pop());
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("stack is empty");
                    }
                    break;
                case 3:
                    try{
                        System.out.println("peeked data is... :  " + s.peek());
                    }catch (IntStack.EmptyIntStackException e) {
                        System.out.println("stack is empty");
                    }
                    break;
                case 4:
                    System.out.println("printin' out every data of the stack");
                    s.dump();
                    break;
            }
        }
    }
}
