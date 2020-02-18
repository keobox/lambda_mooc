package lesson3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomWords {
	
	private List<String> words;

	public RandomWords() {
		Path path = Paths.get("words");
		try {
			words = Files.lines(path).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> createList(int i) {
		IntStream randomInts = new Random().ints(i, 0, words.size());
		return randomInts.mapToObj(words::get).collect(Collectors.toList());
	}

}
