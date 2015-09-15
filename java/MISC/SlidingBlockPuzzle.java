import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class SlidingBlockPuzzle {
 
        public static void main(String[] args) throws FileNotFoundException {
               
               
                Scanner fsn = new Scanner(new File("/cs/home/as362/sliding/input.txt"));
                int tc = fsn.nextInt();
                int [][] dummyBlock = new int[tc][tc];
                for(int i = 0; i < tc; i++) {
                        for(int j = 0; j < tc;j++) {
                                dummyBlock[i][j] = fsn.nextInt();
                        }
                }
                Board board = new Board(dummyBlock,0);
               
               
                //Search the path using A*; the heuristic --> Hamilton distance
                Comparator<Board> comparator = new BoardComparator();
                PriorityQueue<Board> queue = new PriorityQueue<Board>(comparator);
                queue.add(board);
                Map<Integer, ArrayList<Integer>> cloud = new HashMap<Integer, ArrayList<Integer>>();
                ArrayList<Board> path = new ArrayList<>();
                ArrayList<Integer> pathIndex = new ArrayList<>();
                path.add(board);
                pathIndex.add(path.size()-1);
                cloud.put(board.id, pathIndex);
                ArrayList<Board> explored = new ArrayList<>();
               
                while(!queue.isEmpty()) {
                        Board current = queue.remove();
                        if(current.solved) {
                                System.out.println("Path Found");
                                for(int i = 0; i < cloud.get(current.id).size(); i++) {
                                        int temp = cloud.get(current.id).get(i);
                                        System.out.println(path.get(temp));
                                }
                                break;
                        }
                        explored.add(current);
                       
                        if(current.x0-1 >= 0) {
                            int [][] copyCurrent = current.copy();
                            copyCurrent[current.y0][current.x0] = copyCurrent[current.y0][current.x0-1];
                            copyCurrent[current.y0][current.x0-1] = 0;
                            addToQueue(queue, cloud, path, explored, current, copyCurrent);
                                  
                        }
                        if(current.x0+1 < current.blocks.length) {
                            int [][] copyCurrent = current.copy();
                            copyCurrent[current.y0][current.x0] = copyCurrent[current.y0][current.x0+1];
                            copyCurrent[current.y0][current.x0+1] = 0;
                            addToQueue(queue, cloud, path, explored, current, copyCurrent);
                         
                        }
                        if(current.y0+1 < current.blocks.length) {
                            int [][] copyCurrent = current.copy();
                            copyCurrent[current.y0][current.x0] = copyCurrent[current.y0+1][current.x0];
                            copyCurrent[current.y0+1][current.x0] = 0;
                            addToQueue(queue, cloud, path, explored, current, copyCurrent);
                         
                        }
                        if(current.y0-1 >=0) {
                            int [][] copyCurrent = current.copy();
                            copyCurrent[current.y0][current.x0] = copyCurrent[current.y0-1][current.x0];
                            copyCurrent[current.y0-1][current.x0] = 0;
                            addToQueue(queue, cloud, path, explored, current, copyCurrent);
                        }
                }

        }

		@SuppressWarnings("unchecked")
		public static void addToQueue(PriorityQueue<Board> queue, Map<Integer, ArrayList<Integer>> cloud,
				ArrayList<Board> path, ArrayList<Board> explored, Board current, int[][] copyCurrent) {
			ArrayList<Integer> pathIndex;
			boolean explore = false;
			for(int i = 0; i < explored.size(); i++) {
				if(explored.get(i).isEqualTo(copyCurrent)) {
					explore = true;
				}
			}
			if(!explore) {
			Board adj = new Board(copyCurrent, current.moves+1);
			queue.add( adj);
			pathIndex = (ArrayList<Integer>) cloud.get(current.id).clone();
			path.add(adj);
			pathIndex.add(path.size()-1);
			cloud.put(adj.id,pathIndex);
			}
		}
       
}
 
 
class Board {
        int [][] blocks;
        int hamming;
        boolean solved;
        boolean solvable;
        int x0;
        int y0;
        int moves;
        int id;
        static int totalBoard = 0;
        public Board(int [][] blocks, int moves) {
                this.id = totalBoard;
                totalBoard++;
                this.moves = moves;
                this.blocks = blocks;
                int counter = 1;
                this.solved = true;
                this.hamming = 0;
                for(int i = 0; i < blocks.length; i++) {
                        for(int j = 0; j < blocks[i].length; j++) {
                                if(blocks[i][j] == 0) {
                                        x0 = j;
                                        y0 = i;
                                }
                                if(i == blocks.length-1 && j == blocks.length-1) break;
                                if(blocks[i][j] != counter) {
                                        this.solved = false;
                                        this.hamming++;
                                }
                                counter++;
                        }
                }
                if(this.blocks[this.blocks.length-1][this.blocks.length-1] != 0) {
                        this.solved = false;
                        this.hamming++;
                }
                ArrayList <Integer> dummy  = new ArrayList<>();
                for(int i = 0; i < blocks.length; i++) {
                        for(int j = 0; j < blocks.length; j++) {
                                if(blocks[i][j] == 0) continue;
                                dummy.add(blocks[i][j]);
                        }
                }
               
                MergeSort.sort(dummy);
                int inversion = MergeSort.inversion;
                if(blocks.length % 2  ==0) {
                        inversion += this.x0;
                }
                if(inversion % 2 ==0) {
                        this.solvable = true;
                } else {
                        this.solvable = false;
                }
               
               
        }
        public int [][] copy() {
                int [][] result = new int[this.blocks.length][this.blocks.length];
                for(int i = 0; i < result.length; i++) {
                        for(int j = 0; j < result.length; j++) {
                                result[i][j] = this.blocks[i][j];
                        }
                }
                return result;
               
        }
        public int hamming() {
                return this.hamming;
        }
        public boolean isEqualTo(Board b) {
                if(b.blocks.length != this.blocks.length) return false;
                for(int i = 0; i < b.blocks.length; i++) {
                        for(int j = 0; j < b.blocks.length; j++) {
                                if(b.blocks[i][j] != this.blocks[i][j]) {
                                        return false;
                                }
                        }
                }
                return true;
        }
        
