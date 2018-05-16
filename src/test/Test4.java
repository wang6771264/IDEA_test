public class Test4 {
    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        for (Integer i : list) {
            try {
                if(i % 2 != 0){
                    System.out.println(i/0);
                }
            }catch (Exception e){
                System.out.println("catch inner content");
            }finally {
                System.out.println("finally inner content");
            }
            System.out.println("general process content");
            try {
                TimeUnit.SECONDS.sleep(1l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
*/
        //if (singleStoreSupplier != null == singleStoreSupplier.getSupplierId().equals(supplier.getId()))

        Integer i = new Integer(1);
        Integer b = new Integer(2);
        Integer c = new Integer(3);
        if (i != null == b.equals(c)) {
            System.out.println(11111);
        }
    }
}
