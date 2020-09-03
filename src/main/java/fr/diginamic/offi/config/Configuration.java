package fr.diginamic.offi.config;

import java.util.ResourceBundle;

public class Configuration {

	private String driver;
	private String url;
	private String user;
	private String password;
	private String fileUrl;

	public Configuration() {
		ResourceBundle properties = ResourceBundle.getBundle("configuration");
		driver = properties.getString("jdbc.driver");
		url = properties.getString("jdbc.url");
		user = properties.getString("jdbc.user");
		password = properties.getString("jdbc.password");
		fileUrl = properties.getString("file.url");
	}

	/**
	 * Getter
	 * 
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * Getter
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Getter
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Getter
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Getter
	 * 
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return fileUrl;
	}
}
