package sequence;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Static class for reading from a file-sequence stream.
 * <p>
 * The format for file-sequence streams can be found
 * <a href="http://mit.edu/6.005/www/fa08/projects/multipart/assignment.html#specification">here</a>.
 *
 */
public class FileSequenceReader {
	/**
	 * Returns the data from the next sub-file in the given file sequence stream.
	 * <p>
	 * If no sub-files remain, returns null. If the stream ends prematurely,
	 * throws an EOFException.
	 */
	public static byte[] readOneFile(InputStream sequence)
		throws IOException, EOFException {
		// sequence files consist of a (4-byte) int giving the size of the sub-file,
		// followed by the sub-file, followed by another size, followed by the sub-file,
		// and so on until EOF
		int size;
		// note that this hides errors involving less than 4 trailing bytes:
		try {
			size = new DataInputStream(sequence).readInt();
		} catch(EOFException e) { // no more sub-files
			return null;
		}

		byte[] data = new byte[size];
		int read = 0;
		while(read<size) {
			int justRead = sequence.read(data, read, size-read);
			if(justRead==-1)
				throw new EOFException("stream ended after only "+read+" bytes of "+size+"-byte sub-file!");
			read += justRead;
		}
		return data;
	}
}
