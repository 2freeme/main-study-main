# Rocket总结

## 中间件

+ 自己不能干活，需要通过别人来干活

## MQ

主流的MQ有很多，比如ActiveMQ、RabbitMQ、RocketMQ、Kafka、ZeroMQ等。之前阿里巴巴也是使用ActiveMQ，随着业务发展，ActiveMQ IO 模块出现瓶颈，后来阿里巴巴 通过一系列优化但是还是不能很好的解决，之后阿里巴巴把注意力放到了主流消息中间件kafka上面，但是kafka并不能满足他们的要求，尤其是低延迟和高可靠性。

所以RocketMQ是站在巨人的肩膀上（kafka）MetaQ的内核，又对其进行了优化让其更满足互联网公司的特点。它是纯Java开发，具有高吞吐量、高可用性、适合大规模分布式系统应用的特点。 RocketMQ目前在阿里集团被广泛应用于交易、充值、流计算、消息推送、日志流式处理、binglog分发等场景。

### MQ的功能

+ #### 解耦

  + AB应用不在互相依赖

+ #### 异步

  + 也是指不在进行强依赖，可以异步的进行

+ #### 消峰

  + 流量达到高峰的时候，通常使用限流算法来控制流量涌入系统，避免系统被击瘫，但是这种方式损失了一部分请求

    此时可以使用消息中间件来缓冲大量的请求，匀速消费，当消息队列中堆积消息过多时，我们可以动态上线增加消费端，来保证不丢失重要请求。

+ #### 异构系统

  + 跨语言的使用

+ #### 大数据的收集处理

  + 消息中间件可以把各个模块中产生的管理员操作日志、用户行为、系统状态等数据文件作为消息收集到主题中

    数据使用方可以订阅自己感兴趣的数据内容互不影响，进行消费

### ROCKETMQ 的角色

