import java.util.ArrayList;

public class Talon {

	public static ArrayList encode(long lat, long lon) throws UnsupportedEncodingException{
		ArrayList val_1 = _encode(lat);
		ArrayList val_2 = _encode(lon);

		byte[] first = val_1.get(0);
		byte[] second = val_1.get(1);

		byte[] third = val_2.get(0);
		byte[] fourth = val_2.get(1);

		try{
			byte[] icon = "\u2641".getBytes("UTF8");
		}catch( UnsupportedEncodingException e){
			return null;
		}
		
		byte[] r[];
		r[0] = icon;
		r[1] = first;
		r[2] = second;
		r[3] = third;
		r[4] = fourth;

		return r;
	}

	public static byte[] decode(String code) {
		return null;
	}

	private static ArrayList _encode(long loc) throws UnsupportedEncodingException{
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

		Integer temp_1 = Integer.parseInt(val_1, 16);
		Integer temp_2 = Integer.parseInt(val_2, 16);

		ArrayList result = new ArrayList();

		try{
			byte first[] = (String.valueOf(temp_1)).getBytes("UTF8");
			byte second[] = (String.valueOf(temp_2)).getBytes("UTF8");
			result.add(0, first);
			result.add(1, second);
		}catch( UnsupportedEncodingException e){
			return null;
		}

		return result;	
	}

	private static byte[] _decode(int first, int second) {
		return null;
	}

}