package pac00_Test;

import lombok.Data;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.UnsortedGrouping;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;

import java.util.Properties;

/**
 * @author Frank.Tang
 * @date 2022-09-05 16:30
 * @desc
 **/
public class FlinkDemo {

    public static void main(String[] args) throws Exception {
        long sTime = System.currentTimeMillis();

        //streamDemo();
        //sourceDemo();
        kafkaDemo();

        long eTime = System.currentTimeMillis();
        System.out.println("��ʱ: " + (eTime - sTime) + "ms");
    }

    /************************ ������ ************************/
    private static void streamDemo() throws Exception {
        //1.����flink��ִ�л���
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //2.��������Դ
        DataStream<Person> flintstones = env.fromElements(
                new Person("Fred", 35),
                new Person("Wilma", 35),
                new Person("Pebbles", 12),
                new Person("Frank", 15),
                new Person("Jelly", 21)
        );
        //3.�����ݽ��й���
        DataStream<Person> adults = flintstones.filter(person -> person.age >= 18);
        //4.���ݵĴ���ʽ���������̨��
        adults.print();
        //5.ִ��flink����
        env.execute();
    }

    /************************ ������ ************************/
    private static void sourceDemo() throws Exception {
        //1.����ִ�л���
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //2.���ļ���ȡ���� ���ж�ȡ(�洢��Ԫ�ؾ���ÿ�е��ı�)
        DataSource<String> source = env.readTextFile("C:\\Users\\82818\\Desktop\\test.txt");
        //3.ת�����ݸ�ʽ
        FlatMapOperator<String, Tuple2<String, Long>> wordAndOneCount = source
                .flatMap((String line, Collector<Tuple2<String, Long>> out) -> {
                    String[] words = line.split("[ ,?.;]");
                    for (String word : words) {
                        out.collect(Tuple2.of(word, 1L));
                    }
                })
                .returns(Types.TUPLE(Types.STRING, Types.LONG));
        //4.���� word ���з���
        UnsortedGrouping<Tuple2<String, Long>> wordAndOneUG =
                wordAndOneCount.groupBy(0);
        //5.�����ھۺ�ͳ��
        AggregateOperator<Tuple2<String, Long>> sum = wordAndOneUG.sum(1);
        //6.��ӡ���
        sum.print();
    }

    /************************ kafka ************************/
    private static void kafkaDemo() throws Exception {
        //1.����ִ�л���
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //2.�����ļ�
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.1.10.115:9092");
        //3.����������
        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>("nev_car", new SimpleStringSchema(), props);
        //4.����������
        DataStreamSource stream = env.addSource(consumer);
        //5.data sink
        stream.print();

        //6.ִ�г���
        env.execute("kafka�����߳���");
    }
}

@Data
class Person {
    public String name;
    public Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return this.name + ": age " + this.age.toString();
    }
}

