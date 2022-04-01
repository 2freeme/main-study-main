# ES

## ES核心概念和原理

### 1、什么是搜索：百度、垂直搜索（站内搜索）

搜索：通过一个***\*关键词\****或一段描述，得到你想要的（相关度高）结果。

### 2、如何实现搜索功能?

关系型数据库：性能差、不可靠、结果不准确（相关度低）

### 3、倒排索引、Lucene和全文检索？

#### (1) 倒排索引的数据结构

- 1、包含这个关键词的document list

- 2、关键词在每个doc中出现的次数 TF term frequency

- 3、关键词在整个索引中出现的次数 IDF inverse doc frequency

- 4、关键词在当前doc中出现的次数

- 5、每个doc的长度，越长相关度越低

- 6、包含这个关键词的所有doc的平均长度

- <img src="D:\codedir\new\main-study-main\studyNote\book\image\倒排索引原理.png" style="zoom:25%;" />

  

#### (2) Lucene：jar包，帮我们创建倒排索引，提供了复杂的API

#### (3) 如果用Lucene做集群实现搜索，会有那些问题
- ① 节点一旦宕机，节点数据丢失，后果不堪设想，可用性差。
- ② 自己维护，麻烦（自己创建管理索引），单台节点的承载请求的能力是有限的，需要人工做负载（雨露均沾）。

### 4、Elasticsearch：*\*分布式、高性能、**高可用**、可伸缩、易维护\**	ES≠搜索引擎

#### (1) 分布式的***\*搜索，存储\****和***\*数据分析\****引擎：

#### (2) 优点：

- ① 面向开发者友好，屏蔽了Lucene的复杂特性，集群自动发现（cluster discovery）
- ② 自动维护数据在多个节点上的建立
- ③ 会帮我做搜索请求的负载均衡
- ④ 自动维护冗余副本，保证了部分节点宕机的情况下仍然不会有任何数据丢失
- ⑤ ES基于Lucene提供了很多高级功能：复合查询、聚合分析、基于地理位置等。
- ⑥ 对于大公司，可以构建几百台服务器的大型分布式集群，处理PB级别数据；对于小公司，开箱即用，门槛低上手简单。
- ⑦ 相遇传统数据库，提供了全文检索，同义词处理（美丽的cls>漂亮的cls），相关度排名。聚合分析以及海量数据的近实时（NTR）处理，这些传统数据库完全做不到。

#### (3) 应用领域：

- ① 百度（全文检索、高亮、搜索推荐）
- ② 各大网站的用户行为日志（用户点击、浏览、收藏、评论）
- ③ BI（Business Intelligence商业智能），数据分析：数据挖掘统计。
- ④ Github：代码托管平台，几千亿行代码
- ⑤ ELK：Elasticsearch（数据存储）、Logstash（日志采集）、Kibana（可视化）

### 5、ES核心概念：

#### (1) cluster（集群）：每个集群至少包含两个节点.

#### (2) node：集群中的每个节点，一个节点不代表一台服务器

#### (3) field：一个数据字段，与index和type一起，可以定位一个doc

#### (4) document：ES最小的数据单元  Json

```js
{
  "id": "1",
  "name": "小米",
  "price": {
   "标准版": 3999,
  "尊享版": 4999,
  "吴磊签名定制版": 19999
  }
}
```

Type：逻辑上的数据分类，es 7.x中删除了type的概念

Index：一类相同或者类似的doc，比如一个员工索引，商品索引。

Shard分片：

1：一个index包含多个Shard，默认5P，默认每个P分配一个R，P的数量在创建索引的时候设置，如果想修改，需要重建索引。

2：每个Shard都是一个Lucene实例，有完整的创建索引的处理请求能力。

3：ES会自动在nodes上为我们做shard 均衡。

4：一个doc是不可能同时存在于多个PShard中的，但是可以存在于多个RShard中。

5: P和对应的R不能同时存在于同一个节点，所以最低的可用配置是两个节点，互为主备。

