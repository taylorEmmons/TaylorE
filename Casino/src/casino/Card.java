package casino;

public class Card {

	private House house;
	private Value value;
	private int id; 
	private boolean flag;
	
	public Card(House house, Value value,int id) {
		
		this.house = house;
		this.value = value;
		this.id = id;
		this.flag = true;
	}
	
	public int getId() {
		return this.id;
	}
	
	public House getHouse() {
		return house;
	}
	
	public void setHouse(House house) {
		this.house = house;
	}
	
	public Value getValue() {
		return value;
	}
	
	public void setValue(Value value) {
		this.value = value;
	}
	
	public String toString() {
		String str = this.house + " " + this.value;
		
		return str;
	}

	public boolean isInDeck() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
