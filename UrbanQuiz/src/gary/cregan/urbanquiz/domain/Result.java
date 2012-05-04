package gary.cregan.urbanquiz.domain;

import com.google.gson.annotations.*;
public class Result implements Comparable<Result>
{ 
	@SerializedName("defid") 
	public String defid; 
	@SerializedName("word") 
	public String word; 
	@SerializedName("author") 
	public String author; 
	@SerializedName("permalink")
	public String permalink; 
	@SerializedName("definition") 
	public String definition; 
	@SerializedName("example") 
	public String example; 
	@SerializedName("thumbs_up") 
	public int thumbs_up; 
	@SerializedName("thumbs_down") 
	public int thumbs_down; 
	@SerializedName("current_vote") 
	public String current_vote;
	public String getDefid() {
		return defid;
	}
	public void setDefid(String defid) {
		this.defid = defid;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPermalink() {
		return permalink;
	}
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public int getThumbs_up() {
		return thumbs_up;
	}
	public void setThumbs_up(int thumbs_up) {
		this.thumbs_up = thumbs_up;
	}
	public int getThumbs_down() {
		return thumbs_down;
	}
	public void setThumbs_down(int thumbs_down) {
		this.thumbs_down = thumbs_down;
	}
	public String getCurrent_vote() {
		return current_vote;
	}
	public void setCurrent_vote(String current_vote) {
		this.current_vote = current_vote;
	}
	@Override
	public String toString() {
		return "Result [defid=" + defid + ", word=" + word + ", author="
				+ author + ", permalink=" + permalink + ", definition="
				+ definition + ", example=" + example + ", thumbs_up="
				+ thumbs_up + ", thumbs_down=" + thumbs_down
				+ ", current_vote=" + current_vote + "]";
	}
	
	//The solution to the best choice of result is to see what has the highest ups when subtracting the number of downs. I have
	//found a number of definitions with the highest number of thumbs up but they also have higher thumbs down than they do
	//thumbs up!
	public int compareTo(Result argResult) 
	{
		return (argResult.getThumbs_up() - argResult.getThumbs_down()) - (this.getThumbs_up() - this.getThumbs_down());
	}
}
