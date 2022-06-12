import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.Buffer;
import java.nio.CharBuffer;

/**
 * Diese Klasse umwandelt chars, Groß zu Klein und umgekehrt. Man kann mit ein
 * char[] oder einzelne chars bearbeiten.
 * 
 * @author serefbolat
 *
 */
public class UpperLowerWriter extends FilterWriter {

	// private FilterWriter out;

	/**
	 * 
	 * @param out
	 */
	protected UpperLowerWriter(Writer out) {
		super(out);
		// TODO Auto-generated constructor stub
	}

	/**
	 * In der main befindet sich Tests
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		char[] testCharArr = { 'a', 'B', 'c', 'D', 'g', 'f', 'K', 'l', '!', '8', '9', '.' };
		// writeTest(testCharArr,3,2);

		// Aufgabe 2B
/*
		try { // Writer mWriter = new FileWriter("output.txt", true); // Zweite
			// Parameter // fügt ein, ohne parameter die Datei ist neu erstellt.

			Writer mWriter = new FileWriter("output.txt");

			mWriter.write('a'); // mWriter.write(testCharArr); 
			
		} catch (IOException e) {
			System.err.println(e + "");
			throw (e);
		}
		finally {
			mWriter.flush();
			mWriter.close();
		}
*/
		// Aufgabe 2C

		UpperLowerWriter uLw = null;
		try {
			uLw = new UpperLowerWriter(new BufferedWriter(new FileWriter("huhu10.txt")));
			//uLw.write(testCharArr, 2, 3);
			uLw.write(125);
		} catch (IOException e) {
			System.err.println("IOException aufgetreten");
			throw e;
		} finally {
			if (uLw != null) {
				uLw.flush();
				uLw.close();
			}
		}

		// Aufgabe 2E
		// Hinter den FileWriter ist nicht sinnvoll weil FileWriter ist am Ende
		// steht und kein IV out als Zeiger zu den Nächster Element hat
		// Vor den UpperLowerWriter zu hängen ist auch nict sinnvoll

		// Aufgabe 2F
		// Fehler Meldung: java.io.FileNotFoundException: C:/test.txt (No such file or
		// directory)
		/*
		 * UpperLowerWriter uLw2 = null; try { uLw2 = new UpperLowerWriter(new
		 * BufferedWriter(new FileWriter("C:/test.txt"))); uLw2.write(testCharArr, 2,
		 * 3);
		 * 
		 * } catch (IOException e) { System.err.println("IOException aufgetreten");
		 * throw e; } finally { if (uLw2 != null) { uLw2.flush(); uLw2.close(); } }
		 */

		// Aufgabe 3B

		//UpperLowerWriter uLw = null;
		try {
			// Writer outputStreamWriter = new OutputStreamWriter(System.out);

			// uLw = new UpperLowerWriter(new BufferedWriter(new FileWriter("huhu5.txt")));
			uLw = new UpperLowerWriter(new OutputStreamWriter(System.out));
			uLw.write(testCharArr, 2, 3);
			uLw.write('#');
		} catch (IOException e) {
			System.err.println("IOException aufgetreten");
			throw e;
		} finally {
			if (uLw != null) {
				uLw.flush();
				uLw.close();
			}
		}

		// Aufgabe 3D
		// System.out.print funktioniert nicht mehr weil wir mit close diese DatenStrom
		// beendet haben.

		// Aufgabe 3E
		System.err.println("ERR: Ich funktioniere noch :)");

	}

	/**
	 * Umwandelt ein char, wenn Klein ist zu Groß und wenn Groß ist dann zu Klein
	 * 
	 * @param c
	 * @return umgewandelte char
	 */
	public char umwandlung(int c) {
		char tempChar = 'a';

		boolean isUpperCase = Character.isUpperCase(c);
		if (isUpperCase) // Wenn char schon Upper ist dann
		{
			tempChar = (char) Character.toLowerCase(c);
		} else // Wenn char schon Lower ist dann
		{
			tempChar = (char) Character.toUpperCase(c);
		}

		return tempChar;
	}

//	public void write (int c) throws java.io.IOException {
//		
//		out.write(umwandlung(c));
//	}

	/**
	 * 
	 * Zunäcsht ruft die Methode umwandlung und dann gib weiter in Datenstrom
	 */
	public void write(int c) throws IOException {

		try {
			out.write(umwandlung(c));
		} catch (IOException e) {
			System.err.println(e);
			throw (e);
		}

	}

	/**
	 * 
	 * @param off    Off ist offset d.h. ab welchen index umwandlung fängen muss
	 * @param len    len beschreibt wie viele Elemente ab offset umwandeln muss
	 * @param char[]
	 */

	/*
	 * public void write(char[] buf, int off, int len) {
	 * 
	 * char[] neuBuffer = new char[buf.length]; for (int i = 0; i < buf.length; i++)
	 * { neuBuffer[i] = buf[i]; }
	 * 
	 * for (int i = 0; i <= len; i++) { neuBuffer[off + i] = umwandlung(buf[off +
	 * i]); }
	 * 
	 * try { out.write(neuBuffer, 0, neuBuffer.length); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * // CharBuffer neuCharBuffer =CharBuffer.allocate(len);
	 * 
	 * // for (int i=0; i<buf.length; i++) // { // System.out.println(neuBuffer[i]);
	 * // }
	 * 
	 * }
	 */

	// Version 2 nur modifizierte Teil ist behandelt
	// Aufgabe 1B
	public void write(char[] buf, int off, int len) {

		char[] modCharArr = new char[len];
		for (int i = 0; i < len; i++) {
			modCharArr[i] = umwandlung(buf[off + i]);
		}
		try {
			out.write(modCharArr, 0, modCharArr.length);
		} catch (IOException e) { // TODO Auto-generated catch
			e.printStackTrace();
		}
	}

}
