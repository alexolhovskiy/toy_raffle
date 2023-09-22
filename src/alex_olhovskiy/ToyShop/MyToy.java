package alex_olhovskiy.ToyShop;

public class MyToy {
	public static int ctn;
	static{
		ctn=0;
	}
	private ToyType tt;
	private int id;
	
	public MyToy(ToyType tt){
		this.tt=tt;
		id=ctn++;
	}
	
	public String toString(){
		return tt.toString()+" #"+id;
	}
	
	public ToyType getTt(){
		return tt;
	}
	
	public boolean equals(Object o){
		MyToy t=(MyToy) o;
		return id==t.id&&tt.toString().equals(t.getTt().toString());
	}
}
