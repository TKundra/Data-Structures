package Stack_Queue;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

    private void find(){
        String string = "jjava";
        int[] count = new int[26];
        char result = ' ';
        Queue<Character> queue = new LinkedList<>();
        for (int i=0; i<string.length(); i++){
            char ch = string.charAt(i);
            queue.add(ch);
            count[ch-'a']++;
            while (!queue.isEmpty()){
                if (count[queue.peek()-'a'] == 1) {
                    result = queue.peek();
                    break;
                } else {
                    queue.remove();
                }
            }
            if (queue.isEmpty())
                System.out.print(-1 + " ");
        }
        System.out.print(result+" ");
    }

    public static void main(String[] args){
        FirstNonRepeatingCharacter function = new FirstNonRepeatingCharacter();
        function.find();
    }

}
