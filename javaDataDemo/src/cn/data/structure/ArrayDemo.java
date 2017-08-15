package cn.data.structure;

/**
 * Created by zhiyuli on 2017/8/15.
 * 数组
 */
public class ArrayDemo {

     //创建一个Integer空数组<br>
        public static Integer[] player=null;
        //添加球员号码<br>
        private static int size=0;//初始化数组的元素个数
        static StringBuffer sb=new StringBuffer();
        public static void init(int initialCapacity){
            //初始容量为5的线性列表，用来存储数据<br>
            if(initialCapacity<0){
                throw new IllegalArgumentException("容量不能为负数！");
            }
            player=new Integer[initialCapacity];
        }
        public static void add(Integer playNum){//为数组添加元素<br>        //数组扩容<br>
            if(size==player.length){
                Integer[] temp=java.util.Arrays.copyOf(player, player.length*2);
                player=temp;
            }
            player[size]=playNum;
            size++;
        }
        private static void  replace(int indexNum,int setNum) {//根据输入的数据替换成新的数据
             int index=getIndexNum(indexNum);//根据输入的数据查看索引位置<br>
            if(index>=0){
                player[index]=setNum;
            }
        }
        //o(1)
        private static void indexReplace(int index, int newData) {//根据输入索引位置替换数据<br>
            if(index<0 || index>=size){
                throw new IllegalArgumentException("超出索引位置！");
            }
            player[index]=newData;
        }

        //o(n)
        private static void add(int index,int num){

            if(size==player.length){
                Integer[] temp=java.util.Arrays.copyOf(player, player.length*2);
                player=temp;
            }
            size++;
            int forwad = num;
            for(int i=index;i<=size;i+=2){
                int old = player[i];
                int nextOld = -1;
                if(player[i+1] != null){
                    nextOld = player[i+1];
                }
                //交换位置
                player[i]=forwad;
                player[i+1] = old;
                forwad = nextOld;
                //位置移动结束
                if(nextOld == -1){
                    break;
                }
            }

        }

        //o(1)
        private static int  select(int index) {//根据索引位置查找对应的数据
            if(index<0 || index>=size){
                throw new IllegalArgumentException("超出索引位置！"); }
                if(index>size-1){
                return -1;
            }
            return player[index];
        }
        //o(n)
        private static int getIndexNum(int indexNum) {//根据输入的数据查看索引位置<br>
            for (int index = 0; index <size; index++) {
                if(player[index].equals(indexNum)){
                    return index;
                }
            }
            return -1;
        }
        private static void delete(int index) {//删除指定索引位置的数据<br>
            if(index<0 || index>=size){
                throw new IllegalArgumentException("超出索引位置！");
            }
            for (int i = index; i < size-1; i++) {
                player[i]=player[i+1];
            }
            size--;
        }
        //打印数组<br>
        public static void print(){
            if(player==null){
                System.out.println("数组为空！");
                return;
            }
            if(size==0){
                System.out.println("[ ]");
                return;
            }
            sb.append("[");
            for (int index = 0; index < size; index++) {
                sb.append(player[index]);
                if(index!=size-1){
                    sb.append(",");
                }else{
                    sb.append("]");
                }
            }
            System.out.println(sb.toString());
        }
        public static void main(String[] args) {
            init(5);
            add(11);
            add(22);
            add(33);
            add(44);
            add(55);
            add(66);
            print();
            add(3,77);
            print();
//            //
//            int data=select(4);
//            System.out.println(data);
//            int num=getIndexNum(33);//查找值为33的索引位置<br>//
//            System.out.println(num);
//            indexReplace(2,337);
//            replace(22, 66);
//            delete(3);
//            print();
        }
}
