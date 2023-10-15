import java.util.Scanner;
import javax.swing.JOptionPane;
public class Cal_ptr {
    // hàm giải phương trình bậc 1 một biến
    static void first_degree_equation() {
        Scanner scanner = new Scanner(System.in);
        float a, b; // hệ số phương trình bậc 1 ax+b = 0
        do {
            System.out.print("Enter a: ");
            a = scanner.nextFloat();
            if (a == 0) System.out.println("a must not equal to 0");
        } while(a == 0);

        System.out.print("Enter b: ");
        b = scanner.nextFloat();
        System.out.println("x = " + (-b / a));
    }

    // hàm giải phương trình bậc 1 hai biến
    static void system_of_first_degree_equations() {
        Scanner scanner = new Scanner(System.in);
        double a11 , a12 , b1 , a21 , a22 , b2; // hệ số của hệ phương trình 
                                                                                        
        System.out.print("Input here: a11 , a12 , b1 : ");
        a11 = scanner.nextDouble();
        a12 = scanner.nextDouble();
        b1 = scanner.nextDouble();
        System.out.print("Input here:a21 , a22 , b2 : ");
        a21 = scanner.nextDouble();
        a22 = scanner.nextDouble();
        b2 = scanner.nextDouble();
        double Det = (a11 * a22 - a12 * a21);
        double Dx = (b1 * a22 - b2 * a12);
        double Dy = (b2 * a11 - b1 * a21);
        if (Det == 0) {
            if ( a11 == 0 && a12 == 0 && b1 != 0) System.out.println("No solution !");
            else if ( a21 == 0 && a22 == 0 && b2 != 0) System.out.println("No solution !");
            else if(Dx == 0 && Dy == 0) System.out.println("Infinite solution");
            else System.out.println("No solution !");
        }
        else {
            double x = Dx / Det;
            double y = Dy / Det;
            System.out.println("Solution is: x = " + x + " y = " + y);
        }
    }

    // hàm giải phương trình bậc 2
    static void second_degree_equation() {
        Scanner scanner = new Scanner(System.in);
        float a, b, c; // hệ số của phương trình bậc 2 
        System.out.print("Enter a: ");
        a = scanner.nextFloat();
        if (a == 0) {
            do {
                System.out.print("Enter b: ");
                b = scanner.nextFloat();
                if (b == 0) System.out.println("b must not equal to 0");
            } while(b == 0);

            System.out.print("Enter c: ");
            c = scanner.nextFloat();
            System.out.println("x = " + (c / b));
        } else {
            System.out.print("Enter b: ");
            b = scanner.nextFloat();
            System.out.print("Enter c: ");
            c = scanner.nextFloat();
            float delta = (float) Math.pow(b, 2) - 4*a*c;
            if (delta < 0) System.out.println("No solutions");
            else if (delta == 0) System.out.println("x = " + (-b / (2*a)));
            else {
                System.out.println("x1 = " + ((-b + Math.sqrt(delta)) / (2*a)));
                System.out.println("x2 = " + ((-b - Math.sqrt(delta)) / (2*a)));
            }
        }
    }
    public static void main(String[] args) {
        first_degree_equation();
        system_of_first_degree_equations();
        second_degree_equation();
System.exit(0);
    }
}
