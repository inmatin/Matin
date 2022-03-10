
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * File Name: Matin.java<br>
 * Author: Ishtiaque Matin, ID# 041042199<br>
 * Professor: Sandra Iroakazi<br>
 * Course: CST8284_302<br>
 * Assignment: Lab 01<br>
 * Date: Jan 24th, 2022<br>
 * <p>
 * Purpose:
 * <p>
 * A simple program to implement user input for (and also show the output of)
 * the Your name. Student number. Two reasons why you are taking this
 * course.<br>
 * If your student number ends with an odd number: Compute the remaining weeks
 * till the end of your program and subtract 1 from the result.<br>
 * If your student number ends with an even number Compute the number of the
 * remaining months in the year 2022 and add 1 to the result.
 * <p>
 * Class List: Matin
 * <p>
 * 
 * If your student number ends with an odd number: Compute the remaining weeks
 * till the end of your program and subtract 1 from the result. If your student
 * number ends with an even number Compute the number of the remaining months in
 * the year 2022 and add 1 to the result.
 * 
 * @author Ishtiaque Matin, ID# 041042199
 * @version Modified: Jan 24th, 2022
 * 
 * @see LocalDate
 * @see LocalDateTime
 * @see DateTimeFormatter
 * @see ChronoUnit
 * @see Scanner
 * 
 * @since JDK 1.8
 */

public class Matin {
	/**
	 * The main method gathers the information from the user to enter their name,
	 * student number and two reasons for taking the course. Then compute the
	 * student number to see if it end in odd or even number. If odd number then it
	 * computes the remaining weeks till the end of the program and subtract 1 from
	 * the result. If even number then computes the number of the remaining months
	 * in the year 2022 and 1 to the result.
	 * <p>
	 * 
	 * @param args an array of command-line arguments for the main method
	 * 
	 *             <p>
	 *             <u>instance variables:</u>
	 * 
	 *             <p>
	 *             int number = student number;<br>
	 *             String name = student name;<br>
	 *             String reason1 = first reason to take the course;<br>
	 *             String reason2 = second reason to take the course;<br>
	 *             String endSemester = "30/04/2023";<br>
	 *             String endYear = "31/12/2022";<br>
	 *             String formatDate = store today's date formatted;<br>
	 *             String formatToday = store today's date formatted;<br>
	 * 
	 */

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		LocalDateTime todayDate = LocalDateTime.now();

		/**
		 * instance variables
		 */
		int number;
		String name;
		String reason1;
		String reason2;
		String endSemester = "30/04/2023";
		String endYear = "31/12/2022";
		String formatDate;
		String formatToday;

		System.out.print("What is your name? ");

		/**
		 * create name object to store student name
		 */
		name = input.nextLine();

		System.out.print("What is your Stundent Number ? ");

		/**
		 * create number object to store student number
		 */

		number = input.nextInt();

		/**
		 * Consume newline left-over so the nextLine input is executed. If not it jumps
		 * the string input.
		 */

		input.nextLine();

		System.out.print("Reason 1: Why are you taking this course ? ");

		/**
		 * create reason1 object to store first reason
		 */

		reason1 = input.nextLine();

		System.out.print("Reason 2: Why are you taking this course ? ");

		/**
		 * create reason2 object to store second reason
		 */

		reason2 = input.nextLine();

		System.out.println("\nName of the Student: " + name);
		System.out.println("Student Number: " + number);

		System.out.println("Reason 1: " + reason1);
		System.out.println("Reason 2: " + reason2);

		/**
		 * create formatDateObj object to format the date Month/Day/Year.
		 */
		DateTimeFormatter formatDateObj = DateTimeFormatter.ofPattern("MMM / dd / uuuu");

		/**
		 * create formatDate object to store today's date formatted
		 */
		formatDate = todayDate.format(formatDateObj);
		System.out.println("Today's Date: " + formatDate);

		/**
		 * create todayDateObj object to format the date as Day/Month/Year.
		 */
		DateTimeFormatter todayDateObj = DateTimeFormatter.ofPattern("dd/MM/uuuu");

		/**
		 * create formatToday to store today's date formatted
		 */
		formatToday = todayDate.format(todayDateObj);

		/**
		 * if statement to test if student number is divisible by 2 then it'a an even
		 * number or else an odd number
		 */

		if (number % 2 == 0) {
			/**
			 * if statement executed when we have an even number.
			 */

			/**
			 * create calculateDateObj to format the date as Day/Month/Year.
			 */
			DateTimeFormatter calculateDateObj = DateTimeFormatter.ofPattern("dd/MM/uuuu");

			/**
			 * create date1, date2 object to store formatted dates
			 */
			LocalDate date1 = LocalDate.parse(formatToday, calculateDateObj);
			LocalDate date2 = LocalDate.parse(endYear, calculateDateObj);

			/**
			 * create daysBetween object to store days between the two date
			 */
			long daysBetween = ChronoUnit.MONTHS.between(date1, date2);

			/**
			 * since the student number ends with an even number we add 1 to the result.
			 */
			daysBetween = daysBetween + 1;

			/**
			 * if statement to ensure dayBetween is a positive number else convert it to a
			 * positive number
			 */
			if (daysBetween > -1) {
				System.out.println("Months till graduation: " + daysBetween + " months");
			} else {
				System.out.println("Months till graduation: " + daysBetween * -1 + " months");
			}
		} else {
			/**
			 * this else clause it executed when we have an odd number.
			 */

			/**
			 * create calculateDateObj to format the date as Day/Month/Year.
			 */
			DateTimeFormatter calculateDateObj = DateTimeFormatter.ofPattern("dd/MM/uuuu");

			/**
			 * create date1, date2 object to store formatted dates
			 */
			LocalDate date1 = LocalDate.parse(formatToday, calculateDateObj);
			LocalDate date2 = LocalDate.parse(endSemester, calculateDateObj);

			/**
			 * create daysBetween object to store days between the two date
			 */
			long daysBetween = ChronoUnit.WEEKS.between(date1, date2);

			/**
			 * since the student number ends with an odd number we subtract 1 from the
			 * result.
			 */
			daysBetween = daysBetween - 1;

			/**
			 * if statement to ensure dayBetween is a positive number else convert it to a
			 * positive number
			 */
			if (daysBetween > -1) {
				System.out.println("Days till graduation: " + daysBetween + " weeks");
			} else {
				System.out.println("Days till graduation: " + daysBetween * -1 + " weeks");
			}
		}
		/**
		 * printing the name of the creator.
		 */
		System.out.println("\nProgram by Ishtiaque Matin ");

		/**
		 * close scanner API.
		 */

		input.close();

	}

}
