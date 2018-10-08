package ch21;

//Binary file for serialized object intput class

import java.io.*;

class ObjectInput  {
	ObjectInputStream in;
	boolean status = true;

	public ObjectInput(String fileName) {
		try {
			in = new ObjectInputStream(
               	new FileInputStream(fileName));
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
   	}
 	public final Object getObject() {
		Object obj = new Object();
		try {
			obj = in.readObject();
		}
		catch (EOFException eof) {
			System.out.println("End of the file.");
			status = false;
			return null;
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
		catch (ClassNotFoundException cnf) {
			System.out.println(cnf);
		}
		return obj;
	}
	public final boolean hasMore() {
		/*try {
			System.out.println("in.available(): " + in.available());
			if (in.available() != 0)
				status = true;
			else
				status = false;
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
		*/
		return status;
	}
   	public final void closeFile() {
		try {
     		in.close();
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
    }
}