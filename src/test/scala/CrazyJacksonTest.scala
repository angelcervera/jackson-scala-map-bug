
import org.scalatest.FunSuite

class CrazyJacksonTest extends FunSuite {

  test("test json jackson comparision") {

    import com.fasterxml.jackson.databind.ObjectMapper
    import com.fasterxml.jackson.module.scala.DefaultScalaModule
    import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)

    val innerMap = InnerMap(Map(1L->1L))
    val serialized = mapper.writeValueAsString(innerMap)
    val newObj = mapper.readValue(serialized, classOf[InnerMap])
    assert(newObj.map == innerMap.map)

  }

  test("test json circe comparision") {

    import io.circe._
    import io.circe.generic.auto._
    import io.circe.parser._
    import io.circe.syntax._

    val innerMap = InnerMap(Map(1L -> 1L))

    val jsonStr = innerMap.asJson.noSpaces
    decode[InnerMap](jsonStr) match {
      case Right(innerMap2) => assert(innerMap2 == innerMap)
      case Left(error) => fail(error)
    }

  }

}
