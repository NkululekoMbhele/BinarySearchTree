

public class Data implements Comparable<Data>{

	public static String stageDT;
	public static String areas;

	public Data(String stageDT,String area){
		this.stageDT = stageDT;
		this.areas = area;

	}

	public String getstageDT(){
		return this.stageDT;
	}

	public String getAreas(){
		return this.areas;
	}

	public int compareTo(Data l){
		//System.out.println(stageDT+"AV"+l.stageDT);////////////////////////
		return this.stageDT.compareTo(l.getstageDT());

	}

	public String toString(){
		return this.stageDT+"                   | "+this.areas;
	}




}