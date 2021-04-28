class Operation{
    int data;

    Operation(int data) {
        this.data = data;
    }

    void change(int data){
        System.out.println(data);
        data=data+100;//changes will be in the local variable only
        System.out.println(data);
    }

    public static void main(String args[]){
        Operation op=new Operation(50);

        System.out.println("before change "+op.data);
        op.change(500);
        System.out.println("after change "+op.data);

    }
}  