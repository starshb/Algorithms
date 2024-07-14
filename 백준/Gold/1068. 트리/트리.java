import java.util.*;
 
public class Main {
 
    static int n, delete;
    static int[] parent;
    static int count;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        parent = new int[n];
        int root = 0;
        for(int i = 0; i < n; i++) {
            parent[i] = scan.nextInt();        
            if(parent[i] == -1) root = i;
        }
        delete = scan.nextInt();
        
        deleteNode(delete);
            
        count = 0;
        visited = new boolean[n];
        countLeaf(root);
            
        System.out.println(count);
    }
    
    public static void deleteNode(int d) {
        parent[d] = -2; //삭제된 노드 -2로 표시
        for(int i = 0; i < n; i++) {
            if(parent[i] == d) {
                deleteNode(i);
            }
        }
    }
    
    public static void countLeaf(int s) {
        boolean isLeaf = true;
        visited[s] = true;
        if(parent[s] != -2) {
            for(int i = 0; i < n; i++) {
                if(parent[i] == s && visited[i] == false) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }
}