package company.vel.utils;

import java.util.*;

public class ArrayUtils
{
    public static Integer[] toIntegerArray(String str)
    {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext())
        {
            list.add(scanner.nextInt());
        }
        return list.toArray(new Integer[0]);
    }

    public static String toString(Number[] arr)
    {
        if (arr == null)
        {
            return null;
        }
        String format1 = "%d";
        if (arr[0] instanceof Double)
        {
            format1 = "%f";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
        {
            if (i > 0)
            {
                sb.append(", ");
            }
            sb.append(String.format(Locale.ROOT, format1, arr[i]));
        }
        return sb.toString();
    }

    public static Integer[] fillArrayRnd(Integer[] array)
    {
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = rnd.nextInt();
        }
        return array;
    }
}
