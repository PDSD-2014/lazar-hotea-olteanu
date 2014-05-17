package gameplay;

public class CountryInformation {
	private int id;
	private String name;
	private String code;
	private String population;
	private String capital;
	private String continent;
	private String area;
	private String separator = " | ";
	
	public CountryInformation(int id, String name, String code, 
						String population, String capital, 
						String continent, String area) {
		this.setId(id);
		this.setName(name);
		this.setCode(code);
		this.setPopulation(population);
		this.setCapital(capital);
		this.setContinent(continent);
		this.setArea(area);
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getCode() {
		return code;
	}

	void setCode(String code) {
		this.code = code;
	}
	
	String getPopulation() {
		return population;
	}

	void setPopulation(String population) {
		this.population = population;
	}
	
	String getCapital() {
		return capital;
	}

	void setCapital(String capital) {
		this.capital = capital;
	}

	String getContinent() {
		return continent;
	}

	void setContinent(String continent) {
		this.continent = continent;
	}

	String getArea() {
		return area;
	}

	void setArea(String area) {
		this.area = area;
	}
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Name: ");
		info.append(this.getName());
		info.append(this.separator);
		info.append("Code: ");
		info.append(this.getCode());
		info.append(this.separator);
		info.append("Population ");
		info.append(this.getPopulation());
		info.append(this.separator);
		info.append("Capital: ");
		info.append(this.getCapital());
		info.append(this.separator);
		info.append("Area: ");
		info.append(this.getArea());
		return info.toString();
	}
}

