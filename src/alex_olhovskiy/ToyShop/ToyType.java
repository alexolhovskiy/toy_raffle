package alex_olhovskiy.ToyShop;

public enum ToyType {
	Designer("The children's designer"),
	Doll("Doll"),
	Board_game("Board game"),
	Book("Comic"),
	Car("Children's car"),
	Train("little train"),
	Plane("Airplane"),
	Soldiers("Toy soldiers");
	
	private String name;
	
	ToyType(String name){
		this.name=name;
	}
	
	public String toString(){
		return name;
	}
	
//	public boolean equals(Object o){
//		ToyType t=(ToyType)o;
//		return name==t.name;
//	}
}
