package seedu.addressbook.data.person;

public class Block {

	private final String value;
	
	public Block(String blockNumber){
		this.value = blockNumber;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
}
