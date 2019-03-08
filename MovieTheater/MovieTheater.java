package MovieTheater;

public class MovieTheater {
    private static boolean[] theater = {false, false, false, false, false, false, false, false};
    private static int lastSeat = 0;

    public static int findSeat(int start, int end) {
        int middle = (start + end) / 2;

        if(!theater[middle]){
            lastSeat = middle;
            return middle;
        }else if(lastSeat - start > end - lastSeat){
            end = middle - 1;package MovieTheater;

import java.util.Scanner;

public class MovieTheater {
    private static boolean[] movieTheater;

    /**
     * Finds the largest gap in the theater row
     *
     * @return the Integer ArrayList with the indexes of the largest gap
     */
    public static int[] findLargestGap() {
        int[] gapIndex = new int[2];
        int lastMaxGap = 0, highestGapIndex = 0, lowestGapIndex = 0;

        for (int i = 0; i < movieTheater.length; i++) {
            if (movieTheater[i]) {
                lowestGapIndex = i + 1;
                highestGapIndex = 0;
            } else highestGapIndex += 1;

            if (highestGapIndex > lastMaxGap) {
                lastMaxGap = highestGapIndex;
                gapIndex[0] = lowestGapIndex;
                gapIndex[1] = i;
            }
        }

        return gapIndex;
    }

    /**
     * Locate the final index of the seat for this theater
     *
     * @param gap the gap where there are no seats taken
     * @return the index where the seat is to be placed
     */
    public static int findSeat(int[] gap) {
        int place = (gap[1] - gap[0]);
        place = place / 2;

        return gap[1] - place;
    }

    /**
     * Prints the movie theater with X representing a taken seat
     */
    public static void printSeats() {
        for (boolean seat : movieTheater) {
            if (seat) {
                System.out.print("X ");
            } else {
                System.out.print("_ ");
            }
        }

        System.out.println();
    }

    /**
     * Seats the person in the theater and marks the seat as occupied
     */
    public static void seatPerson() {
        for (int i = 0; i < movieTheater.length; i++) {
            printSeats();
            int seat = findSeat(findLargestGap());
            movieTheater[seat] = true;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many seats are in the theater? ");
        int size = input.nextInt();
        movieTheater = new boolean[size];

        movieTheater[size / 2] = true;
        seatPerson();

        movieTheater = new boolean[size];
        int seat = (int) (Math.random() * (size + 1));
        movieTheater[seat] = true;
        seatPerson();
    }
}


            return findSeat(start, end);
        }else if(lastSeat - start < end - lastSeat){
            start = middle + 1;
            return findSeat(start, end);
        }
        return -1;
    }


    public static void printSeats() {
        for (Comparable seat : theater) {
            if (seat.equals(true)) {
                System.out.print("X ");
            } else if (seat.equals(false)) {
                System.out.print("_ ");
            } else {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        int startRow = 0;
        int endRow = theater.length - 1;

        for (int i = 0; i < theater.length; i++) {
            if(findSeat(0, theater.length - 1) > 0){
                if (!theater[i]) {
                    printSeats();
                    System.out.println();
                    theater[findSeat(startRow, endRow)] = true;
                }
            }
        }
    }
}
