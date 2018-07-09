package com.pingan.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
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
 * @date: 2018/7/10 0:35
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class BenchmarkWithoutJit {
    double x = Math.PI;

    @Benchmark
    public void withJIT(){
        Math.log(x);
    }

    @Benchmark
    public void withoutJIT(Blackhole blackhole){
        blackhole.consume(Math.log(x));//consume()可以避免JIT的优化
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include("BenchmarkWithoutJit")
                .warmupIterations(10)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(10)
                .measurementTime(TimeValue.seconds(1))
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
