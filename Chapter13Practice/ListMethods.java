import java.util.*;

public class ListMethods
{
    public static ArrayList makeList(int n)
    {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int count = 1;
        if (n <= 0)  // The smallest list we can make
        {
            return null;

        }
        else        // All other size lists are created here
        {
            tempList.add(count);
            count++;
            makeList(n-1);
        }
        return tempList;
    }
}