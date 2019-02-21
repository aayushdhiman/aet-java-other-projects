package ArrayListInteger;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ArrayListInteger implements ListInteger {
	private int[] arr;
	private int next = 0;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	
	
	public ArrayListInteger() {
		this(10);
	}
	
	public ArrayListInteger(int arrSize) {
		this.arr = new int[arrSize];
	}
	
	@Override
	public boolean add(Integer e) {
		try {
			if (arr.length == next) {
				arr = expandArray(arr);
			}
			
			arr[next] = e;
			next++;
			return true;
		} catch (Exception ex) {
			System.out.println("Ignoring add, invalid index.");
			return false;
		}
	}
	
	@Override
	public void add(int index, Integer e) {
		if(index >= next){
			System.out.println(ANSI_RED + "Ignoring add, invalid index." + ANSI_RESET);
			return;
		}
		try {
			for (int i = next; i > index; i--) {
				arr[i] = arr[i - 1];
			}
			arr[index] = e;
			next++;
		} catch (Exception ex) {
			System.out.println("Ignoring add, invalid index.");
			return;
		}
	}
	
	@Override
	public Integer get(int index) {
		if(index >= next){
			System.out.println(ANSI_RED + "Ignoring get, invalid index." + ANSI_RESET);
			return -1;
		}
		try {
			return arr[index];
		} catch (Exception ex) {
			System.out.println("Ignoring get, invalid index.");
			return -1;
		}
	}
	
	@Override
	public Integer remove(int index) {
		if(index >= next){
			System.out.println(ANSI_RED + "Ignoring remove, invalid index." + ANSI_RESET);
			return -1;
		}
		
		Integer replace = arr[index];
		
		try {
			for (int i = index + 1; i < next; i++) {
				arr[i - 1] = arr[i];
			}
			next--;
			return replace;
		} catch (Exception ex) {
			System.out.println("Invalid remove, ignoring remove.");
			return -1;
		}
	}
	
	@Override
	public int indexOf(Integer e) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == e) {
					return i;
				}
			}
			return -1;
	}
	
	@Override
	public Integer set(int index, Integer e) {
		try{
			if(next == arr.length){
				arr = expandArray(arr);
			}
			arr[index] = e;
			return e;
		}catch(Exception ex){
			System.out.println("Invalid set, ignoring index.");
			return 0;
		}
	}
	
	@Override
	public int size() {
		return next;
	}
	
	public int[] expandArray(int[] arr) {
		int[] arrDouble = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			arrDouble[i] = arr[i];
		}
		return arrDouble;
	}
	
	public String toString(){
		String str = "";
		for (int i = 0; i < next; i++) {
			str += String.format("%4d,", arr[i]);
			if ((i+1) % 10 == 0){
				str += String.format("\n");
			}
		}
		return str;
	}
	
}
