# jackson-scala-map-bug

Documentation about the workaround [in the WIKI](https://github.com/FasterXML/jackson-module-scala/wiki/FAQ#deserializing-optionint-and-other-primitive-challenges)

To fix it, annotate the class with ```@JsonDeserialize(keyAs = classOf[java.lang.Long])```
```scala
case class InnerMap(@JsonDeserialize(keyAs = classOf[java.lang.Long]) map: Map[Long, Long])
```

