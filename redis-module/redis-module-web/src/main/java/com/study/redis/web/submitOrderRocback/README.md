## submitOrderRocback
   * 2021年2月17日
   * 这个目录下面，主要是测试了将redis放到事务管理器中，然后监听事务进行回滚的操作。
   * 遇到问题 Caused by: java.lang.IllegalArgumentException: Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
   * No qualifying bean of type 'org.springframework.transaction.PlatformTransactionManager' available:
   * 上面的问题都是因为配置问题。
   * 关于 内部类的问题，暂时不知道
   