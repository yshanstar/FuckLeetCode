package hack.Others;

/*
Given an array and a range [lowVal, highVal], the task is to complete the function  threeWayPartition which partition the array around the range such that array is divided in three parts.
1) All elements smaller than lowVal come first.
2) All elements in range lowVal to highVal come next.
3) All elements greater than highVal appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified arranged array.

Examples:

Input: A[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}
        lowVal = 14, highVal = 20
Output: A[] = {1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54}

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array (A[]).

Output:
For each test case the output will be 1 if the array is properly arranged else it would be 0.

Constraints:
1<=T<=100
1<=N<=100
1<=A[]<=1000

Example(To be used only for expected output):
Input:
2
5
1 2 3 3 4
1 2
3
1 2 3
1 3
Output:
1
1

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.


Reference: https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/

 */
public class ThreeWayPartitioning {
    public static void threeWayPartition(int[] arr, int pivot) {
        int pos = fixSmaller(arr, pivot);
        fixLarger(arr, pivot, pos);
    }

    private static int fixSmaller(int[] arr, int pivot) {
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivot) {
                int tmp = arr[start];
                arr[start] = arr[i];
                arr[i] = tmp;
                start++;
            }
        }
        return start;
    }

    private static void fixLarger(int[] arr, int pivot, int startPos) {
        int end = arr.length - 1;
        for (int i = startPos; i < end; ) {
            if (arr[i] > pivot) {
                int tmp = arr[end];
                arr[end] = arr[i];
                arr[i] = tmp;
                end--;
            } else {
                i++;
            }
        }
    }


    public static void main(String[] args) {


        int arr[] = {1, 8, 7, 4, 5, 5, 2, 9, 1, 6, 2, 3, 9, 5, 5, 5};

        threeWayPartition(arr, 5);

        System.out.println("Modified array ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }
}