## es的高可用

#### ES如何实现高可用（生产环境均为一台机器一个节点

(2) ES在分配单个索引的分片时会将每个分片尽可能分配到更多的节点上。但是，实际情况取决于集群拥有的分片和索引的数量以及它们的大小，不一定总是能均匀地分布。

(3) ES不允许Primary和它的Replica放在同一个节点中，并且同一个节点不接受完全相同的两个Replica

(4) 同一个节点允许多个索引的分片同时存在。

#### 容错机制

(1) 啥叫容错？

① 傻X的代码你能看懂，牛X的代码你也能看懂

② 只能看懂自己的代码，容错性低

③ PS：***\*各种情况（支持的情况越多，容错性越好）\****下，都能保证work 正常运行

④ 换到咱们ES上就是，就是在局部出错异常的情况下，保证服务正常运行并且有自行恢复能力。

(2) ES-node

① 

1) Master：主节点，每个集群都有且只有一个

a. 尽量避免Master节点 node.data ＝ true

2) voting：投票节点

a. Node.voting_only = true（仅投票节点，即使配置了data.master = true，也不会参选, 但是仍然可以作为数据节点）。

3) coordinating：协调节点

每一个节点都隐式的是一个协调节点，如果同时设置了data.master = false和data.data=false，那么此节点将成为仅协调节点。

4) Master-eligible node（候选节点）：	

5) Data node（数据节点）：

6) Ingest node：

7) Machine learning node（机器学习节点）：

① 两个配置：node.master和node.data

1) node.master = true	 node.data = true

这是ES节点默认配置，既作为候选节点又作为数据节点，这样的节点一旦被选举为Master，压力是比较大的，通常来说Master节点应该只承担较为轻量级的任务，比如创建删除索引，分片均衡等。

2) node.master = true	 node.data = false

只作为候选节点，不作为数据节点，可参选Master节点，当选后成为真正的Master节点。

3) node.master = false	 node.data = false

既不当候选节点，也不作为数据节点，那就是仅协调节点，负责负载均衡

4) node.master=false		node.data=true

不作为候选节点，但是作为数据节点，这样的节点主要负责数据存储和查询服务。

(3) 图解容错机制

**①** ***\*第一步：Master选举（假如宕机节点是Master）\****

1) 脑裂：可能会产生多个Master节点

2) 解决：discovery.zen.minimum_master_nodes=N/2+1

② 第二步：Replica容错，新的（或者原有）Master节点会将丢失的Primary对应的某个副本提升为Primary

③ 第三步：Master节点会尝试重启故障机

④ 第四步：数据同步，Master会将宕机期间丢失的数据同步到重启机器对应的分片上去

#### 总结（如何提高ES分布式系统的可用性以及性能最大化）

（1）每台节点的Shard数量越少，每个shard分配的CPU、内存和IO资源越多，单个Shard的性能越好，当一台机器一个Shard时，单个Shard性能最好。

***\*（\*******\*2\*******\*）\*******\*稳定的\*******\*Master\*******\*节点对于群集健康非常重要\*******\*！\****理论上讲，应该尽可能的减轻Master节点的压力，分片数量越多，Master节点维护管理shard的任务越重，并且节点可能就要承担更多的数据转发任务，可增加“仅协调”节点来缓解Master节点和Data节点的压力，但是在集群中添加过多的仅协调节点会增加整个集群的负担，因为选择的主节点必须等待每个节点的集群状态更新确认。

（3）反过来说，如果相同资源分配相同的前提下，shard数量越少，单个shard的体积越大，查询性能越低，速度越慢，这个取舍应根据实际集群状况和结合应用场景等因素综合考虑。

（4）数据节点和Master节点一定要分开，集群规模越大，这样做的意义也就越大。

（5）数据节点处理与数据相关的操作，例如CRUD，搜索和聚合。这些操作是I / O，内存和CPU密集型的，所以他们需要更高配置的服务器以及更高的带宽，并且集群的性能冗余非常重要。

