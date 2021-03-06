package com.github.mmolimar.kukulcan.java;

import com.github.mmolimar.kukulcan.repl.KApi;
import org.apache.kafka.streams.Topology;

import java.util.Properties;
import java.util.function.Function;

public class Kukulcan {

    private static KApi<KAdmin> kadminApi = new KApi<>("admin") {
        @Override
        public KAdmin createInstance(Properties props) {
            return new KAdmin(props);
        }
    };

    private static KApi<KConsumer<Object, Object>> kconsumerApi = new KApi<>("consumer") {
        @Override
        public KConsumer<Object, Object> createInstance(Properties props) {
            return new KConsumer<>(props);
        }
    };

    private static KApi<KProducer<Object, Object>> kproducerApi = new KApi<>("producer") {
        @Override
        public KProducer<Object, Object> createInstance(Properties props) {
            return new KProducer<>(props);
        }
    };

    private static KApi<KConnect> kconnectApi = new KApi<>("connect") {
        @Override
        public KConnect createInstance(Properties props) {
            return new KConnect(props);
        }
    };

    private static KApi<Function<Topology, KStreams>> kStreamsApi = new KApi<>("streams") {
        @Override
        public Function<Topology, KStreams> createInstance(Properties props) {
            return (topology -> new KStreams(topology, props));
        }
    };

    /**
     * Create a KAdmin instance reading the {@code admin.properties} file.
     * If the instance was already created, it will be reused.
     *
     * @return The KAdmin instance initialized.
     */
    public static KAdmin admin() {
        return kadminApi.inst();
    }

    /**
     * Create a KConsumer instance reading the {@code consumer.properties} file.
     * If the instance was already created, it will be reused.
     *
     * @return The KConsumer instance initialized.
     */
    @SuppressWarnings("unchecked")
    public static <K, V> KConsumer<K, V> consumer() {
        return (KConsumer<K, V>) kconsumerApi.inst();
    }

    /**
     * Create a KProducer instance reading the {@code producer.properties} file.
     * If the instance was already created, it will be reused.
     *
     * @return The KProducer instance initialized.
     */
    @SuppressWarnings("unchecked")
    public static <K, V> KProducer<K, V> producer() {
        return (KProducer<K, V>) kproducerApi.inst();
    }

    /**
     * Create a KConnect instance reading the {@code connect.properties} file.
     * If the instance was already created, it will be reused.
     *
     * @return The KConnect instance initialized.
     */
    public static KConnect connect() {
        return kconnectApi.inst();
    }

    /**
     * Create a KStreams instance reading the {@code streams.properties} file.
     * If the instance was already created, it will be reused.
     *
     * @param topology The topology to create the KStream
     * @return The KStreams instance initialized.
     */
    public static KStreams streams(Topology topology) {
        return kStreamsApi.inst().apply(topology);
    }

    /**
     * Re-create all instances using their properties files.
     *
     */
    public static void reload() {
        kadminApi.reload();
        kconsumerApi.reload();
        kproducerApi.reload();
        kconnectApi.reload();
        kStreamsApi.reload();
        System.out.println("Done!");
    }
}
