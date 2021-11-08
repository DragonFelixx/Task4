package company.vel;

import company.vel.utils.ArrayUtils;

public class PerformanceTest
{
    public static double[] performanceTest(int[] sizes)
    {
        int amountArrays = sizes.length;
        double[] times = new double[amountArrays];
        Integer[][] arrays = new Integer[amountArrays][];
        for (int i = 0; i < amountArrays; i++)
        {
            arrays[i] = ArrayUtils.fillArrayRnd(new Integer[sizes[i]]);
            for (int j = 0; j < arrays[i].length; j++)
            {
                long moment1 = System.nanoTime();
                ShellSort.sort(arrays[i], Integer::compareTo);
                long moment2 = System.nanoTime();
                times[i] = (moment2 - moment1) / 1E6;
            }
        }
        return times;
    }
}
