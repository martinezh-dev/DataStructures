import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record SimpleDate(LocalDate date) implements Comparable<SimpleDate> {

	// Single M/d/yyyy pattern handles both 1-digit and 2-digit months/days (e.g.,
	// 9/3 vs 10/23)
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("M/d/yyyy");

	public static SimpleDate parse(String text) {
		return new SimpleDate(LocalDate.parse(text, FORMATTER));
	}

	@Override
	public int compareTo(SimpleDate other) {
		return this.date.compareTo(other.date);
	}

	@Override
	public String toString() {
		return date.format(FORMATTER);
	}
}