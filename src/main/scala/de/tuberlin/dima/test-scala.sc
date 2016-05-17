import org.apache.flink.api.scala._

val env = ExecutionEnvironment.getExecutionEnvironment

// get input data
val text = env.readTextFile("data")

val counts = text.flatMap { _.toLowerCase.split("\\W+") }
  .map { (_, 1) }
  .groupBy(0)
  .sum(1)
