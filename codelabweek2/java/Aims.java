public class Aims {
    public static void main(String[] args) {
        var anOrder = new Cart();
        //khai bao 3 dia moi
        var dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );
        var dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                87,
                24.95f
        );
        var dvd3 = new DigitalVideoDisc(
                "Aladdin",
                "Animation",
                18.99f
        );
// add 3 dia
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total Cost is: " + anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println(
                "Total cost after removing dvd2 is: " +
                        anOrder.totalCost()
        );
    }
}