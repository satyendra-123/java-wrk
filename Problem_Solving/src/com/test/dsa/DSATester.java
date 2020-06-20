package com.test.dsa;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DSATester {
	int a = 10;

	public static void main(String[] args) {

		DSATester dsaTester = new DSATester();
		//dsaTester.testValueByRef();		
		//dsaTester.testIfThrowError();
		//findMean(new int[][] { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 6, 7 } });
		/*findKnightAllPositions(3, 3, 8,
				new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, });*/
		//printPascalTriangle(9);
		//shortestDistanceOfChar("helloworld", 'l');
		//dsaTester.myDate();
		
		//findSubarrayWithGivenSum(new int[] { 2, 3, 5, 6, 8, 9}, 16);
		//getNonPrime(100);
        //testInOrderTraverse();
        //printInTriangle(new int[] { 1, 2, 3, 4, 5, 6});
	}
	
	void booleanWithBinaryOperator() {
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = true;
		if (b1 & b2 | b2 & b3 | b2) {
			System.out.println("false");
		}else if(b1 & b2 | b2 & b3 | b3) {
			System.out.println("true");
		}
	}

	void testValueByRef() {
		int[] a1 = { 1, 3, 4 };
		fix(a1);
		System.out.println(Arrays.toString(a1));
	}

	int[] fix(int[] a2) {
		a2[2] = 8;
		return a2;
	}
	
	void testIfThrowError(){
		try {
			throw new Error();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("finally throw err");
		}
		System.out.println("Done Throw Error");
	}

	// Mean of two arrays
	private static void findMean(int arr[][]) {
		int result = 0;
		for (int arr1[] : arr) {
		}
		System.out.println(result);
	}

	// Not working
	private static void findKnightAllPositions(int x, int y, int size, int[][] chess) {
		int[][] foundArr = new int[8][8];
		int i = x;
		while (i >= 0 || i <= 7) {
			int j = y;
			while (j >= 0 || j <= 7) {
				if (chess[i][j] == 1) {
					foundArr[i][j] = 1;
				} else {
					foundArr[i][j] = 0;
				}

				if (j == 7)
					j = y;
				if (j == 0)
					break;
				if (j >= y && j < 7)
					j++;
				if (j <= y && j > 0)
					j--;
			}
			if (i == 7)
				i = x;
			if (i == 0)
				break;
			if (i >= x && i < 7)
				i++;
			if (i <= x && i > 0)
				i--;
		}

		System.out.println(Arrays.stream(foundArr).map(a -> String.join(" ", String.valueOf(a)))
				.collect(Collectors.joining(", ")));

	}

	//pairs to get sum from an array
	//{1,2-3,4,5} -> 3 [1,2] . 1 [-3, 4]

	// String str = "helloworld" char c = 'l'
	// shortest distance from each character
	private static void shortestDistanceOfChar(String str, char c) {
		char[] ch = str.toCharArray();
		int[] disArr = new int[ch.length];
		int beginIndex = str.indexOf(c);
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != c && i < beginIndex) {
				disArr[i] = beginIndex - i;
			}
			if (ch[i] == c) {
				beginIndex = i;
				disArr[i] = beginIndex - i;
			}
			if (ch[i] != c && i > beginIndex) {
				int nxtIndex = str.indexOf(c, i);
				if (nxtIndex == -1) {
					disArr[i] = i - beginIndex;
				} else {
					disArr[i] = Integer.min(i - beginIndex, nxtIndex - i);
				}
			}
		}
		System.out.println(Arrays.toString(disArr));
		
	}

	// Formulate the situation when
	// x to reach y if 6 to 20 [ only multiply 2 or subtract 1]min number of
	// possible ways

	// pascal triangle
	/*
	 * N = 5 x = 0 to 4 y = 0 to (N*2-1)-1 WHEN N > 2 y = 0 to 1 N = 1 y = 0 to 2 N
	 * = 2 result = 1; result = result * 11 ----1---- ---1-1--- --1-2-1-- -1-3-3-1-
	 * 1-4-6-4-1
	 */
	private static void printPascalTriangle(int N) {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < ((N * 2) - 1); j++) {
				if (i == 0) {
					printOuterSpace(N - i);
					result = 1;
					System.out.print(result);
					printOuterSpace(N - i);
				}
				if (i > 0) {
					printOuterSpace(N - i);
					result = result * 11;
					printInnerItem(String.valueOf(result).split(""));
					printOuterSpace(N - i);
				}
				break;
			}
			System.out.println();
		}

	}

	private static void printOuterSpace(int n) {
		for (int i = 0; i < n - 1; i++) {
			System.out.print(" ");
		}
	}

	private static void printInnerItem(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(" ");
			}
		}
	}

	// intersection of n lists
	// common characters in n strings
	private void findCommonCharacters() {
		
	}
	
	void myDate() {
		LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));
		
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		isoFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		System.out.println(isoFormat.format(new Date()));
		
		
		//Date date = isoFormat.parse("2010-05-23T09:01:02");
	}
	
	//find subarray with given sum
 static void findSubarrayWithGivenSum(int[] arr, int sum) {
		//find the first continuous subarray of an array
		//find the all continuous subarrays of an array 
	    int arr1 [] = null;
		int count = 0;
		boolean found = false;
		while(!found) {
			arr1 = new int[arr.length];
			int var = 0;
			for(int i = count; i< arr.length; i++) {
				arr1[var] = arr[i];	
				int tempSum = sumarr(arr1);
				if(arr[i] == sum ||  tempSum == sum) {
					found = true;
					break;
				}
				if(tempSum > sum || i == arr.length - 1) {
					count++;
					break;
				}			
				var++;
			}
		}
		System.out.println(Arrays.toString(arr1));

	}
	
	private static int  sumarr(int[] ar) {		
		return 	Arrays.stream(ar).sum();
	}
	
	//find non prime numbers sieve
	private static void getNonPrime(int N) {
		int[] testPrime = new int[N];	
		
		for(int i =0; i<testPrime.length; i++) testPrime[i] = i;
		
		Set<Integer> nonPrimes = new HashSet<>();
		
		//run through the array which are to be marked
		for(int i=2; i*i <N; i++) {
				
			//for each element which is coming need to check if its not marked yet ?? mean we need to mark the succesive items
			//if 2-> 4,6,8,10,12 etc must be marked
			//if 3 -> 6,9,12,15,18 etc must be marked
			//if 4 -> is it marked yes then no need to go 
			//mark mean put that value to a set as we need to find all unique first 50 values (non prime) and we need to make that value as 0
			if(testPrime[i] != 0) {
					for(int j=i+i; j<N; j=j+i) {
						nonPrimes.add(testPrime[j]);
						testPrime[j] = 0;//marked as touched;
						
					}					
			}
		}
		nonPrimes.forEach(s -> System.out.print(s+"\t")); 
		
		System.out.println("------------------------");
		
		IntStream.of(testPrime).filter(c-> c != 0).forEach(d-> System.out.print(d+" ")); ;
	}


	//test the inorder traversal
    private static void testInOrderTraverse(){
	    Node node = new Node(1);
	    node.left = null;
	    node.right = null;

	    node.left = new Node(2);
	    node.right = new Node(3);
	    node.left.left = new Node(4);
	    node.left.right = new Node(5);

        traverseTree(node, true);

       Node m_tree = mirrorTree( node);
        System.out.println("-------------");
        traverseTree(m_tree, true);
    }

    private static void traverseTree(Node root, boolean isOdd){
	    if(root == null)
	        return ;
            System.out.printf("%d", root.getData());
        traverseTree(root.left, !isOdd);
        traverseTree(root.right, !isOdd);
    }

    private static Node mirrorTree( Node root){
	    if(root == null){
	        return null;
        }
	    Node left = mirrorTree(root.left);
	    Node right = mirrorTree(root.right);
	    Node temp = left;
	    left = right;
	    right = temp;
	    root.left = left;
	    root.right = right;
	    return root;
    }
	
	//a string which contains a string as its substring and palindrom count the number of operations
	//aaaaa bbb -> abbba = 3, archit , ar-> arccra = 3

    //programmerxzprogrammer -> find indices

    //common character among all strings

    //print an array in triangle order {1,2,3,4,5}
    /**
     *   1
     *   12
     *   123
     *   1234
     *   12345
     */
	private static void printInTriangle(int[] arr){
        for(int i=0; i<arr.length; i++){
            String s = arr[i]+"";
            System.out.println(s);
            if(i == arr.length-1){
                break;
            }
            for(int j=i+1; j< arr.length; j++){
                s = s+arr[j];
                System.out.println(s);
            }
        }
    }

    // BFS /DFS traversal

	//tic tac toe game
}
