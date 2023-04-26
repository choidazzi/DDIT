package Exercise.Exercise230402.book;

import java.io.PrintStream;

public class ScienceFiction extends Book{
	public ScienceFiction(String title, String author) {
		super(title, author);
	}
	
	@Override
	public int getLateFee(int lateDays) {
		return 600 * lateDays;
	}
}

