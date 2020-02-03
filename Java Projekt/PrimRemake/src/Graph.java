// Klasse zum Abbilden eines Graphen mithilfe von Kanten
import java.util.*;

class Graph
{

    List<Edge> G[];

    public Graph(int n)
    {
        G = new LinkedList[n];
        for (int i = 0; i < G.length; i++)
        {
            G[i] = new LinkedList<Edge>();
        }
    }

    public int getSize()
    {
        return G.length;
    }

    public boolean hasConnection(int u)
    {
        return !G[u].isEmpty();
    }

    public boolean areVertexesConnected(int u, int v)
    {
        for (Edge i : G[u])
        {
            if (i.v == v)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isGraphConnected()
    {
        boolean finished = true;

        for (int i = 0; i < this.getSize(); i++)
        {
            finished = finished && this.hasConnection(i);
        }

        return finished;
    }

    public List<Integer> getWeightsOfEdge(int u)
    {
        List<Integer> weights = new LinkedList<Integer>();

        for (Edge i : G[u])
        {
            weights.add(i.getWeight());
        }

        return weights;
    }

    public void addEdge(int u, int v, int w)
    {
        G[u].add(0, new Edge(v, w));
    }

    List<Edge> getEdges(int u)
    {
        List<Edge> edges = new LinkedList<Edge>();

        for (Edge i : G[u])
        {
            edges.add(i);
        }

        return edges;
    }

    int getAmountofEdges()
    {
        int amount = 0;
        for (int i = 0; i < getSize(); i++)
        {
            amount += getEdges(i).size();
        }

        return amount;
    }

    @Override
    public String toString()
    {
        String result = "";
        for (int i = 0; i < G.length; i++)
        {
            result += i + "=> " + G[i] + "\n";
        }
        return result;
    }

    public boolean equals(Graph b)
    {
        if (this.getSize() != b.getSize())
        {
            return false;
        }

        boolean returnval = true;
        for (int i = 0; i < this.getSize(); i++)
        {
            List<Edge> edgelistA = this.getEdges(i);
            List<Edge> edgelistB = b.getEdges(i);

            if(edgelistA.size() != edgelistB.size())
                return false;
            
            List<Edge> edgelistSortedA = new LinkedList<Edge>();
            List<Edge> edgelistSortedB = new LinkedList<Edge>();

            while (!edgelistA.isEmpty())
            {
                int lowestvertex = Integer.MAX_VALUE;
                int lowestvertexindex = 0;
                int counterSortA = 0;

                for (Edge edgeA : edgelistA)
                {
                    if (edgeA.getVertex() < lowestvertex)
                    {
                        lowestvertex = edgeA.getVertex();
                        lowestvertexindex = counterSortA;
                    }

                    counterSortA++;
                }
                edgelistSortedA.add(edgelistA.get(lowestvertexindex));
                edgelistA.remove(lowestvertexindex);
            }

            while (!edgelistB.isEmpty())
            {
                int lowestvertex = Integer.MAX_VALUE;
                int lowestvertexindex = 0;
                int counterSortB = 0;

                for (Edge edgeB : edgelistB)
                {
                    if (edgeB.getVertex() < lowestvertex)
                    {
                        lowestvertex = edgeB.getVertex();
                        lowestvertexindex = counterSortB;
                    }

                    counterSortB++;
                }
                edgelistSortedB.add(edgelistB.get(lowestvertexindex));
                edgelistB.remove(lowestvertexindex);
            }

            int counter = 0;

            for (Edge edgeA : edgelistA)
            {
                returnval = returnval && edgeA.equals(edgelistB.get(counter));

                counter++;
            }

        }

        return returnval;
    }
}
