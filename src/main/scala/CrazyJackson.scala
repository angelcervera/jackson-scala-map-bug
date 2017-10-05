import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

case class InnerMap(map: Map[Long, Long])

object CrazyJackson {

  def main(args: Array[String]): Unit = {
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)

    val innerMap = InnerMap(Map(1L->1L))
    val serialized = mapper.writeValueAsString(innerMap)
    val newObj = mapper.readValue(serialized, classOf[InnerMap])
    println(serialized) // Why the key is serialized as a String?
    println(innerMap)
    println(newObj)
    assert(newObj == innerMap)
  }

}