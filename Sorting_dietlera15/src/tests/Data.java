package tests;

import algo.ICompare;

public class Data implements ICompare<Data>, Comparable<Data> {
	
	private int value;
	
	public Data(Integer value) {
		this.value = value;
	}

	public Integer getValue() { 
		return this.value; 
	}
	
	@Override
	public boolean greaterEqual(Data y){
		// TODO Auto-generated method stub
		
		if (this.value < y.getValue()) 
			return false;
		else 
			return true;
	}

	@Override
	public boolean lesserEqual(Data y) {
		// TODO Auto-generated method stub

		if (this.value > y.getValue()) 
			return false;
		else 
			return true;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}

	@Override
	public int compareTo(Data o) {
		// TODO Auto-generated method stub
		if (this.value<o.getValue()) return -1;
		else if (this.value>o.getValue()) return +1;
		else return 0;
	}

}
