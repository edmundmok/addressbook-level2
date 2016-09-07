package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
	
	public enum TaggingType {
		ADD_TAG, REMOVE_TAG;
	}
	
	private TaggingType taggingType;
	private Person person;
	private Tag tag;
	
	public Tagging(TaggingType taggingType, Person person, Tag tag){
		this.taggingType = taggingType;
		this.person = person;
		this.tag = tag;
	}
	
	public TaggingType getTaggingType(){
		return taggingType;
	}
	
	public Person getPerson(){
		return person;
	}
	
	public Tag getTag(){
		return tag;
	}
}
