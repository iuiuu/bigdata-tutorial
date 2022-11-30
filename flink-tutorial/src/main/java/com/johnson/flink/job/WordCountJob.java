package com.johnson.flink.job;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * 词频统计
 * 统计从 Socket 接收到的字符串中单词出现次数。
 *
 * @author johnson lin
 * @date 2022/10/9 20:21
 */
public class WordCountJob {
    public static void main(String[] args) throws Exception {
        // 设置执行环境
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Socket 地址、端口
        String hostname = "127.0.0.1";
        int port = 3000;

        // Source：读取数据
        DataStreamSource<String> stream = env.socketTextStream(hostname, port);

        // Transform：将每行数据按任何非单词字符分割成单词，再按单词分组统计单词数量
        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = stream.flatMap(new WordCountFlatMap())
                .keyBy(p -> p.f0).sum(1).uid("Transform");

        // Sink：直接打印输出
        sum.print();

        // 执行程序
        env.execute("词频统计");
    }

    public static class WordCountFlatMap implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
            // 先转为小写，再按任何非单词字符进行分割
            String[] words = s.toLowerCase().split("\\W+");

            for (String word : words) {
                if (word.length() > 0) {
                    // 回收器回收长度大于0的单词，将该单词的出现次数计为1
                    collector.collect(new Tuple2<>(word, 1));
                }
            }
        }
    }
}