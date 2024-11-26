package hust.soict.dsai.aims.store;

public class Store {
    // Mảng lưu trữ các DVD có sẵn trong cửa hàng
    private DigitalVideoDisc[] itemsInStore;
    private int quantity; // Số lượng DVD trong cửa hàng
    private static final int MAX_NUM_DVD = 50; // Giới hạn số DVD tối đa trong cửa hàng

    // Constructor khởi tạo cửa hàng với mảng DVD
    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_NUM_DVD];
        quantity = 0;
    }

    // Phương thức thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc dvd) {
        if (quantity < MAX_NUM_DVD) {
            itemsInStore[quantity] = dvd;
            quantity++;
            System.out.println("DVD '" + dvd.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    // Phương thức xóa DVD khỏi cửa hàng theo ID
    public void removeDVD(int id) {
        boolean found = false;
        for (int i = 0; i < quantity; i++) {
            if (itemsInStore[i].getId() == id) {
                // Di chuyển các DVD còn lại về phía trước
                for (int j = i; j < quantity - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[quantity - 1] = null; // Đặt phần tử cuối cùng thành null
                quantity--;
                found = true;
                System.out.println("DVD with ID " + id + " has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    // Phương thức in ra tất cả DVD trong cửa hàng
    public void printStore() {
        if (quantity == 0) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("***************DVDs in hust.soict.dsai.aims.store.Store***************");
            for (int i = 0; i < quantity; i++) {
                System.out.println(itemsInStore[i].toString());
            }
            System.out.println("********************************************");
        }
    }
}
