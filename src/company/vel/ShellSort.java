package company.vel;

import java.util.Comparator;

public class ShellSort
{
    public static <T> void sort(T[] data, Comparator<T> comparator)
    {
        int length = data.length;
        T temp;
        for (int step = length / 2; step > 0; step /= 2)
        {
            for (int i = step; i < length; i++)
            {
                int j;
                temp = data[i];
                for (j = i; j >= step; j -= step)
                {
                    if (comparator.compare(temp, data[j - step]) < 0)
                    {
                        data[j] = data[j - step];
                    } else
                        break;
                }
                data[j] = temp;
            }
        }
    }
}
