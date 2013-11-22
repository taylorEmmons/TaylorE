package funParser;


public class FunParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String test = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String key = "key";
			
			byte[] testBytes = test.getBytes();
			byte[] keyBytes = key.getBytes();
			byte[] result = new byte[testBytes.length];
			
			for(int i = 0; i < testBytes.length; i++) {
				result[i] = (byte)(testBytes[i] ^ keyBytes[i%key.length()]);
			}
			
			String str = new String(result);
			System.out.println(str);
			
			for(int i = 0; i < testBytes.length; i++) {
				result[i] = (byte)(str.getBytes()[i] ^ keyBytes[i%key.length()]);
			}
			
			str = new String(result);
			
			System.out.println(str);
			
	}

}
