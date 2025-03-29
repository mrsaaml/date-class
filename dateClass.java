import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Date implements Comparable<Date> {
    private int day, month, year;
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MONTH_NAMES = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private static final String[] DAY_NAMES = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        return day <= DAYS_IN_MONTH[month - 1];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public String getDayOfWeek() {
        int m = month;
        int y = year;

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int k = y % 100;
        int j = y / 100;
        int h = (day + 13*(m + 1)/5 + k + k/4 + j/4 + 5*j) % 7;
        return DAY_NAMES[h];
    }

    private int toDays() {
        int totalDays = 0;

        for (int y = 1; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            totalDays += (m == 2 && isLeapYear(year)) ? 29 : DAYS_IN_MONTH[m - 1];
        }

        totalDays += day;
        return totalDays;
    }

    public int calculateDifference(Date otherDate) {
        return Math.abs(this.toDays() - otherDate.toDays());
    }

    public void printDate() {
        System.out.printf("%s %d, %d\n", MONTH_NAMES[month - 1], day, year);
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Date> dates = new ArrayList<>();

        System.out.println("Enter number of dates:");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Enter date %d (day month year):\n", i);
            try {
                int day = input.nextInt();
                int month = input.nextInt();
                int year = input.nextInt();
                dates.add(new Date(day, month, year));
            } catch (Exception e) {
                System.out.println("Invalid input.");
                input.nextLine();
                i--;
            }
        }

        System.out.println("\nEntered dates:");
        for (Date date : dates) {
            date.printDate();
            System.out.println("Day of week: " + date.getDayOfWeek());
        }

        if (dates.size() >= 2) {
            int diff = dates.get(0).calculateDifference(dates.get(1));
            System.out.printf("\nThe difference between 1st & 2nd date is %d days.\n", diff);
        }

        Collections.sort(dates);

        System.out.println("\nSorted dates:");
        for (Date date : dates) {
            date.printDate();
            System.out.println("Day of week: " + date.getDayOfWeek());
        }
    }
}