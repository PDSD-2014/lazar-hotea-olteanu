package gameplay;

import java.util.ArrayList;

public class Question {
	private String question;
	private ArrayList<String> variants;
	private String solution;
	
	public Question(String question, ArrayList<String> variants, String solution) {
		this.setQuestion(question);
		this.setVariants(variants);
		this.setSolution(solution);
	}

	String getQuestion() {
		return question;
	}

	void setQuestion(String question) {
		this.question = question;
	}

	ArrayList<String> getVariants() {
		return variants;
	}

	void setVariants(ArrayList<String> variants) {
		this.variants = variants;
	}

	String getSolution() {
		return solution;
	}

	void setSolution(String correctAnswer) {
		this.solution = correctAnswer;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.getQuestion());
		result.append("\n");
		
		for(int i = 0; i < 4; i++) {
			result.append(i + 1);
			result.append(") ");
			result.append(this.getVariants().get(i));
			result.append("\n");
		}
		result.append("(");
		result.append(this.getSolution());
		result.append(")");
		
		return result.toString();
	}
}
