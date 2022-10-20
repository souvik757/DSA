public class Quick_sort {
    static void swap(int a, int b)
    {
        int temp = b;
        b = a;
        a = temp;
    }

    static int partition(int[] numbs, int s, int l)
    {
        int pivot = numbs[s];
        int count = 0 ;
        for(int i = s+1 ; i <= l ; i++)
        {
            if(numbs[i]<=pivot)
                count++;
        }
        int pivotIndex = s+count;
        swap(numbs[pivotIndex],numbs[s]);
        int i = s;
        int j = l;
        while(i<pivotIndex && j>pivotIndex)
        {
            while(numbs[i]<=pivot)
                i++;
            while (numbs[j]>pivot)
                j--;
            if (i<pivotIndex && j>pivotIndex)
            {
                swap(numbs[i++],numbs[j--]);
            }
        }
        return pivotIndex;
    }
    static void quickSort(int[] numbs, int s, int l)
    {
        //base case:
        if(s>l)
        {
            int pivot = partition(numbs,s,l);
            quickSort(numbs,s,pivot-1);
            quickSort(numbs,pivot+1,l);
        }
    }

    public static void main(String[] args) {
        int[] number = new int[]{4,5,1,2,3,80,-1};
        int N = number.length;
        quickSort(number,0,N-1);
        for(int i : number)
            System.out.print(i+" ");
    }
}
