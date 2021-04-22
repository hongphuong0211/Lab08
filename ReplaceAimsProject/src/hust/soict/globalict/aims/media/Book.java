package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media implements Comparable{
	private List<String> authors;
	private String content;
	private List<String> contentTokens;
	private Map<String, Integer> wordFrequency;
	
	public Book(int id) {
		super(id);
	}
	
	public Book(int id, String title){
		super(id, title);
	}

	public Book(int id, String title, String category){
		super(id, title, category);
	}
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	

	public List<String> getAuthors() {
		return authors;
	}

	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return getTitle().compareTo(((Book) o).getTitle());
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		processContent();
	}

	
	public List<String> getContentTokens() {
		return contentTokens;
	}

	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}

	public void processContent() {
		contentTokens = new ArrayList<String>();
		contentTokens = Arrays.asList(content.split("\\s"));	
		Collections.sort(contentTokens);
		wordFrequency = new TreeMap<>();
		for (String item: contentTokens) {
		      if (wordFrequency.containsKey(item))
		    	  wordFrequency.put(item, wordFrequency.get(item) + 1);
		      else
		    	  wordFrequency.put(item, 1);
		  }
		return;		
	}
	
	@Override
	public String toString() {
		return "Id: " + getId() +
				"\nTitle: " + getTitle() +
				"\nCategory: " + getCategory() +
				"\nCost: " + getCost() +
				"\nAuthors: " + getAuthors() +
				"\nContent: " + getContent() +
				"\nContent Length: " + this.contentTokens.size() +
				"\nToken list: " + getContentTokens() +
				"\nThe word frequency of the content: \n" + getWordFrequency(); 
	}
}
