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
            end = middle - 1;
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
