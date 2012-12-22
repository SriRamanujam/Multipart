package multipart;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Static class for reading from a multipart stream.
 * <p>
 * The format for multipart manifests can be found
 * <a href="http://mit.edu/6.005/www/fa08/projects/multipart/assignment.html#specification">here</a>.
 */
public class Multipart {	
	/**
	 * Returns an InputStream which streams from the given url.
	 * <p>
	 * If the url ends with the suffix .parts or has the MIME type
	 * text/parts-manifest it is treated as a multipart manifest stream,
	 * and the returned InputStream streams the data represented by the manifest,
	 * not the contents of the manifest itself.
	 * <p>
	 * Otherwise, when the url does not point to a manifest,
	 * the returned input stream streams data directly from the url target.
	 */
	public static InputStream openStream(String url)
		throws IOException {
		// TODO your code here.
        InputStream input = new URL(url).openStream();
		// throw new RuntimeException("not yet implemented!");
        return input;
	}
}
