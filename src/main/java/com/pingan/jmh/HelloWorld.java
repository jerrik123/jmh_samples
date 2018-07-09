package com.pingan.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

/**
 * Copyright 2018/7/10 lcfarm All Rights Reserved
 * 请添加类/接口的说明：
 *
 * @Package: com.pingan.jmh
 * @author: Jerrik
 * @date: 2018/7/10 0:11
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class HelloWorld {
    @Benchmark
    public void firstBenchmark() {

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include("HelloWorld")
                .warmupIterations(10)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(10)
                .measurementTime(TimeValue.seconds(1))
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
