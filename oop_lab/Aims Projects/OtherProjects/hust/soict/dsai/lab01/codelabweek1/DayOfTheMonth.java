import java.util.Scanner;
public class DayOfTheMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month;
        int year;
        boolean validMonth;
        boolean validYear;
        // vòng lặp để kiểm tra dữ liệu người dùng nhập vào     
        do {
            System.out.print("Enter month: ");
            month = scanner.nextLine();
            System.out.print("Enter year: ");
            year = scanner.nextInt();
            scanner.nextLine();
            validMonth = true;
            switch (month) {
                case "1", "Jan.", "Jan", "January", "3", "Mar", "Mar.", "March",
                        "5", "May", "7", "July", "Jul", "8", "August", "Aug.", "Aug",
                        "10", "October", "Oct.", "Oct", "12", "December", "Dec", "Dec.":
                    System.out.println("This month has 31 days");
                    break;
                case "2", "Feb", "Feb.", "February":
                    if(!(year>0)) {
                        System.out.println("Not a valid year, enter again!");
                        break;
                    }
                    // kiểm tra có phải là năm nhuận không
                    if((year % 4 == 0) || (year % 400 == 0)) System.out.println("29 days");
                    else System.out.println("28 days");
                    break;
                case "4", "Apr", "Apr.", "April", "6", "Jun", "June",
                        "9", "September", "Sep.", "Sep", "11", "November", "Nov", "Nov.":
                    System.out.println("This month has 30 days");
                    break;
                default:
                    System.out.println("Not a valid month, enter again!");
                    validMonth = false;
            }
        } while (!validMonth || !(year>0));
    }
}