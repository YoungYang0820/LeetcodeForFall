class Solution {
  // baris - the key to this problem is realizing that this is about "topological order".
  //         a topological ordering is possible if and only if the graph has no directed cycles.
  //         solution strategy will be about building a graph & then performing a DFS on this graph.
  //
  //         the following states will manage & make things easier:
  //         a. visited[i] = -1 // Not even exists
  //         a. visited[i] =  0 // Exists but not visited yet
  //         a. visited[i] =  1 // Visiting
  //         a. visited[i] =  2 // Visited

  private final int N = 26;
  public String alienOrder(String[] words) {
    boolean[][] graph = new boolean[N][N];
    int[] visited = new int[N];
    buildGraph(words, graph, visited);

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; ++i)
    {
      // baris - unvisited
      if(visited[i] == 0)
      {
        if(!dfs(graph, visited, sb, i)) return "";
      }
    }

    return sb.reverse().toString();
  }

  private void buildGraph(String[] words, boolean[][] graph, int[] visited)
  {
    // baris - -1 = does not exist
    Arrays.fill(visited, -1);
    for (int i = 0; i < words.length; ++i)
    {
      // baris - init the visited[N] array for all the characters in the current word
      for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;

      if(i > 0)
      {
        String w1 = words[i - 1];
        String w2 = words[i];
        int len = Math.min(w1.length(), w2.length());
        for(int j = 0; j < len; ++j)
        {
          char c1 = w1.charAt(j);
          char c2 = w2.charAt(j);
          if(c1 != c2)
          {
            graph[c1 - 'a'][c2 - 'a'] = true;
            break;
          }
        }
      }
    }
  }

  private boolean dfs(boolean[][] graph, int[] visited, StringBuilder sb, int i)
  {
    // baris - classical DFS walking with a twist.. twist being the state of 1 = visiting
    visited[i] = 1;
    for(int j = 0; j < N; ++j)
    {
      // baris - if connected (graph type, i.e nodes are booleans, therefore if it is true,
      //         then, by default we know that that node is initialized and the vertice has a value)
      if(graph[i][j])
      {
        if(visited[j] == 1) return false;  // baris - 1 => 1, cycle

        // baris - 0 = unvisited
        if(visited[j] == 0)
        {
          if(!dfs(graph, visited, sb, j)) return false;
        }
      }
    }

    // baris - again this is the classical DFS walking pattern here - 2 = visited
    visited[i] = 2;
    sb.append((char) (i + 'a'));
    return true;
  }
}
