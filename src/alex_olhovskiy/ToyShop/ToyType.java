package alex_olhovskiy.ToyShop;

public enum ToyType {
	Designer("������� �����������"),
	Doll("�����"),
	Board_game("���������� ����"),
	Book("������"),
	Car("�������"),
	Train("���������"),
	Plane("���������"),
	Soldiers("���������");
	
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