（6）由于仅投票节不参与Master竞选，所以和真正的Master节点相比，它需要的内存和CPU较少。但是，所有候选节点以及仅投票节点都可能是数据节点，所以他们都需要快速稳定低延迟的网络。

（7）高可用性（HA）群集至少需要三个主节点，其中***\*至少两个不是仅投票\****节点。即使其中一个节点发生故障，这样的群集也将能够选举一个主节点。生产环境最好设置3台仅Master候选节点（node.master = true	 node.data = true）

 （8）为确保群集仍然可用，集群***\*不能\*******\*同时停止投票配置中的一半或更多节点\****。只要有一半以上的投票节点可用，群集仍可以正常工作。这意味着，如果存在三个或四个主节点合格的节点，则群集可以容忍其中一个节点不可用。如果有两个或更少的主机资格节点，则它们必须都保持可用

 

 

#### 容错机制

 <img src="D:\codedir\new\main-study-main\studyNote\book\image\ES容错机制 .png" style="zoom:25%;" />

#### master选举

​	<img src="D:\codedir\new\main-study-main\studyNote\book\image\Master选举.png" style="zoom:25%;" />

## 命令

### cat命令

```python
/_cat/allocation      	#查看单节点的shard分配整体情况
/_cat/shards          #查看各shard的详细情况
/_cat/shards/{index}  	#查看指定分片的详细情况
/_cat/master          #查看master节点信息
/_cat/nodes           #查看所有节点信息
/_cat/indices         #查看集群中所有index的详细信息
/_cat/indices/{index} 	#查看集群中指定index的详细信息
/_cat/segments        #查看各index的segment详细信息,包括segment名, 所属shard, 内存(磁盘)占用大小, 是否刷盘
/_cat/segments/{index}#查看指定index的segment详细信息
/_cat/count           #查看当前集群的doc数量
/_cat/count/{index}   #查看指定索引的doc数量
/_cat/recovery        #查看集群内每个shard的recovery过程.调整replica。
/_cat/recovery/{index}#查看指定索引shard的recovery过程
/_cat/health          #查看集群当前状态：红、黄、绿
/_cat/pending_tasks   #查看当前集群的pending task
/_cat/aliases         #查看集群中所有alias信息,路由配置等
/_cat/aliases/{alias} #查看指定索引的alias信息
/_cat/thread_pool     #查看集群各节点内部不同类型的threadpool的统计信息,
/_cat/plugins         #查看集群各个节点上的plugin信息
/_cat/fielddata       #查看当前集群各个节点的fielddata内存使用情况
/_cat/fielddata/{fields}     #查看指定field的内存使用情况,里面传field属性对应的值
/_cat/nodeattrs              #查看单节点的自定义属性
/_cat/repositories           #输出集群中注册快照存储库
/_cat/templates              #输出当前正在存在的模板信息
```

### 检查命令

#### 健康值检查：

(1) 健康值检查

① _cat/health

② _cluster/health

(2) 健康值状态

① Green：所有Primary和Replica均为active，集群健康

② Yellow：至少一个Replica不可用，但是所有Primary均为active，数据仍然是可以保证完整性的。

③ Red：至少有一个Primary为不可用状态，数据不完整，集群不可用。

#### 基于XX系统的CRUD

**1、*****\*集群健康值\****：

(1) 健康值检查

① _cat/health

② _cluster/health

(2) 健康值状态

① Green：所有Primary和Replica均为active，集群健康

② Yellow：至少一个Replica不可用，但是所有Primary均为active，数据仍然是可以保证完整性的。

③ Red：至少有一个Primary为不可用状态，数据不完整，集群不可用。

**2、*****\*基于XX系统的CRUD\****

（1）创建索引：PUT /product?pretty

（2）查询索引：GET _cat/indices?v

（3）删除索引：DELETE /product?pretty

（4）插入数据：

​		PUT /index/_doc/id

​		{

​		  Json数据

​		}

（5）更新数据

1) 全量替换

