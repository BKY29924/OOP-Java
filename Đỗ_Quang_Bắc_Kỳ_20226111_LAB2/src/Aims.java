// Do Quang Bac Ky - 20226111
public class Aims {

    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // Tạo các đối tượng DVD mới và thêm chúng vào giỏ
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Kiểm tra chức năng xóa và thêm đĩa
        anOrder.removeDigitalVideoDisc(dvd2);
        //anOrder.addDigitalVideoDisc(dvd2);

        // In tổng chi phí các đĩa trong giỏ
        System.out.println("The Total Cost is: " + anOrder.totalCost());
    }
}
