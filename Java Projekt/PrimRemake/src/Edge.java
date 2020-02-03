// Klasse zum Abbilden von Kanten
class Edge
{
	int v,w;
	
	public Edge(int v, int w)
	{
		this.v = v;
		this.w = w;
	}
	
	public int getVertex()
	{
		return v;
	}
	
	public int getWeight()
	{
		return w;
	}
	
	@Override
	public String toString()
	{
		return "("+v+","+w+")";
	}
	
	public boolean equals(Edge b) 
	{
		return (this.getVertex()==b.getVertex() && this.getWeight() == b.getWeight());
	}
}