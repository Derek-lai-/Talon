public class Talon {

	public static char[] encode(long lat, long lon) {
		char val_1[] = _encode(lat);
		char val_2[] = _encode(lon);
		char first = val_1[0];
		char second = val_1[1];
		char third = val_2[0];
		char fourth = val_2[1];

		char[] r = new char[5];
		r[0] = (char)"\u2641";
		r[1] = first;
		r[2] = second;
		r[3] = third;
		r[4] = fourth;

		return r;
	}

	public static char[] decode(String code) {
		return -1;
	}

	private static char[] _encode(long loc){
		long val;
		if (loc < 0){
			val = 0;
			if (loc < -90){
				val = 1000000000;
				loc += 90;
			}
		} else {
			val = 2000000000;
			if (loc > 90){
				val = 3000000000L;
				loc -= 90;
			}
		}
		val += Math.abs(loc) * 10000000;
		val = Long.toHexString(Long.parseLong(val));
		String val_1 = val.substring(0 , 4);
		String val_2 = val.substring(4);
		char first = (char)(Integer.parseInt(val_1, 16));
		char second = (char)(Integer.parseInt(val_2, 16));
		char[] result = new char[2];
		result[0] = first;
		result[1] = second;
		return result;	
	}

	private static char[] _decode(int first, int second) {
		return -1;
	}

}