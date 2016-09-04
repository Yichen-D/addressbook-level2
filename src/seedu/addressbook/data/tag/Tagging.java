package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
	
	
	public enum tagOperation {
			ADDED,
			DELETED
	};
	
	private Person person;
	private Tag tag;
	private tagOperation top;
	
	Tagging(Person person, Tag tag, tagOperation top){
		this.person = person;
		this.tag = tag;
		this.top = top;
	}
	
	
	public Person getPerson(){
		return this.person;
	}
	
	public Tag getTag(){
		return this.tag;
	}
	
	public tagOperation getOperation(){
		return this.top;
	}
}