        public boolean isEqualTo(int [][] blocks) {
        	if(this.blocks.length != blocks.length) return false;
        	for(int i = 0; i < blocks.length; i++) {
        		for(int j = 0; j < blocks.length; j++) {
        			if(blocks[i][j] != this.blocks[i][j]) return false;
        		}
        	}
        	return true;
        }
       
        public boolean isGoal() {
                return this.solved;
        }
       
        public boolean isSolvable() {
                return solved;
               
        }
       
        @Override
        public String toString() {
                String result = "";
                for(int i = 0; i < blocks.length; i++) {
                        result += Arrays.toString(this.blocks[i]);
                        result += "\n";
                }
                return result;
        }
       
}
 
 
 class MergeSort {
 
    static int inversion = 0;
   
    public static void sort(ArrayList<Integer> arr) {
        inversion = 0;
        mergesort(arr);
    }
   
    public static void mergesort(ArrayList<Integer> arr) {
        if(arr.size() <2) return;
        ArrayList<Integer> left =new ArrayList<>(arr.subList(0, arr.size()/2));
        ArrayList<Integer> right =new ArrayList<>(arr.subList(arr.size()/2, arr.size()));
       
        mergesort(left);
        mergesort(right);
        merging(arr, left, right);
    }
   
   
    private static void merging(ArrayList<Integer> arr,
                                ArrayList<Integer> left, ArrayList<Integer> right) {
        arr.clear();
        while(!left.isEmpty() && !right.isEmpty()) {
            if(left.get(0) < right.get(0)) {
                arr.add(left.remove(0));
            } else {
                inversion += left.size();
                arr.add(right.remove(0));
            }
        }
       
       
        while(!left.isEmpty()) {
            arr.add(left.remove(0));
        }
        while(!right.isEmpty()) {
            arr.add(right.remove(0));
        }
    }
   
   
}
 
 
 class BoardComparator implements Comparator<Board>{
 
        @Override
        public int compare(Board o1, Board o2) {
                if((o1.moves + o1.hamming) < (o2.moves + o2.hamming)) {
                        return -1;
                } else if ((o1.moves + o1.hamming) > (o2.moves + o2.hamming)) {
                        return 1;
                }
                return 0;
        }
         
 }