![img](file://D:/%E8%B5%84%E6%96%99/master/16%20%E4%B8%80%E6%9C%9F%20%E6%B6%88%E6%81%AF%E4%B8%AD%E9%97%B4%E4%BB%B6/RocketMQ/image-rocketMQ/webp?lastModify=1603557264)

##  Broker

- Broker面向producer和consumer接受和发送消息
- 向nameserver提交自己的信息
- 是消息中间件的消息存储、转发服务器。
- 每个Broker节点，在启动时，都会遍历NameServer列表，与每个NameServer建立长连接，注册自己的信息，之后定时上报。



#### broker集群

- Broker高可用，可以配成Master/Slave结构，Master可写可读，Slave只可以读，Master将写入的数据同步给Slave。
  - 一个Master可以对应多个Slave，但是一个Slave只能对应一个Master
  - Master与Slave的对应关系通过指定相同的BrokerName，不同的BrokerId来定义BrokerId为0表示Master，非0表示Slave
  - master可以收发，slave只能发，并会把消费的信息同步给master
  - producer只能和master连接，consumer 都可以连接
- Master多机负载，可以部署多个broker
  - 每个Broker与nameserver集群中的所有节点建立长连接，定时注册Topic信息到所有nameserver。





## producer

- 消息的生产者

- 通过集群中的其中一个节点（随机选择）建立长连接，获得Topic的路由信息，包括Topic下面有哪些Queue，这些Queue分布在哪些Broker上等

- 接下来向提供Topic服务的Master建立长连接，且定时向Master发送心跳

- ##### 发送消息

  - ···· 

    ```java
    //同步消息
    SendResult send = producer.send(message); //单个消息同送
    SendResult send2 = producer.send(messages);//多个消息推送
    //异步消息 不会阻塞消息，
    producer.send(message, new SendCallback() {
        @Override
        public void onSuccess(SendResult sendResult) {
            //发送成功
        }
        @Override
        public void onException(Throwable e) {
            //发送失败
        }
    });
    //尝试发送，不关心是否成功 发送的效率最高
    producer.sendOneway(message);
    ```

  ##### 怎么看消息是否被消费

  

### consumer

消息的消费者，通过NameServer集群获得Topic的路由信息，连接到对应的Broker上消费消息。

注意，由于Master和Slave都可以读取消息，因此Consumer会与Master和Slave都建立连接。

+ #### 消费模式

  + 消息消费模式由消费者来决定，可以由消费者设置MessageModel来决定消息模式。

  + 消息模式默认为集群消费模式

  + 一个topic 一个group中绝对不会出现 一个消费者是集群 一个消费者是广播的情形

  + ```java
     consumer.setMessageModel(MessageModel.BROADCASTING);  //指定广播
     consumer.setMessageModel(MessageModel.CLUSTERING);   //指定集群
    ```

  + #### 集群消息

    + ![img](file://D:/%E8%B5%84%E6%96%99/master/16%20%E4%B8%80%E6%9C%9F%20%E6%B6%88%E6%81%AF%E4%B8%AD%E9%97%B4%E4%BB%B6/RocketMQ/image-rocketMQ/160707_kSpS_1469576.png?lastModify=1603612854)

      集群消息是指**集群化部署消费者**

      当使用集群消费模式时，MQ 认为任意一条消息只需要被集群内的任意一个消费者处理即可。

      **特点**

      - 每条消息只需要被处理一次，broker只会把消息发送给消费集群中的一个消费者

      - 在消息重投时，不能保证路由到同一台机器上

      - 消费状态由broker维护

        

  + #### 广播消息

    + ![img](file://D:/%E8%B5%84%E6%96%99/master/16%20%E4%B8%80%E6%9C%9F%20%E6%B6%88%E6%81%AF%E4%B8%AD%E9%97%B4%E4%BB%B6/RocketMQ/image-rocketMQ/160902_4AOI_1469576.png?lastModify=1603613321)

    + 当使用广播消费模式时，MQ 会将每条消息推送给集群内所有注册过的客户端，保证消息至少被每台机器消费一次。

    + 指的是

      **特点**

      - 消费进度由consumer维护
      - 保证每个消费者消费一次消息
      - 消费失败的消息不会重投
      - 

### 消息过滤

+ TAG  消息的分组

  + 切记有很大的坑，其实这个指定的就是tag 过滤分为客户端的过滤和服务端的过滤

  + 同一个消费组中，设置不同tag时，后启动的消费者会**覆盖**先启动的消费者设置的tag

  + tag决定了消息过滤的条件，经过服务端和客户端两层过滤，最后只有后启动的消费者才能收到部分消息

  + **消费端的订阅：**

    + consumer订阅时，会将订阅信息注册到到服务端
    + 保存订阅信息的是Map类，**key为topic**，value主要是tag
    + subVersion取**当前时间**。
    + 拉取消息时，首先从服务端获取订阅关系，得到tag的hash集合codeSet
    + 然后从ConsumerQueue获取一条记录，判断记录的hashCode是否在codeSet中，以达到消息过滤的目的，决定是否将该消息发送给consumer
    + 总之一句话：**tag决定了消息是否发到客户端**
    + 

  + **过滤类型**

    + 首先是先在服务端过滤，过滤结束之后的才会找到对应的订阅的consumer进行投递。所以基本上一个订阅组的一个topic的tag都是一样的，不然的话，这样的机制就会导致消息的丢失。
    + 服务端的过滤：（过滤了之后在consloe 里面实可以里是可以看到的）
      + 过滤：tag的hash值过滤
      + 优点：可以减少不必要的传输
      + 缺点：不能很精准的进行过滤
    + 客户端的过滤 （注意：消息达到了这里的话，其实就是算做已经被消费）
      + 客户度过滤：tag的字符串值做对比。不相等的不返回给消费者

    [地址]: https://blog.csdn.net/Dome_/article/details/94584498

    

+ key   用来找消息的









#### nameserver

​		底层由netty实现，提供了路由管理、服务注册、服务发现的功能，是一个无状态节点 ，没有主从。没有状态，之间不会进行通信。不会持久化

**nameserver是服务发现者**，集群中各个角色（producer、broker、consumer等）都需要定时想nameserver上报自己的状态，以便互相发现彼此，超时不上报的话，nameserver会把它从列表中剔除

**nameserver可以部署多个**，当多个nameserver存在的时候，其他角色同时向他们上报信息，以保证高可用，

**NameServer集群间互不通信**，没有主备的概念

**nameserver内存式存储**，nameserver中的broker、topic等信息默认不会持久化

**为什么不用zookeeper？**：rocketmq希望为了提高性能，CAP定理，客户端负载均衡

### 对比JSM中的Topic和Queue

Topic是一个逻辑上的概念，实际上Message是在每个Broker上以Queue的形式记录。

![img](D:/资料/master/16 一期 消息中间件/RocketMQ/image-rocketMQ/1090617-20190626173042073-147043337.jpg)

对应到JMS中的topic实现是由客户端来完成的