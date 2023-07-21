package org.example;
import java.util.LinkedList;
import java.util.Queue;

interface QueueBehaviour<T> {
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
}
interface MarketBehaviour<T> {
    void enter(T person);
    T exit();
}
class Market<T> implements QueueBehaviour<T>, MarketBehaviour<T> {
    private Queue<T> queue;
    public Market() {
        queue = new LinkedList<>();
    }
    @Override
    public void enqueue(T element) {
        queue.add(element);
    }
    @Override
    public T dequeue() {
        return queue.poll();
    }
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    @Override
    public void enter(T person) {
        enqueue(person);
        System.out.println("Новый клиент в магазине: " + person);
    }
    @Override
    public T exit() {
        T person = dequeue();
        System.out.println("Клиент вышел из магазина: " + person);
        return person;
    }
    public void update() {
        if (!isEmpty()) {
            T order = exit();
            // Обработка заказа и его выполнение
            System.out.println("Заказ обработан и выполнен: " + order);
        } else {
            System.out.println("Нет заказов для обработки!");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Market<String> market = new Market<>();
        market.enter("Петрович");
        market.enter("Александр");
        market.enter("Сергей");
        market.update();
        market.update();
        market.update();
        market.update();
    }
}