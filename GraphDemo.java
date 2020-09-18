package BoutellisWalid_Assignment6;

public class GraphDemo
{
   public static void main(String[] args)
   {
       TownGraph graph = new TownGraph();
        Town[] towns = {new Town("A"), new Town("B"), new Town("C"), new Town("D"), new Town("E"), new Town("F")};   

        graph.addEdge(towns[0], towns[1], 10, "AB");
        graph.addEdge(towns[0], towns[2], 15, "AC");
        graph.addEdge(towns[1], towns[3], 12, "BD");
        graph.addEdge(towns[1], towns[5], 15, "BF");
        graph.addEdge(towns[2], towns[4], 10, "CE");
        graph.addEdge(towns[3], towns[4], 2, "DE");
        graph.addEdge(towns[3], towns[5], 1, "DF");
        graph.addEdge(towns[5], towns[4], 5, "FE");
          
        for(int i = 1; i < towns.length; i++)
        {
           System.out.println(towns[0].getName() + " to " + towns[i].getName() + ": ");
           System.out.println(graph.shortestPath(towns[0], towns[i]) + "\n");
        }
        
        graph.removeVertex(towns[0]);
        graph.removeEdge(towns[0], towns[1], 10, "AB");
        graph.removeEdge(towns[0], towns[2], 15, "AC");
        for(int i = 1; i < towns.length; i++)
        {
           System.out.println(towns[0].getName() + " to " + towns[i].getName() + ": ");
           System.out.println(graph.shortestPath(towns[0], towns[i]) + "\n");
        }
   }
}