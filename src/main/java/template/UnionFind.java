package template;

public class UnionFind {
  int []parent;
  int n;
  public UnionFind(int n){
    parent=new int[n];
    for (int i = 0; i < n; i++) {
      parent[i]=i;
    }
    this.n=n;

  }

  int find(int i){
    if(parent[i]!=i) {
      parent[i]=find(parent[i]);
    }
    return parent[i];
  }

  void union(int i,int j){
    int parentI=find(i);
    int parentJ=find(j);
    if(parentI!=parentJ){
      parent[parentI]=parentJ;
      n--;
    }
  }




}

//https://leetcode.com/problems/number-of-provinces/  lc 547
class Solution {
  public int findCircleNum(int[][] isConnected) {
    UnionFind uf=new UnionFind(isConnected.length);
    for (int i = 0; i < isConnected.length; i++) {
      for (int j = i+1; j < isConnected[0].length; j++) {
        if(isConnected[i][j]==1){
          uf.union(i,j);
        }
      }
    }

    return uf.n;
  }
}