2) 指定字段更新

（6）删除数据	DELETE /index/type/id

### Mapping

#### **(1) 概念**

**mapping就是ES数据字段field的type元数据，ES在创建索引的时候，dynamic mapping会自动为不同的数据指定相应mapping，mapping中包含了字段的类型、搜索方式（exact value或者full text）、分词器等。**

#### (2) 查看mapping

​	GET /product/_mappings

#### (3) Dynamic mapping

​	① “Elasticsearch”：text/keyword		

​	② 123456			=>	long			？为什么不是integer

​	③ 123.123			=>	double		

​	④ true false			=>	boolean

​	⑤ 2020-05-20		=>	date

​	为啥price是long类型而不是integer？因为es的mapping_type是由JSON分析器检测数据类型，而Json没有隐式类型转换（integer=>long or float=> double）,所以dynamic mapping会选择一个比较宽的数据类型。

#### (4) 搜索方式：

① exact value 精确匹配：在倒排索引过程中，分词器会将field作为一个整体创建到索引中，

② full text全文检索：分词、近义词同义词、混淆词、大小写、词性、过滤、时态转换等（normaliztion）

#### (5) ES数据类型：

####   *①核心类型*

**1)** ***\*数字类型\****：

​		a. long, integer, short, byte, double, float, half_float, scaled_float

​		b. 在满足需求的情况下，尽可能选择范围小的数据类型。

**2)** ***\*字符串：string\****：

​	**keyword**：适用于索引结构化的字段，可以用于过滤、排序、聚合。keyword类型的字段只能通过精确值（exact value）搜索到。Id应该用keyword

​	***\*text\****：当一个字段是要被全文搜索的，比如Email内容、产品描述，这些字段应该使用text类型。设置text类型以后，字段内容会被分析，在生成倒排索引以前，字符串会被分析器分成一个一个***\*词项\****。***\*text类型的字段不用于排序，很少用于聚合\****。（解释一下为啥不会为text创建索引：***\*字段数据会占用\*******\*大量\*******\*堆空间，尤其是在加载高基数\*******\*text\*******\*字段时。字段数据一旦加载到堆中，就在该段的生命周期内保持在那里。同样，加载字段数据是一个昂贵的过程，可能导致用户遇到延迟问题。这就是默认情况下禁用字段数据的原因\****）

 	b有时，在同一字段中同时具有全文本（text）和关键字（keyword）版本会很有用：一个用于全文本搜索，另一个用于聚合和排序。

**3)** ***\*date\****（时间类型）：exact value

**4) 布尔类型：boolean**

5) [binary](https://www.elastic.co/guide/en/elasticsearch/reference/current/binary.html)（二进制）：[binary](https://www.elastic.co/guide/en/elasticsearch/reference/current/binary.html)

6) [range](https://www.elastic.co/guide/en/elasticsearch/reference/current/range.html)（区间类型）：integer_range、float_range、long_range、double_range、date_range

***② 复杂类型：***

​	1) Object：用于单个JSON对象

​	2) Nested：用于JSON对象数组

**③ 地理位置：**

​	1) Geo-point：纬度/经度积分

​	2) Geo-shape：用于多边形等复杂形状

④ ***特有类型***：

​	1) IP地址：ip 用于IPv4和IPv6地址

​	2) [Completion](#completion-suggester)：提供自动完成建议

​	3) Tocken_count：计算字符串中令牌的数量

​	4) [Murmur3](https://www.elastic.co/guide/en/elasticsearch/plugins/7.7/mapper-murmur3.html)：在索引时计算值的哈希并将其存储在索引中

​	5) [Annotated-text](https://www.elastic.co/guide/en/elasticsearch/plugins/7.7/mapper-annotated-text.html)：索引包含特殊标记的文本（通常用于标识命名实体）

​	6) [Percolator](https://www.elastic.co/guide/en/elasticsearch/reference/current/percolator.html)：接受来自query-dsl的查询

​	7) Join：为同一索引内的文档定义父/子关系

