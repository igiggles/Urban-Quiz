package gary.cregan.urbanquiz.domain;

import java.util.ArrayList;
import java.util.List;

public class Question 
{
	private String rightAnswer;
	private List<String> wrongAnswers;
	private String description;
	private String author;
	private String wordInUse;
	
	public Question()
	{
		this.wrongAnswers = new ArrayList<String>();
	}
	
	public String getRightAnswer() 
	{
		return rightAnswer;
	}
	
	public void setRightAnswer(String rightAnswer) 
	{
		this.rightAnswer = rightAnswer;
	}

	public List<String> getWrongAnswers() 
	{
		return wrongAnswers;
	}

	public void setWrongAnswers(List<String> wrongAnswers) 
	{
		this.wrongAnswers = wrongAnswers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addToWrongAnswers(String wrongAnswer)
	{
		this.wrongAnswers.add(wrongAnswer);
	}
	
	public void removeFromWrongAnswers(String wrongAnswer)
	{
		this.wrongAnswers.remove(wrongAnswer);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getWordInUse() {
		return wordInUse;
	}

	public void setWordInUse(String wordInUse) {
		this.wordInUse = wordInUse;
	}
	
	
}
