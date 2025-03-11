package Modelo;

import java.util.ArrayList;

public class Cola extends ArrayList<String> {

	@Override
	public void add(int index, String element) {
		super.add(element);
	}
	public String tratar() {
		return super.remove(0);
	}
	
}