​	8) [Rank features](https://www.elastic.co/guide/en/elasticsearch/reference/current/rank-features.html)：记录数字功能以提高查询时的点击率。

​	9) [Dense vector](https://www.elastic.co/guide/en/elasticsearch/reference/current/dense-vector.html)：记录浮点值的密集向量。

​	10) [Sparse vector](https://www.elastic.co/guide/en/elasticsearch/reference/current/sparse-vector.html)：记录浮点值的稀疏向量。

​	11) [Search-as-you-type](https://www.elastic.co/guide/en/elasticsearch/reference/current/search-as-you-type.html)：针对查询优化的文本字段，以实现按需输入的完成

​	12) [Alias](https://www.elastic.co/guide/en/elasticsearch/reference/current/alias.html)：为现有字段定义别名。

​	13) [Flattened](https://www.elastic.co/guide/en/elasticsearch/reference/current/flattened.html)：允许将整个JSON对象索引为单个字段。

​	14) [Shape](https://www.elastic.co/guide/en/elasticsearch/reference/current/shape.html)：shape 对于任意笛卡尔几何。

​	15) [Histogram](https://www.elastic.co/guide/en/elasticsearch/reference/current/histogram.html)：histogram 用于百分位数聚合的预聚合数值。

​	16) [Constant keyword](https://www.elastic.co/guide/en/elasticsearch/reference/current/constant-keyword.html)：keyword当所有文档都具有相同值时的情况的 专业化。

***⑤ Array（数组）***

​	：在Elasticsearch中，数组不需要专用的字段数据类型。默认情况下，任何字段都可以包含零个或多个值，但是，数组中的所有值都必须具有相同的数据类型。

**⑥ ES 7新增：**

​	1) Date_nanos：date plus 纳秒

​	2) Features：

​	3) Vector：as

#### (6) 手工创建mapping

PUT /product

{

 "mappings": {

  "properties": {

​    "field": {

​     "mapping_parameter": "parameter_value"

​    }

   }

 }

}

#### (7) Mapping parameters 

**①** ***\*index\****：是否对创建对当前字段创建索引，默认true，如果不创建索引，该字段不会通过索引被搜索到,但是仍然会在source元数据中展示

② **analyzer**:指定分析器（character filter、tokenizer、Token filters）。

③ **boost**：对当前字段相关度的评分权重，默认1

**④** **coerce**：是否允许强制类型转换  true “1”=> 1  false “1”=< 1 （integer 类型  比如 1 ‘1’的区别）

⑤ **copy_to**：

​	"field": {

​	   "type": "text",

​	   "copy_to": "other_field_name" 

​	},(本来的多个字段，如果没有值的，也可以查到)

**⑥** **doc_values**：为了提升排序和聚合效率，默认true，如果确定不需要对字段进行排序或聚合，也不需要通过脚本访问字段值，则可以禁用doc值以节省磁盘空间（不支持text和annotated_text）

⑦ **dynamic**：控制是否可以动态添加新字段

​		1) true 新检测到的字段将添加到映射中。（默认）

​		2) false 新检测到的字段将被忽略。这些字段将不会被索引，因此将无法搜索，但仍会出现在_source返回的匹配项中。这些字段不会添加到映射中，必须显式添加新字段。

​		3) strict 如果检测到新字段，则会引发异常并拒绝文档。必须将新字段显式添加到映射中

**⑧** ***\*eager_global_ordinals：\*******\*用于聚合的字段上\*******\*，优化聚合性能。\****

​		1) Frozen indices（冻结索引）：有些索引使用率很高，会被保存在内存中，有些使用率特别低，宁愿在使用的时候重新创建，在使用完毕后丢弃数据，Frozen indices的数据命中频率小，不适用于高搜索负载，数据不会被保存在内存中，堆空间占用比普通索引少得多，Frozen indices是只读的，请求可能是秒级或者分钟级。***\*eager_global_ordinals不适用于Frozen indices\****

 ⑨ **enable**：是否创建倒排索引，可以对字段操作，也可以对索引操作，如果不创建索引，让然可以检索并在_source元数据中展示，谨慎使用，该状态无法修改。

