package dojo;

import java.util.ArrayList;
import java.util.List;

public class RomanNumeral {

	static List<Holder> vals = new ArrayList<Holder>();

	static {
		vals.add(new Holder(1000, "M"));
		vals.add(new Holder(900, "CM"));
		vals.add(new Holder(500, "D"));
		vals.add(new Holder(400, "CD"));
		vals.add(new Holder(100, "C"));
		vals.add(new Holder(90, "XC"));
		vals.add(new Holder(50, "L"));
		vals.add(new Holder(40, "XL"));
		vals.add(new Holder(10, "X"));
		vals.add(new Holder(9, "IX"));
		vals.add(new Holder(5, "V"));
		vals.add(new Holder(4, "IV"));
		vals.add(new Holder(1, "I"));
	}

	private static class Holder {
		Holder(int value, String symbol) {
			this.symbol = symbol;
			this.value = value;
		}

		private int value;
		private String symbol;
	}

	public static String get(int number) throws RuntimeException {
		if (number <= 0 || number > 3999) {
			throw new RuntimeException("Cannot process numbers > 3999");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vals.size() ; i++) {
			Holder holder = vals.get(i);
			int counter = number / holder.value;
			number = number % holder.value;

			for (int j = 0; j < counter; j++) {
				sb.append(holder.symbol);
			}
		}

		return sb.toString();
	}

	public static int get(String numeral) {
		int number = 0;
		for (int i = 0; i < vals.size() ; i++) {
			Holder holder = vals.get(i);
			while (numeral.startsWith(holder.symbol)) {
				number += holder.value;
				numeral = numeral.substring(holder.symbol.length());
			}
		}

		return number;
	}

}
