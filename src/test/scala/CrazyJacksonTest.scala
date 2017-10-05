import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.scalatest.FunSuite

class CrazyJacksonTest extends FunSuite {
  test("test json comparision") {
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)

    val innerMap = InnerMap(Map(1L->1L))
    val serialized = mapper.writeValueAsString(innerMap)
    val newObj = mapper.readValue(serialized, classOf[InnerMap])
    assert(newObj.map == innerMap.map)

  }
}
