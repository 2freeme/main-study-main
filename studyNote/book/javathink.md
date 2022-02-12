### java编程思想

#### 地址

1. [https://lingcoder.gitee.io/onjava8/#/book/06-Housekeeping?id=https://lingcoder.gitee.io/onjava8/#/book/06-Housekeeping?id=利用构造器保证初始化](https://lingcoder.gitee.io/onjava8/#/book/06-Housekeeping?id=https://lingcoder.gitee.io/onjava8/#/book/06-Housekeeping?id=利用构造器保证初始化)
2. 读书记录
   - 

#### 运算符

1. Integer的比较

   - 会发现在针对于Integer的比较过程中，如果–128到127之间的  Integer的值直接 == 比较。他的结果也会是true

   - 解析原因：归结于java对于Integer与int的自动装箱与拆箱的设计，是一种模式：叫享元模式（flyweight）。
     　　加大对简单数字的重利用，Java定义在自动装箱时对于值从–128到127之间的值，它们被装箱为Integer对象后，会存在内存中被重用，始终只存在一个对象。
     而如果超过了从–128到127之间的值，被装箱后的Integer对象并不会被重用，即相当于每次装箱时都新建一个 Integer对象。

### this

1. this指的就是一个对象的引用
   - 假设现在在方法内部，你想获得对当前对象的引用。但是，对象引用是被秘密地传达给编译器——并不在参数列表中。方便的是，有一个关键字: **this** 。**this** 关键字只能在非静态方法内部使用。当你调用一个对象的方法时，**this** 生成了一个对象引用。你可以像对待其他引用一样对待这个引用。如果你在一个类的方法里调用该类的其他方法，不要使用 **this**，直接调用即可，**this** 自动地应用于其他方法上了
   - 因为this指的是对象的引用，所以在静态方法中是无法使用this的关键字的

