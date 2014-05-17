package gameplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Question {
	private String question;
	private ArrayList<String> variants;
	private String solution;
	private String extra = "ABCD";
	private String type;
	
	public Question(String question, ArrayList<String> variants, String solution, String type) {
		this.setQuestion(question);
		this.setVariants(variants);
		this.setSolution(solution);
		this.SetInformationType(type);
	}
	
	public static Question generateObject(String json) {
		String question;
		ArrayList<String> variants;
		String solution;
		String infotype;
		JSONObject obj = (JSONObject)JSONValue.parse(json);
		
		if (!obj.containsKey("question") || !obj.containsKey("variants") || !obj.containsKey("solution"))
			return null;
		
		question = (String)obj.get("question");
		variants = (ArrayList<String>)obj.get("variants");
		solution = (String)obj.get("solution");
		infotype = (String)obj.get("informationType");
		
		return new Question(question, variants, solution, infotype.toString());
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getVariants() {
		return variants;
	}

	public void setVariants(ArrayList<String> variants) {
		this.variants = variants;
	}

	public void SetInformationType(String type) {
		this.type = type;
	}
	public String GetInformationType() {
		return type;
	}
	public String getSolution() {
		return solution;
	}

	public void setSolution(String correctAnswer) {
		this.solution = correctAnswer;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.getQuestion());
		result.append("\n");
		
		// Variants changed from 1) to A:
		for(int i = 0; i < 4; i++) {
			result.append(extra.charAt(i));
			result.append(": ");
			result.append(this.getVariants().get(i));
			result.append("\n");
		}
		result.append("(");
		result.append(this.getSolution());
		result.append(")");
		
		return result.toString();
	}
	
	public String JSONToString() {
		JSONObject obj = new JSONObject();
		obj.put("question", question);
		obj.put("variants", variants);
		obj.put("solution", solution);
		obj.put("informationType", type);
		return obj.toString();
	}
}

enum InformationType {
	NAME, CODE, POPULATION,
	CAPITAL, CONTINENT, AREA;
	
	private static final List<InformationType> VALUES = 
			Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	public static InformationType randomType()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
