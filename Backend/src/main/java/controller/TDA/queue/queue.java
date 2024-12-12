package controller.TDA.queue;

<<<<<<< HEAD
public class queue <E>{
    private queueOperation<E> queueOperation;
    public queue(Integer cant) {
        this.queueOperation = new queueOperation<>(cant);
=======
public class Queue <E>{
    private QueueOperation<E> queueOperation;
    public Queue(Integer cant) {
        this.queueOperation = new QueueOperation<>(cant);
>>>>>>> Rama_Fermin
    }
    public void queque(E dato) throws Exception {
        queueOperation.queque(dato);
    }
    public Integer getSize() {
        return this.queueOperation.getSize();
    }
    
    public void clear() {
        this.queueOperation.reset();
    }

    public Integer getTop() {
        return this.queueOperation.getTop();
    }

    public void print() {
        System.out.println("Cola");
        System.out.println(queueOperation.toString());
        System.out.println("*****");
    }
    
    public E  dequeque()  throws Exception {
        return queueOperation.dequeue();
    }
}
