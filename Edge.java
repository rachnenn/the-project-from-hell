
/**
 * This edge class can represent a directed on undirected edge.  Actually, it represents a directed edge.
 * Making an undirected edge actually makes two edges, one going from the vertex a to vertex b and one
 * from vertex b to vertex a.  Functionally, this is identical to an undirected edge.
 * 
 * @author Luke Dramko 
 * @version 1.0
 */
public class Edge
{
    //Used to maintain a liked list of edges from a particular vertex.
    public Edge next;
    //Used to keep track of the vertices this edge connects
    public Vertex start;
    public Vertex end;  //This is the destination of the edge.
    int weight;

    /**
     * This constructor can be used to make an edge: either undirected or directed.<br><br>
     * 
     * The boolean recur determines what kind of edge is created.<br>
     * -true: A standard, undirected edge is created
     * -false: A directed edge is created<br><br>
     * 
     * The way this constructor creates an undirected edge is by creating two directed edges, one from
     * vertex v to vertex u, and one from u to v.
     * 
     * @param st vertex one vertex
     * @param en the other vertex
     * @param w the weight
     * @param recur Create the other edge
     */
    public Edge(Vertex st, Vertex en, int w, boolean recur)
    {
        start = st;
        end = en;
        weight = w;
        if (st.edges == null) {
            st.edges = this;
        } else {
            Edge cur = st.edges;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = this;
        }
        
        if (recur)  //Creates the other directed edge (in the opposite direction) to make a normal edge.
            new Edge(en, st, w, false);
    }
    
    /**
     * Returns a String representation of this Edge in the following format:<br><br>
     * 
     * (start.name, weight, end.name);
     */
    public String toString() {
        return "(" + start.name + ", " + weight + ", " + end.name + ")";
    }
}
