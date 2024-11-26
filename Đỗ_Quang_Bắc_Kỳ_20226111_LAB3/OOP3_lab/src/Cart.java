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


    // Phương thức thêm nhiều đĩa vào giỏ hàng
//    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//        for (DigitalVideoDisc disc : dvdList) {
//            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//                itemsOrdered[qtyOrdered] = disc;
//                qtyOrdered++;
//                System.out.println("The disc " + disc.getTitle() + " has been added!");
//                if (qtyOrdered == MAX_NUMBERS_ORDERED) {
//                    System.out.println("Warning! The cart is full!");
//                    break; // Không thêm được nữa nếu giỏ đã đầy
//                }
//            } else {
//                System.out.println("Cannot add " + disc.getTitle() + ". The cart is already full!");
//                break; // Ngừng thêm nếu giỏ đầy
//            }
//        }
//    }


    // Thêm một số lượng tùy ý các DVD bằng varargs
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc " + disc.getTitle() + " has been added!");
                if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                    System.out.println("Warning! The cart is full!");
                    break; // Không thêm được nữa nếu giỏ đã đầy
                }
            } else {
                System.out.println("Cannot add " + disc.getTitle() + ". The cart is already full!");
                break; // Ngừng thêm nếu giỏ đầy
            }
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

    // Phương thức tìm kiếm DVD theo ID
    public DigitalVideoDisc searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                return itemsOrdered[i];
            }
        }
        System.out.println("No DVD found with ID: " + id);
        return null;
    }

    // Phương thức tìm kiếm DVD theo tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found DVD: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title: " + title);
        }
    }


    public void printCart() {
        StringBuilder output = new StringBuilder("************************CART************************\nOrdered items:\n");
        for (int i = 0; i < qtyOrdered; i++) {
            output.append(i + 1 + ".[" + itemsOrdered[i].getTitle() + "] - [" + itemsOrdered[i].getCategory() + "] - [" + itemsOrdered[i].getDirector() + "] - [" + itemsOrdered[i].getLength() + "]: $" + itemsOrdered[i].getCost() + "\n");
        }
        output.append("total: ").append(totalCost()).append(" $\n");
        output.append("***************************************************\n");
        System.out.println(output);
    }
}





