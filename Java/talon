public class Talon {

	public static encode(int lat, int lon) {

	}

	public static decode(str code) {

	}

	private static _encode(int loc){
		int val;
		if (loc < 0){
			val = 0;
			if (loc < -90){
				val = 1000000000;
				loc += 90;
			}
		} else {
			val = 2000000000;
			if (loc > 90){
				val = 3000000000;
				loc -= 90;
			}
		}
		val += Math.abs(loc) * 10000000;
		val = Integer.toHexString(Integer.parseInt(val));
		String val_1 = val.substring(0 , 4);
		String val_2 = val.substring(4);
		char first = (char)(Integer.parseInt(val_1, 16));
		char second = (char)(Integer.parseInt(val_2, 16));
		char[] result = new char[2];
		result[0] = first;
		result[1] = second;
		return result;	
	}

	private static _decode(int first, int second) {

	}

}