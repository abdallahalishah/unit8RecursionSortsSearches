import java.util.Arrays;

/**
This program demonstrates the merge sort algorithm by
sorting an array that is filled with random numbers.
 */
public class MergeSortDemo
{  
    public static void main(String[] args)
    {  
        String[] a = {"sausage","blubber ","pencil ", "cloud ","moon ","water ","computer","school",
        "network ", "hammer ", "walking ","violently", "mediocre ","literature", "chair","two","window",
        "cords","musical","zebra","xylophone"};

        System.out.println(Arrays.toString(a));
        MergeSorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

