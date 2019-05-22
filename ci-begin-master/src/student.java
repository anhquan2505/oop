public class student {

        //thuoctinh
        String name;
        int age;
        //phg thuc
        void sleep(){
            System.out.println("đang ngủ");
        }
        void eat(){
            System.out.println("đang ăn");
        }
        public student(){
            name = "Nguyen Tran Anh Quan";
            age = 19;
        }
        public student(String name, int age){
            this.name=name;
            this.age=age;
        }
    }

