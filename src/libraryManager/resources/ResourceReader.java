package libraryManager.resources;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Alexander Luebbe
 *
 */
public class ResourceReader {
	private static final String BUNDLE_NAME = "libraryManager.resources.language"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ResourceReader() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
