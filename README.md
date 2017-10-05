# jackson-scala-map-bug

Tpo fix it, annotate the class with ```@JsonDeserialize(keyAs = classOf[java.lang.Long])```
```scala
case class InnerMap(@JsonDeserialize(keyAs = classOf[java.lang.Long]) map: Map[Long, Long])
```

