// Do Quang Bac Ky - 20226111
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Giới hạn số lượng đĩa tối đa có thể thêm vào giỏ
    private static final int NOT_FOUND = -1; // Hằng số biểu thị không tìm thấy đĩa
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; // Mảng lưu các đĩa đã thêm vào giỏ
    private int qtyOrdered = 0; // Biến lưu số lượng đĩa hiện tại trong giỏ

    // Phương thức thêm đĩa vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Awesome, the disc has been added!");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("Warning! The cart is full!");
            }
        } else {
            System.out.println("Cannot add. The cart is already full!");
        }
    }

    // Phương thức tính tổng chi phí các đĩa trong giỏ
    public float totalCost() {
        float result = 0f;
        for (int i = 0; i < qtyOrdered; i++) {
            result += itemsOrdered[i].getCost();
        }
        return result;
    }

    // Phương thức xóa một đĩa khỏi giỏ
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int disc_position = NOT_FOUND;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                disc_position = i;
                break;
            }
        }

        if (disc_position == NOT_FOUND) {
            System.out.println("We couldn't find that disc in your cart.");
            return;
        }

        for (int i = disc_position; i < qtyOrdered - 1; i++) {
            itemsOrdered[i] = itemsOrdered[i + 1];
        }
        itemsOrdered[qtyOrdered - 1] = null;
        qtyOrdered--;
        System.out.println("The disc has been removed!");
    }
}
