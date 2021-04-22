package hust.soict.globalict.aims.media;

public class Disc extends Media{
	private int length;
	private String director;

	public Disc(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Disc(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}

	public Disc(int id, String title, String category) {
		super(id, title, category);
		// TODO Auto-generated constructor stub
	}

	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}
	
	public Disc(int id, String title, String category, float cost, int length) {
		super(id, title, category, cost);
		this.length = length;
		// TODO Auto-generated constructor stub
	}
	
	public Disc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
		// TODO Auto-generated constructor stub
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

}
