import java.util.*;

public class Channel {

    public static final int CLEAR_CHANNEL = -1;
    public static final int COLLISION = -2;

    private Queue<Integer> queue;
    private List<Node> nodeList;
    private int timeCounter;

    public Channel(int numberOfNodes, int delay) {
        nodeList = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            nodeList.add(new Node(this, .02));
        }

        // Create queue with clear channel size equal to delay
        queue = new ArrayDeque<>(delay);
        for (int i = 0; i < delay; i++) {
            queue.add(CLEAR_CHANNEL);
        }
        timeCounter = 0;
    }

    public boolean isClear() {
        return queue.peek() == CLEAR_CHANNEL;
    }

    public boolean isSeizedByNode(Node n) {
        int nodeIndex = nodeList.indexOf(n);
        return queue.peek() == nodeIndex;
    }

    public int getStatus() {
        return queue.peek();
    }

    public int[] advanceTime() {
        int queueCode = CLEAR_CHANNEL;
        int[] transmissions = {0,0,0,0,0,CLEAR_CHANNEL};
        for (int nodeIndex = 0; nodeIndex < nodeList.size(); nodeIndex++) {
            if (nodeList.get(nodeIndex).postsFrameToChannel()) {
                System.out.println("Node " + (nodeIndex + 1) + " begins transmission.");
                transmissions[nodeIndex] = 1;
                if (queueCode != CLEAR_CHANNEL) {
                    queueCode = COLLISION;
                    break;
                } else {
                    queueCode = nodeIndex;
                }
            }
        }
        queue.add(queueCode);
        queue.poll(); // remove element to keep queue size the same
        transmissions[5] = queueCode;
        timeCounter++;
        return transmissions;

    }

    public int getTime() {
        return timeCounter;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public String printChannel() {
        return queue.toString();
    }
}
