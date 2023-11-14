import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Nhập số thứ nhất
        System.out.print("Nhập số thứ nhất: ");
        double num1 = input.nextDouble();

        // Nhập số thứ hai
        System.out.print("Nhập số thứ hai: ");
        double num2 = input.nextDouble();

        // Tính tổng
        double sum = num1 + num2;
        System.out.println("Tổng: " + sum);

        // Tính hiệu
        double difference = num1 - num2;
        System.out.println("Hiệu: " + difference);

        // Tính tích
        double product = num1 * num2;
        System.out.println("Tích: " + product);

        // Kiểm tra điều kiện tránh lỗi chia cho 0
        if (num2 != 0) {
            double thuong = num1 / num2;
            System.out.println("Thương: " + thuong);
        } else {
            System.out.println("Không thể chia cho 0.");
        }
    }
}
