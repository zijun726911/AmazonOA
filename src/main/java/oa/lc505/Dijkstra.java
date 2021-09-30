package oa.lc505;


//https://leetcode.com/problems/the-maze-ii/

import java.util.Comparator;
import java.util.PriorityQueue;

// dijkstra is priorityQueue +BFS， single source with positive path weight
class Dijkstra {

    int dX[]={0,1,0,-1};
    int dY[]={1,0,-1,0};
    int[][] maze;
    class Item{
        public Item(int dist, int y, int x) {
            this.dist = dist;
            this.y = y;

            this.x = x;
        }

        int dist;//distance between current coordinate and source
        int x;
        int y;
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        this.maze=maze;
        boolean[][] visited=new boolean[maze.length][maze[0].length];
        PriorityQueue<Item> q=new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));


        q.offer(new Item(0,start[0],start[1]));
        while (!q.isEmpty()){
            Item item = q.poll();
            int y=item.y;
            int x=item.x;
            int minDist=item.dist;

            if(y==destination[0]&&x==destination[1]) return minDist;
            if (visited[y][x]) continue; //当前节点已经被更短的距离更新过，continue; 之前先出队的一定是到该点的最短距离；仅本题适用

            visited[y][x]=true;

            for (int i = 0; i < 4; i++) {

                int step=0;
                int newX=x;
                int newY=y;
                while (inBoundary(newX,newY)&&maze[newY][newX]!=1){
                    newY+=dY[i];
                    newX+=dX[i];
                    step++;
                }
                newY-=dY[i];
                newX-=dX[i];
                step--;
                if (!visited[newY][newX]){ //if(visited[newY][newX]==true) 当前节点已经被更短的距离更新过;仅本题适用

                    q.offer(new Item(step+minDist,newY,newX));
                }

            }
        }

        return -1;
    }

    boolean inBoundary(int x, int y){
        if(x>=0&&x<maze[0].length&&y>=0&&y<maze.length) return true;
        else  return false;
    }

    public static void main(String[] args) {
        int res = new Dijkstra().shortestDistance(
                new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}},
                new int[]{0, 4},
                new int[]{4, 4}
        );
        System.out.println(res);
    }




}