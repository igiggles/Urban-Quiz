package gary.cregan.urbanquiz.domain;

import com.google.gson.annotations.*;
public class Result 
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
	public String thumbs_up; 
	@SerializedName("thumbs_down") 
	public String thumbs_down; 
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
	public String getThumbs_up() {
		return thumbs_up;
	}
	public void setThumbs_up(String thumbs_up) {
		this.thumbs_up = thumbs_up;
	}
	public String getThumbs_down() {
		return thumbs_down;
	}
	public void setThumbs_down(String thumbs_down) {
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
}
