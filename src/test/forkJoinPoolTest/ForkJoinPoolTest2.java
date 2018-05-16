package forkJoinPoolTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest2 {
    public static class CountTask extends RecursiveTask<List<Integer>> {
        private static final int ThresHold = 10;
        private int start;
        private int end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected List<Integer> compute( ) {
            List<Integer> list = new ArrayList<>();
            boolean canCompute = (end - start) <= ThresHold;
            if (canCompute) {
                for (int i = start; i < end ; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(i);
                }
            } else {
                int middle = (start + end) / 2;
                CountTask leftTask = new CountTask(start, middle);
                CountTask rightTask = new CountTask(middle, end);
                leftTask.fork();
                rightTask.fork();
                list.addAll(leftTask.join());
                list.addAll(rightTask.join());
            }
            return list;
        }
    }

    public static void main(String[] args) {
        //初始化数据
        List<Integer> list = initTestData();
        System.out.println(list);

        List<Integer> list1 =  testPerfomance();
        System.out.println(list1);
    }

    /**
     * 测试ForkJoinPool
     */
    public static List<Integer> testPerfomance(){
        long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0, 100);
        Future<List<Integer>> result = forkJoinPool.submit(countTask);
        List<Integer> resultList = null;
        try {
            resultList = result.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("FokrJoinPoll测试方式"+ (endTime - startTime));
        return resultList;
    }

    private static List<Integer> initTestData(){
        long startTime = System.currentTimeMillis();
        List<Integer>  list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通for循环测试方式"+ (endTime - startTime));
        return list;
    }
}
