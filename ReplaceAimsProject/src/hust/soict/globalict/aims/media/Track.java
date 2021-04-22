package hust.soict.globalict.aims.media;

public class Track implements Playable, Comparable{
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	public boolean equals(Object o) {
		return (title.equals(((Track) o).getTitle()) && length == ((Track) o).getLength());
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return getTitle().compareTo(((Track) o).getTitle());
	}
}
