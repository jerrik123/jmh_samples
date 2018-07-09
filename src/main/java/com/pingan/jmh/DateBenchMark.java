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

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Copyright 2018/7/9 lcfarm All Rights Reserved
 * 请添加类/接口的说明：
 *
 * @Package: com.pingan.jmh
 * @author: Jerrik
 * @date: 2018/7/9 21:01
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class DateBenchMark {

    @Benchmark
    public Calendar runCalendar() {
        return Calendar.getInstance();
    }

    @Benchmark
    public long runCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                        .include(DateBenchMarkAnnotation.class.getSimpleName())
                        .forks(1)
                        .measurementIterations(3)
                        .measurementTime(TimeValue.seconds(1))
                        .warmupIterations(3)
                        .warmupTime(TimeValue.seconds(1))
                        .build();
        new Runner(options).run();
    }
}
