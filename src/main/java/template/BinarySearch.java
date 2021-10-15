package template;


//https://www.youtube.com/watch?v=v57lNF2mb_s&t=1096s
public class BinarySearch {

  int findVal(int [] arr,int key){
    int l=0;
    int r=arr.length;
    while (l<r){
      int mid=(l+r)/2;
      if(arr[mid]==key) return mid;
      if(key<arr[mid]){
        r=mid;
      }else {
        l=mid+1;
      }
    }

    return -1;
  }

  int upperBound(int []arr, int key){
    int l=0;
    int r=arr.length;
    while (l<r){
      int m=(l+r)/2;

      if(arr[m]> key){
        r=m;
      }else{
        l=m+1;
      }
    }

    return l;
  }


  int lowerBound(int []arr, int key){
    int l=0;
    int r=arr.length;
    while (l<r){
      int m=(l+r)/2;
      if (key<=arr[m]){
          r=m;
      }else {
        l=m+1;
      }
    }
    return l;
  }
}
