public class merge_two_sorted_arr {
    static void merge(int[] numbs, int s,int mid, int e)
    {
        int len1 = mid - s +1;
        int len2 = e - mid;
        int[] num1 = new int[len1];
        int[] num2 = new int[len2];
        int index = s;
        for(int i = 0 ;  i < len1 ; i++)
            num1[i] = numbs[index++];
        index = mid + 1;
        for(int i = 0 ; i < len2 ; i++)
            num2[i] = numbs[index++];
        int i1 = 0 ;
        int i2 = 0 ;
        index = s;
        while(i1 < len1 && i2 < len2)
        {
            if(num1[i1]<num2[i2])
                numbs[index++] = num1[i1++];
            else
                numbs[index++] = num2[i2++];
        }
        while (i1 < len1)
            numbs[index++] = num1[i1++];
        while(i2 < len2)
            numbs[index++] = num2[i2++];
    }

    static void mergeSort(int[] numbs, int s, int e)
    {
        //base case :
        if(s>=e)
            return;
        int mid = s + (e-s)/2;
        mergeSort(numbs,s,mid);//sorting left part
        mergeSort(numbs,mid+1,e);//sorting right part
        merge(numbs,s,mid,e);//merging both sorted parts
    }
    public static void main(String[] args) {
        int[] numbs = new int[]{10,9,12,0,1};
        mergeSort(numbs,0,numbs.length-1);
        for(int n : numbs)
            System.out.print(n+" ");
        System.out.println();
    }
}
