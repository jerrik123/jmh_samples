package com.pingan.jmh;

import com.pingan.jmh.bean.Person;
import com.pingan.jmh.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

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
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class BeanCopyPropsBenchMark {

    private  User user;

    private Person person;

    @Setup
    public void init(){
        user = new User(3,"jerrik",27,"深圳");
        person = new Person();
    }


    @Benchmark
    public Person runBeanUtils() {
        try {
            BeanUtils.copyProperties(user,person);
            return person;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Benchmark
    public Person runPropertyUtils() {
        try {
            PropertyUtils.copyProperties(person,user);
            return person;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                        .include(BeanCopyPropsBenchMark.class.getSimpleName())
                        .forks(1)
                        .threads(1)
                        .measurementIterations(10)
                        .measurementTime(TimeValue.seconds(1))
                        .warmupIterations(10)
                        .warmupTime(TimeValue.seconds(1))
                        .build();
        new Runner(options).run();
    }
}
