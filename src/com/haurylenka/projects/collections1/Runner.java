package com.haurylenka.projects.collections1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

import com.haurylenka.projects.collections1.utils.TextAnalyzer;

public class Runner {

	public static void main(String[] args) {
		final String ENTER_WORD = "Enter a word:";
		final String POSITIVE_MESSAGE = "Times occurred: ";
		final String NEGATIVE_MESSAGE = "No such a word in the text";
		try {
			Map<String, Integer> map = TextAnalyzer.getWordOccurrence(getPath());
			while (true) {
				System.out.println(ENTER_WORD);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));
				String input = reader.readLine();
				if (input != null) {
					input = input.toUpperCase();
					Integer occurrence = map.get(input);
					if (occurrence != null) {
						System.out.println(POSITIVE_MESSAGE + occurrence);
					} else {
						System.out.println(NEGATIVE_MESSAGE);
					}
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static String getPath() throws IOException {
		final String CONFIG_PATH = "resourses/config.properties";
		final String PATH_KEY = "path";
		final String SOMETHING_WRONG = "Something wrong with 'config.properties'";
		Properties props = new Properties();
		InputStream input = Runner.class.getResourceAsStream(CONFIG_PATH);
		if (input == null) {
			throw new IOException(SOMETHING_WRONG);
		}
		try {
			props.load(input);
			return props.getProperty(PATH_KEY);
		} catch (IOException e) {
			throw new IOException(SOMETHING_WRONG);
		}
	}

}
