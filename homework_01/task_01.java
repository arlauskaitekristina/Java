// Написать программу вычисления n-ого треугольного числа. url

package homework_01;
import java.util.Scanner;

public class task_01 {

    public static void main(String[] args) {
        int number = 0;
        number = input();
        System.out.println(counter(number));
    }

    public static int input() {
        int number = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число для вычисления n-ого треугольного числа: ");
        if(scan.hasNextInt()) { 
          number = scan.nextInt();
        } 
        scan.close();
        return number;
    }

    public static int counter(int n) {{
        int res = 0;
        res = (n * (n + 1))/2;
        return res;
    }
        
    }
}