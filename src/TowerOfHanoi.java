
/*  where you try to move disks from one peg to another peg using only 3 pegs
    cannot place large disk over small */

public class TowerOfHanoi {
    static void TOH(int n, char from, char aux, char to) {
        if (n > 0) {
            TOH(n - 1, from, to, aux);
            System.out.println("move " + n + " from " + from + " to " + to);
            TOH(n - 1, aux, from, to);
        }
    }
    public static void main(String[] args){
        int n = 3;
        TOH(n, 'a', 'b', 'c');
    }
}
