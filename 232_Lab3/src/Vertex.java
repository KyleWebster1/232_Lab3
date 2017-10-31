/**
 * Created by kylewebster1 on 10/30/17.
 */
public class Vertex {
    // Class with constructor for vertexes.
        private char label; // Names the vertex
        private boolean wasVisted;
        public Vertex(char lab){
            label = lab;
            wasVisted = false;
        }

        public char getLabel(){
            return label;
        }
        public boolean getVisited(){return wasVisted;}
        public void setWasVisted(boolean visited){wasVisted = visited;}
    }
