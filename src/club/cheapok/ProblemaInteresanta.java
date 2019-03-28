package club.cheapok;

public class ProblemaInteresanta {
    public static void main(String[] args) {
        //populate
        Node start = populateLinkedList(30, 30, true);


        //checkCyclic : bool
        if (checkCyclic(start)) {
            System.out.println("Wsio, am gasit ciclu!");
        } else {
            System.out.println("Nu-i ciclic, doswindows!");
        }
    }


    private static boolean checkCyclic(Node start) {
        Node pivot = start;
        int n = 1; int cd;
        while (start != null) {
            cd = n;
            while (cd > 0) {
                start = start.next;
                cd--;
                if(pivot == start) {
                    return true;
                }
            }
            pivot = start;
            n++;
        }
        return false;
    }

    private static Node populateLinkedList(int nrNodes, int startCycleIndex, boolean isCyclic) {
        Node n1 = new Node();
        Node start = n1;
        n1.setValue(101);
        Node cicle = null;

        for (int i = 0; i < nrNodes; i++) {
            Node node = new Node();
            n1.setNext(node);
            node.setValue(i);
            n1 = node;
            if (isCyclic && i == startCycleIndex-1) cicle = n1;
        }
        n1.setNext(cicle);
        return start;
    }



    static class Node{
        int value;
        Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
