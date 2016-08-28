package seedu.addressbook.data.person;

public class Unit {

	private final String value;
	
	public Unit (String unit){
		this.value = unit;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
}
