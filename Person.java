package people;

public abstract class Person {

	private String name;
	private String telephone;
	
	public Person(String name, String telephone) {
		this.name = name;
		this.telephone = telephone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
}
