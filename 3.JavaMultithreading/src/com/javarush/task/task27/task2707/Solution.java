package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        //следующие 4 строки в тестах имеют другую реализацию
        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;

        synchronized (firstLock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }

            synchronized (secondLock) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        });

        synchronized (o2) {
            synchronized (o1) {
                thread1.start();
                //спим чтобы второй поток попал в состояние ожидания - он не может захватить ни o1 ни o2
                Thread.sleep(1000);

            } //отпускаем монитор o1
            //спим чтобы второй поток попробовал выполнить работу после того как o1 был отпущен
            Thread.sleep(1000);

            //теперь поток thread1 ждет, но вопрос захватил ли он монитор o1
            //если он его захватил - значит порядок правильный
            //если нет - обратный

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o1) {
                        System.out.println("o1 не захвачен потоком thread1");
                    }
                }
            });
            thread2.start();
            Thread.sleep(1000); //ждем чтобы thread2 стартанул и попытался захватить o1

            return Thread.State.BLOCKED.equals(thread2.getState());

        }

    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o1, o2); //expected boolean b
                } catch (Exception ignored) {
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o2, o1); //expected boolean !b
                } catch (Exception ignored) {
                }
            }
        }.start();
    }
}