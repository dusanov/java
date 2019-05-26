public class Palindrome {
    public static boolean isPalindrome(String word) {
        
            char[] wordArr = word.toCharArray();
            for (int x=0; x<=word.length() / 2  ;x++)
                if (Character.toLowerCase(wordArr[x])!=Character.toLowerCase(wordArr[word.length() - x -1])) return false;
        
            return true;
            //throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}