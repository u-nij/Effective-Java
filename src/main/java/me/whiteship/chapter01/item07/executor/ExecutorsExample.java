package me.whiteship.chapter01.item07.executor;

import me.whiteship.chapter01.item01.Product;

import java.util.concurrent.*;

public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        100개의 스레드를 사용해 100개의 작업을 처리.
        많은 스레드를 사용하는 만큼, 시스템 리소스를 많이 쓰게 된다.
         */
//        for (int i = 0; i < 100; i++) {
//            Thread thread = new Thread(new Task()); // 메인 스레드가 아닌 별도의 스레드 호출
//            thread.start();
//        }

        /*
        더 적은 스레드만으로도 똑같은 양의 작업을 비동기적으로 처리할 수 있다.
        10개의 스레드만으로 100개의 작업을 처리할 수 있게 된다. 버벅버벅
        10개 full -> 2초 -> 10개 full -> 2초 -> ...

        CPU와 I/O 주 어떤 것에 집중적인 작업인지 그 특징에 따라 스레드 풀의 개수에 영향을 준다.

        1) CPU Intensive
        아무리 스레드의 개수를 늘려도, CPU의 개수만큼만.

        2) I/O Intensive
        DB의 엑세스해서 어떤 데이터를 가져온다던가, 네트워크로 HTTP CALL해서 값을 가져오거나
        I/O 단에서 INPUT, OUTPUT 처리 중 딜레이가 있다.
        CPU가 4개라고 할 때, I/O를 기다리는 동안 CPU 리소스는 남게 된다.
        CPU 개수를 더 늘려야 하지만, 그것에 대한 정답이 없다.
        어떤 오퍼레이션을 실행할 때 몇 초가 걸려, 몇 개의 스레드를 잡는 것이 적절한가. 그때 그때 재봐야 한다.
        DB 및 네트워크 단의 지연시간에 따라 적절한 스레드 풀의 개수를 조정하는 등 적절한 성능 튜닝이 필요하다.
        I/O Intensive한 작업들은 CPU 개수에 상관 없이 더 많은 수의 스레드가 필요하다.
         */

        /*
        // CPU Intensive한 작업을 처리하기 위한 스레드 풀이 만들어진다.
        int numberOfCpu = Runtime.getRuntime().availableProcessors();
        ExecutorService service1 = Executors.newFixedThreadPool(numberOfCpu);

        // Cached Thred Pool. 놀고있는 스레드를 사용하고, 필요한 만큼 스레드를 만든다.
        // 오랫동안 사용되지 않는 스레드가 있을 경우, 60초가 지나면 자동으로 해당 스레드를 삭제한다.
        ExecutorService service2 = Executors.newCachedThreadPool();

        newFixedThreadPool
        전자의 경우 내부적으로 BlockingQueue를 쓴다. 작업 100개를 큐에 넣어 여러 스레드가 동시에 데이터에 접근할 수 있다.
        일반적인 ArrayList나 HashMap과 같은 것은 동시 접근에 안전하지 않다.
        멀티스레드가 동시다발적으로 동일한 ArrayList나 HashMap에 접근해 elemenet들을 조작하면 ConcurrentModificationException이 일어난다.
        이 때 BlockingQueue라는 동시성을 보장하는 데이터 구조를 사용할 수 있다.

        newCachedThreadPool
        작업을 위한 공간이 하나이다. 작업이 큐에 들어오자마자 쓰레드에 준다.
        작업을 할당할 쓰레드가 없으면 스레드를 만든다.
        무한정 스레드가 늘어날 수 있기 때문에, 자원이 낭비되지 않도록 주의해야 한다.

        newSingleThreadPool
        스레드를 하나 만들어 작업 여러 개를 처리한다. 비효율적이다.

        newScheduledThreadPool
        순차적으로 작업이 들어오지 않는다. 스케쥴을 감안해 순서가 바뀔수 있다.
        어떤 작업을 몇 초 뒤로 딜레이해 실행하거나, 주기적으로 실행하는 등 할 수 있다.
         */

        ExecutorService service = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100; i++) {
//            service.submit(new Task()); // 리턴 값이 없는 Runnable
//        }

        Future<String> submit = service.submit(new Task()); // non-blocking call.


        System.out.println(Thread.currentThread() + " hello"); // 메인 스레드

        /*
        submit 메서드는 non-blocking call이기 때문에 " hello" 혹은 " world"가 거의 바로 출력될 것이다.
        (println 자체가 그렇게 많이 시간이 소요되지 않는 오퍼레이션이기 때문에)

        해서, blocking call인 get 오퍼레이션에서 2초를 기다리게 된다.
         */
        System.out.println(submit.get()); // get이라는 오퍼레이션은 blccking call. 결과를 기다려야 한다.

        service.shutdown();
    }

    /*
    리턴 타입이 없고, 별도의 스레드에서 작업을 호출한 후 스레드가 끝나면 끝.
     */
//    static class Task implements Runnable {
//
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(2000L); // 작업을 하는데 걸리는 시간이라고 가정.
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread() + " world");
//        }
//    }

    /*
    별도의 스레드에서 처리한 작업에 대한 리턴 값을 받고 싶은 경우 사용.
     */
    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(2000L);
            return Thread.currentThread() + " world";
        }
    }


}
