package MovieTheater;

public class MovieTheater {
    private static Comparable[] theater = {false, false, false, false, false, false, false, false};

    public static int binarySearch(Comparable[] array, Comparable target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            int compared = array[middle].compareTo(target);
            if (compared == 0) {
                return middle;
            } else if (compared > 0) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

        }
        return -1;

    }

    public static boolean ifFull(){
        for (int i = 0; i < theater.length; i++) {
            if(theater[i].equals(false)){
                return false;
            }
        }
        return true;
    }

    public static void printSeats(){
        for (Comparable seat :
                theater) {
            if(seat.equals(true)){
                System.out.print("X ");
            }else if(seat.equals(false)){
                System.out.print("_ ");
            }else{
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < theater.length; i++){
            if(theater[i].equals(false)){
                printSeats();
                System.out.println();
                theater[binarySearch(theater, false)] = true;
            }else if(ifFull()){
                printSeats();
                break;
            }
        }
    }
}
