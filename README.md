Project Report: Java Date Class Implementation

Project Overview
This Java program is designed to handle, manipulate, and analyze date information with several key functionalities:
1.	Date Validation: The program checks if entered dates are valid by considering leap years and month lengths.
2.	Day of Week Calculation: It determines the day of the week a given date falls on.
3.	Date Comparison: The program calculates the difference in days between two dates.
4.	Date Sorting: It sorts the dates in chronological order.
5.	Formatted Output: The program displays dates in a human-readable format (e.g., "January 1, 2000").

Key Components:

1. Date Class
The core of the program is the Date class which implements Comparable<Date> to enable sorting:
•	Attributes: 
o	day, month, year: These store the date components.
•	Arrays:
o	DAYS_IN_MONTH: A constant array that contains the number of days in each month of a non-leap year.
o	MONTH_NAMES: A string array holding the names of the months.
o	DAY_NAMES: A string array with the names of the days of the week.
•	Methods:
o	isValidDate(): This method validates if the date is within reasonable ranges, considering leap years.
o	isLeapYear(): Determines if a given year is a leap year.
o	getDayOfWeek(): Uses Zeller's Congruence algorithm to calculate the day of the week for a given date.
o	toDays(): Converts a given date into the total number of days since year 1. This helps calculate the difference in days between two dates.
o	calculateDifference(): Computes the absolute difference in days between the current date and another date.
o	printDate(): Outputs the date in a human-readable format (e.g., "January 1, 2023").
o	compareTo(): Implements Comparable<Date> to enable sorting by year, then month, then day.

2. Main Class
Handles user interaction and program flow:
•	The program allows the user to input multiple dates.
•	It validates user input and catches any exceptions such as invalid dates.
•	Displays the entered and sorted dates along with the corresponding weekday names.
•	Computes and shows the difference in days between the first two dates.

Key Algorithms
1.	Zeller's Congruence (in getDayOfWeek()):
o	A mathematical algorithm used to determine the day of the week for any given date.
o	Formula: h = (day + 13*(month + 1)/5 + year + year/4 + century/4 + 5*century) % 7
o	The formula adjusts for January and February by treating them as months 13 and 14 of the previous year.
2.	Date Difference Calculation:
o	The program converts each date to the total number of days since year 1 and calculates the difference in days between two dates by subtracting these values.
3.	Date Validation:
o	It checks that the year is greater than 0, the month is between 1 and 12, and the day is valid based on the month and leap year adjustments.

Error Handling
•	Invalid Date Handling: Invalid dates are caught using IllegalArgumentException. When a date is invalid, a message is displayed, and the user is prompted to enter a valid date.
•	User Input Handling: The program uses try-catch blocks to handle invalid inputs gracefully, ensuring that the program doesn't crash due to unexpected user input.
•	Leap Year Validation: The leap year calculation is carefully implemented to account for the special rules surrounding century years (divisible by 100 but not 400).

Challenges and Solutions
1.	Leap Year Calculation:
o	Challenge: Ensuring correct leap year calculations, especially considering century years.
o	Solution: The leap year check is implemented using the formula: year % 4 == 0 && (year % 100 != 0 || year % 400 == 0).
2.	Date Difference Calculation:
o	Challenge: Accurately computing the difference between distant dates.
o	Solution: By converting each date to total days since year 1 and calculating the absolute difference, the program can compute accurate date differences.
3.	Day of Week Calculation:
o	Challenge: Correctly implementing Zeller's Congruence, especially handling months January and February as months 13 and 14 of the previous year.
o	Solution: Adjust the formula to ensure January and February are treated as the 13th and 14th months of the previous year.
4.	User Input Handling:
o	Challenge: Preventing the program from crashing due to invalid input.
o	Solution: The program uses try-catch blocks to handle incorrect input and prompts the user to re-enter the date until it is valid.

Example Usage:
Sample Input:
Enter number of dates:
3
Enter date 1 (day month year):
29 2 2000
Enter date 2 (day month year):
31 4 2020
Invalid input.
Enter date 2 (day month year):
15 7 2022
Enter date 3 (day month year):
1 1 1970
Sample Output:
Entered dates:
February 29, 2000
Day of week: Tuesday
July 15, 2022
Day of week: Friday
January 1, 1970
Day of week: Thursday

The difference between 1st & 2nd date is 8176 days.

Sorted dates:
January 1, 1970
Day of week: Thursday
February 29, 2000
Day of week: Tuesday
July 15, 2022
Day of week: Friday


