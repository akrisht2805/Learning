
public class Sorting {
    public static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n; i++){
            int minIndex = 0;
            int mini = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                if( arr[j]<mini ){
                    mini = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void bubbolSort(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; i++){
            boolean isSwap = false;
            for(int j=1; j<n; j++){
                if( arr[j-1] > arr[j] ){
                    isSwap = true;
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1]= temp;
                }
            }
            if(isSwap == false){
                break;
            }
        }
    }

    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i=1; i<n; i++){
            int j = i;
            while( j>0 && arr[j] < arr[j-1] ){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1]= temp;
                j--;
            }
        }
    }


    public static void mergeSort(int arr[]){
        int n = arr.length;
        mergeSortImpl(arr,0,n-1);
    }

    public static void mergeSortImpl(int arr[],int low, int high){
        if( low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergeSortImpl(arr,low, mid);
        mergeSortImpl(arr,mid+1, high);
        merge(arr,low, high);
    }

    public static void merge(int arr[], int low, int high){
        int mid = (low+high)/2;
        int newArr[] = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while( i<= mid && j<= high ){
            if( arr[i]<= arr[j] ){
                newArr[k] = arr[i];
                i++;
            }
            else {
                newArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i<=mid){
            newArr[k] = arr[i];
            i++;
            k++;
        }

        while (j<=high){
            newArr[k] = arr[j];
            j++;
            k++;
        }

        k = 0;
        for(i=low; i<= high; i++){
            arr[i] =newArr[k];
            k++;
        }

    }

    public static void quickSort(int arr[]){
        quickSortImpl(arr,0,arr.length-1);
    }

    public static void quickSortImpl(int arr[], int low, int high){
        if(low>=high){
            return;
        }
        int partitionIndex = partition(arr,low,high);
        quickSortImpl(arr,low,partitionIndex-1);
        quickSortImpl(arr,partitionIndex+1, high);
    }

    public static int partition(int arr[], int low,int high){
        int pivot = arr[low];
        int i = low, j = high;
        while (i<j){
            while (arr[i]<=pivot && i<=high-1){
                i++;
            }
            while (arr[j]>pivot && j>=low-1){
                j--;
            }
            if( i<j ){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }


    public static void main(String[] args) {

        int arr[] = {234,1,43,23,54,65,23,4,5};
//        selectionSort(arr);
//        bubbolSort(arr);
//        insertionSort(arr);
//        mergeSort(arr);
        quickSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
