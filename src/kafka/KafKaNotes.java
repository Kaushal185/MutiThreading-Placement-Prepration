package kafka;

/*
    Kafka is designed to handle data that is constantly being generated and needs to be processed as it comes in, without delays.
    Collect constantly generating events and store temporary and distributes to servers
    source -> destination (make this flow smooth)

    In Kafka asynchronicity is achieved


    Kafka cluster -> group of kafka brokers
    kafka broker ->  server on which kafka is running
    kafka producer -> write new data into kafka cluster
    kafka consumer -> consume data from kafka cluster
    zookeeper -> monitor kafka cluster health
    Kafka connect -> Fetch data (in or out) from external entity into kafka cluster
    kafka stream -> functionality used for data transformation (take data from kafka cluster transform and put into cluster again)

Kafka Topic:
1. Named container for similar events, Unique identifier is its name.
2. ex Student topic will have student related data, Food topic will have food related data.
3. Topic is like table in a database they live insider broker.
4. producer produce message into the topic (ultimately to partitions in round-robin fashion or directly to partitions.
   consumer poll continuously for new message using the topic

Kafka Partition: A topic is partitioned and distributed to kafka brokers in round-robin fashion to
                 achieve distributed system.
Replication factor: a partition is replicated by this factor and it is replicated in another broker to prevent fault tolerance.

Partitions: A topic is split into several parts which are known as the partitions of the topic.
Partition is where the actual message is located.



 */
public class KafKaNotes {

}