```java
PUT my_index{
 "mappings": {
  "enabled": false 
 }} 

PUT my_index{
 "mappings": {
  "properties": {
   "session_data": {
   "type": "object",
 "enabled": false
   }
  }
 }}
```

**⑩** ***\*fielddata\****：查询时***\*内存\****数据结构，在首次用当前字段聚合、排序或者在脚本中使用时，需要字段为fielddata数据结构，并且创建倒排索引保存到堆中

**⑪** ***\*fields：\****给field创建多字段，用于不同目的（全文检索或者聚合分析排序）

**⑫ format：格式化**

​	"date": {

​	   "type":  "date",

​	   "format": "yyyy-MM-dd"

​	 }

**⑬ ignore_above：*\*超过长度将被忽略\****

14 **ignore_malformed**：忽略**类型**错误

```java
PUT my_index{
  "mappings": {
    "properties": {
      "number_one": {
        "type": "integer",
        "ignore_malformed": true
      },
      "number_two": {
        "type": "integer"
      }
    }
  }}
PUT my_index/_doc/1{
  "text":       "Some text value",
  "number_one": "foo" }   //虽然有异常 但是不抛出
PUT my_index/_doc/2{
  "text":       "Some text value",
  "number_two": "foo" }   //数据格式不对	
```

15 **index_options**：控制将哪些信息添加到反向索引中以进行搜索和突出显示。仅用于text字段

16 **Index_phrases**：提升exact_value查询速度，但是要消耗更多磁盘空间

17 **Index_prefixes**：前缀搜索

​	1) min_chars：前缀最小长度，>0，默认2（包含）

​	2) max_chars：前缀最大长度，<20，默认5（包含）

​	"index_prefixes": {

  	   "min_chars" : 1,

  	   "max_chars" : 10

 	   }	

18 **meta**：附加元数据

19  **normalizer**：

20 **norms**：是否禁用评分（在filter和聚合字段上应该禁用）。

21 null_value：为null值设置默认值

​		"null_value": "NULL"

22 position_increment_gap：

23 proterties：除了mapping还可用于object的属性设置

24***\*search_analyzer\****：设置单独的查询时分析器：

```java
PUT my_index{
 "settings": {
  "analysis": {
   "filter": {
​    "autocomplete_filter": {
​     "type": "edge_ngram",
​     "min_gram": 1,
​     "max_gram": 20
​    }
   },
   "analyzer": {
​    "autocomplete": { 
​     "type": "custom",
​     "tokenizer": "standard",
​     "filter": [
​      "lowercase",
​      "autocomplete_filter"
​     ]
​    }
   }
  }
 },
 "mappings": {
  "properties": {
   "text": {
​    "type": "text",
​    "analyzer": "autocomplete", 
​    "search_analyzer": "standard" 
   }
  }
 }}

PUT my_index/_doc/1{
 "text": "Quick Brown Fox" }
GET my_index/_search{
 "query": {
  "match": {
   "text": {
​    "query": "Quick Br", 
​    "operator": "and"
   }
  }
 }}
```

25 **similarity**：为字段设置相关度算法，支持BM25、claassic（TF-IDF）、boolean

26 **store**：设置字段是否仅查询

27 **term_vector**：

​	聚合查询：

​	(1) bucket和metirc：

​	(2) 语法:

​	aggs:{

​	code...

​	}

(3) “goup by”：

​	① 以tag维度每个产品的数量，即每个标签

​	② 在的基础上增加筛选条件：统计价格大于1999的数据

(4) “avg”：

​	① 价格大于1999的每个tag产品的平均价格

(5) 分组聚合

(6) 按照千元机：1000以下  中端机：2000-3000 高端机：3000以上分组聚合，分别计算数量

 



## 注意点 

text默认不会创建正排索引的



 

 

 