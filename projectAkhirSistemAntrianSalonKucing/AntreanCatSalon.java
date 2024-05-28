package com.mycompany.antreancatsalon;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class AntreanCatSalon<T> implements Serializable {
    public Queue<T> queue = new LinkedList<>();

    public void addCatToQueue(T cat) {
        queue.add(cat);
    }

    public T processCat() throws Exception {
        if (queue.isEmpty()) {
            throw new Exception("No cats in the queue to process.");
        }
        return queue.poll();
    }
}
