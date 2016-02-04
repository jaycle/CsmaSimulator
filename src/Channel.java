import java.util.*;

public class Channel {

    private static final int CLEAR_CHANNEL = -1;
    private static final int COLLISION = -2;

    private Queue<Integer> queue;
    private List<Node> nodeList;

    public Channel(int numberOfNodes, int delay) {
        nodeList = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            nodeList.add(new Node(this, .1));
        }

        // Create queue with clear channel size equal to delay
        queue = new ArrayDeque<>(delay);
        for (int i = 0; i < delay; i++) {
            queue.add(CLEAR_CHANNEL);
        }
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

    public void advanceTime() {
        int queueCode = CLEAR_CHANNEL;
        for (int nodeIndex = 0; nodeIndex < nodeList.size(); nodeIndex++) {
            if (nodeList.get(nodeIndex).postsFrameToChannel()) {
                System.out.println("Node " + nodeIndex + " begins transmission.");
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
    }

    public String printChannel() {
        return queue.toString();
    }
}
