import java.security.SecureRandom;
public class merging {
	public static int[] dropFirstElement (int[] array) {
		int[] reduced=new int[array.length-1];
		for (int i=1; i<array.length; i++) {
			reduced[i-1]=array[i];
		}
		return reduced;
	}
	public static int[] mergesort(int[] zuSortieren) {
		if (zuSortieren.length<=1) {
			return zuSortieren;	
		}
		int[] arr1 = new int[zuSortieren.length/2];
		int[] arr2 = new int[zuSortieren.length-(zuSortieren.length/2)];
		for (int i=0; i<zuSortieren.length/2; i++) {
			arr1[i]=zuSortieren[i];
		}
		for (int i=0; i<arr2.length; i++) {
			arr2[i]=zuSortieren[(zuSortieren.length/2)+i];
		}
		arr1=mergesort(arr1);
		arr2=mergesort(arr2);
		return merge(arr1, arr2);
	}
	public static int[] merge (int[] arr1, int[] arr2) {
		int[] gemerged = new int[arr1.length+arr2.length];
		int counter=0;
		while (arr1.length!=0 && arr2.length!=0) {
			if (arr1[0]<=arr2[0]) {
				gemerged[counter]=arr1[0];
				arr1=dropFirstElement(arr1);
				counter++;
			}
			else {
				gemerged[counter]=arr2[0];
				arr2=dropFirstElement(arr2);
				counter++;
			}
		}
		while (arr1.length!=0) {
			gemerged[counter]=arr1[0];
			arr1=dropFirstElement(arr1);
			counter++;
		}
		while (arr2.length!=0) {
			gemerged[counter]=arr2[0];
			arr2=dropFirstElement(arr2);
			counter++;
		}
		return gemerged;
	}
	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		int[] test = new int[100];
		for (int i=0; i<test.length; i++) {
			test[i]=random.nextInt(10000);
		}
		for (int i=0; i<test.length; i++) {
			System.out.print(i + ":" + test[i] + " ");
		}
		System.out.println();
		test=mergesort(test);
		for (int i=0; i<test.length; i++) {
			System.out.print(i + ":" + test[i] + " ");
		}
		System.out.println();
	}

}
