package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public String toString() {
		return "Media - id: " + this.getId() +
				" - title: " + this.getTitle() +
				" - category: " + this.getCategory() +
				" - cost: " + this.getCost() + "$";
	}
	
	public boolean isMatch(String title) {
	    if (title == null || this.getTitle() == null || title.trim().isEmpty())
	        return false;

	    String[] words = title.toLowerCase().split("\\s+"); // bởi vì không phân biệt chữ hoa chữ thường
	    String loweredThisTitle = this.getTitle().toLowerCase();

	    for (String word : words) {
	        if (loweredThisTitle.contains(word)) return true;
	    }

	    return false;
	}
	
	@Override
	public boolean equals(Object o) {
		try {
	        if (this == o) return true;

	        if (o == null || getClass() != o.getClass()) return false;

	        Media media = (Media) o;
	        return this.title != null && this.title.equals(media.title);
	        
	    } catch (NullPointerException e) {
	        System.err.println("NullPointerException: Title của đối tượng hoặc đối tượng là null.");
	        return false;
	        
	    } catch (ClassCastException e) {
	        System.err.println("ClassCastException: Không thể ép kiểu đối tượng so sánh.");
	        return false;
	    }
	}
}
