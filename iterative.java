import java.util.ArrayList;
import java.util.List;
 
class iterative
{
    public static void permutations(String s)
    {
        // create an empty ArrayList to store (partial) permutations
        List<String> partial = new ArrayList<>();
 
        // initialize the list with the first character of the string
        partial.add(String.valueOf(s.charAt(0)));
        // do for every character of the specified string
        for (int i = 1; i < s.length(); i++)
        {
            for (int j = partial.size() - 1; j >= 0 ; j--)
            {
                // remove current partial permutation from the ArrayList
                String str = partial.remove(j);
                for (int k = 0; k <= str.length(); k++)
                {
                    partial.add(str.substring(0, k) + s.charAt(i) +
                                str.substring(k));
                }
            }
        }

        System.out.println(partial);
    }

    // Iterative program to generate all permutations of a string in Java
    public static void main(String[] args)
    {
        String s = "ABC";
        permutations(s);
    }
}
