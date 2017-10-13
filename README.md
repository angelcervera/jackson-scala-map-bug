# jackson-scala-map-bug

Documentation about the workaround [in the WIKI](https://github.com/FasterXML/jackson-module-scala/wiki/FAQ#deserializing-optionint-and-other-primitive-challenges)

To fix it using Jackson, annotate the class with ```@JsonDeserialize(keyAs = classOf[java.lang.Long])```
```scala
case class InnerMap(@JsonDeserialize(keyAs = classOf[java.lang.Long]) map: Map[Long, Long])
```

To avoid to tie the model to the parser implementation, move to [Circe](https://circe.github.io/circe/).
Check the unit test to see how easy to use.

