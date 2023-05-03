package training_java_question689;

public class Piglatin {
	
	public static String pigLatinSentence(String s)
    {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            if (i >= s.length())
                break;
            while (i < s.length() && s.charAt(i) != ' ')
                i++;
            if (ans.isEmpty()) {
                ans = ans.concat(
                    s.substring(j + 1, i)
                    + s.charAt(j) + "a");
            }
            else {
                ans = ans.concat(
                    " " + s.substring(j + 1, i)
                    + s.charAt(j) + "a");
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        String s = "this is a tree";
        System.out.println(pigLatinSentence(s));
        
        String str = "Hai |how |are |you ";
        String words[] = str.split("[|]");
        for(String token : words) {
           System.out.print(token);
        }
        
        
    }

}
