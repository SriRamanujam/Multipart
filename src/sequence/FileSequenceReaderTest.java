package sequence;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for FileSequenceReader.
 */
public class FileSequenceReaderTest {
	
	/**
	 * Constructs a file sequence consisting of one zero-byte
	 * sub-file (not the same as zero sub-files!) and tests behavior on the
	 * sequence.
	 */
	@Test public void oneEmptyFile() throws IOException {
		InputStream sequence = new ByteArrayInputStream(new byte[]{0,0,0,0});
		
		Assert.assertArrayEquals("doesn't return zero-length sub-file",
				FileSequenceReader.readOneFile(sequence), new byte[0]);
		
		Assert.assertEquals("didn't read all four bytes",
				sequence.read(), -1);
		
		Assert.assertNull( "didn't detect end of sequence",
				FileSequenceReader.readOneFile(sequence) );
	}
}
