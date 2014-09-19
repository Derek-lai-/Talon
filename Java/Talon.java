public class Talon {

	public static byte[] encode(long lat, long lon) {
		byte val_1[] = _encode(lat);
		byte val_2[] = _encode(lon);
		byte first = val_1[0];
		byte second = val_1[1];
		byte third = val_2[0];
		byte fourth = val_2[1];

		byte[] r = new byte[5];
		r[0] = "\u2641";
		r[1] = first;
		r[2] = second;
		r[3] = third;
		r[4] = fourth;

		return r;
	}

	public static byte[] decode(String code) {
		return -1;
	}

	private static byte[] _encode(long loc){
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
		String valString = Long.toHexString(val);
		String val_1 = valString.substring(0 , 4);
		String val_2 = valString.substring(4);
		byte[] first = String.valueOf((Integer.parseInt(val_1, 16))).getBytes("UTF8");
		byte[] second = String.valueOf((Integer.parseInt(val_2, 16))).getBytes("UTF8");
		byte[] result = {first, second};
		return result;	
	}

	private static byte[] _decode(int first, int second) {
		return -1;
	}

}