package org.day2;

//饿汉式
//class Single
//{
//    private static final Single s = new Single();
//    private Single(){}
//    public static Single getInstance()
//    {
//        return s;
//    }
//}



//懒汉式

class Single
{
    private static Single s = null;
    public String xxx ="1";
    private Single(){}

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    public static  Single getInstance()
    {
        if(s==null)
        {
            synchronized(Single.class)
            {
                if(s==null)
                    //--->A;
                    s = new Single();
            }
        }
        return s;
    }
}

class People{
    private static final People p = new People();

    public static People getInstance(){
        return p;
    }
}

class SingleDemo
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        Single s = Single.getInstance();
        s.setXxx("ssssssss");
        System.out.println(s.getXxx());
        System.out.println(s.xxx);
    }
}