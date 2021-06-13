package mutating;


import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

class Average {
    private double sum = 0;
    private long count = 0;

    public Average(double sum, long count) {
        this.count = count;
        this.sum = sum;
    }

    public Average() {}
    public void include(double d) {
        this.sum += d;  this.count += 1;
    }

    public void merge(Average  other) {
        this.sum += other.sum;
        this.count += other.count;
    }

    public Optional<Double> get() {
        if(this.count > 0) return Optional.of(this.sum/this.count);
        else {
            return Optional.empty();
        }
    }

}

public class AverageReduce {

    public static void main(String[] args) {
        long start = System.nanoTime();
      //  DoubleStream.generate(() -> Math.random()) -> Cant use this , Math.random is a big critical section .It mean if 6 threads concurrently try to access , only one thread
        // will execute the section and other will wait .Eventually you will not be able to attain much concurrency.

        // here each thread would have its own random generation
        ThreadLocalRandom.current().doubles(4_000_000_000L,-Math.PI,+ Math.PI)// eventually average to be zero
     //   .reduce ( this reduce does not exist on primitive)
                .parallel()
              //  .collect(() -> new Average(),(r,d) -> r.include(d),(r1,r2) -> r1.merge(r2))
                .collect(Average::new,Average::include,Average::merge)
                .get()
                .ifPresent(v -> System.out.println("Average is  " + v));

        long time = System.nanoTime() - start;
        System.out.println("time is  " + time/1_000_000_000.00);
        // cpu in the machine do not execute bytecode , it interpret bytecode . When code run for longer time , Just in compiler intervene and optimize and produce exact machine binary which improves.
   // we created 4 billion integer objets , wrap it and unwrap it , we box and unboxed it

    }
}
