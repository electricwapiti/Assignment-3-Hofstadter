package org.example.jmh;

import org.example.Hofstadter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 1)
@Measurement(iterations = 1, time = 200, timeUnit = TimeUnit.MILLISECONDS)
public class SampleBenchmark {
  @Param({"5", "10", "15", "20", "25", "30"})
  public int n;

  Hofstadter hofstadter;

  @Setup(Level.Iteration)
  public void setup() {
    hofstadter = new Hofstadter();
  }

  @Benchmark
  @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
  public void naiveG(Blackhole bh) {
      Integer output = hofstadter.naiveGSequence(n);
      bh.consume(output);
  }

  @Benchmark
  @Timeout(time=5, timeUnit = TimeUnit.SECONDS)
  public void memoizedG(Blackhole bh) {
    Integer output = hofstadter.memoizedGSequence(n);
    bh.consume(output);
  }
}
