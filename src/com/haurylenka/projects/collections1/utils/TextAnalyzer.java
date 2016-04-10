package com.haurylenka.projects.collections1.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.haurylenka.projects.collections1.exceptions.TextAnalyzerException;

public class TextAnalyzer {

	private TextAnalyzer() {}
	
	public static Map<String, Integer> getWordOccurrence(String path) {
		final String REGEX = "\\s+\\W|\\s|\\W\\s|\\W";
		Map<String, Integer> map = new HashMap<>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(path));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(REGEX);
				for (String word : words) {
					if (!word.isEmpty()) {
						word = word.toUpperCase();
						Integer occ = map.get(word);
						if (occ == null) {
							map.put(word, 1);
						} else {
							map.put(word, ++occ);
						}
					}
				}
			}
			return map;
		} catch (FileNotFoundException e) {
			throw new TextAnalyzerException(e.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
}
