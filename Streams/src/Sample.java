import java.util.HashMap;

public class Sample {




    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        int target = 18;

        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i],i);
        }

//        for(int i=0; i<n; i++){
//
//           int rem = target-arr[i];
//           if( map.containsKey(rem) ){
//               System.out.println(i+" "+map.get(rem));
//           }
//        }

        int low = 0;
        int high = n-1;

        while( low<= high){
            int mid = ( low + high )/2;

            int ele = arr[mid];
            int rem = target - ele;
            if( map.containsKey(rem) ){
                System.out.println(mid+" "+map.get(rem));
                break;
            }
            else if(ele<rem){
                low = mid+1;
            }

        }


    }
}


/*
OUTPUT -
 */