import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {

	public static void main(String[] args){

		int[] arr = { 18, 15, 2, 3 , 21 , 11,3, 100, 55, 33};


		//		selctionSort(arr);
		//		insertionSort(arr);
		//		bubbleSort(arr);
		//		mergeSort(arr, 0, arr.length-1);
			quickSort(arr, 0, arr.length-1);
		printArray(arr);
		
		
		
	}
	
	static void selctionSort(int[] arr){ //선택정렬

		for(int i = 0 ; i < arr.length-1 ; i++){
			for(int j = i ; j< arr.length-1; j++ ){
				//오름차순
				if(arr[i] > arr[j+1] ){
					int temp = arr[i];
					arr[i] = arr[j+1];
					arr[j+1] = temp;

				}
			}
		}

	}

	static void insertionSort(int[] arr){ //삽입정렬
		for(int i = 1 ; i < arr.length-1 ; i++){
			int tempIdx = i ;
			int temp = arr[i];
			for(int j = i-1 ; j >= 0 ; j--){
				//오름차순
				if(temp < arr[j] ){
					arr[tempIdx] = arr[j];
					arr[j] = temp;
				}
				tempIdx--;
			}
		}
	}

	static void bubbleSort(int[] arr){

		int count = 0; //중간 멈춤을 위함

		for(int i = 0 ; i < arr.length-1; i++){

			for(int j = 0 ; j < arr.length-1-i; j++){

				if(arr[j] > arr[j+1]){
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					count++;
				}
			}
			if(count == 0){
				break;
			}
			count = 0 ;
		}



	}

	static void mergeSort(int[] arr, int low, int high){ //합병정렬
		if( low < high){
			int middle = (low + high) / 2;

			mergeSort(arr, low, middle);
			mergeSort(arr, middle+1, high);
			merge(arr,low,middle,high);


		}
	}

	static void merge(int[] arr, int low, int middle , int high){

		int current = low, left = low, right = middle+1;

		int[] temp = new int[arr.length];

		for(int i = 0 ; i < arr.length ; i++){
			temp[i] = arr[i];
		}

		while(left <= middle && right <=high){

			if(temp[left] <= temp[right]){
				arr[current++] = temp[left++];
			}else{
				arr[current++] = temp[right++];
			}
		}
		//나머지 정리
		while(left<=middle){
			arr[current++] = temp[left++];
		}
		while(right <= high){
			arr[current++] = temp[right++];
		}


	}



	static void quickSort(int[] data, int l, int r){
		int left = l;
		int right = r;
		int pivot = data[(l+r)/2];

		do{
			while(data[left] < pivot) left++;
			while(data[right] > pivot) right--;
			if(left <= right){    
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		}while (left <= right);

		if(l < right) quickSort(data, l, right);
		if(r > left) quickSort(data, left, r);
	}







	public static  void printArray(int array[]) {

		for (int element : array) {

			System.out.print(element + " ");

		}

		System.out.println("");

	}

}
