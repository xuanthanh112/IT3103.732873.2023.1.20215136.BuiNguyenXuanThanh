//package hust.soict.dsai.aims.test.cart;
//
//import hust.soict.dsai.aims.cart.Cart;
//import hust.soict.dsai.aims.media.DigitalVideoDisc;
//
//public class CartTest {public static void main(String[] args) {
//    // Tạo 1 giỏ hàng
//    var cart = new Cart();
//    var dvd1 = new DigitalVideoDisc(
//            "The Lion King",
//            "Animation",
//            "Roger Allers",
//            87,
//            19.95f
//    );
//    var dvd2 = new DigitalVideoDisc(
//            "Star Wars",
//            "Science Fiction",
//            "George Lucas",
//            87,
//            24.95f
//    );
//    var dvd3 = new DigitalVideoDisc(
//            "Aladin",
//            "Animation",
//            18.99f
//    );
//
//    // Thêm đĩa
//    cart.addDigitalVideoDisc(dvd1);
//    cart.addDigitalVideoDisc(dvd2);
//    cart.addDigitalVideoDisc(dvd3);
//
//    // Test in giỏ
//    cart.print();
//
//    // Tìm kiếm
//    cart.searchById(1);
//    cart.searchByTitle("Aladin");
//    cart.searchById(99);
//    cart.searchByTitle("Conan");
//}
//}
