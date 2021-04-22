package hust.soict.globalict.aims.media;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media() {}
	
	public Media(int id) {
		this.id = id;
	}
	
	public Media(int id, String title) {
		this(id);
		this.title = title;
	}
	
	public Media(int id, String title, String category) {
		this(id, title);
		this.category = category;
	}

	public Media(int id, String title, String category, float i) {
		// TODO Auto-generated constructor stub
		this(id, title, category);
		this.cost = i;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public boolean equals(Object o) {
		return (id == ((Media) o).getCost());
	}
}
