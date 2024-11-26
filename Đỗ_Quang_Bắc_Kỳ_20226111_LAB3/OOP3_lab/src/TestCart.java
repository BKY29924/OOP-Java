class CartTest {
    public static void main(String[] args) {
        // Tạo các đĩa DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix", "Action", "Lana Wachowski", 136, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 14.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 22.99f);

        // Tạo giỏ hàng
        Cart cart = new Cart();

        // Thêm đĩa vào giỏ
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // In ra thông tin giỏ hàng
        cart.printCart();

        // Tìm kiếm DVD theo ID
        DigitalVideoDisc foundById = cart.searchById(2); // Tìm DVD với ID = 2
        if (foundById != null) {
            System.out.println("Found DVD by ID: " + foundById.toString());
        }

        // Tìm kiếm DVD theo tiêu đề
        cart.searchByTitle("The Matrix"); // Tìm DVD với tiêu đề "The Matrix"
        cart.searchByTitle("Avatar");    // Tìm DVD với tiêu đề "Avatar" (không tồn tại)
    }
}
