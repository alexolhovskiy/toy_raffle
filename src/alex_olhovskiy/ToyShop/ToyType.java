package alex_olhovskiy.ToyShop;

public enum ToyType {
	Designer("Детский конструктор"),
	Doll("Кукла"),
	Board_game("Настольная игра"),
	Book("Комикс"),
	Car("Машинка"),
	Train("Паровозик"),
	Plane("Самолетик"),
	Soldiers("Солдатики");
	
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
