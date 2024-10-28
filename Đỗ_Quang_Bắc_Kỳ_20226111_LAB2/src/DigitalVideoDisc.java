// Do Quang Bac Ky - 20226111
public class DigitalVideoDisc {
    // Khai báo các thuộc tính của class
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructor tiêu đề
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // Constructor với tiêu đề, thể loại và giá
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor với tiêu đề, thể loại, đạo diễn và giá
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Constructor với đầy đủ các thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }


    //Getter
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
}
