import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo các đĩa DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix", "Action", "Lana Wachowski", 136, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 14.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 22.99f);

        // Tạo cửa hàng
        Store store = new Store();

        // Thêm DVD vào cửa hàng
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // In ra các DVD có trong cửa hàng
        store.printStore();

        // Xóa DVD khỏi cửa hàng theo ID
        store.removeDVD(dvd2.getId()); // Xóa DVD với ID = 2
        store.printStore(); // In lại cửa hàng sau khi xóa

        // Thử xóa DVD không tồn tại
        store.removeDVD(999); // ID không tồn tại
        store.printStore(); // In lại cửa hàng
    }
}
