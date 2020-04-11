package com.shasu19p.solid_principles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// We should not give more than one responsibility to a class.
// Keep related stuff only in the class
// Move extra thing which is not required in class
// Keep it simple so that easy modification or debugging works fine

/*
Learning: In this example, we want to maintain Journal of each day.
User can add, print journal or can save journals to some file. Tenant
can load the journal details from file storage also.

 */

class Journal {
	private final List<String> entries = new ArrayList<>();
	private static int counter = 1;

	public void addEntry(String entry) {
		entries.add("" + (counter++) + ": " + entry);
	}

	public void remove(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}

	// violating SRP principle
	public void save(String fileName) throws FileNotFoundException {
		try (PrintStream ps = new PrintStream(fileName)) {
			ps.println(this);
		}
	}

	public Journal load(String fileName) {
		return null;
	}

	public Journal load(URL url) {
		return null;
	}
	// End of violating code
}

// We should move this aspect into different class as this is for responsibility 
// of Journal class for save, load. 
// Create a new class Persistence

// By moving this into separate class
// this class is independent for any future changes
// Journal can be served over HTTP request etc.
class Persistence {
	public void saveToFile(String fileName, Journal journal, boolean override) throws IOException {

		File file = new File(fileName);
		if (override || file.exists()) {

			if (!file.exists()) {
				file.createNewFile();
			}

			try (PrintStream ps = new PrintStream(fileName)) {
				ps.println(journal);
			}
		}
	}

	public Journal load(String fileName) {
		return null;
	}

	public Journal load(URL url) {
		return null;
	}
}

public class SingleResponsibilityPrinciple_01 {

	public static void main(String[] args) throws Exception {
		Journal journal = new Journal();
		journal.addEntry("Today is good day");
		journal.addEntry("Tomorrow is better day");

		System.out.println(journal);

		// =========== save into file
		Persistence ps = new Persistence();
		String fileName = "C:\\tmp\\journal.txt";
		ps.saveToFile(fileName, journal, true);

		Runtime.getRuntime().exec("notepad.exe " + fileName);
		System.out.println("Exit");
	}
}