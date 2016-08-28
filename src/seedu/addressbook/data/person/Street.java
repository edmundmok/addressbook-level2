package seedu.addressbook.data.person;

public class Street {

	private final String value;
	
	public Street (String street){
		this.value = street;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
}
