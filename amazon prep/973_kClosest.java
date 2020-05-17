// 973. K Closest Points to Origin

// We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

// (Here, the distance between two points on a plane is the Euclidean distance.)

// You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

// Example 1:

// Input: points = [[1,3],[-2,2]], K = 1
// Output: [[-2,2]]
// Explanation: 
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
// Example 2:

// Input: points = [[3,3],[5,-1],[-2,4]], K = 2
// Output: [[3,3],[-2,4]]
// (The answer [[-2,4],[3,3]] would also be accepted.)
 

// Note:

// 1 <= K <= points.length <= 10000
// -10000 < points[i][0] < 10000
// -10000 < points[i][1] < 10000

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Heap heap = new Heap(points);
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = heap.removeMin();
        }
        return result;
    }

    class Heap {
        int[][] data;
        int size;

        public Heap(int[][] inputs) {
            size = inputs.length;

            // We can either not do it inplace:
            // data = new int[size][2];
            // for (int i = 0; i < inputs.length; i++) {
            //     data[i][0] = inputs[i][0];
            //     data[i][1] = inputs[i][1];
            // }

            // or do it inplace
            data = inputs;
            heapify();
        }

        public int[] removeMin() {
            if (size == 0) return null;
            int[] result = new int[2];
            result[0] = data[0][0];
            result[1] = data[0][1];
            swap(0, size - 1);
            size--;
            shiftDown(0);
            return result;
        }


        private void heapify() {
            for (int i = (size - 2) / 2; i >= 0; i--) {
                shiftDown(i);
            }
        }

        private boolean smallerThan(int[] point1, int[] point2) {
            return Math.pow(point1[0], 2) + Math.pow(point1[1], 2)
                    < Math.pow(point2[0], 2) + Math.pow(point2[1], 2);
        }

        private void shiftDown(int i) {
            if (i * 2 + 2 > size) return;
            else {
                int index = indexOfSmallerChild(i);
                if (smallerThan(data[index], data[i])) {
                    swap(index, i);
                    shiftDown(index);
                }
            }
        }

        private void swap(int i, int j) {
            int[] temp = new int[2];
            temp[0] = data[i][0];
            temp[1] = data[i][1];
            data[i][0] = data[j][0];
            data[i][1] = data[j][1];
            data[j][0] = temp[0];
            data[j][1] = temp[1];
        }

        private int indexOfSmallerChild(int i) {
            if (i * 2 + 3 > size) return i * 2 + 1;
            else {
                return smallerThan(data[i * 2 + 1], data[i * 2 + 2]) ? i * 2 + 1 : i * 2 + 2;
            }
        }
    }
}