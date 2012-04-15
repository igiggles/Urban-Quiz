package gary.cregan.urbanquiz.domain;

import java.util.List; 
import com.google.gson.annotations.SerializedName; 
public class SearchResponse 
{ 
	public List<Result> list; 
	@SerializedName("has_related_words")
	public boolean has_related_words; 
	@SerializedName("result_type")
	public String result_type; 
	
	public List<Result> getList() {
		return list;
	}
	public void setList(List<Result> list) {
		this.list = list;
	}
	public boolean isHas_related_words() {
		return has_related_words;
	}
	public void setHas_related_words(boolean has_related_words) {
		this.has_related_words = has_related_words;
	}
	public String getResult_type() {
		return result_type;
	}
	public void setResult_type(String result_type) {
		this.result_type = result_type;
	}
}
